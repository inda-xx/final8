// GameManager.java
import java.util.Scanner;

public class GameManager {
    private Player player;

    public void startGame() {
        // Method signature for starting the game
    }

    public static void main(String[] args) {
        // Entry point for the application
    }
}

// Player.java
public class Player {
    public Player(String name, int health, Room startRoom) {
        // Constructor
    }

    public Room getCurrentRoom() {
        // Getter for current room
        return null;
    }

    public void setCurrentRoom(Room room) {
        // Setter for current room
    }

    public int getScore() {
        // Getter for score
        return 0;
    }
}

// Room.java
import java.util.Map;

public class Room {
    public String getDescription() {
        // Method to get room description
        return null;
    }

    public void printExits() {
        // Method to print available exits
    }

    public Room getExit(String direction) {
        // Method to get the connected room in a given direction
        return null;
    }
}

// GameLoader.java
import java.util.Map;

public class GameLoader {
    public void loadGame(String filePath) {
        // Method to load game data from a file
    }

    public Map<String, Room> getRooms() {
        // Method to get all rooms
        return null;
    }
}