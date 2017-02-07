import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Dialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import java.util.stream.*;

import classfile.*;

final class TextMap {
    String fileName;
    Map<Map<String, String>, Map<String, Integer>> map = new HashMap<Map<String, String>, Map<String, Integer>>();
    Map<Map<String, String>, Map<Integer, String>> revMap = new HashMap<Map<String, String>, Map<Integer, String>>();
    public TextMap() {
    }
    public TextMap(String fileName) {
        this.fileName = fileName;
    }

    // read a text file and capture all words
    // word: a-z char
    public List<String> getWords() {
        //Pattern pattern = Pattern.compile("(?<=^|\\s)[a-zA-Z]+(?=\\s|$)");
        Pattern pattern = Pattern.compile("(?<=^|\\s)[a-zA-Z]+(?=\\s|$)");

        List<String> wordList = new ArrayList<String>();
        List<String> list = readFile(fileName);
        for(String s : list) {
            String[] arr = s.split("\\s+");
            for(String str : arr) {
                Matcher matcher = pattern.matcher(str.toLowerCase());
                if(matcher.find()) {
                    wordList.add(matcher.group());
                }
            }
        }
        return wordList;
    }

    // read file line by line to list
    public List<String> readFile(String fileName) {
        List<String> list = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str;
            while((str = in.readLine()) != null) {
                list.add(str.trim());
            }
            in.close();
        } catch(IOException io) {
            io.printStackTrace();
        }
        return list;
    }


    public Map<Map<String, String>, Map<String, Integer>> prefixSuffixMap(List<String> list) {
        Map<Map<String, String>, Map<String, Integer>> map = new HashMap<Map<String, String>, Map<String, Integer>>();
        for(int i=0; i<list.size() - 2; i++) {
            Map<String, String> key = new HashMap<String, String>();
            Map<String, Integer> value = new HashMap<String, Integer>();
            key.put(list.get(i), list.get(i+1));
            value.put(list.get(i+2), 1);

            Map<String, Integer> v = map.get(key);
            if(v == null) {
                map.put(key, value);
            } else {
                Integer n = v.get(list.get(i+2));
                if(n == null) {
                    v.put(list.get(i+2), 1);
                } else {
                    n++;
                    v.put(list.get(i+2), n);
                }
            }
        }
        return map;
    }

    // generate number [1...n]
    public int random(int n) {
        Random ran = new Random();
        int num = ran.nextInt(n) + 1;
        return num;
    }

    public List<String> generateText(int numWords, String prefix, String suffix, Map<Map<String, String>, Map<String, Integer>> map , Map<Map<String, String>, Map<Integer, String>> reverseFreMap) {

        List<String> list = new ArrayList<String>();


        // clean up prefix and suffix, e.g. trim white-space
        String[] arr = prefix.split("\\s+");
        List<String> inputList = new ArrayList<String>();
        for(String s : arr) {
            if(s.trim().length() > 0)
                inputList.add(s);
        }

        String inputSuffix = suffix.trim();
        if(inputList.size() == 2) {
            String firstPrefix = inputList.get(0);
            String secondPrefix = inputList.get(1);
            list.add(firstPrefix);
            list.add(secondPrefix);
            list.add(inputSuffix);

            firstPrefix = secondPrefix;
            secondPrefix = inputSuffix;
              while(true){
                Map<String, String> key = new  HashMap<String, String>();
                key.put(firstPrefix, secondPrefix);

                Map<String, Integer> value = map.get(key);

                if(value != null) {
                    Map<Integer, String> revValueMap = reverseFreMap.get(key);
                    if(revValueMap != null) {

                        int ranKey = random(revValueMap.size());

                        String newSuffix = revValueMap.get(ranKey);
                        firstPrefix = secondPrefix;
                        secondPrefix= newSuffix;
                        list.add(newSuffix);

                        if(list.size() >= numWords){
                            break;
                        }
                    }
                }else{
                    break;
                }
            }
        }
        return list;
    }

    public Map<Map<String, String>, Map<Integer, String>>  reverseFrequencyMap(Map<Map<String, String>, Map<String, Integer>> map) {
        Map<Map<String, String>, Map<Integer, String>> tableMap = new HashMap<Map<String, String>, Map<Integer, String>>();
        for(Map.Entry<Map<String, String>, Map<String, Integer>> entry : map.entrySet()) {
            Map<String, String> key = entry.getKey();
            Map<String, Integer> value = entry.getValue();
            for(Map.Entry<String, String> keyEntry : key.entrySet()) {
                Map<Integer, String> rmap = inverseMap(value);
                tableMap.put(key, rmap);

                Ut.l();
            }
            Ut.l();
        }
        return tableMap;
    }

    public List<String> textGeneMap() {
        List<String> list = getWords();
        map = prefixSuffixMap(list);

        List<String> retList = new ArrayList<String>();
        for(Map.Entry<Map<String, String>, Map<String, Integer>> entry : map.entrySet()) {
            Map<String, String> key = entry.getKey();
            Map<String, Integer> value = entry.getValue();
            String str = "";
            for(Map.Entry<String, String> keyEntry : key.entrySet()) {
                str += keyEntry.getKey() + " " + keyEntry.getValue() + " => ";

                for(Map.Entry<String, Integer> valueEntry: value.entrySet()) {
                    str += valueEntry.getKey()  + "[" + valueEntry.getValue() + "] ";
                }
                Ut.l();
                str += "\n";
            }
            retList.add(str);
            Ut.l();
        }
        return retList;
    }

    public List<String> processFile(int maxWords, String prefix, String suffix) {

        revMap = reverseFrequencyMap(map);
        List<String> listWords= generateText(maxWords, prefix, suffix, map, revMap);
        return listWords;
    }

    // return investable map: <k, v> => <v, k>
    // v = 1, 2, ... , n
    public Map<Integer, String> inverseMap(Map<String, Integer> map) {

        Map<Integer, String> rMap = new HashMap<Integer, String>();
        int k = 1;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer n = entry.getValue();

            int init = k;
            while(k < init + n) {
                rMap.put(k, entry.getKey());
                k++;
            }
        }
        return rMap;
    }
}

public class AnimalLogicTask  extends Application {
    String fileName = null;
    TextMap textMap = new TextMap();
    final int numCharLine = 10;
    public static void main(String[] args) {
        launch(args);
    }

    public boolean isNumeric(String str) {
        return str.matches("[1-9][0-9]*|0");
    }
    @Override
    public void start(final Stage primaryStage) {
        Group root = new Group();

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");


        TextArea textArea = new TextArea();
        TextArea textTable = new TextArea();
        textArea.setMinSize(500,500);
        textTable.setMinSize(500,500);

        TextField selectedFileTF = new TextField();
        selectedFileTF.setEditable(false);
        selectedFileTF.setPrefWidth(200);
        Button buttonLoad = new Button("Select File");
        Button buttonGeneText= new Button("Generate Text");

        HBox hboxField = new HBox();
        hboxField.setAlignment(Pos.CENTER);
        hboxField.setPadding(new Insets(1, 1, 1, 1));
        hboxField.getChildren().add(textTable);
        hboxField.getChildren().add(textArea);

        VBox box = new VBox();
        box.setAlignment(Pos.TOP_CENTER);
        box.setSpacing(5);
        box.getChildren().add(hboxField);

        HBox hboxTextField1 = new HBox();
        HBox hboxtextField2 = new HBox();
        hboxTextField1.setAlignment(Pos.CENTER);
        hboxTextField1.setSpacing(20);

        Label prefixLable = new Label("Prefix:");
        Label suffixLable = new Label("Suffix:");
        Label maxWordsLable = new Label("Maximum Words:");

        TextField prefixTF = new TextField ();
        TextField suffixTF = new TextField ();
        TextField maxWordsTF = new TextField ();


        buttonLoad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);

                File file = fileChooser.showOpenDialog(primaryStage);

                if(file != null) {
                    fileName = file.getAbsolutePath();

                    if(fileName != null) {
                        textMap = new TextMap(fileName);
                        selectedFileTF.setText(file.getName());

                        List<String> textList = textMap.textGeneMap();
                        textTable.clear();
                        for(String s : textList) {
                            textTable.appendText(s + " ");
                        }
                    }
                } 
            }
        });

        buttonGeneText.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {

                if(fileName != null) {

                    String[] prefixArr = prefixTF.getText().trim().split("\\s+");
                    String[] suffixArr = suffixTF.getText().trim().split("\\s+");
                    if(prefixArr.length == 2 && suffixArr.length == 1) {
                        if(isNumeric(maxWordsTF.getText().trim())) {
                            Integer maxWords = Integer.valueOf(maxWordsTF.getText().trim());
                            List<String> wlist = textMap.processFile(maxWords, prefixTF.getText(), suffixTF.getText());

                            textArea.clear();

                            int count = 0;
                            for(String s : wlist) {
                                if((count % numCharLine)  + 1 == numCharLine)
                                    textArea.appendText(s + "\n");
                                else
                                    textArea.appendText(s + " ");

                                count++;
                            }

                        } else {
                            alert.setHeaderText("Maximum Words: invalid input");
                            alert.setContentText("Maximum Words field must be an integer.");
                            alert.showAndWait();
                        }
                    }else{
                        alert.setHeaderText("Invalid Prefix or Suffix");
                        alert.setContentText("Prefix must be two words\n Suffix must be one word");
                        alert.showAndWait();
                    }
                }else{
                    alert.setHeaderText("Invalid file");
                    alert.setContentText("Please select a valid text file.");
                    alert.showAndWait();
                }

            }
        });

        HBox lbtTFBox1 = new HBox();
        HBox lbtTFBox2 = new HBox();
        HBox lbtTFBox3 = new HBox();

        lbtTFBox1.getChildren().addAll(prefixLable, prefixTF);
        lbtTFBox1.setSpacing(2);
        lbtTFBox1.setPadding(new Insets(1, 1, 1, 1));
        lbtTFBox1.setStyle("-fx-background-color: #EEEEEE;");


        lbtTFBox2.getChildren().addAll(suffixLable, suffixTF);
        lbtTFBox2.setSpacing(2);
        lbtTFBox2.setPadding(new Insets(1, 1, 1, 1));
        lbtTFBox2.setStyle("-fx-background-color: #EEEEEE;");

        lbtTFBox3.getChildren().addAll(maxWordsLable, maxWordsTF);
        lbtTFBox3.setSpacing(2);
        lbtTFBox3.setPadding(new Insets(1, 1, 1, 1));
        lbtTFBox3.setStyle("-fx-background-color: #EEEEEE;");

        hboxTextField1.getChildren().addAll(lbtTFBox1);
        hboxTextField1.getChildren().addAll(lbtTFBox2);
        hboxTextField1.getChildren().addAll(lbtTFBox3);

        box.getChildren().addAll(hboxTextField1);

        HBox fileBox = new HBox();
        fileBox.setAlignment(Pos.CENTER);
        fileBox.setSpacing(2);
        fileBox.getChildren().addAll(buttonLoad, selectedFileTF);
        box.getChildren().add(fileBox);

        box.getChildren().add(buttonGeneText);
        primaryStage.setScene(new Scene(box, 1000, 800));
        primaryStage.show();
    }
}
