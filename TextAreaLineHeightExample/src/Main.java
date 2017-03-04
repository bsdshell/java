import java.awt.Font;

import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
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
        area.setEditable(false);
        area.setFont(javafx.scene.text.Font.font(Font.MONOSPACED));

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        vbox.getChildren().add(area);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.hide();

        FontMetrics metrics = Toolkit.getToolkit().getFontLoader().getFontMetrics(area.getFont());
        Text t = (Text) area.lookup(".text");

        double lineHeight = metrics.getLineHeight();
        double actualLineHeight = t.getBoundsInLocal().getHeight() / lineCount;

        System.out.println("LineHeight: " + lineHeight);
        System.out.println("ActualHeight: " + actualLineHeight);
        System.out.println("Diff: " + (actualLineHeight - lineHeight));

        System.out.println();
        System.out.println(metrics);
        System.out.println();
        System.out.println("LayoutX "+t.getLayoutX());
        System.out.println("LayoutY "+t.getLayoutY());
        System.out.println("Width: "+t.getBoundsInLocal().getWidth());
        System.out.println("Height: "+t.getBoundsInLocal().getHeight());


        area.setMaxHeight(t.getBoundsInLocal().getHeight()*lineCount);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}