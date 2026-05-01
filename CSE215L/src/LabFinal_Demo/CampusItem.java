package LabFinal_Demo;

public abstract class CampusItem {
    private String itemId;
    private String title;
    private double dailyFee;

    public CampusItem() {
        this.itemId = "I-000";
        this.title = "Unknown Item";
        this.dailyFee = 0.0;
    }

    public CampusItem(String itemId, String title, double dailyFee) {
        this.itemId = itemId;
        this.title = title;
        this.dailyFee = dailyFee;
    }

    public String getTitle() {
        return title;
    }

    public double getDailyFee() {
        return dailyFee;
    }

    public void displayInfo() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Daily Fee: " + dailyFee);
    }

    public abstract double calculateFee(int days);
}
