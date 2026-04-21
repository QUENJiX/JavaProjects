package labModules.labMod13;

public class Main {
    public static void main(String[] args) {
        FirePokemon charmander = new FirePokemon("Charmander", 5);
        WaterPokemon squirtle = new WaterPokemon("Squirtle", 5);
        GrassPokemon bulbasaur = new GrassPokemon("Bulbasaur", 5);
        ElectricPokemon pikachu = new ElectricPokemon("Pikachu", 5);
        FlyingPokemon pidgey = new FlyingPokemon("Pidgey", 3);
        FightingPokemon machop = new FightingPokemon("Machop", 6);

        charmander.attack();
        squirtle.attack();
        bulbasaur.attack();
        pikachu.attack();
        pidgey.attack();
        machop.attack();

        System.out.println("\n--- Pokemon Data ---");

        charmander.displayInfo();
        System.out.println();
        squirtle.displayInfo();
        System.out.println();
        bulbasaur.displayInfo();
        System.out.println();
        pikachu.displayInfo();
        System.out.println();
        pidgey.displayInfo();
        System.out.println();
        machop.displayInfo();
    }
}
