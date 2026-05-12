public abstract class Building {
    protected final String name;
    protected final String address;
    protected final int numberOfFloor;
    protected final BuildingStatus status;
    protected final String type;

    public Building(String name, String address, int numberOfFloor, BuildingStatus status, String type) {
        this.name = name;
        this.address = address;
        this.numberOfFloor = numberOfFloor;
        this.status = status;
        this.type = type;
    }

    public abstract void showBuildings();

    public String getName() { return name; }
}
