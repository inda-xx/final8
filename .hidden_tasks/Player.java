public class Player {
    private String name;
    private int score;
    private int health;
    private Room currentRoom;

    public Player(String name, int health, Room startingRoom) {
        this.name = name;
        this.health = health;
        this.score = 0;
        this.currentRoom = startingRoom;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newRoom) {
        this.currentRoom = newRoom;
    }
}