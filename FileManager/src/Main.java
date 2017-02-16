import classfile.Aron;
import classfile.Print;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//final class TextMap {
//    String fileName;
//    Map<Map<String, String>, Map<String, Integer>> map = new HashMap<>();
//    Map<Map<String, String>, Map<Integer, String>> revMap = new HashMap<>();
//    public TextMap() { }
//    public TextMap(String fileName) {
//        this.fileName = fileName;
//    }
//
//    // read a text file and capture all words
//    // word: a-z char
//    public List<String> getWords() {
//        //Pattern pattern = Pattern.compile("(?<=^|\\s)[a-zA-Z]+(?=\\s|$)");
//        Pattern pattern = Pattern.compile("(?<=^|\\s)[a-zA-Z]+(?=\\s|$)");
//
//        List<String> wordList = new ArrayList<String>();
//        List<String> list = readFile(fileName);
//        for(String s : list) {
//            String[] arr = s.split("\\s+");
//            for(String str : arr) {
//                Matcher matcher = pattern.matcher(str.toLowerCase());
//                if(matcher.find()) {
//                    wordList.add(matcher.group());
//                }
//            }
//        }
//        return wordList;
//    }
//
//    // read file line by line to list
//    public List<String> readFile(String fileName) {
//        List<String> list = new ArrayList<String>();
//        try {
//            BufferedReader in = new BufferedReader(new FileReader(fileName));
//            String str;
//            while((str = in.readLine()) != null) {
//                list.add(str.trim());
//            }
//            in.close();
//        } catch(IOException io) {
//            io.printStackTrace();
//        }
//        return list;
//    }
//
//
//    // generate map from prefix -> suffix, e.g.  <my, dog> -> <is, 1>
//    public Map<Map<String, String>, Map<String, Integer>> prefixSuffixMap(List<String> list) {
//        Map<Map<String, String>, Map<String, Integer>> map = new HashMap<Map<String, String>, Map<String, Integer>>();
//        for(int i=0; i<list.size() - 2; i++) {
//            Map<String, String> key = new HashMap<String, String>();
//            Map<String, Integer> value = new HashMap<String, Integer>();
//            key.put(list.get(i), list.get(i+1));
//            value.put(list.get(i+2), 1);
//
//            Map<String, Integer> v = map.get(key);
//            if(v == null) {
//                map.put(key, value);
//            } else {
//                Integer n = v.get(list.get(i+2));
//                if(n == null) {
//                    v.put(list.get(i+2), 1);
//                } else {
//                    n++;
//                    v.put(list.get(i+2), n);
//                }
//            }
//        }
//        return map;
//    }
//
//    // generate number [1...n]
//    public int random(int n) {
//        Random ran = new Random();
//        int num = ran.nextInt(n) + 1;
//        return num;
//    }
//
//    // generate list of words from prefix, suffix
//    public List<String> generateText(int numWords, String prefix, String suffix, Map<Map<String, String>, Map<String, Integer>> map , Map<Map<String, String>, Map<Integer, String>> reverseFreMap) {
//        List<String> list = new ArrayList<String>();
//
//        // clean up prefix and suffix, e.g. trim white-space
//        String[] arr = prefix.split("\\s+");
//        List<String> inputList = new ArrayList<String>();
//        for(String s : arr) {
//            if(s.trim().length() > 0)
//                inputList.add(s);
//        }
//
//        String inputSuffix = suffix.trim();
//        if(inputList.size() == 2) {
//            String firstPrefix = inputList.get(0);
//            String secondPrefix = inputList.get(1);
//            list.add(firstPrefix);
//            list.add(secondPrefix);
//            list.add(inputSuffix);
//
//            firstPrefix = secondPrefix;
//            secondPrefix = inputSuffix;
//            while(true){
//                Map<String, String> key = new  HashMap<String, String>();
//                key.put(firstPrefix, secondPrefix);
//
//                Map<String, Integer> value = map.get(key);
//
//                if(value != null) {
//                    Map<Integer, String> revValueMap = reverseFreMap.get(key);
//                    if(revValueMap != null) {
//                        int ranKey = random(revValueMap.size());
//                        String newSuffix = revValueMap.get(ranKey);
//                        firstPrefix = secondPrefix;
//                        secondPrefix= newSuffix;
//                        list.add(newSuffix);
//
//                        if(list.size() >= numWords){
//                            break;
//                        }
//                    }
//                }else{
//                    break;
//                }
//            }
//        }
//        return list;
//    }
//
//    // generate map: <prefix, suffix> -> <frequency, word>
//    public Map<Map<String, String>, Map<Integer, String>>  reverseFrequencyMap(Map<Map<String, String>, Map<String, Integer>> map) {
//        Map<Map<String, String>, Map<Integer, String>> tableMap = new HashMap<Map<String, String>, Map<Integer, String>>();
//        for(Map.Entry<Map<String, String>, Map<String, Integer>> entry : map.entrySet()) {
//            Map<String, String> key = entry.getKey();
//            Map<String, Integer> value = entry.getValue();
//            for(Map.Entry<String, String> keyEntry : key.entrySet()) {
//                Map<Integer, String> rmap = inverseMap(value);
//                tableMap.put(key, rmap);
//            }
//        }
//        return tableMap;
//    }
//
//    public List<String> textGeneMap() {
//        List<String> list = getWords();
//        map = prefixSuffixMap(list);
//
//        List<String> retList = new ArrayList<String>();
//        for(Map.Entry<Map<String, String>, Map<String, Integer>> entry : map.entrySet()) {
//            Map<String, String> key = entry.getKey();
//            Map<String, Integer> value = entry.getValue();
//            String str = "";
//            for(Map.Entry<String, String> keyEntry : key.entrySet()) {
//                str += keyEntry.getKey() + " " + keyEntry.getValue() + " => ";
//
//                for(Map.Entry<String, Integer> valueEntry: value.entrySet()) {
//                    str += valueEntry.getKey()  + "[" + valueEntry.getValue() + "] ";
//                }
//                str += "\n";
//            }
//            retList.add(str);
//        }
//        return retList;
//    }
//
//    // generate list of words from user inputs: maximum number of words, prefix, and suffix
//    public List<String> processFile(int maxWords, String prefix, String suffix) {
//        revMap = reverseFrequencyMap(map);
//        List<String> listWords= generateText(maxWords, prefix, suffix, map, revMap);
//        return listWords;
//    }
//
//    // return investable map: <k, v> => <v, k>
//    // v = 1, 2, ... , n
//    public Map<Integer, String> inverseMap(Map<String, Integer> map) {
//
//        Map<Integer, String> rMap = new HashMap<Integer, String>();
//        int k = 1;
//        for(Map.Entry<String, Integer> entry : map.entrySet()) {
//            Integer n = entry.getValue();
//
//            int init = k;
//            while(k < init + n) {
//                rMap.put(k, entry.getKey());
//                k++;
//            }
//        }
//        return rMap;
//    }
//}
//



public class Main  extends Application {
    String fileName = null;
//    TextMap textMap = new TextMap();
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

        final Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        final TextArea textArea = new TextArea();
        final TextArea textTable = new TextArea();
        textArea.setMinSize(500,500);
        textTable.setMinSize(500,500);


        final TextField selectedFileTF = new TextField();
        selectedFileTF.setEditable(false);
        selectedFileTF.setPrefWidth(200);
        Button buttonLoad = new Button("Select File");
        Button buttonGeneText= new Button("Generate Text");

        final TextField searchTF = new TextField ();

        final HBox searchBox = new HBox();
        searchBox.getChildren().add(searchTF);

        HBox searchParentHBox  = new HBox();

        searchParentHBox.setAlignment(Pos.CENTER);
        searchParentHBox.setPadding(new Insets(1, 1, 1, 1));
        searchParentHBox.getChildren().add(searchBox);

        HBox hboxField = new HBox();
        hboxField.setAlignment(Pos.CENTER);
        hboxField.setPadding(new Insets(1, 1, 1, 1));
        hboxField.getChildren().add(textTable);
        hboxField.getChildren().add(textArea);


        VBox box = new VBox();
        box.setAlignment(Pos.TOP_CENTER);
        box.setSpacing(5);
        box.getChildren().add(searchParentHBox);
        box.getChildren().add(hboxField);

        HBox hboxTextField1 = new HBox();
        HBox hboxtextField2 = new HBox();
        hboxTextField1.setAlignment(Pos.CENTER);
        hboxTextField1.setSpacing(20);

        Label prefixLable = new Label("Prefix:");
        Label suffixLable = new Label("Suffix:");
        Label maxWordsLable = new Label("Maximum Words:");


        final TextField prefixTF = new TextField ();
        final TextField suffixTF = new TextField ();
        final TextField maxWordsTF = new TextField ();

        searchTF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                Print.pbl(searchTF.getText());

                String fname = "/Users/cat/myfile/github/java/text";
                List<String> wlist = Aron.getCurrentFiles(fname);
                String input = searchTF.getText();
                List<String> matchList = fileSearch(wlist, input);

                textArea.clear();
                for(String s : matchList) {
                    textArea.appendText(s + "\n");
                }
            }
        });

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
//                        textMap = new TextMap(fileName);
//                        selectedFileTF.setText(file.getName());
//
//                        List<String> textList = textMap.textGeneMap();
//                        textTable.clear();
//                        for(String s : textList) {
//                            textTable.appendText(s + " ");
//                        }
                    }
                }
            }
        });

        buttonGeneText.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
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

    public static  List<String> fileSearch(List<String> list, String pattern){
        Map<String, String> map = new HashMap<>();
        Pattern pat = Pattern.compile(pattern);
        List<String> matchList = new ArrayList<>();
        for(String s : list){
            Path path = Paths.get(s);
            Matcher match = pat.matcher(path.getFileName().toString());
            Print.pbl("fname=" + path.getFileName().toString());
            if(match.find()){
                Print.pbl(s);
                matchList.add(s);
            }
        }
        return matchList;
    }
}
