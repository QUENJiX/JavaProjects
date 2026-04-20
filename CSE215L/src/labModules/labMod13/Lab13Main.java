package labModules.labMod13;

public class Lab13Main {
    public static void main(String[] args) {
        FirePokemon charmander = new FirePokemon("Charmander", 5);
        FirePokemon vulpix = new FirePokemon("Vulpix", 12);

        WaterPokemon squirtle = new WaterPokemon("Squirtle", 6);
        WaterPokemon psyduck = new WaterPokemon("Psyduck", 14);

        System.out.println("--- BATTLE LOG ---");
        charmander.attack();
        vulpix.attack();
        squirtle.attack();
        psyduck.attack();

        System.out.println("\n--- POKEMON INFORMATION ---");
        charmander.displayInfo();
        System.out.println();
        vulpix.displayInfo();
        System.out.println();
        squirtle.displayInfo();
        System.out.println();
        psyduck.displayInfo();
    }
}
