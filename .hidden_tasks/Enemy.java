public class Enemy {
    private String name;
    private int health;
    private int damage;
    private Room currentRoom;

    public Enemy(String name, int health, int damage, Room startingRoom) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.currentRoom = startingRoom;
    }

    public String getName() {
        return name;
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

    public int getDamage() {
        return damage;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newRoom) {
        this.currentRoom = newRoom;
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}