package labModules.labMod11;

public class Combatant {
    private String name;
    private int health;

    public Combatant() {
    }

    public Combatant(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void recover() {
        this.health = 100;
    }

    public void displayDetails() {
        System.out.println(name);
        System.out.println(health);
    }

    public void healthDeplete(int damage) {
        this.health -= damage;
    }

    public void performSpecialMove(Combatant k) {
        System.out.println("Run it from the instance of the Child Class!");
    }
}