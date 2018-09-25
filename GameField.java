import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.util.Duration;


public class GameField extends Application {

    public static GameField me;
    public GameField()
    {
        me=this;
    }

    static Pane canvas = new Pane();
    static Ball ball = new Ball(5, Color.WHITE);
    static Platform platform = new Platform(80,5, Color.WHITE);
    Scene scene = new Scene(canvas,550,500, Color.BLACK);




    @Override
    public void start(Stage stage) {
        canvas.getChildren().add(ball);
        canvas.getChildren().add(platform);
        ball.relocate(50, 50);
        platform.relocate(235,495);

        stage.setScene(scene);
        stage.setTitle("Cat Arcanoid");

        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {
            double dx = 10;
            double dy = 10;

                    @Override
                    public void handle(ActionEvent t) {
                        ball.setLayoutX(ball.getLayoutX() + dx);
                        ball.setLayoutY(ball.getLayoutY() + dy);

                        dx = ball.XCollision(dx);
                        dy = ball.YCollision(dy);
                        dy = platform.PlatformCollision(dy);
                    }


                }));
             timeline.setCycleCount(Timeline.INDEFINITE);
             timeline.play();



}
}
