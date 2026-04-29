package ModulePractice.LabMod7;

public class Gunner extends RPGCharacter {
    private int precision;

    public Gunner() {
        super();
        this.precision = 0;
    }

    public Gunner(String name, int level, int healthPoints, int precision) {
        super(name, level, healthPoints);
        this.precision = precision;
    }

    public int getPrecision() {
        return this.precision;
    }
    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public void shootEnemy(){
        System.out.println(getName() + " has shot a bullet towards an enemy.");

    }

    public void increasePrecision(){
        this.precision = (this.precision + 5 + getLevel());
        System.out.println("Precision Increment is Successful for " + getName());
    }
}
