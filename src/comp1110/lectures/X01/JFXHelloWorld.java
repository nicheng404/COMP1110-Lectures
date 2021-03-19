package comp1110.lectures.X01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JFXHelloWorld extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello");
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);

        Text hi = new Text("Hello World!");
        hi.setFont(Font.font("Tahoma", FontWeight.BLACK, 40));
        hi.setFill(Color.RED);
        root.getChildren().add(hi);

        Rectangle r = new Rectangle(0, 0, 280, 70);
        r.setFill(Color.BLUE);
        root.getChildren().add(r);
        r.setOpacity(0.5);

        stage.show();
    }
}
