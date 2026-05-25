public abstract class Building {
    protected String name;
    protected String address;
    protected int numberOfFloor;
    protected StatusBuilding status;

    public Building(String name, String address, int numberOfFloor, StatusBuilding status) throws InvalidDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDataException("Name cannot be empty");
        }

        if (numberOfFloor <= 0) {
            throw new InvalidDataException("Number of floor must be greater than 0");
        }

        this.name = name;
        this.address = address;
        this.numberOfFloor = numberOfFloor;
        this.status = status;
    }

    public abstract void showBuilding();
    public String getName() { return name; }
}
