/*
Problem 2: Take user input of first and last names separately. Then, make the first name look like it is
written in all uppercase letters and follow it up by concatenating these names.
 */

package labModules.labMod2;

import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String firstName, lastName;

        System.out.print("Enter your first name: ");
        firstName = input.nextLine();
        System.out.print("Enter your last name: ");
        lastName = input.nextLine();
        System.out.println(firstName.toUpperCase() + " " + lastName); // concat(firstName.toUpperCase(), lastName) also
                                                                      // works

        input.close();
    }
}
