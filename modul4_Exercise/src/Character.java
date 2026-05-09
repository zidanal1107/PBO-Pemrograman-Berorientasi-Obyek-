public abstract class Character implements SpecialAbility {
    protected String name;
    protected int age;
    protected Gender.Genders gender;
    protected String role;

    public static final String GAME_NAME = "Labit RPG v2.0";

    public String getName() { return name; }

    public Character(String name, int age, Gender.Genders gender, String role) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.role = role;
    }

    public final void displayBasicInfo() {
        System.out.println("====" + GAME_NAME + "====");
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Gender  : " + gender);
        System.out.println("Role    : " + role);
    }

    public abstract void attack();

    public abstract void displayClassInfo();
}
