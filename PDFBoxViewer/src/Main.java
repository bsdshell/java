
import classfile.Print;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;


import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


// pdf file to image, pdf file to ImageView, pdf rendering, display pdf
//
// https://gist.github.com/c9katayama/bad980d6bfaf5150281d#file-pdfimageviewer-java-L40
//
// /Users/cat/myfile/github/JavaLib/jar
//
// Three jar files are required
// commons-logging-1.2.jar
// pdfbox-2.0.4.jar
// fontbox-2.0.4.jar

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    int pdfScale = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        String fName = "/Users/cat/try/tryspan.pdf";
        int width  = 600;
        int height = 600;
//
//        File file = new File(fName);
//        PDDocument doc = PDDocument.load(file);
//        if(doc == null){
//            Print.pbl("doc is null");
//        }
//
//        PDFRenderer renderer = new PDFRenderer(doc);
//        //PDFBoxでレンダリングして、BufferedImageを作成
//        BufferedImage img = renderer.renderImage(0, pdfScale);
//
//        //JavaFXで扱えるように、WritableImageに変換
//        WritableImage fxImage = SwingFXUtils.toFXImage(img, null);
//        ImageView imageView = new ImageView(fxImage);
        ImageView imageView = pdfToImage(fName);
        pane.getChildren().add(imageView);

        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public ImageView pdfToImage(String fName) throws Exception{
        File file = new File(fName);
        PDDocument doc = PDDocument.load(file);
        if(doc == null){
            Print.pbl("doc is null");
        }

        PDFRenderer renderer = new PDFRenderer(doc);
        //PDFBoxでレンダリングして、BufferedImageを作成
        BufferedImage img = renderer.renderImage(0, pdfScale);

        //JavaFXで扱えるように、WritableImageに変換
        WritableImage fxImage = SwingFXUtils.toFXImage(img, null);
        ImageView imageView = new ImageView(fxImage);
        return imageView;
    }
}