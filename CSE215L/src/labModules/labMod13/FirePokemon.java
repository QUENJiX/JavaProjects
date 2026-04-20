package labModules.labMod13;

class FirePokemon implements Pokemon {
    private String name;
    private int level;

    public FirePokemon() {
        this.name = "Unknown Fire Type";
        this.level = 1;
    }

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
        return this.name;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void levelUp() {
        this.level += 1;
    }

    @Override
    public void attack() {
        System.out.println(this.name + " has used Ember");
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Type: Fire");
        System.out.println("Level: " + this.level);
    }
}
