import java.awt.*;

public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;




    public MapGenerator(int row, int col){
        map = new int[row][col];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                map[i][j]= 1;
            }
        }
        brickHeight = 150/row;
        brickWidth = 540/col;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] > 0){
                    g.setColor(Color.WHITE);
                    g.fillRect(j * brickWidth + 88, i * brickHeight + 50, brickWidth, brickHeight);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j * brickWidth + 88, i * brickHeight + 50, brickWidth, brickHeight);
                }


            }
        }

        double newBorder = Math.random();
        if (newBorder >= 0.0 && newBorder <= 0.2) {
            g.setColor(Color.GREEN);
        }
        if (newBorder >= 0.2 && newBorder <= 0.4) {
            g.setColor(Color.ORANGE);
        }
        if (newBorder >= 0.4 && newBorder <= 0.6) {
            g.setColor(Color.YELLOW);
        }
        if (newBorder >= 0.6 && newBorder <= 0.8) {
            g.setColor(Color.RED);
        } else if (newBorder >= 0.8) {
            g.setColor(Color.BLUE);
        }

        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

    }





    public void setBrickValue(int value, int row, int col){
        map[row][col] = value;
    }
}
