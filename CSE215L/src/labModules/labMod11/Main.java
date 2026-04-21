package labModules.labMod11;

public class Main {
    public static void main(String[] args) {
        MartialArtist k1 = new MartialArtist("Sujon Majhi", 100);
        SuperSoldier k2 = new SuperSoldier("Vikram Rathore", 100);

        k1.displayDetails();
        k2.displayDetails();

        while (k1.getHealth() > 0 && k2.getHealth() > 0) {
            int choice = (int) Math.ceil(Math.random() * 2);

            if (choice == 1) {
                k1.performSpecialMove(k2);
            } else {
                k2.performSpecialMove(k1);
            }
        }

        Combatant kw = (k1.getHealth() > 0) ? k1 : k2;
        kw.recover();

        SuperAgent tiger = new SuperAgent("Tiger", 100);

        while (kw.getHealth() > 0 && tiger.getHealth() > 0) {
            int choice = (int) Math.ceil(Math.random() * 2);

            if (choice == 1) {
                kw.performSpecialMove(tiger);
            } else {
                tiger.performSpecialMove(kw);
            }
        }
    }
}