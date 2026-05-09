public class Assassin extends Character {
    private int couldownSkill;

    public Assassin(String name, int age, Gender.Genders gender, String role, int couldownSkill) {
        super(name, age, gender, role);
        this.couldownSkill = couldownSkill;
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks with skill!");
        System.out.println("Couldown skill attacks : " + couldownSkill * 0.7);
    }

    @Override
    public void displayClassInfo() {
        displayBasicInfo();
        System.out.println("Couldown skill    : " + couldownSkill);
    }

    @Override
    public void useUltimate() {
        System.out.println(name + " unleashes the ultimate ability!");
        System.out.println("Couldown ultimate  : " + couldownSkill * 0.55);
    }

    public String getName()            { return name; }
    public int getAge()                { return age; }
    public String getRole()            { return role; }
    public Gender.Genders getGender()  { return gender; }
    public int setCouldownSkill()         { return couldownSkill; }

    public void setCouldownSkill(int couldownSkill) { this.couldownSkill = couldownSkill; }
}