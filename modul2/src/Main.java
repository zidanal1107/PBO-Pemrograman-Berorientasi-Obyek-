import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Building build = new Building();

        char option;
        do {
            System.out.println("=== Welcome To Data Collection System ===");
            System.out.print("Enter name of building\t\t: ");
            String name_building = in.nextLine();

            System.out.print("Enter address of building\t: ");
            String address_building = in.nextLine();

            System.out.print("Enter floor of building\t\t: ");
            int floor_building = in.nextInt();
            in.nextLine();

            build.bulding(name_building, address_building, floor_building);

            System.out.print("Do you want to input building again[Y/n]? ");
            option = in.next().charAt(0);

            in.nextLine();
        } while (option == 'y' || option == 'Y');

        System.out.println("\nProgram end!");
        in.close();
    }
}