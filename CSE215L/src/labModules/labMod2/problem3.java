/*Take a string input from the user and show whether the last character of the string is a
letter or a digit. */
package labModules.labMod2;

import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str;
        System.out.print("Enter a string: ");
        str = input.nextLine();

        char lastChar = str.charAt(str.length() - 1);

        if (Character.isDigit(lastChar)) {
            System.out.println("The last character is a digit.");
        } else if (Character.isLetter(lastChar)) {
            System.out.println("The last character is a letter.");
        } else {
            System.out.println("The last character is neither a letter nor a digit.");
        }
        input.close();
    }
}
