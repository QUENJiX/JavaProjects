/*Take a string input from the user and show whether the last character of the string is a
letter or a digit. */
/*
* index  =      0 ,  1,   2,   3,   4,   5 
* String str = [S], [t], [r], [i], [n], [g] 
* Size = 6
* str.charAt(5) = g
*/

package labModules.labMod2;

import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str;
        boolean isLetter = true;

        System.out.print("Enter a string: ");
        str = input.nextLine();

        if (Character.isDigit(str.charAt(str.length() - 1))) {
            isLetter = false;
            System.out.println("The last character is a digit.");
        }
        if (isLetter) {
            System.out.println("The last character is a letter.");
        }
        input.close();
    }
}
