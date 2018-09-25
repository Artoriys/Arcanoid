import javafx.geometry.Bounds;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Platform extends Rectangle {
    public Platform() {
        super();
    }

    public Platform(double width, double height) {
        super(width, height);
    }

    public Platform(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public Platform(double width, double height, Paint fill) {
        super(width, height, fill);
    }

    public double PlatformCollision(double dy) {

        if ((GameField.ball.getLayoutY() == (GameField.platform.getHeight() - GameField.ball.getRadius()))&&(GameField.ball.getLayoutX() <= GameField.platform.getWidth())) {

            dy = -dy;

        }

        return dy;
    }
}
