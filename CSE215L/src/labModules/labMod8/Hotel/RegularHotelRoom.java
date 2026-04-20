package labModules.labMod8.Hotel;

public class RegularHotelRoom extends HotelRoom {
    private boolean hasWifi;
    private boolean hasAC;

    public RegularHotelRoom() {
    }

    public RegularHotelRoom(String roomNumber, double pricePerNight, int numberOfBeds, boolean hasWifi, boolean hasAC) {
        super(roomNumber, pricePerNight, numberOfBeds);
        this.hasWifi = hasWifi;
        this.hasAC = hasAC;
    }

    public boolean getHasWifi() {
        return hasWifi;
    }

    public boolean getHasAC() {
        return hasAC;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Wi-Fi: " + (hasWifi ? "Yes" : "No"));
        System.out.println("Has AC: " + (hasAC ? "Yes" : "No"));
    }

    @Override
    public double calculateTotalPrice(int days) {
        double currentPricePerNight = super.getPricePerNight();

        if (hasWifi && hasAC) {
            currentPricePerNight += 1000;
        } else if (hasWifi) {
            currentPricePerNight += 300;
        } else if (hasAC) {
            currentPricePerNight += 700;
        }
        return currentPricePerNight * days;
    }
}
