
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SnakeGame extends JFrame implements Runnable, KeyListener {

    Snake snake;
    Graphics g;
    Thread thread;
    Token token;

    boolean gameOver;


    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public SnakeGame() {

        gameOver = false;
        this.setSize(500, 500);
        this.setTitle("Snake Game");
        this.setVisible(true);  // Needed here for Graphics to work properly
        this.addKeyListener(this);
        snake = new Snake();
        token = new Token(snake);
       thread = new Thread(this);
       thread.start();
    }


    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        if(!gameOver) {
            snake.draw(g);
            token.draw(g);
        }
        else{
            g.setColor(Color.CYAN);
            g.drawString("Game Over",200,250);
        }
    }

    public void update (Graphics g) {
        paint(g);

    }

    public void repaint (Graphics g) {
        paint(g);

    }


    public void run() {
        for(;;) {

            if(!gameOver) {
                snake.move();
                this.checkGameOver();
                token.snakeCollision();
            }
            this.repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public void checkGameOver () {
        if (snake.getX() < 0 || snake.getX() > 496) {
            gameOver = true;
        }
        if (snake.getY() < 30 || snake.getY() > 496) {
            gameOver = true;
        }
        if (snake.snakeCollision()) {
            gameOver = true;
        }


    }


    public void keyPressed(KeyEvent e) {
        if(!snake.isMoving()) {
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
                    || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                snake.setIsMoving(true);
            }
        }


                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (snake.getYDir() != 1) {
                        snake.setYDir(-1);
                        snake.setXDir(0);
                    }
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (snake.getYDir() != -1) {
                        snake.setYDir(1);
                        snake.setXDir(0);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (snake.getXDir() != 1) {
                        snake.setXDir(-1);
                        snake.setYDir(0);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (snake.getXDir() != -1) {
                        snake.setXDir(1);
                        snake.setYDir(0);
                    }
                }
            }




    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }


    }

