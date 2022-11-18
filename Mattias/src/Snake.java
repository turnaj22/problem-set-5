import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    private int x, y;
    boolean isMoving, elongate;
    final int


    List<Point> snakePoints;
    int xDir, yDir;
    public Snake() {
        snakePoints = new ArrayList<Point>();
        xDir = 0;
        yDir = 0;
        isMoving = false;
        elongate = false;
    }


    public void draw(Graphics g) {
        g.setColor(Color.white);
        for(Point p : snakePoints) {
            g.fillRect(p.getX(), p.getY(), 4, 4);
        }

    }

    public int getXDir () {
        return xDir;
    }

    public int getyDir() {
        return yDir;
    }

    public void setxDir(int xDir) {
        this.xDir = x;
    }

    public void setyDir(int yDir) {
        this.yDir = y;
    }

    // X. position of head of snake
    public int getX() {
        return snakePoints.get(0).getX();
    }

    public int getY () {
        return snakePoints.get(0).getY();
    }

}
