
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SnakeGame extends JFrame implements Runnable, KeyListener {

    public Snake snake;
    public SnakeGame game;
    public Thread thread;
    private Token token;
    private Token token2;

    public boolean gameOver;


    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public SnakeGame() {

        gameOver = false;
        this.setSize(400, 400);
        this.setTitle("Snake Game");
        this.setVisible(true);  // Needed here for Graphics to work properly
        this.addKeyListener(this);
        snake = new Snake();
        token = new Token(snake);
        token2 = new Token(snake);
       thread = new Thread(this);
       thread.start();
    }


    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 400, 400);
        if(!gameOver) {
            snake.draw(g);
            token.draw(g,1);
            token2.draw(g,2);
        }
        else{
            int x = token2.getScore() + token.getScore();
            g.setColor(Color.CYAN);
            super.setTitle("Snake :,(");
            g.drawString("Game Over",150,175);
            g.drawString("Score: " + x, 150,190);
            g.drawString("Play Again? (press y)",150,150);
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                int x = token2.getScore() + token.getScore();
                super.setTitle("Score: " + x);
                snake.move();
                this.checkGameOver();
                token.snakeCollision();
                token2.snakeCollision();
            }
            this.repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public void checkGameOver () {
        if (snake.getX() < 0 || snake.getX() > 396) {
            gameOver = true;
        }
        if (snake.getY() < 30 || snake.getY() > 396) {
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

        if (e.getKeyCode() == KeyEvent.VK_Y) {
            if (gameOver) {
                game = new SnakeGame();

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

