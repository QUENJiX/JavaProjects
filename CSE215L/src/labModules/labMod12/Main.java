package labModules.labMod12;

import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        FictionBook fb = new FictionBook("Harry Potter", "J.K. Rowling", "Fantasy");
        NonFictionBook nfb = new NonFictionBook("Sapiens", "Yuval Noah Harari", "History");

        fb.displayInfo();
        System.out.print("Enter age to check FictionBook recommendation: ");
        int fbAge = input.nextInt();
        System.out.println("Is Recommended: " + fb.isRecommendedForAge(fbAge));

        System.out.println();

        nfb.displayInfo();
        System.out.print("Enter age to check NonFictionBook recommendation: ");
        int nfbAge = input.nextInt();
        System.out.println("Is Recommended: " + nfb.isRecommendedForAge(nfbAge));

        input.close();
    }
}
