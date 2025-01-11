public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.loadGameData("gameData.txt");
        game.displayGameData();
        game.startGame();
    }
}