public class Player {
    private int x;
    private int y;
    private int score;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getScore() {
        return score;
    }

    public void move(String direction) {
        switch (direction.toLowerCase()) {
            case "up":
                y--;
                break;
            case "down":
                y++;
                break;
            case "left":
                x--;
                break;
            case "right":
                x++;
                break;
            default:
                System.out.println("Invalid move direction.");
                break;
        }
    }

    public void updateScore(int points) {
        score += points;
    }

    @Override
    public String toString() {
        return "Player at (" + x + ", " + y + ") with score: " + score;
    }
}