public class Hospital extends Building {
    protected int beds;

    public Hospital(String name, String address, int numberOfFloor, StatusBuilding status, int beds)
        throws InvalidDataException{
        super(name, address, numberOfFloor, status);
        this.beds = beds;
    }

    @Override
    public void showBuilding() {
        System.out.println("Name            : "+name);
        System.out.println("Address         : "+address);
        System.out.println("Number Of Floor : "+numberOfFloor);
        System.out.println("Status          : "+status);
        System.out.println("Beds            : "+beds);
    }
}
