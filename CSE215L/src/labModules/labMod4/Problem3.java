package labModules.labMod4;

/* * Problem 3: Declare an integer array of size 10, then assign the values as you see fit. 
 * Then, you find the summation of these numbers you had just entered, followed by finding the maximum 
 * of those numbers.
 */
public class Problem3 {
    public static void main(String[] args) {
        int[] numbers = { 12, 45, 7, 89, 23, 56, 91, 34, 18, 5 };

        int sum = 0;
        int max = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println("Summation of all numbers: " + sum);
        System.out.println("Maximum number in the array: " + max);
    }
}
