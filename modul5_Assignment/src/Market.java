public class Market extends Building {
    protected int revenue;

    public Market(String name, String address, int numberOfFloor, StatusBuilding status, int revenue) throws InvalidDataException {
        super(name, address, numberOfFloor, status);
        this.revenue = revenue;
    }

    @Override
    public void showBuilding() {
        System.out.println("Name            : "+name);
        System.out.println("Address         : "+address);
        System.out.println("Number Of Floor : "+numberOfFloor);
        System.out.println("Status          : "+status);
        System.out.println("Revenue         : "+revenue);
    }
}
