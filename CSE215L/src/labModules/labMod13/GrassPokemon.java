package labModules.labMod13;

public class GrassPokemon implements Pokemon {
    private String name;
    private int level;

    public GrassPokemon() {
    }

    public GrassPokemon(String name, int level) {
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
        System.out.println(name + " has used Razor Leaf");
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Type: Grass");
        System.out.println("Level: " + level);
    }
}