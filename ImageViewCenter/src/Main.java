import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// center image, imageview center, image view center
// borderpane image
//
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/a/a7/Frankenstein's_monster_(Boris_Karloff).jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);

        BorderPane pane = new BorderPane();
        pane.setPrefSize(400, 300);
        pane.setCenter(imageView);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
