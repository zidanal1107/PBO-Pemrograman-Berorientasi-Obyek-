public class Apartment extends Building {
    double monthlyFee;

    public Apartment (String name, String address, int numberOfFloors, double monthlyFee) {
        super(name, address, numberOfFloors);
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void showBuildings() {
        super.showBuildings();
        System.out.println("Apartment Details");
        System.out.println("Month Fee\t\t\t\t: "+ monthlyFee);
        System.out.println("======================================");
    }
}
