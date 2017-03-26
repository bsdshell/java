import java.awt.Font;
import java.util.*;

import classfile.Aron;
import classfile.Print;
import com.google.common.base.Strings;
import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;

import static jdk.nashorn.internal.objects.NativeString.substring;

// http://stackoverflow.com/questions/34351258/java-fx-8-textarea-lineheight-is-smaller-than-actual-when-got-from-fontmetrics
//
// textarea font height, line height, font width, textarea font width
// compute the line height and set the height of TextArea dynamically
//
public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);

        final ComboBox<String> comboboxAbbreSearch = new ComboBox<>();
        comboboxAbbreSearch.setEditable(true);
        comboboxAbbreSearch.setPrefWidth(300);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.getChildren().add(comboboxAbbreSearch);

        List<String> listCode = new ArrayList<>(Arrays.asList("vi cmd, vi help, vi code", "line 1", "line 2"));


        String str = "vi cmd, vi help, vi code";
        Map<String, Set<String>> map = new HashMap<>();
        prefixStringMap(listCode, map);
        comboboxAbbreSearch.getEditor().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            String gettext = comboboxAbbreSearch.getEditor().getText();
            String getcode = event.getCode().toString();

            if (event.getCode() == KeyCode.BACK_SPACE) {
                String inputKey = gettext;

                if(inputKey.length() > 0){
                    String  removeChar = inputKey.substring(0, inputKey.length() - 1);
                    Print.pbl("inputKey=" + inputKey);
                    Print.pbl("removeChar=" + removeChar);
                    inputKey = removeChar;
                    Set<String> setWords = map.get(inputKey);
                    if (setWords != null && setWords.size() > 0) {
                        comboboxAbbreSearch.getItems().clear();
                        List<String> list = new ArrayList<>(setWords);
                        comboboxAbbreSearch.getItems().addAll(list);
                        if (!comboboxAbbreSearch.isShowing()) {
                            comboboxAbbreSearch.show();
                        }
                    }
                    Print.pbl("inputKey.length=" + inputKey.length());
                }else{
                    Print.pbl("inputKey.length():=" + inputKey.length());
                }
            }else if(event.getCode() == KeyCode.DOWN) {
                String inputKey = gettext + event.getCode().toString().toLowerCase();
                Print.pbl("KEY_PRESSED: KeyEvent                 :=" + gettext);
                Print.pbl("KEY_PRESSED: KeyEvent.getCode()       :=" + getcode);
                Print.pbl("inputKey                              :=" + inputKey);
            }else if(event.getCode() == KeyCode.ENTER) {
                String inputKey = gettext + event.getCode().toString().toLowerCase();
                Print.pbl("KEY_PRESSED: KeyEvent                 :=" + gettext);
                Print.pbl("KEY_PRESSED: KeyEvent.getCode()       :=" + getcode);
                Print.pbl("inputKey                              :=" + inputKey);
            } else {
                String inputKey = gettext + event.getCode().toString().toLowerCase();
                Print.pbl("KEY_PRESSED: KeyEvent                 :=" + gettext);
                Print.pbl("KEY_PRESSED: KeyEvent.getCode()       :=" + getcode);
                Print.pbl("inputKey                              :=" + inputKey);

                if (!Strings.isNullOrEmpty(inputKey)) {
                    Print.pbl("isPressed=" + comboboxAbbreSearch.isPressed());
                    comboboxAbbreSearch.getItems().clear();
                    Set<String> setWords = map.get(inputKey);
                    if (setWords != null && setWords.size() > 0) {
                        List<String> list = new ArrayList<>(setWords);
                        comboboxAbbreSearch.getItems().addAll(list);
                        if (!comboboxAbbreSearch.isShowing()) {
                            comboboxAbbreSearch.show();
                        }
                    }
                } else {
                    Print.pbl("prefix= is null or empty");
                    if (comboboxAbbreSearch.isShowing()) {
                        comboboxAbbreSearch.hide();
                    }
                }
            }



//            if (event.getCode() == KeyCode.ENTER) {
//                Print.pbl("ENTER KEY: selected item:=" + comboboxAbbreSearch.getEditor().getText());
//                comboboxAbbreSearch.hide();
//            }else if(event.getCode() == KeyCode.DOWN) {
//                if(comboboxAbbreSearch.getItems().size() > 0){
//                    if(!comboboxAbbreSearch.isShowing()) {
//                        comboboxAbbreSearch.show();
//                    }
//                }else {
//                    String prefix =  Aron.trimLeading( comboboxAbbreSearch.getEditor().getText());
//                    Print.pbl("DOWN KEY: selected item:=" + comboboxAbbreSearch.getEditor().getText());
//                    Print.pbl("prefix  : selected item:=" + comboboxAbbreSearch.getEditor().getText());
//                    Print.pbl("getCode()  : event.getCode():=" + event.getCode());
//
//
//                    if (!Strings.isNullOrEmpty(prefix)) {
//                        Set<String> setWords = map.get(prefix);
//                        if (setWords != null && setWords.size() > 0) {
//                            List<String> list = new ArrayList<>(setWords);
//                            comboboxAbbreSearch.getItems().addAll(list);
//                            if (!comboboxAbbreSearch.isShowing()) {
//                                comboboxAbbreSearch.show();
//                            }
//                        } else {
//                            Print.pbl("prefix= is null or empty");
//                        }
//                    }
//                }
//            }else if(event.getCode() == KeyCode.RIGHT) {
//                Print.pbl("right key");
//            }else if(event.getCode() == KeyCode.LEFT) {
//                Print.pbl("left key");
//            }else if(event.getCode() == KeyCode.UP) {
//                Print.pbl("up key");
//            }else if(event.getCode() == KeyCode.TAB) {
//                Print.pbl("tab key");
//            }else{
//            }
        });





        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // str = "vi cmd, vi help"
    //
    // v -> "vi cmd"
    // vi -> "vi cmd"
    // c -> "cmd"
    // cm -> "cmd"
    // cmd -> "cmd"
    //
    // v -> "vi help"
    // vi -> "vi help"
    // h -> help
    // he -> help
    // hel-> help
    // help -> help
    //
    // listKeyWords = [vi cmd, vi help]
    // words = "vi cmd"
    // words = "vi help"
    //
    static void prefixStringMap(List<String> oneBlock, Map<String, Set<String>> map){
    //  Map<String, Set<String>> map = new HashMap<>();
        List<String> listKeyWords = Aron.splitTrim(oneBlock.get(0), ",");
        for(String words : listKeyWords) {
            List<String> list = Aron.split(words, "\\s+");
            for (int k = 0; k < list.size(); k++) {
                String word = list.get(k);

                for (int i = 0; i < word.length(); i++) {
                    String key = word.substring(0, i + 1);
                    Print.pbl("key=" + key);
                    List<String> subList = list.subList(k, list.size());
                    Set<String> value = map.get(key);
                    if (value != null) {
                        value.add(listToStr(subList));
                    } else {
                        Set<String> set = new HashSet<>();
                        set.add(listToStr(subList));
                        map.put(key, set);
                    }
                }
            }
            for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                System.out.print("[" + entry.getKey() + "]->[" + entry.getValue() + "]");
                Print.line();
            }
        }
    }
    // "vi cmd"
    // "v" -> "vi cmd"
    // "vi" -> "vi cmd"
    // "vi "-> "vi cmd"
    // "vi c"-> "vi cmd"
    // "vi cm" -> "vi cmd"
    // "vi cmd" -> "vi cmd"
    //
    // "c" -> "vi cmd"
    // "cm" -> "vi cmd"
    // "cmd" -> "vi cmd"
//    static Map<String, Set<String>> prefixStringMap(String words){
//        List<String> list = Aron.split(words, "\\s+");
//
//        Map<String, Set<String>> map = new HashMap<>();
//        for(int k=0; k<list.size(); k++) {
//            String s = list.get(k);
//            for(int i=0; i<s.length(); i++) {
//                String key = s.substring(0, i + 1);
//                Print.pbl("key=" + key);
//                List<String> preList = list.subList(0, k);
//                Print.pbl("->" + listToStr(preList));
//                List<String> subList = list.subList(k, list.size());
//
//                Set<String> set = map.get(key);
//                if(set != null){
////                    value.add(listToStr(subList));
//                    set.add(words);
//                }else{
//                    Set<String> tmpSet = new HashSet<>();
////                    set.add(listToStr(subList));
//                    tmpSet.add(words);
//                    map.put(key, tmpSet);
//                }
//            }
//        }
//
//        for(Map.Entry<String, Set<String>> entry : map.entrySet()){
//            System.out.print("[" + entry.getKey() + "]->[" + entry.getValue() + "]");
//            Print.line();
//        }
//
//        return map;
//    }


    static String listToStr(List<String> list){
        String retStr = "";
        for(String s : list)
            retStr += s + " ";

        return retStr.trim();
    }


}