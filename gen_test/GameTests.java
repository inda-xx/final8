package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTests {

    @Test
    public void testRoomCreation() {
        Room room = new Room("Living Room", "A cozy living room.");
        assertEquals("Living Room", room.getName());
        assertEquals("A cozy living room.", room.getDescription());
    }

    @Test
    public void testRoomExits() {
        Room room1 = new Room("Room1", "Description1");
        Room room2 = new Room("Room2", "Description2");

        room1.addExit("north", room2);
        assertEquals(room2, room1.getExit("north"));
        assertNull(room1.getExit("south"));
    }

    @Test
    public void testPlayerInitialization() {
        Room startRoom = new Room("Start Room", "The starting point.");
        Player player = new Player("Hero", 100, startRoom);

        assertEquals("Hero", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(startRoom, player.getCurrentRoom());
        assertEquals(0, player.getScore());
    }

    @Test
    public void testPlayerMovement() {
        Room room1 = new Room("Room1", "Description1");
        Room room2 = new Room("Room2", "Description2");

        room1.addExit("north", room2);
        Player player = new Player("Hero", 100, room1);

        player.setCurrentRoom(room2);
        assertEquals(room2, player.getCurrentRoom());
    }

    @Test
    public void testPlayerScore() {
        Player player = new Player("Hero", 100, new Room("Start", "Start Room"));
        player.addScore(50);
        assertEquals(50, player.getScore());
    }

    @Test
    public void testPlayerHealthReduction() {
        Player player = new Player("Hero", 100, new Room("Start", "Start Room"));
        player.reduceHealth(30);
        assertEquals(70, player.getHealth());
        player.reduceHealth(100);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testItemCreation() {
        Room room = new Room("Room", "A simple room");
        Item item = new Item("Key", "A small key.", room);

        assertEquals("Key", item.getName());
        assertEquals("A small key.", item.getDescription());
        assertEquals(room, item.getLocation());
    }

    @Test
    public void testItemRelocation() {
        Room room1 = new Room("Room1", "First room.");
        Room room2 = new Room("Room2", "Second room.");
        Item item = new Item("Key", "A small key.", room1);

        item.setLocation(room2);
        assertEquals(room2, item.getLocation());
    }

    @Test
    public void testEnemyInitialization() {
        Room room = new Room("Dungeon", "A dark dungeon.");
        Enemy enemy = new Enemy("Goblin", 50, 10, room);

        assertEquals("Goblin", enemy.getName());
        assertEquals(50, enemy.getHealth());
        assertEquals(10, enemy.getDamage());
        assertEquals(room, enemy.getCurrentRoom());
    }

    @Test
    public void testEnemyHealthReduction() {
        Enemy enemy = new Enemy("Orc", 60, 15, new Room("Cave", "A deep cave."));
        enemy.reduceHealth(20);
        assertEquals(40, enemy.getHealth());
        enemy.reduceHealth(50);
        assertEquals(0, enemy.getHealth());
        assertFalse(enemy.isAlive());
    }

    @Test
    public void testEnemyRelocation() {
        Room room1 = new Room("Room1", "First room.");
        Room room2 = new Room("Room2", "Second room.");
        Enemy enemy = new Enemy("Troll", 100, 20, room1);

        enemy.setCurrentRoom(room2);
        assertEquals(room2, enemy.getCurrentRoom());
    }

    @Test
    public void testGameLoaderRoomParsing() {
        GameLoader loader = new GameLoader();
        loader.loadGame("test_game_data.txt");

        Map<String, Room> rooms = loader.getRooms();
        assertNotNull(rooms.get("Living Room"));
        assertEquals("A spacious living room.", rooms.get("Living Room").getDescription());
    }

    @Test
    public void testGameLoaderItemParsing() {
        GameLoader loader = new GameLoader();
        loader.loadGame("test_game_data.txt");

        List<Item> items = loader.getItems();
        assertFalse(items.isEmpty());
        assertEquals("Key", items.get(0).getName());
    }

    @Test
    public void testGameLoaderEnemyParsing() {
        GameLoader loader = new GameLoader();
        loader.loadGame("test_game_data.txt");

        List<Enemy> enemies = loader.getEnemies();
        assertFalse(enemies.isEmpty());
        assertEquals("Zombie", enemies.get(0).getName());
    }

    @Test
    public void testRoomExitLinkageDuringGameLoad() {
        GameLoader loader = new GameLoader();
        loader.loadGame("test_game_data.txt");

        Room room1 = loader.getRooms().get("Hallway");
        Room room2 = loader.getRooms().get("Kitchen");

        assertNotNull(room1);
        assertNotNull(room2);
        assertEquals(room2, room1.getExit("east"));
    }

    @Test
    public void testRoomExitPrint() {
        Room room = new Room("Room", "A room.");
        room.addExit("north", new Room("North Room", "The room to the north."));
        room.addExit("south", new Room("South Room", "The room to the south."));

        room.printExits();
    }

    @Test(expected = NullPointerException.class)
    public void testGameLoaderHandlesInvalidFile() {
        GameLoader loader = new GameLoader();
        loader.loadGame("non_existent_file.txt");
    }

    @Test
    public void testPerformanceOfGameLoader() {
        GameLoader loader = new GameLoader();
        long startTime = System.currentTimeMillis();
        loader.loadGame("large_game_data.txt");
        long duration = System.currentTimeMillis() - startTime;
        assertTrue(duration < 5000); // Ensure loading is under 5 seconds.
    }
}