/*Problem 5: You are tasked to write the name of your living place, but make sure the final product
does not contain whitespaces before the beginning and after the end. */

package labModules.labMod2;

import java.util.Scanner;

public class problem5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String adress;

        System.out.print("Enter your address: ");
        adress = input.nextLine();

        System.out.println(adress.trim());
        input.close();
    }
}
