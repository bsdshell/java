import classfile.Aron;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

import classfile.Print;


// TextArea example, mouse click, mouseClick, MouseClicked
//
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {

        final int numTexAreas = 10 ;
        TextField[] textFields = new TextField[numTexAreas];

        VBox root = new VBox(5);
        TextArea textArea = new TextArea();
        root.getChildren().add(textArea);

        textArea.setOnMouseClicked(e -> {
            System.out.println("Clicked");
        });

        Scene scene = new Scene(new ScrollPane(root), 250, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        test2();
    }

    public static void test1(){
        String str = "java file, java list, thread java";
        List<String> list = new ArrayList<>();
        prefixWordMap(str, list);
    }

    static void test2(){
        Aron.beg();
        List<String> list = new ArrayList<>(Arrays.asList("cat", "dog", "cow"));
        Collections.reverse(list);

        Aron.printList(list);


        Aron.end();
    }



    public static void prefixWordMap(String str, List<String> listCode){
        List<String> list = Aron.split(str, ",");
        Map<String, List<List<String>>> map = new HashMap<>();
        for(String s : list){
            List<String> listWord = Aron.split(s, "\\s+");
            String prefixKey = "";
            for(int i=0; i<listWord.size(); i++){
                prefixKey = prefixKey + " " + listWord.get(i);
                prefixKey = prefixKey.trim();
                List<List<String>> value = map.get(prefixKey);
                if(value != null){
                    value.add(Arrays.asList("Snap worth of 27.8 billion"));
                    map.put(prefixKey, value);
                }else{
                    List<List<String>> tmpLists = new ArrayList<>();
                    tmpLists.add(Arrays.asList("make sense, does't make sense, do beyond yourself"));
                    map.put(prefixKey, tmpLists);

                }
                Print.pbl("------------------");
            }
            Print.pbl("==============");

        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}