package labModules.labMod11;

public class Lab11Main {
    public static void main(String[] args) {
        MartialArtist k1 = new MartialArtist("Sujon Majhi", 100); // [cite: 998, 1019]
        SuperSoldier k2 = new SuperSoldier("Vikram Rathore", 100); // [cite: 998, 1019]

        System.out.println("--- FIGHTER PROFILES ---");
        k1.displayDetails();
        System.out.println();
        k2.displayDetails();
        System.out.println("\n--- BATTLE 1 COMMENCES ---");

        while (k1.getHealth() > 0 && k2.getHealth() > 0) {
            int choice = (int) Math.ceil(Math.random() * 2);

            if (choice == 1) {
                k1.performSpecialMove(k2);
            } else {
                k2.performSpecialMove(k1);
            }
        }

        Combatant kw;
        if (k1.getHealth() > 0) {
            kw = k1;
        } else {
            kw = k2;
        }

        System.out.println("\n" + kw.getName() + " survives Battle 1 with " + kw.getHealth() + " HP left!");
        kw.recover();
        System.out.println(kw.getName() + " has recovered to 100 HP for the next battle.");

        System.out.println("\n--- BATTLE 2 COMMENCES ---");
        SuperAgent tiger = new SuperAgent("Tiger", 100);

        System.out.println("A new challenger appears! " + tiger.getName() + " vs " + kw.getName() + "\n");

        while (kw.getHealth() > 0 && tiger.getHealth() > 0) {
            int choice = (int) Math.ceil(Math.random() * 2);

            if (choice == 1) {
                kw.performSpecialMove(tiger);
            } else {
                tiger.performSpecialMove(kw);
            }
        }

        System.out.println("\n--- TOURNAMENT CONCLUDED ---");
    }
}
