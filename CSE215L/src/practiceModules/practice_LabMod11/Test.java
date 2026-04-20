package practiceModules.practice_LabMod11;

public class Test {
    public static void main(String[] args) {
        MartialArtist k1 = new MartialArtist("Sujhon Majhi", 100);
        SuperSoldier k2 = new SuperSoldier("Vikram Rathore", 100);
        SuperAgent tiger = new SuperAgent("Tiger", 100);
        
        System.out.println("\nFighter Information: \n");
        k1.displayDetails();
        System.out.println();
        k2.displayDetails();

        /* // Classwork Test Portion
        * System.out.println("\nTesting Martial Artist: \n");
        * k1.displayDetails();
        * k1.performSpecialMove(k2);
        * 
        * System.out.println("\nTesting Super Soldier: \n");
        * k2.displayDetails();
        * k2.performSpecialMove(k1);
        * System.out.println();
        */

        System.out.println("\nBattel Begins: \n");
        while(k1.getHealth() > 0 && k2.getHealth() > 0){
            int choice = (int) Math.ceil(Math.random() * 2);

            if(choice == 1){
                k1.performSpecialMove(k2);
            }else{
                k2.performSpecialMove(k1);
            }
        }

        Combatant kw;
        if(k1.getHealth() > 0){
            kw = k1;
        }else{
            kw = k2;
        }
        System.out.println("\nThe Battel Ended.\n");
        System.out.println("The winner is " + kw.getName() + ". HP left: " + kw.getHealth());
        kw.recover();
        System.out.println("\n" + kw.getName() + "'s health recovered to 100.");

        System.out.println("\n" + kw.getName() + " v/s " + tiger.getName() +"Begins\n");
        while (kw.getHealth() > 0 && tiger.getHealth() > 0) {
            int choice = (int) Math.ceil(Math.random() * 2);

            if (choice == 1) {
                kw.performSpecialMove(tiger);
            } else {
                tiger.performSpecialMove(kw);
            }
        }
        System.out.println("\nBattel Ends\n");
    }
}
