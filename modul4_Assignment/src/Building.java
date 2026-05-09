public abstract class Building {
    protected String name;
    protected String address;
    protected int numberOfFloor;
    protected BuildingStatus status;
    protected String type;

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
