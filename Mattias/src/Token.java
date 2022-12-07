import java.awt.*;

public class Token {

    private int x, y, score;
    private Snake snake;

    public Token (Snake s) {
        x = (int) (Math.random() * 393);
        y = (int) ((Math.random() * 363) + 30);
        snake = s;
    }

   public void changePosition () {
        x = (int) (Math.random() * 393);
        y = (int) ((Math.random() * 363) + 30);
    }

    public int getScore() {
        return score;
    }

    public void draw(Graphics g, int x) {
        if (x == 1) {
            g.setColor(Color.GREEN);
        }
        else{
            g.setColor(Color.RED);
        }
        g.fillRect(this.x,y,10,10);
        g.setColor(Color.orange);
        g.fillRect(this.x+4,y-3,3,7);
        g.setColor(Color.WHITE);
        g.fillOval(this.x+1,y+3,3,3);

    }

    public boolean snakeCollision() {
        int snakeX = snake.getX() + 2;
        int snakeY = snake.getY() + 2;

        if (snakeX >= x - 2 && snakeX <= (x+9)) {
            if (snakeY >= y-2 && snakeY <= (y+9)) {
                changePosition();
                score++;
                snake.setElongate(true);
                return true;
            }
        }
        return false;
    }







}
