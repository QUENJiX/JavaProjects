package labModules.labMod13;

public class FirePokemon implements Pokemon {
    private String name;
    private int level;

    public FirePokemon() {}
    public FirePokemon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getLevel() {
        return level;
    }
    @Override
    public void levelUp() {
        level++;
    }
    @Override
    public void attack() {
        System.out.println(name + " has used Ember");
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Type: Fire");
        System.out.println("Level: " + level);
    }
}
