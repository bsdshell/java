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

        Group root = new Group();


        final Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        final TextArea textArea = new TextArea();
        final TextArea textTable = new TextArea();
        textArea.setMinSize(500,500);
        textTable.setMinSize(500,500);

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

        final HBox searchBox = new HBox();
        searchBox.getChildren().add(searchTF);

        HBox searchParentHBox  = new HBox();

        searchParentHBox.setAlignment(Pos.CENTER);
        searchParentHBox.setPadding(new Insets(1, 1, 1, 1));
        searchParentHBox.getChildren().add(searchBox);

        HBox hboxField = new HBox();
        hboxField.setAlignment(Pos.CENTER);
        hboxField.setPadding(new Insets(1, 1, 1, 1));
        hboxField.getChildren().add(list);
        hboxField.getChildren().add(textArea);


        VBox box = new VBox();
        box.setAlignment(Pos.TOP_CENTER);
        box.setSpacing(5);
        box.getChildren().add(listBox);
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
