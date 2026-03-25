/*Problem 1; Take user input for the salary for February, March, and April, then find the maximum
salary and round it up to zero decimal figures. Then, add half of the minimum salary to
the rounded-up maximum salary*/

package labModules.labMod2;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner inpput = new Scanner(System.in);

        double feb, mar, apr;

        System.out.print("Enter the salary for February: ");
        feb = inpput.nextDouble();
        System.out.print("Enter the salary for March: ");
        mar = inpput.nextDouble();
        System.out.print("Enter the salary for April: ");
        apr = inpput.nextDouble();

        double maxSalary = Math.ceil((Math.max(feb, Math.max(mar, apr))));
        double minSalary = (Math.min(feb, Math.min(mar, apr)));

        System.out.println(maxSalary + (minSalary / 2.0));
        inpput.close();
    }
}
