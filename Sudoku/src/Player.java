import java.util.Random;

/**
 * Created by Nik on 30.03.2015.
 */
public class Player {
    private int x;
    private int y;

    public Player(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveUp(){
        y--;
    }

    public void moveDown(){
        y++;
    }

    public void moveLeft(){
        x--;
    }

    public void moveRight(){
        x++;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}