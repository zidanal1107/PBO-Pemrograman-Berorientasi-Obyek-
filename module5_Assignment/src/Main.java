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
                    case 1: return StatusBuilding.AVAILABLE;
                    case 2: return StatusBuilding.UNDER_CONSTRUCTION;
                    case 3: return StatusBuilding.INACTIVE;
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

            System.out.print("Number of floor: ");
            int numberOfFloor = in.nextInt();
            in.nextLine();

            System.out.print("Beds: ");
            int beds = in.nextInt();
            in.nextLine();

            StatusBuilding status = selectStatus(in);

            if (!checkDuplicate(list, name)) {
                list.add(new Hospital(name,address,numberOfFloor,status,beds));
            } else {
                throw new InvalidDataException("Error your input");
            }

        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
            in.nextLine();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Building> list = new ArrayList<>();
        addHospital(in, list);
    }
}