import com.sun.javafx.scene.control.behavior.TextBinding;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.InnerShadowBuilder;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

// javafx color text, color string, multiple color text
// javafx different color text, javafx color string
// javafx text concatenation, javafx string concat
//
public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) {
        String family = "Helvetica";
        double size = 50;

        TextFlow textFlow = new TextFlow();
        textFlow.setLayoutX(40);
        textFlow.setLayoutY(40);
        Text text1 = new Text("Hello ");
        text1.setFont(Font.font(family, size));
        text1.setFill(Color.RED);
        Text text2 = new Text("Bold\n");
        text2.setFill(Color.ORANGE);
        text2.setFont(Font.font(family, FontWeight.BOLD, size));
        Text text3 = new Text("World");
        text3.setFill(Color.GREEN);
        text3.setFont(Font.font(family, FontPosture.ITALIC, size));
        textFlow.getChildren().addAll(text1, text2, text3);

        Group group = new Group(textFlow);
        Scene scene = new Scene(group, 500, 150, Color.WHITE);
        stage.setTitle("Hello Rich Text");
        stage.setScene(scene);
        stage.show();
    }
}