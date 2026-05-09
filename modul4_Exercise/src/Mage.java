public class Mage extends Character {
    private int manaPoints;

    public Mage(String name, int age, Gender.Genders gender, String role, int manaPoints) {
        super(name, age, gender, role);
        this.manaPoints = manaPoints;
    }

    @Override
    public void attack() {
        if (manaPoints < 10) {
            System.out.println("Not enough mana to attack!");
            return;
        }
        manaPoints -= 10;
        System.out.println(name + " attacks with magic!");
        System.out.println("Mana used  : " + 10);
        System.out.println("Mana left  : " + manaPoints);
    }

    @Override
    public void displayClassInfo() {
        displayBasicInfo();
        System.out.println("Mana    : " + manaPoints);
    }

    @Override
    public void useUltimate() {
        if (manaPoints < 25) {
            System.out.println("Not enough mana to ultimate!");
            return;
        }
        System.out.println(name + " unleashes the ultimate ability!");
        manaPoints -= 25;
        System.out.println("Mana used  : " + 25);
        System.out.println("Mana left  : " + manaPoints);
    }

    public String getName()            { return name; }
    public int getAge()                { return age; }
    public String getRole()            { return role; }
    public Gender.Genders getGender()  { return gender; }
    public int getManaPoints()         { return manaPoints; }

    public void setManaPoints(int manaPoints) { this.manaPoints = manaPoints; }
}