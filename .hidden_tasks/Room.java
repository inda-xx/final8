import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits = new HashMap<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void printExits() {
        System.out.print("Exits available: ");
        for (String direction : exits.keySet()) {
            System.out.print(direction + " ");
        }
        System.out.println();
    }
}