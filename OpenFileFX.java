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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import java.util.stream.*;

import classfile.*;

final class TextMap {
    int maxWords;
    String fileName;
    Map<Map<String, String>, Map<String, Integer>> map = new HashMap<Map<String, String>, Map<String, Integer>>();
    Map<Map<String, String>, Map<Integer, String>> revMap = new HashMap<Map<String, String>, Map<Integer, String>>();
    public TextMap() {
    }
    public TextMap(String fileName, int maxWords) {
        this.maxWords = maxWords;
        this.fileName = fileName;
    }

    // read a text file and capture all words
    // word: a-z char
    public List<String> getWords() {
        Pattern pattern = Pattern.compile("(?<=^|\\s)[a-zA-Z]+(?=\\s|$)");

        List<String> wordList = new ArrayList<String>();
        List<String> list = Aron.readFile(fileName);
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

            Print.pbl("firstPrefix =" + firstPrefix);
            Print.pbl("secondPrefix=" + secondPrefix);
            Print.pbl("inputSuffix=" + inputSuffix);

            firstPrefix = secondPrefix;
            secondPrefix = inputSuffix;
            for(int i=0; i<numWords-3; i++) {
                Map<String, String> key = new  HashMap<String, String>();
                key.put(firstPrefix, secondPrefix);

                Map<String, Integer> value = map.get(key);

                if(value != null) {
                    Map<Integer, String> revValueMap = reverseFreMap.get(key);
                    if(revValueMap != null) {

                        int ranKey = random(revValueMap.size());

                        String newSuffix = revValueMap.get(ranKey);
                        Print.pbl("newSuffix=" + newSuffix + " " + "ranKey=" + ranKey);
                        firstPrefix = secondPrefix;
                        secondPrefix= newSuffix;
                        list.add(newSuffix);
                    }
                } else {
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
                Print.pp(keyEntry.getKey() + " " + keyEntry.getValue() + "=>");

                Map<Integer, String> rmap = inverseMap(value);
                tableMap.put(key, rmap);

                for(Map.Entry<String, Integer> valueEntry: value.entrySet()) {
                    Print.pb(valueEntry.getKey() + "->" + valueEntry.getValue());
                }

                Ut.l();
                for(Map.Entry<Integer, String> revEntry: rmap.entrySet()) {
                    Print.pb(revEntry.getKey() + "->" + revEntry.getValue());
                }
                Print.pbl("size=" + rmap.size());
                Print.pp("\n");
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
                Print.pp(keyEntry.getKey() + " " + keyEntry.getValue() + "=>");
                str += keyEntry.getKey() + " " + keyEntry.getValue() + "=>"; 

                for(Map.Entry<String, Integer> valueEntry: value.entrySet()) {
                    Print.pb(valueEntry.getKey() + "[" + valueEntry.getValue() + "]");
                    str += valueEntry.getKey()  + "[" + valueEntry.getValue() + "]";
                }
                Ut.l();
                str += "\n";
                Print.pp("\n");
            }
            retList.add(str);
            Ut.l();
        }
        return retList;
    }

    public List<String> processFile(String prefix, String suffix) {
        Aron.beg();

//        List<String> list = getWords();
//        map = prefixSuffixMap(list);
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

            Print.pbl(entry.getKey() + "->" + entry.getValue());
            int init = k;
            while(k < init + n) {
                rMap.put(k, entry.getKey());
                k++;
            }
        }
        return rMap;
    }
}

public class OpenFileFX extends Application {
    String fileName = null;
    TextMap textMap = new TextMap();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(final Stage primaryStage) {
        Group root = new Group();

        TextArea textArea = new TextArea();
        TextArea textTable = new TextArea();
        Button buttonLoad = new Button("Select File");
        Button buttonGeneText= new Button("Generate Text");

        VBox box = new VBox();
        box.setAlignment(Pos.CENTER_LEFT);
        box.setSpacing(5);
        box.getChildren().add(textTable);
        box.getChildren().add(textArea);

        HBox hboxTextField1 = new HBox();
        HBox hboxtextField2 = new HBox();
        hboxTextField1.setSpacing(10);

        Label prefix = new Label("Prefix:");
        Label suffix= new Label("Suffix:");

        TextField prefixTF = new TextField ();
        TextField suffixTF = new TextField ();


        buttonLoad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);

                File file = fileChooser.showOpenDialog(primaryStage);
                if(file != null) {
                    Print.pbl("fname=" + file.getAbsolutePath());
                    fileName = file.getAbsolutePath();

                    if(fileName != null) {
                        textMap = new TextMap(fileName, 10);

                        List<String> textList = textMap.textGeneMap();
                        textTable.clear();
                        for(String s : textList){
                            Print.pbl("s=" + s);
                            textTable.appendText(s + " ");
                        }
                    }
                }
            }
        });

        buttonGeneText.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                Print.pbl("buttonGeneText click");

                if(fileName != null){
                    List<String> list = Aron.getWords(fileName);
                    Aron.printList(list);
                    Print.pbl("prefixTF=" + prefixTF.getText());
                    Print.pbl("suffixTF=" + suffixTF.getText());
                    List<String> wlist = textMap.processFile(prefixTF.getText(), suffixTF.getText());

                    textArea.clear();
                    for(String s : wlist) {
                        Print.pbl("s=" + s);
                        textArea.appendText(s + " ");
                    }
                }
            }
        });

        hboxTextField1.getChildren().addAll(prefix, prefixTF);
        hboxTextField1.getChildren().addAll(suffix, suffixTF);

        box.getChildren().addAll(hboxTextField1);
        box.getChildren().add(buttonLoad);
        box.getChildren().add(buttonGeneText);
        primaryStage.setScene(new Scene(box, 500, 400));
        primaryStage.show();
    }
}
