import java.util.Random;

public class RandomNum {
    private int x;
    private int y;
    private int total;
    Random rand = new Random();

    public RandomNum(){
        x = 7;
        y = 3;
        total = 21;
    }
    public int getInitialTotal(){
        total = 21;
        return total;
    }

    public int getX() {
        x = rand.nextInt(5, 15);
        return x;
    }
    public int getInitialX(){
        return x;
    }

    public int getY() {
        y = rand.nextInt(5, 15);
        return y;
    }
    public int getInitialY(){
        return y;
    }

    public int getTotal() {
        total = x * y;
        return total;
    }
}
