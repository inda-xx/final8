import java.util.Scanner;

public class GameManager {
    private Player player;

    public void startGame() {
        GameLoader loader = new GameLoader();
        loader.loadGame("game_data.txt");
        Room startRoom = loader.getRooms().values().iterator().next();
        player = new Player("Hero", 100, startRoom);

        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("Welcome to the game!");
        System.out.println(player.getCurrentRoom().getDescription());

        while (gameRunning) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "look":
                    System.out.println(player.getCurrentRoom().getDescription());
                    player.getCurrentRoom().printExits();
                    break;
                case "move":
                    System.out.print("Direction? ");
                    String direction = scanner.nextLine();
                    Room nextRoom = player.getCurrentRoom().getExit(direction);
                    if (nextRoom != null) {
                        player.setCurrentRoom(nextRoom);
                        System.out.println("You moved to: " + nextRoom.getDescription());
                    } else {
                        System.out.println("You can't go that way!");
                    }
                    break;
                case "exit":
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Unknown command!");
            }
        }

        System.out.println("Game Over. Your score: " + player.getScore());
    }

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.startGame();
    }
}