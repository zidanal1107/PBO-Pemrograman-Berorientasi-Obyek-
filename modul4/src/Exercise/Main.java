import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Character hero;

    static void printSelectHeroMenu() {
        System.out.println("\n=== " + Character.GAME_NAME + "===");
        System.out.println("SELECT HERO");
        System.out.println("1. Mage");
        System.out.println("2. Fighter");
        System.out.println("3. Assassin");
        System.out.println("4. Marksman");
        System.out.println("5. Tank");
        System.out.println("0. Exit");
        System.out.print("Select your hero: ");
    }

    static void printActionMenu() {
        System.out.println("\n=== ACTION ===");
        System.out.println("Active Hero: " + hero.getName());
        System.out.println("1. Display Hero");
        System.out.println("2. Attack");
        System.out.println("3. Use Ultimate");
        System.out.println("0. Back to Hero Select");
        System.out.print("Select action: ");
    }

    static void inputHeroes(int option) {
        System.out.println("\n--- INPUT HERO ---");
        System.out.print("Name   : ");
        String name = in.nextLine();

        System.out.print("Age    : ");
        int age = in.nextInt();
        in.nextLine();

        System.out.print("Gender (F/M): ");
        char gender = in.next().toUpperCase().charAt(0);
        in.nextLine();

        Gender.Genders heroGender;
        switch (gender) {
            case 'F':
                heroGender = Gender.Genders.FEMALE;
                break;
            case 'M':
                heroGender = Gender.Genders.MALE;
                break;
            default:
                System.out.println(">> Invalid gender input!");
                return;
        }

        switch (option) {
            case 1:
                System.out.print("Mana   : ");
                int mana = in.nextInt();
                in.nextLine();
                hero = new Mage(name, age, heroGender, "Mage", mana);
                System.out.println(">> Mage added successfully!");
                break;
            case 2:
                System.out.print("Spell vamp: ");
                int spellVamp = in.nextInt();
                in.nextLine();
                hero = new Fighter(name, age, heroGender, "Fighter", spellVamp);
                System.out.println(">> Fighter added successfully!");
                break;
            case 3:
                System.out.print("Couldown skill: ");
                int couldownSkill = in.nextInt();
                in.nextLine();
                hero = new Assassin(name, age, heroGender, "Assassin", couldownSkill);
                System.out.println(">> Assassin added successfully!");
                break;
            case 4:
                System.out.print("Attack speed: ");
                int attackSpeed = in.nextInt();
                in.nextLine();
                hero = new Marksman(name, age, heroGender, "Marksman", attackSpeed);
                System.out.println(">> Marksman added successfully!");
                break;
            case 5:
                System.out.print("Stun duration: ");
                int stunDuration = in.nextInt();
                in.nextLine();
                hero = new Tank(name, age, heroGender, "Tank", stunDuration);
                System.out.println(">> Tank added successfully!");
                break;
        }
    }

    static void actionMenu() {
        int action;
        do {
            printActionMenu();
            action = in.nextInt();
            in.nextLine();

            switch (action) {
                case 0:
                    System.out.println(">> Back to Hero Select...");
                    break;
                case 1:
                    System.out.println("\n--- HERO INFO ---");
                    hero.displayClassInfo();
                    break;
                case 2:
                    System.out.println("\n--- ATTACK ---");
                    hero.attack();
                    break;
                case 3:
                    System.out.println("\n--- ULTIMATE ---");
                    hero.useUltimate();
                    break;
                default:
                    System.out.println(">> Invalid option!");
            }

        } while (action != 0);
    }

    public static void main(String[] args) {
        int option;
        do {
            printSelectHeroMenu();
            option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 0:
                    System.out.println(">> Goodbye! Thanks for playing " + Character.GAME_NAME);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    inputHeroes(option);
                    if (hero != null) {
                        actionMenu();
                    }
                    break;
                default:
                    System.out.println(">> Invalid option!");
            }

        } while (option != 0);

    }
}