
import java.util.Scanner;

class Building {

    String name;
    String address;
    int floor;

    void building(String name, String address, int floor) {
        this.name = name;
        this.address = address;
        this.floor = floor;
    }

    void display() {
        if (name == null || address == null || floor == 0) {
            System.out.println("\nNo Avialeble Data\n");
            return;
        }

        System.out.println("\n===== Building Data =====");
        System.out.println("Building Name\t: " + name);
        System.out.println("Building Address: " + address);
        System.out.println("Number of Floors: " + floor);
        System.out.println("=========================\n");
    }
}

public class Main {

    public static void main(String[] args) {
        // Deklarasi
        Scanner in = new Scanner(System.in);
        Building building = new Building();

        for (;;) {

            System.out.println("Welcome to Smart City Management System!");
            System.out.println("1. Add New Building");
            System.out.println("2. View All Buildings");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");
            int option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Building Name: ");
                    String name = in.nextLine();
                    System.out.print("Enter Building Address: ");
                    String address = in.nextLine();
                    System.out.print("Enter Number of Floors: ");
                    int numFloors = in.nextInt();
                    building.building(name, address, numFloors);

                    System.out.println("\nSuccessfully added\n");
                    in.nextLine();
                    break;

                case 2:
                    building.display();
                    break;

                case 3:
                    System.out.println("Program Exit");
                    in.close();
                    return;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
