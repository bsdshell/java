import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

// javafx color text, color string, multiple color text
// javafx different color text, javafx color string
// javafx text concatenation, javafx string concat
//
public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) {
        test1_simple(stage);
        //test2_two_textflow(stage);
    }

    public void test1_simple(Stage stage){
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
        textFlow.setLineSpacing(100);
        textFlow.getChildren().addAll(text1, text2, text3);

        Group group = new Group(textFlow);
        Scene scene = new Scene(group, 500, 150, Color.WHITE);
        stage.setTitle("Hello Rich Text");
        stage.setScene(scene);
        stage.show();
    }

    public void test2_two_textflow(Stage stage){
        String family = "Helvetica";
        double size = 50;

        TextFlow textFlow1 = createTextFlow();
        TextFlow textFlow2 = createTextFlowDifferentColor();
        VBox vbox = new VBox();
        vbox.getChildren().addAll(textFlow1, textFlow2);


        //Group group = new Group(vbox);
        Scene scene = new Scene(vbox, 500, 150);
        stage.setTitle("Hello Rich Text");
        stage.setScene(scene);
        stage.show();
    }

    public TextFlow createTextFlow(){
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
        textFlow.setLineSpacing(10);
        textFlow.getChildren().addAll(text1, text2, text3);
        textFlow.setStyle("-fx-background-color: gray;");

        return textFlow;
    }
    public TextFlow createTextFlowDifferentColor(){
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
        textFlow.setStyle("-fx-background-color: cyan;");

        return textFlow;
    }

}