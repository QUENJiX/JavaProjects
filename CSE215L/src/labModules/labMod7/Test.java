package labModules.labMod7;

public class Test {
    public static void main(String[] args) {
        // Create two Knight Objects which get called by the constructor [cite: 345]
        Knight knight1 = new Knight("Arthur", 5, 100, 50);
        Knight knight2 = new Knight("Lancelot", 6, 110, 55);

        System.out.println("--- Class Practice Execution ---");

        // The first knight will block an attack [cite: 346]
        knight1.blockAttack();

        // The second knight will boost his or her defense [cite: 346]
        System.out.println(knight2.getName() + "'s Defense before boost: " + knight2.getDefensePoints());
        knight2.boostDefense();
        System.out.println(knight2.getName() + "'s Defense after boost: " + knight2.getDefensePoints());
    }
}
