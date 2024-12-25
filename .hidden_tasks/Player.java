public class Player {
    private int x, y; // Player position
    private int score;
    private int lives;

    // Constructor to initialize player's position, score, and lives
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
        this.lives = 3; // Default number of lives
    }

    // Moves the player based on the direction
    public void move(String direction) {
        switch (direction.toUpperCase()) {
            case "UP":
                y--;
                break;
            case "DOWN":
                y++;
                break;
            case "LEFT":
                x--;
                break;
            case "RIGHT":
                x++;
                break;
            default:
                System.out.println("Invalid direction!");
        }
    }

    // Updates the player's score
    public void updateScore(int points) {
        score += points;
    }

    // Decreases the player's lives
    public void loseLife() {
        lives--;
    }

    // Getters for position, score, and lives
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }
}