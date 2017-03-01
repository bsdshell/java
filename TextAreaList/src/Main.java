import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    }
    public static void main(String[] args) {
        launch(args);
    }
}