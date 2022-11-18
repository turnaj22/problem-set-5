import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame extends JFrame implements Runnable, KeyListener{

    private Snake snake;
    private int x;
    private Graphics g;


    public SnakeGame() {
        snake = new Snake();
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Snake Game");
        this.setVisible(true);  // Needed here for Graphics to work properly
        this.addKeyListener(this);
    }


    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //snake.draw(g);
    }

    public void update (Graphics g) {
        paint(g);
    }

    public void repaint (Graphics g) {
        paint(g);

    }


    public void run() {

    }

    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {

        }
        if(e.getKeyCode() == KeyEvent.VK_S) {

        }
        if(e.getKeyCode() == KeyEvent.VK_D) {

        }
        if(e.getKeyCode() == KeyEvent.VK_A) {

        }

    }


    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
