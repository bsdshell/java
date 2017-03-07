import classfile.Aron;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
//      test0(stage);
      test1(stage);
    }

    public void test0(Stage stage){
        Aron.beg();

        VBox box = new VBox();
        Scene scene = new Scene(box, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Scroll Pane");
        box.getChildren().addAll(sp, fileName);
        VBox.setVgrow(sp, Priority.ALWAYS);

        fileName.setLayoutX(30);
        fileName.setLayoutY(160);

        List<ImageView> imageViewList = imageFileToImageView(Arrays.asList(imageNames));
        for(ImageView iv : imageViewList) {
            vb.getChildren().add(iv);
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

        Aron.end();
    }

    /**
     * read image files from input and create a list of ImageViews
     *
     * @param listImgNames is a list of image names
     * @return a list of ImageViews
     */
    public List<ImageView> imageFileToImageView(List<String> listImgNames){
        List<ImageView> imageList = new ArrayList<ImageView>();
        for (String imgPath : listImgNames) {
            //TODO: Add getResource to get the resources/images
            //images[i] = new Image(getClass().getResourceAsStream(imageNames[i]));
            //Print.pbl(images[i].toString());
            ImageView imageView = new ImageView(new File(imgPath).toURI().toString());
            imageList.add(imageView);
            imageView.setFitHeight(400);
            imageView.setFitWidth(400);
            imageView.setPreserveRatio(true);
            imageList.add(imageView);
        }
        return imageList;
    }

    public void test1(Stage stage){
        Aron.beg();
        VBox box = new VBox();
        Scene scene = new Scene(box, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Scroll Pane");
        box.getChildren().addAll(sp, fileName);
        VBox.setVgrow(sp, Priority.ALWAYS);

        fileName.setLayoutX(30);
        fileName.setLayoutY(160);
        List<Pane> listFlowPane = new ArrayList<Pane>();

        //
        // Using Pane as super class in the list ??? add FlowPane, BorderPane, StackPane and so on so that
        // location can be specified.
        //
        for (int i = 0; i < 5; i++) {
            //images[i] = new Image(getClass().getResourceAsStream(imageNames[i]));
            //Print.pbl(images[i].toString());
            pics[i] = new ImageView(new File(imageNames[i]).toURI().toString());
            pics[i].setFitHeight(300);
            pics[i].setFitWidth(300);
            pics[i].setPreserveRatio(true);

            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(pics[i]);
            borderPane.setStyle("-fx-background-color: gray;");

            vb.getChildren().add(borderPane);
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

        Aron.end();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
