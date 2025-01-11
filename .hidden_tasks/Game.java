import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {
    private Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private boolean isGameOver = false;

    public void loadGameData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("Player")) {
                    String[] parts = line.split(":")[1].trim().split(", ");
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    if (isValidPosition(x, y)) {
                        player = new Player(x, y);
                    } else {
                        System.out.println("Invalid Player position: " + line);
                    }
                } else if (line.startsWith("Enemy")) {
                    String[] parts = line.split(":")[1].trim().split(", ");
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    if (isValidPosition(x, y)) {
                        enemies.add(new Enemy(x, y));
                    } else {
                        System.out.println("Invalid Enemy position: " + line);
                    }
                } else if (line.startsWith("Item")) {
                    String[] parts = line.split(":")[1].trim().split(", ");
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    if (isValidPosition(x, y)) {
                        items.add(new Item(x, y));
                    } else {
                        System.out.println("Invalid Item position: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (!isGameOver) {
            System.out.println("Enter move (up, down, left, right): ");
            String move = scanner.nextLine();
            player.move(move);

            if (player.getX() < 0) player.setX(0);
            if (player.getX() >= 10) player.setX(9);
            if (player.getY() < 0) player.setY(0);
            if (player.getY() >= 10) player.setY(9);

            moveEnemies();
            checkCollisions();

            if (isGameOver) {
                System.out.println("Game Over! Final Score: " + player.getScore());
                break;
            }
        }
        scanner.close();
    }

    private void moveEnemies() {
        for (Enemy enemy : enemies) {
            enemy.moveRandomly(10);
        }
    }

    private void checkCollisions() {
        for (Enemy enemy : enemies) {
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                isGameOver = true;
                System.out.println("Game Over! You collided with an enemy.");
                return;
            }
        }

        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (player.getX() == item.getX() && player.getY() == item.getY()) {
                iterator.remove();
                player.updateScore(10);
                System.out.println("Item collected! Score: " + player.getScore());
            }
        }
    }

    public void displayGameData() {
        System.out.println(player);
        for (Enemy enemy : enemies) {
            System.out.println(enemy);
        }
        for (Item item : items) {
            System.out.println(item);
        }
    }
}