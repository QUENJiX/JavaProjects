package labModules.labMod13;

public class Main {
    public static void main(String[] args) {
        FirePokemon f1 = new FirePokemon("Charmander", 5);
        FirePokemon f2 = new FirePokemon("Vulpix", 8);

        WaterPokemon w1 = new WaterPokemon("Squirtle", 5);
        WaterPokemon w2 = new WaterPokemon("Psyduck", 10);

        f1.attack();
        f2.attack();
        w1.attack();
        w2.attack();

        System.out.println();

        f1.displayInfo();
        System.out.println();
        f2.displayInfo();
        System.out.println();
        w1.displayInfo();
        System.out.println();
        w2.displayInfo();
    }
}
