package ModulePractice.LabMod7;

public class LabMod7_Test {
    public static void main(String[] args) {
        Knight k = new Knight("Hasib", 1, 10, 0);
        Archer a = new Archer("Hawkeye", 10, 100, 90);
        Wizard w = new Wizard("Dr. Strange", 50, 100, 60);
        Gunner g = new Gunner("War Machine", 40, 100, 60);
        Warrior wr = new Warrior("Black Panthar", 80, 100, 20);

        System.out.println("\n--- Testing Knight Class ---");
        k.blockAttack();
        k.boostDefense();

        System.out.println("\n--- Testing Archer Class ---");
        a.shootEnemy();
        a.increaseAccuracy();

        System.out.println("\n--- Testing Wizard Class ---");
        w.castSpells(1);
        w.castSpells(2);
        w.castSpells(3);
        w.castSpells(4);

        System.out.println("\n--- Testing Gunner Class ---");
        g.shootEnemy();
        g.increasePrecision();

        System.out.println("\n--- Testing Warrior Class ---");
        wr.attackEnemy();
        wr.parryAttack();
        wr.boostAttack();
    }
}