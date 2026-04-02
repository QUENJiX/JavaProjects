package labModules.labMod8.Pirate;

public class Captain extends Pirate {
    private boolean ownsShip = false;
    private Ship ownedShip = null;

    public Captain() {
    }

    public Captain(String name, String country) {
        super(name, country);
    }

    public void ownShip(Ship ship) {
        this.ownedShip = ship;
        this.ownsShip = true;
    }

    public void disownShip() {
        this.ownedShip = null;
        this.ownsShip = false;
    }

    public void getShipDetails() {
        if (!ownsShip || ownedShip == null) {
            System.out.println("The pirate captain does not own a ship.");
        } else {
            ownedShip.displayDetails();
        }
    }
}
