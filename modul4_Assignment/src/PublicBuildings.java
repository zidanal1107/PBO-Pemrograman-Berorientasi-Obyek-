public class PublicBuildings extends Building implements Taxable {
    private double assessedValue ;

    public PublicBuildings(String name, String address, int numberOfFloor, BuildingStatus status, String type, double assessedValue ) {
        super(name, address, numberOfFloor, status, type);
        this.assessedValue  = assessedValue ;
    };

    @Override
    public void showBuildings() {
        System.out.println("======== Public Building ========");
        System.out.println("Name of building    : " + getName());
        System.out.println("Address of building : " + address);
        System.out.println("Number of floor     : " + numberOfFloor);
        System.out.println("Status of building  : " + status);
        System.out.println("Building type       : " + type);
        System.out.printf("Assessed value      : %.2f\n", assessedValue);
        System.out.printf("Tax of month        : %.2f\n", calculateTax());
    }

    @Override
    public double calculateTax() {
        return assessedValue * BASE_TAX_RATE;
    }
}
