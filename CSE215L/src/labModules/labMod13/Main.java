package labModules.labMod13;

public class Main {
    public static void main(String[] args) {
        FirePokemon charmander = new FirePokemon("Charmander", 5);
        WaterPokemon squirtle = new WaterPokemon("Squirtle", 5);

        System.out.println("\n--- Attacks Begin ---");
        charmander.attack();
        squirtle.attack();

        System.out.println("\n--- Pokemon Data ---");
        charmander.levelUp();
        charmander.displayInfo();
        System.out.println();

        squirtle.levelUp();
        squirtle.displayInfo();
        System.out.println();

        System.out.println();
    }
}
