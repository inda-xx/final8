package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testInitialPosition() {
        Player player = new Player(0, 0);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }

    @Test
    public void testInitialScore() {
        Player player = new Player(0, 0);
        assertEquals(0, player.getScore());
    }

    @Test
    public void testInitialLives() {
        Player player = new Player(0, 0);
        assertEquals(3, player.getLives());
    }

    @Test
    public void testMoveUp() {
        Player player = new Player(0, 0);
        player.move("UP");
        assertEquals(0, player.getX());
        assertEquals(-1, player.getY());
    }

    @Test
    public void testMoveDown() {
        Player player = new Player(0, 0);
        player.move("DOWN");
        assertEquals(0, player.getX());
        assertEquals(1, player.getY());
    }

    @Test
    public void testMoveLeft() {
        Player player = new Player(0, 0);
        player.move("LEFT");
        assertEquals(-1, player.getX());
        assertEquals(0, player.getY());
    }

    @Test
    public void testMoveRight() {
        Player player = new Player(0, 0);
        player.move("RIGHT");
        assertEquals(1, player.getX());
        assertEquals(0, player.getY());
    }

    @Test
    public void testMoveInvalidDirection() {
        Player player = new Player(0, 0);
        player.move("INVALID");
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }

    @Test
    public void testUpdateScorePositivePoints() {
        Player player = new Player(0, 0);
        player.updateScore(10);
        assertEquals(10, player.getScore());
    }

    @Test
    public void testUpdateScoreNegativePoints() {
        Player player = new Player(0, 0);
        player.updateScore(-5);
        assertEquals(-5, player.getScore());
    }

    @Test
    public void testUpdateScoreMultipleCalls() {
        Player player = new Player(0, 0);
        player.updateScore(10);
        player.updateScore(5);
        player.updateScore(-3);
        assertEquals(12, player.getScore());
    }

    @Test
    public void testLoseLife() {
        Player player = new Player(0, 0);
        player.loseLife();
        assertEquals(2, player.getLives());
    }

    @Test
    public void testLoseLifeToZero() {
        Player player = new Player(0, 0);
        player.loseLife();
        player.loseLife();
        player.loseLife();
        assertEquals(0, player.getLives());
    }

    @Test
    public void testLoseLifeBeyondZero() {
        Player player = new Player(0, 0);
        player.loseLife();
        player.loseLife();
        player.loseLife();
        player.loseLife(); // Beyond zero
        assertEquals(0, player.getLives()); // Ensures lives don't go negative
    }

    @Test
    public void testBoundaryConditionMovement() {
        Player player = new Player(Integer.MAX_VALUE, Integer.MAX_VALUE);
        player.move("RIGHT"); // Check overflow condition
        assertEquals(Integer.MAX_VALUE + 1L, (long) player.getX());
        assertEquals(Integer.MAX_VALUE, player.getY());

        player = new Player(Integer.MIN_VALUE, Integer.MIN_VALUE);
        player.move("LEFT"); // Check underflow condition
        assertEquals(Integer.MIN_VALUE - 1L, (long) player.getX());
        assertEquals(Integer.MIN_VALUE, player.getY());
    }
    
    @Test
    public void testPerformanceWithMultipleMoves() {
        Player player = new Player(0, 0);
        for (int i = 0; i < 1_000_000; i++) {
            player.move("UP");
        }
        assertEquals(0, player.getX());
        assertEquals(-1_000_000, player.getY());
    }
    
    @Test
    public void testPerformanceWithScoreUpdates() {
        Player player = new Player(0, 0);
        for (int i = 0; i < 1_000_000; i++) {
            player.updateScore(1);
        }
        assertEquals(1_000_000, player.getScore());
    }
    
    @Test
    public void testPerformanceWithLivesLost() {
        Player player = new Player(0, 0);
        for (int i = 0; i < 10; i++) { // Lives should cap at 0
            player.loseLife();
        }
        assertEquals(0, player.getLives());
    }
}