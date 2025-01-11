import java.util.HashMap;
import java.util.Set;

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
        System.out.print("> ");
        return System.console().readLine().trim();
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to The Colossal KTH Adventure!");
        state.getCurrentRoom().lookAround();
        CommandParser.printHelpMessage();
    }

    private static void generateRoomsFromFile() {
        Map<String, Room> worldModel = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("rooms.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(";");
                if (data[0].equals("Room")) {
                    worldModel.put(data[1], new Room(data[2]));
                } else if (data[0].equals("Exit")) {
                    worldModel.get(data[1]).addExit(data[2], worldModel.get(data[3]));
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error loading rooms from file: " + e.getMessage());
            System.exit(1);
        }
        state = new GameState(worldModel.get("start"));
    }
}

class GameState {
    private Room currentRoom;

    public GameState(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}

import java.util.HashMap;
import java.util.Map;

class Room {
    private Map<String, Room> exits = new HashMap<>();
    private String description;

    public Room(String description) {
        this.description = description;
    }

    public void addExit(String direction, Room toRoom) {
        exits.put(direction, toRoom);
    }

    public Room go(String direction) {
        Room newRoom = exits.get(direction);
        if (newRoom == null) {
            System.out.println("You can't go that way!");
            printExits();
        }
        return newRoom;
    }

    public void printExits() {
        System.out.print("Exits: ");
        for (String direction : exits.keySet()) {
            System.out.print(direction + " ");
        }
        System.out.println();
    }

    public void lookAround() {
        System.out.println(description);
        printExits();
    }
}

class CommandParser {
    public static void parse(String command, GameState state) {
        switch (command) {
            case "help":
                printHelpMessage();
                break;
            case "look":
                state.getCurrentRoom().lookAround();
                break;
            default:
                Room nextRoom = state.getCurrentRoom().go(command);
                if (nextRoom != null) {
                    state.setCurrentRoom(nextRoom);
                    state.getCurrentRoom().lookAround();
                }
        }
    }

    public static void printHelpMessage() {
        System.out.println("Commands: look, help, [direction]");
    }
}