import java.util.Random;

public class Enemy {
    private int x;
    private int y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveRandomly(int gridSize) {
        int direction = (int) (Math.random() * 4);
        switch (direction) {
            case 0:
                if (y > 0) y--;
                break;
            case 1:
                if (y < gridSize - 1) y++;
                break;
            case 2:
                if (x > 0) x--;
                break;
            case 3:
                if (x < gridSize - 1) x++;
                break;
        }
    }

    @Override
    public String toString() {
        return "Enemy at (" + x + ", " + y + ")";
    }
}