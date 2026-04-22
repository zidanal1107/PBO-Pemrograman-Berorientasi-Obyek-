import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Building> buildings = new ArrayList<>();

        int option = 0;
        do {
            System.out.println("\nWelcome To Smart City Management System");

            System.out.println("1. Add New Building");
            System.out.println("2. View All Building");
            System.out.println("3. Exit");

            System.out.print("Please select an option: ");
            option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 1:
                    System.out.println("=== Add New Building ===");

                    System.out.println("1. Add New Hospitals");
                    System.out.println("2. Add New Cinemas");
                    System.out.println("3. Add New Apartments");
                    System.out.println("4. Exit");

                    System.out.print("Please select an option: ");
                    int option_2 = in.nextInt();
                    in.nextLine();

                    switch (option_2) {
                        case 1:
                            System.out.print("\nEnter Hospital Name: ");
                            String hospitalName = in.nextLine();

                            System.out.print("Enter Hospital Address: ");
                            String hospitalAddress = in.nextLine();

                            System.out.print("Enter Number Of Floors: ");
                            int hospitalFloors = in.nextInt();
                            in.nextLine();

                            System.out.print("Enter Number Of Beds: ");
                            int hospitalBeds = in.nextInt();
                            in.nextLine();

                            Hospital hosp = new Hospital(hospitalName, hospitalAddress, hospitalFloors, hospitalBeds);
                            buildings.add(hosp);
                            System.out.println("\nHospital Added Successfully!");
                            break;
                        case 2:
                            System.out.print("\nEnter Cinema Name: ");
                            String cinemaName = in.nextLine();

                            System.out.print("Enter Cinema Address: ");
                            String cinemaAddress = in.nextLine();

                            System.out.print("Enter Number Of Floors: ");
                            int cinemaFloors = in.nextInt();
                            in.nextLine();

                            System.out.print("Enter Number Of Ticket: ");
                            int cinemaTicket = in.nextInt();
                            in.nextLine();

                            Cinema cin = new Cinema(cinemaName, cinemaAddress, cinemaFloors, cinemaTicket);
                            buildings.add(cin);
                            System.out.println("\nCinema Added Successfully!");
                            break;
                        case 3:
                            System.out.print("\nEnter Apartment Name: ");
                            String apartmentName = in.nextLine();

                            System.out.print("Enter Apartment Address: ");
                            String apartmentAddress = in.nextLine();

                            System.out.print("Enter Number Of Floors: ");
                            int apartmentFloors = in.nextInt();
                            in.nextLine();

                            System.out.print("Enter Month Fee: ");
                            int apartmentTicket = in.nextInt();
                            in.nextLine();

                            Apartment apart = new Apartment(apartmentName, apartmentAddress, apartmentFloors, apartmentTicket);
                            buildings.add(apart);
                            System.out.println("\nApartment Added Successfully!");
                            break;
                    }
                    break;
                case 2:
                    if (buildings.isEmpty()) {
                        System.out.println("\nNo Available Data!");
                    } else {
                        for (Building b : buildings) {
                            b.showBuildings();
                        }
                    }
                    break;
            }
        } while (option != 3);
    }
}