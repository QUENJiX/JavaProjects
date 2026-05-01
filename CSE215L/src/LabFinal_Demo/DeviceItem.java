package LabFinal_Demo;

public class DeviceItem extends CampusItem implements Borrowable {
    private String brand;
    private boolean available;
    private Student borrowedBy;

    public DeviceItem() {
        super();
        this.brand = "Unknown Brand";
        this.available = true;
        this.borrowedBy = null;
    }

    public DeviceItem(String itemId, String title, double dailyFee, String brand) {
        super(itemId, title, dailyFee);
        this.brand = brand;
        this.available = true;
        this.borrowedBy = null;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Brand: " + brand);
        System.out.println("Available: " + available);
    }

    public double calculateFee(int days) {
        return (getDailyFee() * days) + 100;
    }

    public void borrowItem(Student student, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be positive.");
        }

        if (student.getCompletedCredits() < 30) {
            throw new IllegalArgumentException("Not enough credits to borrow device.");
        }

        if (available) {
            borrowedBy = student;
            available = false;
            System.out.println(student.getName() + " borrowed device: " + getTitle());
        } else {
            System.out.println("Device is not available.");
        }
    }

    public void returnItem() {
        borrowedBy = null;
        available = true;
    }

    public boolean isAvailable() {
        return available;
    }
}
