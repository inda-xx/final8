public class Item {
    private String name;
    private String description;
    private Room location;

    public Item(String name, String description, Room location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getLocation() {
        return location;
    }

    public void setLocation(Room newLocation) {
        this.location = newLocation;
    }
}