import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {
    public static void main(String[] args) { launch(Main.class); }

    @Override public void start(Stage stage) {
        Label label = new Label(
                "Power is my mistress.\n" +
                        "I have worked too hard at her conquest " +
                        "to allow anyone to take her away from me.\n" +
                        " - Napoleon Bonaparte");
        label.setPadding(new Insets(100));

        // as the default font spacing in JavaFX is 13 points,
        // all of the following lines will provide the same results
        // (double spacing the label text).
        //
        // label.setLineSpacing(13);
        // label.setStyle("-fx-line-spacing: 13px;");
        label.setStyle("-fx-line-spacing: 1em;");

//        stage.setScene(new Scene(label));
//        stage.show();


        TextArea area = new TextArea("This is some random very long text\n more text here\n more text");
        area.setWrapText(true);
        area.setMaxHeight(100);
        area.setMaxWidth(200);
        area.setStyle("-fx-font: 14pt Arial");
        StackPane root = new StackPane(area);

        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.show();

        Text t = (Text)area.lookup(".text");
        System.out.println("LayoutX "+t.getLayoutX());
        System.out.println("LayoutY "+t.getLayoutY());
        System.out.println("Width: "+t.getBoundsInLocal().getWidth());
        System.out.println("Height: "+t.getBoundsInLocal().getHeight());
        //area.setPrefHeight(t.getBoundsInLocal().getHeight());
//        stage.hide();
//        stage.show();


    }
}
