import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class PaneNode{
    FlowPane flowPane;
    double tranX = 0;
    double tranY = 0;
    double flowPaneX = 0;
    double flowPaneY = 0;
    static  int count = 0;

    public PaneNode(){
        flowPane = new FlowPane();
    }
    public void insert(String str, double x, double y){
            TextFlow textFlow = new TextFlow(new Text(str));
//        textFlow.setLayoutX(this.layoutX);
//        textFlow.setLayoutY(this.layoutY);
//            textFlow.setLayoutX(0);
//            textFlow.setLayoutY(0);
            textFlow.setTranslateX(-10);
            textFlow.setTranslateY(this.tranY);
            this.tranX += x;
            this.tranY += y;

            flowPane.setPrefSize(100, 100);
            flowPane.getChildren().add(textFlow);
    }
    public void setLayOut(double x, double y){
        flowPane.setLayoutX(x);
        flowPane.setLayoutY(y);
        if(count % 2 == 0)
            flowPane.setStyle("-fx-background-color: green;");
        else
            flowPane.setStyle("-fx-background-color: red;");

        count++;
    }
}

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        List<PaneNode> listPaneNode = new ArrayList<>();

        // immutable list

        List<List<String>> lists = new ArrayList<>();
        createList(lists);
        double panelY = 0;
        for(List<String> list: lists){
            PaneNode paneNode = new PaneNode();
            for(String s : list){
                paneNode.insert(s, 0, 20);
            }
            paneNode.setLayOut(0, panelY);
            listPaneNode.add(paneNode);
            panelY += 100;
        }

        stage.setTitle("Label Sample");
        stage.setWidth(400);
        stage.setHeight(180);

        VBox vbox = new VBox();

        Label label1 = new Label("Search");
        label1.setTextFill(Color.web("#0076a3"));

        FlowPane flowPane = new FlowPane();
        flowPane.setLayoutX(0);
        flowPane.setLayoutY(0);

        flowPane.setVgap(10);
        flowPane.setHgap(10);
        flowPane.setPadding(new Insets(25));
        flowPane.setPrefSize(100, 100);
        flowPane.setStyle("-fx-background-color: black;");

        FlowPane flowPane1 = new FlowPane();
        flowPane1.setVgap(10);
        flowPane1.setHgap(10);
        flowPane1.setPadding(new Insets(25));
        flowPane1.setPrefSize(100, 100);
        flowPane1.setStyle("-fx-background-color: gray;");
        flowPane1.setLayoutX(0);
        flowPane1.setLayoutY(200);


        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.PURPLE);
        List<String> list = Arrays.asList("dog", "cat");

        Text text = new Text("A TextFlow Layout");
        text.setFont(Font.font("Georgia", 14));
        text.setFill(Color.BLUE);
        text.setEffect(dropShadow);

        TextFlow textFlow = new TextFlow(text);
        textFlow.setLayoutX(10);
        textFlow.setLayoutY(20);
        //root.setTextAlignment(TextAlignment.CENTER);
        textFlow.setLineSpacing(10);
        flowPane.getChildren().add(textFlow);
        flowPane1.getChildren().add(textFlow);


        Text text1 = new Text("This is line 2");
        text1.setFont(Font.font("Georgia", 12));
        text1.setFill(Color.BLUE);
        text1.setEffect(dropShadow);

        TextFlow textFlow1 = new TextFlow(text1);
        textFlow1.setLayoutX(10);
        textFlow1.setLayoutY(40);
        //root.setTextAlignment(TextAlignment.CENTER);
        textFlow1.setLineSpacing(10);
        flowPane.getChildren().add(textFlow1);


        vbox.getChildren().add(flowPane);
        vbox.getChildren().add(flowPane1);


        for(PaneNode paneNode : listPaneNode){
//            vbox.getChildren().add(paneNode.flowPane);
            ((Group) scene.getRoot()).getChildren().add(paneNode.flowPane);
        }

//        ((Group) scene.getRoot()).getChildren().add(vbox);


//        ((Group) scene.getRoot()).getChildren().add(flowPane);
//        ((Group) scene.getRoot()).getChildren().add(flowPane1);

        stage.setScene(scene);
        stage.show();
    }
    public void createList(List<List<String>> lists){
        List<String> list1 = Arrays.asList("line1 ", "line2", "line3");
//        List<String> list1 = Arrays.asList("line1");
        List<String> list2 = Arrays.asList("line11", "line22", "line33");
        List<String> list3 = Arrays.asList("line111", "line222", "line333");
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
    }

}














