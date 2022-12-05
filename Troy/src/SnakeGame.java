import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame extends JFrame implements Runnable, KeyListener {
    Graphics gfx;
    Image img;


    public void init (){
        this.resize(400,400);
        img = createImage(400,400);
        gfx = img.getGraphics();


    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
        gfx.setColor(Color.black);
        gfx.fillRect(0,0,400,400);

        g.drawImage(img, 0, 0, null);

    }

    public void update(Graphics g){
        paint(g);

    }

    public void repaint(Graphics g){
        paint(g);

    }

    public void run() {

    }


    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        if (e.getExtendedKeyCode() == KeyEvent.VK_UP) {
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
        }

    }


    public void keyReleased(KeyEvent e) {

    }
}
