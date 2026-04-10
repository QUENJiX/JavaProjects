package labModules.labMod7;

public class Wizard extends RPGCharacter {
    private int magicPoints;

    public Wizard(String name, int level, int healthPoints, int magicPoints) {
        super(name, level, healthPoints);
        this.magicPoints = magicPoints;
    }

    public int getMagicPoints() {
        return magicPoints;
    }public void setMagicPoints(int magicPoints) {
        this.magicPoints = magicPoints;
    }

    public void castSpells(int choice) {
        if (choice == 1) {
            castFire();
        } else if (choice == 2) {
            castIce();
        } else if (choice == 3) {
            castThunder();
        } else {
            System.out.println("Invalid magic choice.");
        }
    }

    private void castFire() {
        System.out.println(getName() + " has used fire magic towards an enemy");
    }

    private void castIce() {
        System.out.println(getName() + " has used ice magic towards an enemy");
    }

    private void castThunder() {
        System.out.println(getName() + " has used thunder magic towards an enemy");
    }
}
