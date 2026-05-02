package LabFinal_Demo;

import java.io.FileWriter;
import java.io.IOException;

public class BorrowRecord {
    private String recordId;
    private Student student;
    private CampusItem item;
    private int days;

    public BorrowRecord(String recordId, Student student, CampusItem item, int days) {
        this.recordId = recordId;
        this.student = student;
        this.item = item;
        this.days = days;
    }

    public double getTotalFee() {
        return item.calculateFee(days);
    }

    public void displayRecord() {
        System.out.println("Record ID: " + recordId);
        System.out.println("Student: " + student.getName());
        System.out.println("Item: " + item.getTitle());
        System.out.println("Days: " + days);
        System.out.println("Total Fee: " + getTotalFee());
    }

    public void saveToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("Record ID: " + recordId + "\n");
            writer.write("Student: " + student.getName() + "\n");
            writer.write("Item: " + item.getTitle() + "\n");
            writer.write("Days: " + days + "\n");
            writer.write("Total Fee: " + getTotalFee() + "\n");
            writer.write("--------------------\n");
        } catch (IOException e) {
            System.out.println("File writing failed.");
        }
    }
}
