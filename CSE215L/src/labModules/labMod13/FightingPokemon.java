package labModules.labMod13;

public class FightingPokemon implements Pokemon {
    private String name;
    private int level;

    public FightingPokemon() {
    }

    public FightingPokemon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
    }

    public void attack() {
        System.out.println(name + " has used Karate Chop");
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Type: Fighting");
        System.out.println("Level: " + level);
    }
}
