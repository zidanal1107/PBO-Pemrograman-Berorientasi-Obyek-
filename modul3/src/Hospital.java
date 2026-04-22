public class Hospital extends Building {
    int numberOfBads;

    public Hospital(String name, String address, int numberOfFloors, int numberOfBads) {
        super(name, address, numberOfFloors);
        this.numberOfBads = numberOfBads;
    }

    @Override
    public void showBuildings() {
        super.showBuildings();
        System.out.println("Hospital Details");
        System.out.println("Hospital Beds\t\t\t: "+ numberOfBads);
        System.out.println("======================================");
    }
}
