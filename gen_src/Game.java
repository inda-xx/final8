// Game.java
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game {
    private static GameState state;

    public static void main(String[] args) {
        generateRoomsFromFile();
        printWelcomeMessage();

        while (true) {
            String command = getCommand();
            CommandParser.parse(command, state);
        }
    }

    private static String getCommand() {
        // Implement logic to read user input
        return null;
    }

    private static void printWelcomeMessage() {
        // Print the welcome message and initial room details
    }

    private static void generateRoomsFromFile() {
        // Load and initialize room configurations from a file
    }
}

// GameState.java
public class GameState {
    private Room currentRoom;

    public GameState(Room startingRoom) {
        // Initialize with a starting room
    }

    public Room getCurrentRoom() {
        // Return the current room
        return null;
    }

    public void setCurrentRoom(Room currentRoom) {
        // Set the current room
    }
}

// Room.java
import java.util.HashMap;
import java.util.Map;

class Room {
    private Map<String, Room> exits = new HashMap<>();
    private String description;

    public Room(String description) {
        // Initialize with a description
    }

    public void addExit(String direction, Room toRoom) {
        // Add an exit to the room
    }

    public Room go(String direction) {
        // Navigate to another room in the given direction
        return null;
    }

    public void printExits() {
        // Print available exits from the room
    }

    public void lookAround() {
        // Print the description of the room and its exits
    }
}

// CommandParser.java
class CommandParser {
    public static void parse(String command, GameState state) {
        // Interpret and execute a command
    }

    public static void printHelpMessage() {
        // Print a list of available commands
    }
}