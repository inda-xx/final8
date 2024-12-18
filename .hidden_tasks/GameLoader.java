import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class GameLoader {
    private Map<String, Room> rooms = new HashMap<>();
    private List<Enemy> enemies = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public void loadGame(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                switch (parts[0]) {
                    case "ROOM":
                        rooms.put(parts[1], new Room(parts[1], parts[2]));
                        break;
                    case "ENEMY":
                        Room enemyRoom = rooms.get(parts[4]);
                        if (enemyRoom != null) {
                            enemies.add(new Enemy(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), enemyRoom));
                        }
                        break;
                    case "ITEM":
                        Room itemRoom = rooms.get(parts[3]);
                        if (itemRoom != null) {
                            items.add(new Item(parts[1], parts[2], itemRoom));
                        }
                        break;
                    case "EXIT":
                        Room fromRoom = rooms.get(parts[1]);
                        Room toRoom = rooms.get(parts[3]);
                        if (fromRoom != null && toRoom != null) {
                            fromRoom.addExit(parts[2], toRoom);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading game data: " + e.getMessage());
        }
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Item> getItems() {
        return items;
    }
}