import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static boolean checkDuplicate(ArrayList<Building> list, String name) {
        for (Building a : list) {
            if (a.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static StatusBuilding selectStatus(Scanner in) {
        while (true) {
            try {
                System.out.println("=== Building Status ===");
                System.out.println("1. AVAILABLE\n2. UNDER_CONSTRUCTION\n3. INACTIVE");
                System.out.print("Select status: ");
                int status = in.nextInt();
                in.nextLine();

                switch (status) {
                    case 1:
                        return StatusBuilding.AVAILABLE;
                    case 2:
                        return StatusBuilding.UNDER_CONSTRUCTION;
                    case 3:
                        return StatusBuilding.INACTIVE;
                    default:
                        System.out.println("Options are only (1-3)");
                }
            } catch (InputMismatchException e) {
                in.nextLine();
                System.out.println("Options are only numbers");
            }
        }
    }

    private static void addHospital(Scanner in, ArrayList<Building> list) {
        try {
            System.out.println("--- ADD NEW HOSPITAL ---");
            System.out.print("Name: ");
            String name = in.nextLine();

            System.out.print("Address: ");
            String address = in.nextLine();

            System.out.print("Floor: ");
            int numberOfFloor = in.nextInt();
            in.nextLine();

            System.out.print("Beds: ");
            int beds = in.nextInt();
            in.nextLine();

            StatusBuilding status = selectStatus(in);

            if (!checkDuplicate(list, name)) {
                Hospital h = new Hospital(name, address, numberOfFloor, status, beds);
                list.add(h);
                System.out.println(">> Success: Hospital added.");
            } else {
                throw new InvalidDataException("[ERROR] your format input");
            }

        } catch (InputMismatchException e) {
            System.out.println("Floor or beds is " + e.getMessage());
            in.nextLine();
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
            in.nextLine();
        }
    }

    private static void addMarket(Scanner in, ArrayList<Building> list) {
        try {
            System.out.println("--- ADD NEW MARKET ---");
            System.out.print("Name: ");
            String name = in.nextLine();

            System.out.print("Address: ");
            String address = in.nextLine();

            System.out.print("Floor: ");
            int numberOfFloor = in.nextInt();
            in.nextLine();

            System.out.print("Revenue: ");
            int revenue = in.nextInt();
            in.nextLine();

            StatusBuilding status = selectStatus(in);

            if (!checkDuplicate(list, name)) {
                Market m = new Market(name, address, numberOfFloor, status, revenue);
                list.add(m);
                System.out.println(">> Success: Market added.");
            } else {
                throw new InvalidDataException("[VALIDATION FAILED]");
            }

        } catch (InputMismatchException e) {
            System.out.println("Floor or revenue is " + e.getMessage());
            in.nextLine();
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
            in.nextLine();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Building> listh = new ArrayList<>(),
                listm = new ArrayList<>();

        int choice = 0;
        do {
            try {
                System.out.println("=== Add your Building ===");
                System.out.println("1. Hospital\n2. Market\n0. Exit");
                System.out.print("Choice: ");
                choice = in.nextInt();
                in.nextLine();

                switch (choice) {
                    case 1:
                        addHospital(in, listh);
                        break;
                    case 2:
                        addMarket(in, listm);
                        break;
                    case 0:
                        System.out.println("Program end!");
                        break;
                    default:
                        System.out.println("Choice only 0-2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: choice is " + e.getMessage());
                in.nextLine();
            }
        } while (choice != 0);
    }
}
