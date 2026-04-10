package labModules.labMod7;

// IS-A relationship
// Mohammad IS-A child of Salman
// Dog (Dog) IS-An Animal (Parent)

public class RPGCharacter {
    private String name;
    private int level;
    private int healthPoints;

    // Default Constructor
    public RPGCharacter() {
        this.name = "NPC";
        this.level = 1;
        this.healthPoints = 10;
    }

    // Parameterized Constructor
    public RPGCharacter(String name, int level, int healthPoints) {
        this.name = name;
        this.level = level;
        this.healthPoints = healthPoints;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
