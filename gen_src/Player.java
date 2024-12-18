// File: Player.java
public class Player {
    private String name;
    private int score;
    private int health;
    private Room currentRoom;

    public Player(String name, int health, Room startingRoom) {
        // Constructor
    }

    public String getName() {
        // Method to get the player's name
    }

    public int getScore() {
        // Method to get the player's score
    }

    public void addScore(int points) {
        // Method to add points to the player's score
    }

    public int getHealth() {
        // Method to get the player's health
    }

    public void reduceHealth(int damage) {
        // Method to reduce the player's health
    }

    public Room getCurrentRoom() {
        // Method to get the current room of the player
    }

    public void setCurrentRoom(Room newRoom) {
        // Method to set the player's current room
    }
}