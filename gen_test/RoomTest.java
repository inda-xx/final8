package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {

    @Test
    public void testAddAndRetrieveExit() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");

        room1.addExit("north", room2);
        
        assertEquals(room2, room1.go("north"));
    }

    @Test
    public void testAddingMultipleExits() {
        Room room = new Room("Main Room");
        Room northRoom = new Room("North Room");
        Room southRoom = new Room("South Room");

        room.addExit("north", northRoom);
        room.addExit("south", southRoom);

        assertEquals(northRoom, room.go("north"));
        assertEquals(southRoom, room.go("south"));
    }

    @Test
    public void testGoInvalidDirection() {
        Room room1 = new Room("Room 1");
        
        assertNull(room1.go("west"));
    }

    @Test
    public void testCircularExits() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");

        room1.addExit("toRoom2", room2);
        room2.addExit("toRoom1", room1);

        assertEquals(room2, room1.go("toRoom2"));
        assertEquals(room1, room2.go("toRoom1"));
    }

    @Test
    public void testPrintExitsEmpty() {
        Room room = new Room("Empty Room");
        
        // Mocking System.out output
        java.io.ByteArrayOutputStream outStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outStream));
        
        room.printExits();
        
        assertEquals("There are exits in the directions: \n", outStream.toString());
    }

    @Test
    public void testPrintExitsWithSingleExit() {
        Room room = new Room("A room with one exit");
        Room otherRoom = new Room("Another room");
        room.addExit("north", otherRoom);

        // Mocking System.out output
        java.io.ByteArrayOutputStream outStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outStream));

        room.printExits();

        assertEquals("There are exits in the directions: north \n", outStream.toString());
    }

    @Test
    public void testPrintExitsWithMultipleExits() {
        Room room = new Room("Room with exits");
        Room room2 = new Room("Room 2");
        Room room3 = new Room("Room 3");

        room.addExit("north", room2);
        room.addExit("south", room3);

        // Mocking System.out output
        java.io.ByteArrayOutputStream outStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outStream));

        room.printExits();

        String result = outStream.toString();
        // Order of directions may vary due to hashmap implementation
        assertTrue(result.contains("north"));
        assertTrue(result.contains("south"));
    }

    @Test
    public void testLookAround() {
        Room room = new Room("A beautiful garden");

        // Mocking System.out output
        java.io.ByteArrayOutputStream outStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outStream));

        room.lookAround();
        
        String result = outStream.toString();
        assertTrue(result.contains("A beautiful garden"));
        assertTrue(result.contains("There are exits in the directions:"));
    }

    @Test
    public void testEmptyRoomLookAround() {
        Room room = new Room("An empty space");

        // Mocking System.out output
        java.io.ByteArrayOutputStream outStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outStream));

        room.lookAround();

        String result = outStream.toString();
        assertTrue(result.contains("An empty space"));
        assertTrue(result.contains("There are exits in the directions:"));
    }

    @Test
    public void testGoDirectionNotAdded() {
        Room room = new Room("A room");

        // Mocking System.out output
        java.io.ByteArrayOutputStream outStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outStream));

        Room resultRoom = room.go("east");
        
        assertNull(resultRoom);
        assertTrue(outStream.toString().contains("You can't go that way!"));
    }

    @Test
    public void testBoundaryConditions() {
        Room room = new Room(null);

        // Mocking System.out output
        java.io.ByteArrayOutputStream outStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outStream));

        room.lookAround();
        
        String result = outStream.toString();
        assertTrue(result.contains("null"));
    }

    @Test
    public void testPerformanceForLargeNumberOfExits() {
        Room room = new Room("A large complex room");

        int exitsCount = 10000;
        for (int i = 0; i < exitsCount; i++) {
            room.addExit("Exit" + i, new Room("Room " + i));
        }

        assertEquals(new Room("Room 999"), room.go("Exit999"));
    }
}