package labModules.labMod8.Hotel;

public class HotelTest {
    public static void main(String[] args) {
        System.out.println("--- Testing HotelRoom ---");
        HotelRoom basicRoom = new HotelRoom("101", 2000, 2);
        basicRoom.displayInfo();
        System.out.println("Total Price for 3 days: " + basicRoom.calculateTotalPrice(3));

        System.out.println("\n--- Testing RegularHotelRoom ---");
        RegularHotelRoom regRoom = new RegularHotelRoom("102", 2000, 2, true, true);
        regRoom.displayInfo();
        System.out.println("Total Price for 3 days (with Wi-Fi & AC): " + regRoom.calculateTotalPrice(3));
    }
}
