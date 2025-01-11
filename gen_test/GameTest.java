package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testLoadGameDataValidFile() throws IOException {
        Game game = new Game();
        String content = "Player: 2, 3\n" +
                         "Enemy: 4, 5\n" +
                         "Item: 6, 7";

        File tempFile = File.createTempFile("gameData", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write(content);
        }

        game.loadGameData(tempFile.getAbsolutePath());

        assertNotNull(game);
        tempFile.delete();
    }

    @Test
    public void testLoadGameDataInvalidPositions() throws IOException {
        Game game = new Game();
        String content = "Player: 15, 3\n" +
                         "Enemy: -2, 5\n" +
                         "Item: 6, 15";

        File tempFile = File.createTempFile("gameData", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write(content);
        }

        game.loadGameData(tempFile.getAbsolutePath());
        tempFile.delete();
    }}