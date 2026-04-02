package labModules.labMod7;

public class ClassworkTest {
    public static void main(String[] args) {
        System.out.println("--- Knight Class Practice ---");

        // Creating two Knight objects using the parameterized constructor
        Knight knight1 = new Knight("Arthur", 5, 100, 20);
        Knight knight2 = new Knight("Lancelot", 6, 120, 25);

        // The first knight blocks an attack
        knight1.blockAttack();

        // The second knight boosts his defense
        knight2.boostDefense();
        System.out.println(knight2.getName() + "'s new defense points: " + knight2.getDefensePoints());
    }
}