import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Main extends Application {

    FlowPane flowPane = new FlowPane();

    @Override
    public void start(Stage primaryStage) {

        flowPane.setVgap(10);
        flowPane.setHgap(10);
        flowPane.setPadding(new Insets(25));
//        Random random = new Random();
//        int r, g, b;
//        for (int i=10; i<80; i+=5) {
//            r = random.nextInt(256);
//            g = random.nextInt(256);
//            b = random.nextInt(256);
//            addCirc(i, Color.rgb(r, g, b));
//        }

        addTextFlow();
        Scene scene = new Scene(flowPane, 500, 500, Color.HONEYDEW);

        primaryStage.setTitle("Example 19. Flowpane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void addCirc(double radius, Color color) {
        Circle circle = new Circle();
        circle.setRadius(radius);
        circle.setFill(color);
        flowPane.getChildren().add(circle);
    }
    private void addTextFlow(){
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.PURPLE);

        Text text = new Text("A TextFlow Layout ");
        text.setFont(Font.font("Georgia", 14));
        text.setFill(Color.BLUE);
        text.setEffect(dropShadow);

        Text text1 = new Text("This is Line 2");
        text1.setFont(Font.font("Georgia", 12));
        text1.setFill(Color.RED);
        text1.setEffect(dropShadow);
        text1.setX(10);
        text1.setY(40);


        TextFlow textFlow = new TextFlow(text);
        textFlow.setLayoutX(10);
        textFlow.setLayoutY(20);
        //root.setTextAlignment(TextAlignment.CENTER);
        textFlow.setLineSpacing(10);
        //flowPane.getChildren().add(textFlow);

        TextFlow textFlow1 = new TextFlow(text1);
//        textFlow1.setLayoutX(10);
//        textFlow1.setLayoutY(40);
        //root.setTextAlignment(TextAlignment.CENTER);
        textFlow1.setLineSpacing(10);
        flowPane.getChildren().add(textFlow1);
        flowPane.setLayoutX(10);
        flowPane.setLayoutY(10);
        flowPane.setStyle("-fx-background-color: gray;");
    }
}
