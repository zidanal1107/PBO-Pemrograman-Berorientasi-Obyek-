public class Marksman extends Character {
    private int attackSpeed;

    public Marksman(String name, int age, Gender.Genders gender, String role, int attackSpeed) {
        super(name, age, gender, role);
        this.attackSpeed = attackSpeed;
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks with speed!");
        System.out.println("Attack speed : " + attackSpeed * 0.5);
    }

    @Override
    public void displayClassInfo() {
        displayBasicInfo();
        System.out.println("Attack speed    : " + attackSpeed);
    }

    @Override
    public void useUltimate() {
        System.out.println(name + " unleashes the ultimate ability!");
        System.out.println("Speed ultimate  : " + attackSpeed * 0.4);
    }

    public String getName()            { return name; }
    public int getAge()                { return age; }
    public String getRole()            { return role; }
    public Gender.Genders getGender()  { return gender; }
    public int setAttackSpeed()         { return attackSpeed; }

    public void setAttackSpeed(int attackSpeed) { this.attackSpeed = attackSpeed; }
}