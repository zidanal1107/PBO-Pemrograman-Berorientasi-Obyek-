public class Commercial extends Building implements Taxable {
    private double monthlyRevenue;

    public Commercial(String name, String address, int numberOfFloor, BuildingStatus status, String type, double monthlyRevenue) {
        super(name, address, numberOfFloor, status, type);
        this.monthlyRevenue = monthlyRevenue;
    }

    @Override
    public void showBuildings() {
        System.out.println("======== Commercial Building ========");
        System.out.println("Name of building    : " + getName());
        System.out.println("Address of building : " + address);
        System.out.println("Number of floor     : " + numberOfFloor);
        System.out.println("Status of building  : " + status);
        System.out.println("Building type       : " + type);
        System.out.printf("Monthly Revenue     : %.2f\n", monthlyRevenue);
        System.out.printf("Tax of month        : %.2f\n", calculateTax());
    }

    @Override
    public double calculateTax() {
        return monthlyRevenue * BASE_TAX_RATE;
    }
}
