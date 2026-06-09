public abstract class Building {
    private String name;
    private String address;
    private int floors;
    private BuildingStatus status;

    public Building(String name, String address, int floors, BuildingStatus status) {
        this.name = name;
        this.address = address;
        this.floors = floors;
        this.status = status;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public int getFloors() { return floors; }
    public BuildingStatus getStatus() { return status; }

    public abstract String getType();
    public abstract String getDetail();
}