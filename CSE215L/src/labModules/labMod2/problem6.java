/*Problem 6: (Using if-else statement) Take a user input for your name and check whether it starts with
a Uppercase Vowel. If the condition is fulfilled, write “My name starts with a vowel”;
otherwise, write “My name starts with a consonant.” */

package labModules.labMod2;

import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name = new String();

        System.out.print("Enter your name: ");
        name = input.nextLine();

        if (name.charAt(0) == 'A' || name.charAt(0) == 'E' || name.charAt(0) == 'I' || name.charAt(0) == 'O' || name
                .charAt(0) == 'U') {
            System.out.println("My name starts with a vowel");
        } else {
            System.out.println("My name starts with a consonant");
        }

        input.close();
    }
}
