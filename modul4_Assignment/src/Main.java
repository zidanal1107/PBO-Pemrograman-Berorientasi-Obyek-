import java.util.Scanner;

public class Main {
    static Building build;
    static Scanner in = new Scanner(System.in);

    static void inputData(int option) {
        String type;
        if (option == 1) {
            type = "Public Building";
        } else if (option == 2) {
            type = "Commercial";
        } else {
            return;
        }
        System.out.println();
        System.out.println("Building type: " + type);

        System.out.print("Building name: ");
        String name = in.nextLine();

        System.out.print("Building address: ");
        String address = in.nextLine();

        System.out.print("Number of floor: ");
        int numberOfFloor = in.nextInt();
        in.nextLine();

        System.out.print("Select status (1. ACTIVE / 2. UNDER_CONSTRUCTION / 3. INACTIVE): ");
        int inputStatus = in.nextInt();
        in.nextLine();

        BuildingStatus status;
        switch (inputStatus) {
            case 1:
                status = BuildingStatus.ACTIVE;
                break;
            case 2:
                status = BuildingStatus.UNDER_CONSTRUCTION;
                break;
            case 3:
                status = BuildingStatus.INACTIVE;
                break;
            default:
                System.out.println("Status building invalid!");
                return;
        }

        switch (option) {
            case 1:
                System.out.print("Input assessed value: ");
                double assessedValue = in.nextDouble();
                in.nextLine();

                build = new PublicBuildings(name, address, numberOfFloor, status, type, assessedValue);
                System.out.println("Success add " + build.getName());
                System.out.println();
                break;
            case 2:
                System.out.print("Input monthly revenue: ");
                double monthlyRevenue = in.nextDouble();
                in.nextLine();

                build = new Commercial(name, address, numberOfFloor, status, type, monthlyRevenue);
                System.out.println("Success add " + build.getName());
                System.out.println();
                break;
        }
    }

    public static void main(String[] args) {

        int option;
        do {
            System.out.println("=== Select Building Status ===");
            System.out.println("1. Public buildings");
            System.out.println("2. Commercial");
            System.out.println("3. View building");
            System.out.println("0. Exit");
            System.out.print("Select Status: ");
            option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 0:
                    System.out.println("\nSystem ended");
                    break;
                case 1:
                case 2:
                    inputData(option);
                    break;
                case 3:
                    try {
                        System.out.println();
                        build.showBuildings();
                        System.out.println();
                        break;
                    } catch (Exception e) {
                        System.out.println("Data is empty!\n");
                        break;
                    }
                default:
                    System.out.println("\nOption invalid!\n");
                    break;
            }

        } while (option != 0);
    }
}