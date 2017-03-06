import com.google.common.base.Strings;
import com.sun.org.apache.bcel.internal.classfile.Code;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;


class MyTextFlow extends TextFlow{
    String fontFamily = "Helvetica";
    double fontSize = 14;
    DropShadow dropShadow;
    Color textColor;
    double preWidth;
    double preHeight;
    String setStyleStr;
    List<String> list;
    public MyTextFlow(List<String> list){
        this.list = list;
        init();
   }
   public void init(){
       dropShadow = new DropShadow();
       dropShadow.setOffsetX(4);
       dropShadow.setOffsetY(6);
       dropShadow.setColor(Color.BLACK);

       this.setStyle("-fx-background-color: gray;");

       textColor = Color.BLACK;
       preWidth  = 100;
       preHeight = 100;
       setStyleStr = "-fx-background-color: cyan;";
   }
    public MyTextFlow createTextFlow(){
        for(String s : list) {
            Text text = new Text(s);
            text.setFont(Font.font(fontFamily, FontPosture.REGULAR, fontSize));
            text.setFill(textColor);
            text.setEffect(dropShadow);
            getChildren().add(text);
        }
        setPrefSize(preWidth, preHeight);
        setStyle(setStyleStr);
        return this;
    }
}

/**
 * The class creates TextFlow from list of string.
 *
 */
class CodeNodeTextFlow{
    String fontFamily = "Helvetica";
    double fontSize = 14;
    DropShadow dropShadow;
    Color textColor;
    double preWidth;
    double preHeight;
    String setStyleStr;

    public CodeNodeTextFlow(){
        dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.BLACK);

        textColor = Color.BLACK;
        preWidth  = 100;
        preHeight = 100;
        setStyleStr = "-fx-background-color: gray;";

    }
    public void setFontSize(double fontSize){
        this.fontSize = fontSize;
    }
    public void setFontFamily(String fontFamily){
        this.fontFamily = fontFamily;
    }
    public void setDropShadown(DropShadow dropShadow){
        this.dropShadow = dropShadow;
    }
    public void setTextColor(Color color){
        this.textColor = textColor;
    }
    public void setPreSize(double preWidth, double preHeight){
        this.preWidth = preWidth;
        this.preHeight = preHeight;
    }
    public void setSetStyle(String style){
        this.setStyleStr = style;
    }

    public TextFlow createTextFlow(List<String> list){
        TextFlow textFlow = new TextFlow();

        for(String s : list) {
            Text text = new Text(s);
            text.setFont(Font.font(fontFamily, FontPosture.REGULAR, fontSize));
            text.setFill(textColor);
            text.setEffect(dropShadow);
            textFlow.getChildren().add(text);
        }
        textFlow.setPrefSize(preWidth, preHeight);
        textFlow.setStyle(setStyleStr);
        return textFlow;
    }
}

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
//        Scene scene = new Scene(new Group());
        List<PaneNode> listPaneNode = new ArrayList<>();

        // immutable list

//        List<List<String>> lists = new ArrayList<>();
//        createList(lists);
//        double panelY = 0;
//        for(List<String> list: lists){
//            PaneNode paneNode = new PaneNode();
//            for(String s : list){
//                paneNode.insert(s, 0, 20);
//            }
//            paneNode.setLayOut(0, panelY);
//            listPaneNode.add(paneNode);
//            panelY += 100;
//        }

        stage.setTitle("Label Sample");
        stage.setWidth(400);
        stage.setHeight(180);

        VBox vbox = new VBox();
        vbox.setSpacing(4);

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

        Text text1 = new Text("This is line 2");
        text1.setFont(Font.font("Georgia", 12));
        text1.setFill(Color.BLUE);
        text1.setEffect(dropShadow);

        TextFlow textFlow1 = new TextFlow(text1);
        textFlow1.setLayoutX(10);
        textFlow1.setLayoutY(40);
        textFlow1.setLineSpacing(10);
        flowPane.getChildren().add(textFlow1);


        List<List<String>> lists = createList();
        List<FlowPane> listFlowPane = createListFlowPane(lists);
        // use textflow inside flowpane
        for(FlowPane fp : listFlowPane) {
            vbox.getChildren().add(fp);
        }

        // use textflows only
//        List<TextFlow> textFlowList = createListTextFlow(lists);
//        for(TextFlow tf : textFlowList){
//            vbox.getChildren().add(tf);
//        }


        Scene scene = new Scene(vbox, 500, 300);


        stage.setScene(scene);
        stage.show();
    }
    public List<List<String>> createList(){
        List<List<String>> lists = new ArrayList<>();
        List<String> list1 = Arrays.asList("line1 \n", "line2\n", "line3\n");
//        List<String> list1 = Arrays.asList("line1");
        List<String> list2 = Arrays.asList("line11\n", "line22\n", "line33\n");
        List<String> list3 = Arrays.asList("line111\n", "line222\n", "line333\n");
        List<String> list4 = Arrays.asList("   line1111\n", " line2222\n", "    line3333\n");
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        return lists;
    }

    public List<FlowPane> createListFlowPane(List<List<String>> lists){
        List<FlowPane> listFlowPane = new ArrayList<>();

        for(List<String> list : lists) {
            FlowPane flowPane = new FlowPane();
            flowPane.setPrefSize(300, 300);
            flowPane.getChildren().add(createTextFlow(list));
            listFlowPane.add(flowPane);
        }

        return listFlowPane;
    }

    public TextFlow createTextFlow(List<String> list){
        //CodeNodeTextFlow codeTextFlow = new CodeNodeTextFlow();
        MyTextFlow textFlow = new MyTextFlow(list);

        return textFlow.createTextFlow();
    }
//    public TextFlow createTextFlow(List<String> list){
//        String family = "Helvetica";
//        double size = 20;
//        TextFlow textFlow = new TextFlow();
//        for(String s : list) {
//            Text text = new Text(s);
//            text.setFont(Font.font(family, FontPosture.REGULAR, size));
//            text.setFill(Color.CYAN);
//
//            DropShadow dropShadow = new DropShadow();
//            dropShadow.setOffsetX(4);
//            dropShadow.setOffsetY(6);
//            dropShadow.setColor(Color.BLACK);
//
//            text.setEffect(dropShadow);
//
//            textFlow.setPrefSize(100, 100);
//            textFlow.getChildren().add(text);
//        }
//        textFlow.setStyle("-fx-background-color: gray;");
//
//        return textFlow;
//    }

    public FlowPane createFlowPane(){
        FlowPane flowPane = new FlowPane();
        flowPane.setLayoutX(0);
        flowPane.setLayoutY(0);

        flowPane.setVgap(10);
        flowPane.setHgap(10);
        flowPane.setPadding(new Insets(25));
        flowPane.setPrefSize(100, 100);
        flowPane.setStyle("-fx-background-color: black;");

        String family = "Helvetica";
        double size = 50;
        TextFlow textFlow = new TextFlow();
        textFlow.setLayoutX(40);
        textFlow.setLayoutY(40);
        Text text1 = new Text("Hello ");
        text1.setFont(Font.font(family, size));
        text1.setFill(Color.RED);
        Text text2 = new Text("Bold\n");
        text2.setFill(Color.ORANGE);
        text2.setFont(Font.font(family, FontWeight.BOLD, size));
        Text text3 = new Text("World");
        text3.setFill(Color.GREEN);
        text3.setFont(Font.font(family, FontPosture.ITALIC, size));
        textFlow.getChildren().addAll(text1, text2, text3);
        textFlow.setStyle("-fx-background-color: gray;");

        flowPane.getChildren().add(textFlow);

        return flowPane;
    }
    public List<TextFlow> createListTextFlow(List<List<String>> lists){
        String family = "Helvetica";
        double size = 14;
        List<TextFlow> listTextFlow = new ArrayList<>();


        for(List<String> list : lists) {
            TextFlow textFlow = new TextFlow();
            textFlow.setLayoutX(10);
            textFlow.setLayoutY(10);
            for (String s : list) {
                Text text = new Text(s);

                text.setFont(Font.font(family, FontPosture.REGULAR, size));
                text.setFill(Color.BLUE);
                textFlow.getChildren().add(text);
            }
            textFlow.setStyle("-fx-background-color: green;");
            textFlow.setPrefSize(100,100);
            listTextFlow.add(textFlow);
        }
        return listTextFlow;
    }
}














