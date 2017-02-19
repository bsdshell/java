import classfile.Aron;
import classfile.Print;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main  extends Application {
    String fileName = null;
    final String allPathsFileName = "/Users/cat/myfile/github/java/text/path.txt";

    ListView<String> list = new ListView<String>();

    ObservableList<String> data = FXCollections.observableArrayList();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        List<String> pathList = new ArrayList<>();
        final Map<String, List<List<String>>> codeMap = processCodeFile();

        Group root = new Group();


        final Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");

        final TextArea textAreaFile = new TextArea();
        final TextArea textAreaPath = new TextArea();
        textAreaFile.setMinSize(500,500);
        textAreaPath.setMinSize(500,500);

        pathList = Aron.readFile(allPathsFileName);
        for(String s : pathList){
            data.add(s + "\n");
        }


        list.setItems(data);

        final HBox listBox = new HBox();
        listBox.getChildren().add(list);


        final TextField selectedFileTF = new TextField();
        selectedFileTF.setEditable(false);
        selectedFileTF.setPrefWidth(200);
        Button buttonLoad = new Button("Select File");
        Button buttonGeneText= new Button("Generate Text");

        final TextField searchTF = new TextField ();
        final TextField pathTF = new TextField ();

        pathTF.setMinWidth(400);
        final HBox searchBox = new HBox();
        searchBox.getChildren().add(searchTF);
        searchBox.getChildren().add(pathTF);

        HBox searchParentHBox  = new HBox();

        searchParentHBox.setAlignment(Pos.CENTER);
        searchParentHBox.setPadding(new Insets(1, 1, 1, 1));
        searchParentHBox.getChildren().add(searchBox);

        HBox hboxField = new HBox();
        hboxField.setAlignment(Pos.CENTER);
        hboxField.setPadding(new Insets(1, 1, 1, 1));
        hboxField.getChildren().add(list);
        hboxField.getChildren().add(textAreaFile);


        VBox box = new VBox();
        box.setAlignment(Pos.TOP_CENTER);
        box.setSpacing(5);
        box.getChildren().add(listBox);
        box.getChildren().add(searchParentHBox);
        box.getChildren().add(hboxField);

        HBox hboxTextField1 = new HBox();

        hboxTextField1.setAlignment(Pos.CENTER);
        hboxTextField1.setSpacing(20);

        Label prefixLable = new Label("Prefix:");
        Label suffixLable = new Label("Suffix:");
        Label maxWordsLable = new Label("Maximum Words:");


        final TextField prefixTF = new TextField ();
        final TextField suffixTF = new TextField ();
        final TextField maxWordsTF = new TextField ();



        list.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + list.getSelectionModel().getSelectedItem());
                String selectedItem = list.getSelectionModel().getSelectedItem();
                pathTF.setText(list.getSelectionModel().getSelectedItem());

                List<String> flist = fileList(selectedItem.trim());
                textAreaFile.clear();
                for(String s : flist) {
                    textAreaFile.appendText(s + "\n");
                }
            }
        });
/*
        searchTF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                Print.pbl(searchTF.getText());

                String fname = pathTF.getText();
                List<String> wlist = fileList(fname);
                String input = searchTF.getText();
                List<String> matchList = fileSearch(wlist, input);

                textAreaFile.clear();
                for(String s : matchList) {
                    textAreaFile.appendText(s + "\n");
                }
            }
        });
*/

        searchTF.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent key) {
                Print.pbl("Key Pressed: " + key.getText());
            }
        });
        searchTF.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent key) {
                Print.pbl("Key Released: " + key.getText());

                String prefix = searchTF.getText();
                List<List<String>> lists = codeMap.get(prefix);
                textAreaFile.clear();
                for(List<String> list : lists){
                    for(String s : list) {
                        textAreaFile.appendText(s);
                    }
                    textAreaFile.appendText("----------------\n");
                }
            }
        });

        searchTF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                Print.pbl(searchTF.getText());


/*
                String key = searchTF.getText();
                List<List<String>> lists = codeMap.get(key);
                textAreaFile.clear();
                for(List<String> list : lists){
                    for(String s : list) {
                        textAreaFile.appendText(s + "\n");
                    }
                    textAreaFile.appendText("----------------\n");
                }
*/


/*
                    String fname = pathTF.getText();
                List<String> wlist = fileList(fname);
                String input = searchTF.getText();
                List<String> matchList = fileSearch(wlist, input);

                textAreaFile.clear();
                for(String s : matchList) {
                    textAreaFile.appendText(s + "\n");
                }
*/
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


        //test2();
        //test3();
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
    public static  void test1() {
        String dir = "/Users/cat/myfile/github/java";
        List<String> list = Aron.getCurrentDir(dir);
        Aron.printList(list);
    }
    public static  void test2() {
        String dir = "/Users/cat/myfile/github/java";
        List<String> list = fileList(dir);
        Aron.printList(list);
    }

    public static void test3(){
        Aron.beg();

        String fName = "/Users/cat/myfile/github/snippets/snippet.m";
        List<List<String>> list2d = readCode(fName);
        Map<String, List<List<String>>> map = buildMap(list2d);

        Aron.printList2dln(list2d);

        Aron.end();
    }
    public static Map<String, List<List<String>>> processCodeFile() {
        String fName = "/Users/cat/myfile/github/snippets/snippet.m";
        List<List<String>> list2d = readCode(fName);
        Map<String, List<List<String>>> map = buildMap(list2d);
        return map;
    }

    public static Map<String, List<List<String>>> buildMap(List<List<String>> lists){
        Map<String, List<List<String>>> map = new HashMap<>();
        for(List<String> list : lists){
            if(list.size() > 0){
                List<String> listToken = Aron.split(list.get(0), ":");
                if(listToken.size() > 0){
                    String key = listToken.get(0).trim();
                    Print.pbl("key=" + key);
                    for(int i=0; i<key.length(); i++){
                        String prefix = key.substring(0, i+1);
                        //String suffix = key.substring(i, key.length());
                        Print.pbl("prefix=" + prefix);
                        List<List<String>> listValue = map.get(prefix);

                        if(listValue != null){
                            listValue.add(list);
                        }else{
                            List<List<String>> list2d = new ArrayList<>();
                            list2d.add(list);
                            map.put(prefix, list2d);
                        }

                    }
                }
            }
        }
        return map;
    }

    public static List<List<String>> readCode(String fName){
//        List<String> list = Aron.readFile(fName);
        List<String> list = Aron.readFileLineByte(fName, 200);
        List<List<String>> list2d = new ArrayList<>();

        List<String> line = new ArrayList<>();
        for(String s : list){

            if(s.trim().length() > 0){
                line.add(s);
            }else{
                if(line.size() > 0) {
                    list2d.add(line);
                    line = new ArrayList<>();
                }
            }
        }
        return list2d;
    }
    public static List<String> fileList(String directory) {
        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                fileNames.add(path.getFileName().toString());
                Print.pbl(path.getFileName().toString());
            }
        } catch (IOException ex) {}
        return fileNames;
    }


}
