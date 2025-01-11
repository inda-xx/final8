package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testRoomCreation() {
        Room room = new Room("A dark and creepy room");
        assertNotNull(room);
        assertEquals("A dark and creepy room", roomDescription(room));
    }

    @Test
    public void testAddExit() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        room1.addExit("north", room2);

        assertNotNull(room1);
        assertNotNull(room2);
        assertSame(room2, room1"The".Noth##}).;}CLessObjA