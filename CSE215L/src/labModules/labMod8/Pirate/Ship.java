package labModules.labMod8.Pirate;

public class Ship {
    private String shipName;

    public Ship() {
    }

    public Ship(String name) {
        this.shipName = name;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipName() {
        return shipName;
    }

    public void displayDetails() {
        System.out.println("Ship Name: " + shipName);
    }
}
