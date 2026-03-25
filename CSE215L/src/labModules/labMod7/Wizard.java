package labModules.labMod7;

// Wizard extends RPGCharacter [cite: 351]
public class Wizard extends RPGCharacter {
    private int magicPoints; // [cite: 356]

    public Wizard(String name, int level, int healthPoints, int magicPoints) {
        super(name, level, healthPoints);
        this.magicPoints = magicPoints;
    }

    public int getMagicPoints() {
        return magicPoints;
    }

    public void setMagicPoints(int magicPoints) {
        this.magicPoints = magicPoints;
    }

    // castSpells uses PRIVATE METHODS called 'castFire', 'castIce', and
    // 'castThunder' [cite: 356]
    private void castFire() {
        System.out.println(getName() + " has used fire magic towards an enemy"); // [cite: 365]
    }

    private void castIce() {
        System.out.println(getName() + " has used ice magic towards an enemy"); // [cite: 367]
    }

    private void castThunder() {
        System.out.println(getName() + " has used thunder magic towards an enemy"); // [cite: 369]
    }

    public void castSpells(int choice) {
        // 1 for Fire, 2 for Ice, and 3 for Thunder [cite: 364]
        if (choice == 1) {
            castFire(); // [cite: 363]
        } else if (choice == 2) {
            castIce(); // [cite: 363]
        } else if (choice == 3) {
            castThunder(); // [cite: 363]
        } else {
            System.out.println("Invalid spell choice!");
        }
    }
}
