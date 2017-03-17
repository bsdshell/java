import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;

// http://stackoverflow.com/questions/34351258/java-fx-8-textarea-lineheight-is-smaller-than-actual-when-got-from-fontmetrics
//
// textarea font height, line height, font width, textarea font width
// compute the line height and set the height of TextArea dynamically
//
public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);

        TextArea area = new TextArea();

        int lineCount = 10;

        String text = "";
        for (int i = 0; i < lineCount; i++) {
            if(i < lineCount - 1)
                text += "LINE" + (i + 1) + "\n";
            else
                text += "LINE" + (i + 1);
        }
        area.setText(text);
        area.setMinSize(600, 600);
        area.setEditable(false);
        area.setFont(javafx.scene.text.Font.font(Font.MONOSPACED));

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.getChildren().add(new HBox(area));


        List<String> imagesList = new ArrayList<String>(Arrays.asList("/Users/cat/try/draw14.png", "/Users/cat/try/draw15.png"));
        List<ImageView> imageViewList = imageFileToImageView(imagesList, 600, 600);
        for(ImageView iv : imageViewList){
            vbox.getChildren().add(iv);
        }

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private static List<ImageView> imageFileToImageView(List<String> listImgNames, double imgWidth, double imgHeight){
        List<ImageView> imageList = new ArrayList<ImageView>();

        for (String imgPath : listImgNames) {
            ImageView imageView = new ImageView(new File(imgPath).toURI().toString());
            imageList.add(imageView);
            imageView.setFitHeight(imgWidth);
            imageView.setFitWidth(imgHeight);
            imageView.setPreserveRatio(true);
        }
        return imageList;
    }
}