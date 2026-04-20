package practiceModules.practice_LabMod11;

public class Combatant {
    private String name;
    private int health;

    public Combatant() {}
    public Combatant(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public int getHealth() { return this.health; }

    public void recover(){
        this.health = 100;
    }

    public void healthDeplete(int damage){
        this.health -= damage;
    }
    public void displayDetails(){
        System.out.println("Name: " + this.name);
        System.out.println("Health: " + this.health);
    }

    public void performSpecialMove(Combatant k){
        System.out.println("Run it from the instance of the Child Class!");
    }
}
