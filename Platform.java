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
        boolean x;
       // x = ((GameField.ball.getLayoutX() >= GameField.platform.getX())&&(GameField.ball.getLayoutX() <= (GameField.platform.getX()+GameField.platform.getWidth())));
        x = ((GameField.platform.getLayoutY() - GameField.platform.getHeight()) == GameField.ball.getLayoutY()) && ((GameField.ball.getLayoutX() >= (GameField.platform.getLayoutX())-GameField.platform.getWidth()/2)&&(GameField.ball.getLayoutX() <= (GameField.platform.getLayoutX()+(GameField.platform.getWidth())/2)));
        System.out.println(x);
        //if ((GameField.ball.getLayoutY() == (GameField.platform.getHeight() - GameField.ball.getRadius()))&&(GameField.ball.getLayoutX() <= GameField.platform.getWidth()))
        //if( ((GameField.ball.getCenterX() >= GameField.platform.getX())&&(GameField.ball.getCenterX() <= GameField.platform.getX()+GameField.platform.getWidth()) ) && ((GameField.ball.getCenterY()-GameField.ball.getRadius()) >= GameField.platform.getY()))
            if ( ((GameField.platform.getLayoutY() - GameField.platform.getHeight()) == GameField.ball.getLayoutY()) && ((GameField.ball.getLayoutX() >= (GameField.platform.getLayoutX()-1))&&(GameField.ball.getLayoutX() <= (GameField.platform.getLayoutX())+GameField.platform.getWidth()+1)) )
        {

            dy = -dy+1;

        }

        return dy;
    }

    public void LeftShift(){
        double dx = 20;
        GameField.platform.setLayoutX(GameField.platform.getLayoutX()-dx);
    }

    public void RightShift(){
        double dx = 20;
        GameField.platform.setLayoutX(GameField.platform.getLayoutX()+dx);
    }
}
