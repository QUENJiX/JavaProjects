package labModules.labMod7;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("--- Homework Execution ---");

        // Create an instance of EACH OF THE FOUR CLASSES and run all of the methods
        // involved [cite: 375]

        System.out.println("\n[Archer]");
        Archer legolas = new Archer("Legolas", 10, 120, 85);
        legolas.shootEnemy();
        legolas.increaseAccuracy();

        System.out.println("\n[Wizard]");
        Wizard gandalf = new Wizard("Gandalf", 20, 150, 300);
        gandalf.castSpells(1); // Cast Fire
        gandalf.castSpells(2); // Cast Ice
        gandalf.castSpells(3); // Cast Thunder

        System.out.println("\n[Gunner]");
        Gunner clint = new Gunner("Clint", 8, 110, 75);
        clint.shootEnemy();
        clint.increasePrecision();

        System.out.println("\n[Warrior]");
        Warrior gimli = new Warrior("Gimli", 12, 200, 90);
        gimli.attackEnemy();
        gimli.parryAttack();
        gimli.boostAttack();
    }
}
