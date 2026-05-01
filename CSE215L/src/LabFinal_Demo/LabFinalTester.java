package LabFinal_Demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LabFinalTester {
    public static void main(String[] args) {
        File file = new File("borrow_report.txt");
        if (file.exists()) {
            file.delete();
        }

        Student s1 = new Student("231001", "Araf Khan", 45);
        Student s2 = new Student("231002", "Mira Das", 20);

        BookItem b1 = new BookItem("B-101", "Java Basics", 40, "Herbert Schildt");
        DeviceItem d1 = new DeviceItem("D-201", "DSLR Camera", 250, "Canon");

        CampusItem[] items = new CampusItem[2];
        items[0] = b1;
        items[1] = d1;

        System.out.println("===== Item Details =====");
        for (int i = 0; i < items.length; i++) {
            items[i].displayInfo();
            System.out.println();
        }

        System.out.println("===== Borrowing Section =====");
        b1.borrowItem(s1, 4);

        try {
            d1.borrowItem(s2, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            d1.borrowItem(s1, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        BorrowRecord r1 = new BorrowRecord("R-01", s1, b1, 4);
        BorrowRecord r2 = new BorrowRecord("R-02", s1, d1, 2);

        System.out.println();
        System.out.println("===== Borrow Records =====");
        r1.displayRecord();
        System.out.println();
        r2.displayRecord();

        r1.saveToFile("borrow_report.txt");
        r2.saveToFile("borrow_report.txt");

        System.out.println();
        System.out.println("===== File Content =====");

        try {
            FileReader reader = new FileReader("borrow_report.txt");
            Scanner fileScanner = new Scanner(reader);

            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }

            fileScanner.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("File reading failed.");
        }
    }
}
