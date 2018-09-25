import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.util.Duration;

import java.sql.Time;

public class Background extends Application {
    @Override
    public void start(Stage stage) {
        Circle cir = new Circle(225, 490, 5, Color.WHITE);
        Group background = new Group(cir);
        Scene scene = new Scene(background, Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("First Application");
        stage.setWidth(550);
        stage.setHeight(500);
        stage.show();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        KeyValue kx = new KeyValue(cir.centerXProperty(), 50);
        KeyValue ky = new KeyValue(cir.centerYProperty(), 100);
        KeyFrame kf = new KeyFrame(Duration.millis(1000), kx,ky);
        timeline.getKeyFrames().add(kf);
        timeline.play();

    }

}
