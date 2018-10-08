import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
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
    Bounds bounds = GameField.canvas.getBoundsInLocal();
    static Timeline timeline;


    @Override
    public void start(Stage stage) {
        canvas.getChildren().add(ball);
        canvas.getChildren().add(platform);
        ball.relocate(50, 50);
        platform.relocate(235,495);

        stage.setScene(scene);
        stage.setTitle("Cat Arcanoid");

        stage.show();




        timeline = new Timeline(new KeyFrame(Duration.millis(10),
                new EventHandler<ActionEvent>() {
            double dx = 3;
            double dy = 3;

                    @Override
                    public void handle(ActionEvent t) {
                        ball.setLayoutX(ball.getLayoutX() + dx);
                        ball.setLayoutY(ball.getLayoutY() + dy);

                        dx = ball.XCollision(dx);
                        dy = ball.YCollision(dy);
                        dy = platform.PlatformCollision(dy);
                        ball.GameOver();
                        canvas.requestFocus();
                        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent event) {
                                if ((event.getCode() == KeyCode.LEFT) && (platform.getLayoutX() > bounds.getMinX())) {
                                    platform.LeftShift();
                                    event.consume();
                                }

                                if ((event.getCode() == KeyCode.RIGHT) && ((platform.getLayoutX()+platform.getWidth()) < bounds.getMaxX())) {
                                    platform.RightShift();
                                    event.consume();
                                }
                            }
                        });


                    }

        }));

             timeline.setCycleCount(Timeline.INDEFINITE);
             timeline.play();

}
}
