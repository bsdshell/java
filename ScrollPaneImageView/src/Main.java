import classfile.Print;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    final ScrollPane sp = new ScrollPane();
    final Image[] images = new Image[5];
    final ImageView[] pics = new ImageView[5];
    final VBox vb = new VBox();
    final Label fileName = new Label();
    final String [] imageNames = new String [] {
            "/Users/cat/try/draw10.png",
            "/Users/cat/try/draw11.png",
            "/Users/cat/try/draw12.png",
            "/Users/cat/try/draw13.png",
            "/Users/cat/try/draw14.png",
            "/Users/cat/try/draw15.png"
    };

    @Override
    public void start(Stage stage) {
        VBox box = new VBox();
        Scene scene = new Scene(box, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Scroll Pane");
        box.getChildren().addAll(sp, fileName);
        VBox.setVgrow(sp, Priority.ALWAYS);

        fileName.setLayoutX(30);
        fileName.setLayoutY(160);

        for (int i = 0; i < 5; i++) {
            //images[i] = new Image(getClass().getResourceAsStream(imageNames[i]));
            //Print.pbl(images[i].toString());
            pics[i] = new ImageView(new File(imageNames[i]).toURI().toString());
            pics[i].setFitHeight(400);
            pics[i].setFitWidth(400);
            pics[i].setPreserveRatio(true);
            vb.getChildren().add(pics[i]);
        }

        sp.setVmax(440);
        sp.setPrefSize(400, 400);
        sp.setContent(vb);
        sp.vvalueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                fileName.setText(imageNames[(new_val.intValue() - 1)/100]);
            }
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
