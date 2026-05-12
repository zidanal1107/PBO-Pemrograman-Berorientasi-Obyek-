public class PublicBuildings extends Building {
    private double monthlyRevenue ;

    public PublicBuildings(String name, String address, int numberOfFloor, BuildingStatus status, String type, double monthlyRevenue ) {
        super(name, address, numberOfFloor, status, type);
        this.monthlyRevenue  = monthlyRevenue ;
    };

    @Override
    public void showBuildings() {
        System.out.println("======== Public Building ========");
        System.out.println("Name of building    : " + getName());
        System.out.println("Address of building : " + address);
        System.out.println("Number of floor     : " + numberOfFloor);
        System.out.println("Status of building  : " + status);
        System.out.println("Building type       : " + type);
        System.out.printf("monthly revenue      : %.2f\n", monthlyRevenue);
    }

}
