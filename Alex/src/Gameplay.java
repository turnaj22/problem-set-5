import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;
    private RandomNum randomNum;

    private int totalBricks;

    private Timer timer;
    private int delay = 8;

    private int playerX = 310;

    private int ballPosX = 200;
    private int ballPosY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;
    private int bricksBroken = 0;
    private MapGenerator map;
    private int x;
    private int y;
    private int total;
    private int level = 1;
    private int flag = 0;
    private int scoreboard = 0;
    private int flag2 = 0;
    private int dirY = -1;
    private int dirX;
    private int x1 = ballPosX;
    private int y1 = ballPosY;
    private int powX = x1;
    private int powY = y1;
    private int i = 0;
    private int powerUp;

    private int flag3 = 0;
    private int ballPosX1 = 200;
    private int ballPosY1 = 350;
    private int ballXdir1 = -1;
    private int ballYdir1 = -2;
    private int flag4 = 1;


    public Gameplay(){
        map = new MapGenerator(3, 7);
        randomNum = new RandomNum();
        total = randomNum.getInitialTotal();
        if(level == 1) {
            x = randomNum.getInitialX();
            y = randomNum.getInitialY();
        }
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){
        //background
        g.setColor(Color.black);
        g.fillRect(1,1, 692, 592);


        //borders
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,3, 592);
        g.fillRect(0,0,692, 3);
        g.fillRect(691,0,3, 592);


        if(scoreboard == 1){
            g.setColor(Color.BLACK);
            g.fillRect(1,1, 692, 592);
            g.setColor(Color.GREEN);
            g.setFont(new Font("serif", Font.BOLD, 50));
            g.drawString("Top 4 Players", 200, 200);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Name", 230, 260);
            g.drawString("1: Alex", 220, 290);
            g.drawString("2: Troy", 220, 320);
            g.drawString("3: Mattias", 220, 350);
            g.drawString("4: Josh", 220, 380);
            g.drawString("Score", 400, 260);
            g.drawString("1,000", 400, 290);
            g.drawString("1,000", 400, 320);
            g.drawString("1,000", 400, 350);
            g.drawString("1,000", 400, 380);
            g.drawString("Press escape to leave", 20, 30);
        }

        if(flag == 0) {
            //welcome screen
            g.setColor(Color.GREEN);
            g.setFont(new Font("serif", Font.BOLD, 50));
            g.drawString("Brick Breaker", 200, 200);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Press p to play", 275, 325);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Press tab for scoreboard", 220, 360);
        }


        if(flag == 1 && flag2 == 1) {
            flag = 1;
            //map
            map.draw((Graphics2D) g);

            //score
            g.setColor(Color.WHITE);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Score: " + score, 570, 30);

            //paddle
            g.setColor(Color.GREEN);
            g.fillRect(playerX, 550, 100, 8);

            //ball
            if (bricksBroken >= 15) {
                if (randomNum.ballColor() == 0) {
                    g.setColor(Color.GREEN);
                }
                if (randomNum.ballColor() == 1) {
                    g.setColor(Color.BLUE);
                }
                if (randomNum.ballColor() == 2) {
                    g.setColor(Color.PINK);
                }
                if (randomNum.ballColor() == 3) {
                    g.setColor(Color.red);
                }
                if (randomNum.ballColor() == 4) {
                    g.setColor(Color.ORANGE);
                }
            }
            if (bricksBroken < 15) {
                if (level == 1) {
                    g.setColor(Color.PINK);
                }
                if (level == 2) {
                    g.setColor(Color.GREEN);
                }
                if (level == 3) {
                    g.setColor(Color.blue);
                }
                if (level == 4) {
                    g.setColor(Color.ORANGE);
                }
            }
            g.fillOval(ballPosX, ballPosY, 20, 20);

            //power up
            if(flag4 == 1) {
                if (powerUp == 1) {
                    while (i < 1) {
                        i = 2;
                        x1 = ballPosX;
                        y1 = ballPosY;
                    }
                    powX = x1;
                    powY = y1;
                    g.setColor(Color.RED);
                    g.fillRect(x1, y1, 20, 20);
                }
            }


            //new ball
            if(flag3 == 1){
                if (bricksBroken >= 15) {
                    if (randomNum.ballColor() == 0) {
                        g.setColor(Color.GREEN);
                    }
                    if (randomNum.ballColor() == 1) {
                        g.setColor(Color.BLUE);
                    }
                    if (randomNum.ballColor() == 2) {
                        g.setColor(Color.PINK);
                    }
                    if (randomNum.ballColor() == 3) {
                        g.setColor(Color.red);
                    }
                    if (randomNum.ballColor() == 4) {
                        g.setColor(Color.ORANGE);
                    }
                }
                if (bricksBroken < 15) {
                    if (level == 1) {
                        g.setColor(Color.PINK);
                    }
                    if (level == 2) {
                        g.setColor(Color.GREEN);
                    }
                    if (level == 3) {
                        g.setColor(Color.blue);
                    }
                    if (level == 4) {
                        g.setColor(Color.ORANGE);
                    }
                }
                g.fillOval(ballPosX1, ballPosY1, 20, 20);
            }

            if(flag4 == 0) {
                if (ballPosY > 570 && ballPosY1 > 570) {
                    play = false;
                    ballXdir = 0;
                    ballYdir = 0;
                    g.setColor(Color.RED);
                    g.setFont(new Font("serif", Font.BOLD, 30));
                    g.drawString("Game Over Score: " + score, 190, 300);

                    g.setFont(new Font("serif", Font.BOLD, 20));
                    g.drawString("Press Enter to Restart", 230, 350);
                }
            }
            else{
                if (ballPosY > 570) {
                    play = false;
                    ballXdir = 0;
                    ballYdir = 0;
                    g.setColor(Color.RED);
                    g.setFont(new Font("serif", Font.BOLD, 30));
                    g.drawString("Game Over Score: " + score, 190, 300);

                    g.setFont(new Font("serif", Font.BOLD, 20));
                    g.drawString("Press Enter to Restart", 230, 350);
                }
            }
            if (bricksBroken == x * y) {
                g.setColor(Color.GREEN);
                g.setFont(new Font("serif", Font.BOLD, 30));
                g.drawString("Level Complete!", 230, 300);
                g.drawString("Press Shift For Next Level", 190, 350);
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Level: " + level, 20, 30);

            g.dispose();
        }
    }
    public void actionPerformed(ActionEvent e) {
        timer.start();
            if (play) {
                if (new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX + 50, 550, 49, 8))) {
                    ballYdir = -ballYdir;
                }
                if (new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 49, 8))) {
                    ballYdir = -ballYdir;
                    ballXdir = -ballXdir;
                }
                if (new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX + 50, 550, 1, 8))) {
                    ballYdir = -ballYdir;
                }
                if (new Rectangle(ballPosX1, ballPosY1, 20, 20).intersects(new Rectangle(playerX + 50, 550, 49, 8))) {
                    ballYdir1 = -ballYdir1;
                }
                if (new Rectangle(ballPosX1, ballPosY1, 20, 20).intersects(new Rectangle(playerX, 550, 49, 8))) {
                    ballYdir1 = -ballYdir1;
                    ballXdir1 = -ballXdir1;
                }
                if (new Rectangle(ballPosX1, ballPosY1, 20, 20).intersects(new Rectangle(playerX + 50, 550, 1, 8))) {
                    ballYdir1 = -ballYdir1;
                }
                if (new Rectangle(powX, powY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                    flag3 = 1;
                    flag4 = 0;
                }

                A:
                for (int i = 0; i < map.map.length; i++) {
                    for (int j = 0; j < map.map[0].length; j++) {
                        if (map.map[i][j] > 0) {
                            int brickX = j * map.brickWidth + 80;
                            int brickY = i * map.brickHeight + 50;
                            int brickWidth = map.brickWidth;
                            int brickHeight = map.brickHeight;

                            Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                            Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
                            Rectangle ballRect1 = new Rectangle(ballPosX1, ballPosY1, 20, 20);
                            Rectangle brickRect = rect;
                            if (ballRect.intersects(brickRect)) {
                                map.setBrickValue(0, i, j);
                                totalBricks--;
                                score += 5;
                                bricksBroken++;
                                x1 = ballPosX;
                                y1 = ballPosY;
                                if(flag4 == 1){
                                    powerUp = randomNum.powerUp();
                                }
                                if (ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width) {
                                    ballXdir = -ballXdir;
                                } else {
                                    ballYdir = -ballYdir;
                                }
                                break A;
                            }
                            if(flag3 == 1) {
                                if (ballRect1.intersects(brickRect)) {
                                    map.setBrickValue(0, i, j);
                                    totalBricks--;
                                    score += 5;
                                    bricksBroken++;
                                    x1 = ballPosX1;
                                    y1 = ballPosY1;
                                    if(flag4 == 1) {
                                        powerUp = randomNum.powerUp();
                                    }

                                    if (ballPosX1 + 19 <= brickRect.x || ballPosX1 + 1 >= brickRect.x + brickRect.width) {
                                        ballXdir1 = -ballXdir1;
                                    } else {
                                        ballYdir1 = -ballYdir1;
                                    }
                                    break A;
                                }
                            }
                        }
                    }
                }

                ballPosX += ballXdir;
                ballPosY += ballYdir;
                if (flag3 == 1) {
                    ballPosX1 += ballXdir1;
                    ballPosY1 += ballYdir1;
                }
                y1 -= dirY;


                if (ballPosX < 0) {
                    ballXdir = -ballXdir;
                }
                if (ballPosY < 0) {
                    ballYdir = -ballYdir;
                }
                if (ballPosX > 670) {
                    ballXdir = -ballXdir;
                }
                if (flag3 == 1) {
                    if (ballPosX1 < 0) {
                        ballXdir1 = -ballXdir1;
                    }
                    if (ballPosY1 < 0) {
                        ballYdir1 = -ballYdir1;
                    }
                    if (ballPosX1 > 670) {
                        ballXdir1 = -ballXdir1;
                    }
                }
        }
//            if (bricksBroken == 21){
//                ballPosX = 200;
//                ballPosY = 350;
//            }
            if(bricksBroken == x*y){
                ballPosX = 200;
                ballPosY = 350;
            }
            repaint();

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!play){
                play = true;
                ballPosX = 200;
                ballPosY = 350;
                ballXdir = -1;
                ballYdir = -2;
                playerX = 310;
                score = 0;
                totalBricks = 21;
                bricksBroken = 0;
                flag4 = 1;
                powerUp = 0;
                map = new MapGenerator(3, 7);

                repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT){
            if(bricksBroken == x * y) {
                   play = false;
                   x = randomNum.getX();
                   y = randomNum.getY();
                   ballPosX = 200;
                   ballPosY = 350;
                   ballXdir = -1;
                   ballYdir = -2;
                   playerX = 310;
                   totalBricks = x * y;
                   bricksBroken = 0;
                   flag4 = 1;
                   powerUp = 0;
                   level++;
                   total = randomNum.getTotal();
                   map = new MapGenerator(x, y);

                   repaint();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerX >= 600){
                playerX = 600;
            }
            else{
                moveRight();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(playerX < 10){
                playerX = 10;
            }
            else{
                moveLeft();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_P){
            flag = 1;
            flag2 = 1;
        }
        if(e.getKeyCode() == KeyEvent.VK_TAB){
            flag2 = 0;
            flag = 1;
            scoreboard = 1;
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            flag = 0;
            scoreboard = 0;
        }
    }

    public void keyReleased(KeyEvent e) {

    }


    public void moveRight(){
        play = true;
        playerX += 35;
    }
    public void moveLeft(){
        play = true;
        playerX -= 35;
    }
//
}
