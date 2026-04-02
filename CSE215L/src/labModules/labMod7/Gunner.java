package labModules.labMod7;

public class Gunner extends RPGCharacter {
    private int precision;

    public Gunner(String name, int level, int healthPoints, int precision) {
        super(name, level, healthPoints);
        this.precision = precision;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public void shootEnemy() {
        System.out.println(getName() + " has shot a bullet to the enemy");
    }

    public void increasePrecision() {
        this.precision += 5 + getLevel();
        System.out.println("Precision Increment is Successful for " + getName());
    }
}
