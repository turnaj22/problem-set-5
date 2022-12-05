import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    private int x, y;
    boolean isMoving, elongate;
    final int STARTSIZE = 20, STARTX = 150, STARTY = 150;


    List<Point> snakePoints;
    int xDir, yDir;
    public Snake() {

        // list of points that the snake is at
        snakePoints = new ArrayList<Point>();
        xDir = 0;
        yDir = 0;
        isMoving = false;
        elongate = false;
        snakePoints.add(new Point(STARTX, STARTY));
        for (int i = 1; i < STARTSIZE; i++) {

            snakePoints.add(new Point(STARTX - i * 4, STARTY));
        }


    }


    public void draw(Graphics g) {
        g.setColor(Color.RED);
        for(Point p : snakePoints) {
            g.fillRect(p.getX(), p.getY(), 4, 4);
        }

    }

    public void move() {
       if(isMoving == true) {
            Point temp = snakePoints.get(0);
            Point last = snakePoints.get(snakePoints.size() - 1);

            // creates new head of snake in any direction that the user inputs
            Point newStart = new Point(temp.getX() + (xDir * 4), temp.getY() + (yDir * 4));
            System.out.println("X: " + newStart.getX() + ",  Y: " + newStart.getY());
            for(int i = snakePoints.size() - 1; i >= 1; i--) {
                snakePoints.set(i, snakePoints.get(i-1));
            }
           snakePoints.set(0,newStart);

        }

    }

   public boolean snakeCollision () {
        int x = this.getX();
        int y = this.getY();

        for (int i = 1; i < snakePoints.size(); i++) {
            if(snakePoints.get(i).getX() == x && snakePoints.get(i).getY() == y)  {
                return true;
            }
        }
        return false;
   }

    public boolean isMoving() {
        return isMoving;
    }

    public void setIsMoving(boolean b) {
        isMoving = b;
    }

    public int getXDir () {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }

    public void setXDir(int xDir) {
        this.xDir = xDir;
    }

    public void setYDir(int yDir) {
        this.yDir = yDir;
    }

    // X. position of head of snake
    public int getX() {
        return snakePoints.get(0).getX();
    }

    public int getY () {
        return snakePoints.get(0).getY();
    }

}
