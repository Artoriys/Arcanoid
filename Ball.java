import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;



public class Ball extends Circle {
    public Ball() {
        super();
    }

    public Ball(double radius) {
        super(radius);
    }

    public Ball(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius);
    }
    public Ball (double centerX, double centerY, double radius, Paint fill) {
        super(centerX, centerY, radius, fill);
    }
    public Ball (double radius, Paint fill) {
        super(radius, fill);
    }




    public double XCollision(double dx) {
        Bounds bounds = GameField.canvas.getBoundsInLocal();


        //If the ball reaches the left or right border make the step negative
        if(GameField.ball.getLayoutX() <= (bounds.getMinX() + GameField.ball.getRadius()) ||
                GameField.ball.getLayoutX() >= (bounds.getMaxX() - GameField.ball.getRadius()) ){

            dx = -dx;

        }
        return dx;
    }

    public double YCollision(double dy) {
        Bounds bounds = GameField.canvas.getBoundsInLocal();


        if (GameField.ball.getLayoutY() <= (bounds.getMinY() + GameField.ball.getRadius()) ||
                GameField.ball.getLayoutY() >= (bounds.getMaxY() - GameField.ball.getRadius())) {

            dy = -dy;

        }
        return dy;
    }
    public void GameOver() {
        Bounds bounds = GameField.canvas.getBoundsInLocal();
        if (GameField.ball.getLayoutY() == (bounds.getMaxY() - GameField.ball.getRadius())) {
            System.out.println("Game Over!!");
            GameField.timeline.stop();
        }
    }

    }

