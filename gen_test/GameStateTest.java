package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameStateTest {

    @Test
    public void testInitialRoomIsSetCorrectly() {
        Room initialRoom = new Room("Start Room");
        GameState gameState = new GameState(initialRoom);

        assertEquals(initialRoom, gameState.getCurrentRoom());
    }

    @Test
    public void testSetCurrentRoomUpdatesRoom() {
        Room initialRoom = new Room("Start Room");
        Room newRoom = new Room("New Room");
        GameState gameState = new GameState(initialRoom);

        gameState.setCurrentRoom(newRoom);

        assertEquals(newRoom, gameState.getCurrentRoom());
    }

    @Test
    public void testSetCurrentRoomToNull() {
        Room initialRoom = new Room("Start Room");
        GameState gameState = new GameState(initialRoom);

        gameState.setCurrentRoom(null);

        assertEquals(null, gameState.getCurrentRoom());
    }
    
    @Test
    public void testConstructorWithNullRoom() {
        GameState gameState = new GameState(null);

        assertEquals(null, gameState.getCurrentRoom());
    }

    @Test
    public void testChangingRoomDoesNotAffectOriginalInstance() {
        Room initialRoom = new Room("Start Room");
        GameState gameState1 = new GameState(initialRoom);
        GameState gameState2 = new GameState(new Room("Another Room"));

        // Change room in one instance
        gameState1.setCurrentRoom(new Room("Changed Room"));

        // Ensure change doesn't affect other instance
        assertEquals("Another Room", gameState2.getCurrentRoom().getName());
    }
}

class RoomTest {

    @Test
    public void testRoomNameIsSetCorrectly() {
        Room room = new Room("Sample Room");

        assertEquals("Sample Room", room.getName());
    }

    @Test
    public void testRoomNameSetToEmptyString() {
        Room room = new Room("");

        assertEquals("", room.getName());
    }

    @Test
    public void testRoomNameSetToNull() {
        assertThrows(IllegalArgumentException.class, () -> new Room(null));
    }

    @Test
    public void testEqualityOfRoomsWithSameName() {
        Room room1 = new Room("Room A");
        Room room2 = new Room("Room A");

        assertEquals(room1, room2);
    }

    @Test
    public void testInequalityOfRoomsWithDifferentNames() {
        Room room1 = new Room("Room A");
        Room room2 = new Room("Room B");

        assertThrows(AssertionError.class, () -> assertEquals(room1, room2));
    }
}

class Room {
    private String name;

    public Room(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Room name cannot be null");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Room room = (Room) obj;
        return name.equals(room.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}