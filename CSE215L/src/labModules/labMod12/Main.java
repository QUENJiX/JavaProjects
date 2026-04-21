package labModules.labMod12;

import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        FictionBook fb = new FictionBook("Harry Potter", "J.k Rowling", "Fantasy");
        NonFictionBook nFb = new NonFictionBook("A Brief History of Time", "Stepher Hawking", "Physics");

        System.out.print("\nEnter your age to view recommendation: ");
        int age = input.nextInt();
        if(nFb.isRecommendedForAge(age)){
            System.out.println();
            nFb.displayInfo();
            System.out.println();
        }else if (fb.isRecommendedForAge(age)){
            System.out.println();
            fb.displayInfo();
            System.out.println();
        }else{
            System.out.println("Get the fuck out of my Library!");
        }

        input.close();
    }
}
