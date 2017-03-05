import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.PURPLE);
        FlowPane flowPane = new FlowPane();

        Text text = new Text("A TextFlow Layout ");
        text.setFont(Font.font("Georgia", 14));
        text.setFill(Color.BLUE);
        text.setEffect(dropShadow);

        Text text1 = new Text("This is line 2 ");
        text1.setFont(Font.font("Georgia", 12));
        text1.setFill(Color.RED);
        text1.setEffect(dropShadow);


        TextFlow textFlow = new TextFlow(text);
        textFlow.setLayoutX(10);
        textFlow.setLayoutY(40);
        textFlow.setTranslateX(0);
        textFlow.setTranslateY(100);
        //root.setTextAlignment(TextAlignment.CENTER);
        textFlow.setLineSpacing(10);
        flowPane.getChildren().add(textFlow);
        flowPane.setLayoutX(10);
        flowPane.setLayoutY(20);
        flowPane.setStyle("-fx-background-color: gray;");

        TextFlow textFlow1 = new TextFlow(text1);
        textFlow1.setLayoutX(10);
        textFlow1.setLayoutY(40);
        textFlow1.setTranslateX(-100);
        textFlow1.setTranslateY(200);
        //root.setTextAlignment(TextAlignment.CENTER);
        textFlow1.setLineSpacing(10);
        flowPane.getChildren().add(textFlow1);
        flowPane.setLayoutX(10);
        flowPane.setLayoutY(20);
        flowPane.setStyle("-fx-background-color: gray;");


//        Scene scene = new Scene(textFlow, 300, 300, Color.LIGHTGREEN);
        Scene scene = new Scene(flowPane, 300, 300, Color.LIGHTGREEN);
        stage.setTitle("Example 62. TextFlow");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}