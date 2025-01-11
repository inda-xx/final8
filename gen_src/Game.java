import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private boolean isGameOver = false;

    public void loadGameData(String fileName) {
        // Method to load game data from a file.
    }

    private boolean isValidPosition(int x, int y) {
        // Method to validate positions within the grid.
        return false;
    }

    public void startGame() {
        // Main game loop for user input and game progression.
    }

    private void moveEnemies() {
        // Method to control enemy movement.
    }

    private void checkCollisions() {
        // Method to check for collisions between entities.
    }

    public void displayGameData() {
        // Method to display current game data to the user.
    }
}

public class Player {
    private int x;
    private int y;
    private int score;

    public Player(int x, int y) {
        // Constructor for creating a Player instance.
    }

    public void move(String direction) {
        // Method to move the player in the given direction.
    }

    public int getX() {
        // Method to get the player's X coordinate.
        return 0;
    }

    public void setX(int x) {
        // Method to set the player's X coordinate.
    }

    public int getY() {
        // Method to get the player's Y coordinate.
        return 0;
    }

    public void setY(int y) {
        // Method to set the player's Y coordinate.
    }

    public int getScore() {
        // Method to get the player's score.
        return 0;
    }

    public void updateScore(int points) {
        // Method to update the player's score.
    }

    @Override
    public String toString() {
        // Method to return player's data as a string.
        return null;
    }
}

public class Enemy {
    private int x;
    private int y;

    public Enemy(int x, int y) {
        // Constructor for creating an Enemy instance.
    }

    public void moveRandomly(int gridSize) {
        // Method to move the enemy randomly within the grid.
    }

    public int getX() {
        // Method to get the enemy's X coordinate.
        return 0;
    }

    public int getY() {
        // Method to get the enemy's Y coordinate.
        return 0;
    }

    @Override
    public String toString() {
        // Method to return enemy's data as a string.
        return null;
    }
}

public class Item {
    private int x;
    private int y;

    public Item(int x, int y) {
        // Constructor for creating an Item instance.
    }

    public int getX() {
        // Method to get the item's X coordinate.
        return 0;
    }

    public int getY() {
        // Method to get the item's Y coordinate.
        return 0;
    }

    @Override
    public String toString() {
        // Method to return item's data as a string.
        return null;
    }
}