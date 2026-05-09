public class Fighter extends Character {
    private int spellVamp;

    public Fighter(String name, int age, Gender.Genders gender, String role, int spellVamp) {
        super(name, age, gender, role);
        this.spellVamp = spellVamp;
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks with physical!");
        System.out.println("Spell vamp used  : " + spellVamp * 0.1);
    }

    @Override
    public void displayClassInfo() {
        displayBasicInfo();
        System.out.println("Spell vamp    : " + spellVamp);
    }

    @Override
    public void useUltimate() {
        System.out.println(name + " unleashes the ultimate ability!");
        System.out.println("Spell vamp used  : " + spellVamp * 0.5);
    }

    public String getName()            { return name; }
    public int getAge()                { return age; }
    public String getRole()            { return role; }
    public Gender.Genders getGender()  { return gender; }
    public int getSpellVamp()         { return spellVamp; }

    public void setSpellVamp(int spellVamp) { this.spellVamp = spellVamp; }
}