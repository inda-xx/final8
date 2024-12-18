import java.util.Map;
import java.util.HashMap;

public class Room {
    private Map<String, Room> exits;
    private String description;

    public Room(String description) {
        // Constructor
    }

    public void addExit(String direction, Room toRoom) {
        // Method to add an exit
    }

    public Room go(String direction) {
        // Method to move to another room
        return null;
    }

    public void printExits() {
        // Method to print available exits
    }

    public void lookAround() {
        // Method to show the room description and exits
    }
}