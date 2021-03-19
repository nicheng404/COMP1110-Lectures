package comp1110.lectures.X02;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JFXKeyEvent extends Application {
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

        scene.setOnKeyTyped(event -> {
            String c = event.getCharacter();
            if (c.equals("q")) {
                Platform.exit(); // this is how to exit a JavaFX application
                // System.exit(1); // this is how you might exit a regular Java app
            }
            hi.setText(c);
        });

        stage.show();
    }
}
