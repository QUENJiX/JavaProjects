package labModules.labMod8.Pirate;

public class PirateTest {
    public static void main(String[] args) {
        Ship ship1 = new Ship("Black Pearl");
        Ship ship2 = new Ship("Queen Anne's Revenge");

        Captain captain = new Captain("Jack Sparrow", "England");

        System.out.println("Captain: " + captain.getPirateName());

        System.out.println("\n-- Owning First Ship --");
        captain.ownShip(ship1);
        captain.getShipDetails();

        System.out.println("\n-- Disowning First Ship --");
        captain.disownShip();
        captain.getShipDetails();

        System.out.println("\n-- Owning Second Ship --");
        captain.ownShip(ship2);
        captain.getShipDetails();
    }
}