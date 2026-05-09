public class Tank extends Character {
    private int stunDuration;

    public Tank(String name, int age, Gender.Genders gender, String role, int stunDuration) {
        super(name, age, gender, role);
        this.stunDuration = stunDuration;
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks with stun!");
        System.out.println("Stun duration : " + stunDuration * 0.45);
    }

    @Override
    public void displayClassInfo() {
        displayBasicInfo();
        System.out.println("Stun duration   : " + stunDuration);
    }

    @Override
    public void useUltimate() {
        System.out.println(name + " unleashes the ultimate ability!");
        System.out.println("Stun duration  : " + stunDuration * 0.6);
    }

    public String getName()            { return name; }
    public int getAge()                { return age; }
    public String getRole()            { return role; }
    public Gender.Genders getGender()  { return gender; }
    public int setStunDuration()         { return stunDuration; }

    public void setStunDuration(int stunDuration) { this.stunDuration = stunDuration; }
}