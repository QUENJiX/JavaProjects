package labModules.labMod7;

public class HomeworkTest {
    public static void main(String[] args) {
        System.out.println("--- Knight Class ---");
        Knight knight1 = new Knight("Arthur", 5, 100, 20);
        Knight knight2 = new Knight("Lancelot", 6, 120, 25);
        knight1.blockAttack();
        knight2.boostDefense();
        System.out.println(knight2.getName() + "'s new defense points: " + knight2.getDefensePoints());

        System.out.println("--- Testing Archer ---");
        Archer archer = new Archer("Legolas", 10, 80, 50);
        archer.shootEnemy();
        archer.increaseAccuracy();
        System.out.println("Current Accuracy: " + archer.getAccuracy() + "\n");

        System.out.println("--- Testing Wizard ---");
        Wizard wizard = new Wizard("Gandalf", 20, 100, 300);
        wizard.castSpells(1); // Fire
        wizard.castSpells(2); // Ice
        wizard.castSpells(3); // Thunder
        System.out.println();

        System.out.println("--- Testing Gunner ---");
        Gunner gunner = new Gunner("Percy", 15, 90, 60);
        gunner.shootEnemy();
        gunner.increasePrecision();
        System.out.println("Current Precision: " + gunner.getPrecision() + "\n");

        System.out.println("--- Testing Warrior ---");
        Warrior warrior = new Warrior("Guts", 25, 150, 100);
        warrior.attackEnemy();
        warrior.parryAttack();
        warrior.boostAttack();
        System.out.println("Current Attack Points: " + warrior.getAttackPoints());
    }
}
