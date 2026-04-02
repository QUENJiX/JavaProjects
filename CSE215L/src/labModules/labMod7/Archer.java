package labModules.labMod7;

public class Archer extends RPGCharacter {
    private int accuracy;

    public Archer(String name, int level, int healthPoints, int accuracy) {
        super(name, level, healthPoints);
        this.accuracy = accuracy;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void shootEnemy() {
        System.out.println(getName() + " has shot an arrow to the enemy");
    }

    public void increaseAccuracy() {
        this.accuracy += 10 + (getLevel() * 2);
        System.out.println("Accuracy Increment is Successful " + getName());
    }
}
