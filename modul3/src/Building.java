public class Building {
    private String name;
    private String address;
    private int numberOfFloors;

    public Building (String name, String address, int numberOfFloors) {
        this.name = name;
        this.address = address;
        this.numberOfFloors = numberOfFloors;
    }

    public void showBuildings() {
        System.out.println("\n======================================");
        System.out.println("Building Name\t\t\t  : "+ name);
        System.out.println("Building Address\t\t  : "+ address);
        System.out.println("Building Number Of Floors : "+ numberOfFloors);
        System.out.println("--------------------------------------");
    }
}
