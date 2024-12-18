// GameLoader.java
import java.util.List;
import java.util.Map;

public class GameLoader {
    private Map<String, Room> rooms;
    private List<Enemy> enemies;
    private List<Item> items;

    public void loadGame(String filePath) {
        // Method to load game data
    }

    public Map<String, Room> getRooms() {
        // Method to get rooms
        return null;
    }

    public List<Enemy> getEnemies() {
        // Method to get enemies
        return null;
    }

    public List<Item> getItems() {
        // Method to get items
        return null;
    }
}

// Room.java
public class Room {
    public Room(String name, String description) {
        // Constructor
    }

    public void addExit(String direction, Room room) {
        // Method to add an exit to the room
    }
}

// Enemy.java
public class Enemy {
    public Enemy(String name, int health, int damage, Room room) {
        // Constructor
    }
}

// Item.java
public class Item {
    public Item(String name, String description, Room room) {
        // Constructor
    }
}