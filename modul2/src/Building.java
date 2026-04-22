public class Building {
    String name_building;
    String address_building;
    int number_floor_building;

    void bulding(String name_building, String address_building, int number_floor_building) {
        this.name_building = name_building;
        this.address_building = address_building;
        this.number_floor_building = number_floor_building;

        display();
    }

    void display() {
        System.out.println("\n===== Data Of Building =====");
        System.out.println("Name Building\t\t: " + name_building);
        System.out.println("Address Building\t: " + address_building);
        System.out.println("Number Of Building\t: " + number_floor_building);
        System.out.println("============================");

        System.out.println("\nAdded Successfully\n");
    }

}
