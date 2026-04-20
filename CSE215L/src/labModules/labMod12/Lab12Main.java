package labModules.labMod12;

import java.util.Scanner;

public class Lab12Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        FictionBook fBook = new FictionBook("The Hobbit", "J.R.R. Tolkien", "Fantasy");
        NonFictionBook nfBook = new NonFictionBook("Sapiens", "Yuval Noah Harari", "History");

        System.out.println("--- Fiction Book Details ---");
        fBook.displayInfo();
        System.out.print("Enter reader's age to check recommendation: ");
        int age1 = input.nextInt();

        if (fBook.isRecommendedForAge(age1)) {
            System.out.println("Result: Recommended.");
        } else {
            System.out.println("Result: Not recommended (Must be 14+).");
        }

        System.out.println("\n--- Non-Fiction Book Details ---");
        nfBook.displayInfo();
        System.out.print("Enter reader's age to check recommendation: ");
        int age2 = input.nextInt();
        if (nfBook.isRecommendedForAge(age2)) {
            System.out.println("Result: Recommended.");
        } else {
            System.out.println("Result: Not recommended (Must be 18+).");
        }

        input.close();
    }
}
