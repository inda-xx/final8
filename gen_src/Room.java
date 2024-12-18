// Room.java
import java.util.Map;
import java.util.HashMap;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits;

    public Room(String name, String description) {
        // Constructor
    }

    public String getName() {
        // Method to get the name
    }

    public String getDescription() {
        // Method to get the description
    }

    public void addExit(String direction, Room room) {
        // Method to add an exit
    }

    public Room getExit(String direction) {
        // Method to get an exit
    }

    public void printExits() {
        // Method to print exits
    }
}