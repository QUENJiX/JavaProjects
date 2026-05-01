package LabFinal_Demo;

public class BookItem extends CampusItem implements Borrowable {
    private String author;
    private boolean available;
    private Student borrowedBy;

    public BookItem() {
        super();
        this.author = "Unknown Author";
        this.available = true;
        this.borrowedBy = null;
    }

    public BookItem(String itemId, String title, double dailyFee, String author) {
        super(itemId, title, dailyFee);
        this.author = author;
        this.available = true;
        this.borrowedBy = null;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + author);
        System.out.println("Available: " + available);
    }

    public double calculateFee(int days) {
        return getDailyFee() * days;
    }

    public void borrowItem(Student student, int days) {
        if (available) {
            borrowedBy = student;
            available = false;
            System.out.println(student.getName() + " borrowed book: " + getTitle());
        } else {
            System.out.println("Book is not available.");
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
