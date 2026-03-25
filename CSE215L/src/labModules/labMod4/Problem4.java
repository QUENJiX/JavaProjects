package labModules.labMod4;

/* * Problem 4: Recreate the pattern printing exercise (Lab 4 Homework Question 1), but this time, use 
 * the method void createPattern(char a, char b), where a and b could be any character of 
 * your choosing.
 */
public class Problem4 {

    // Method to create an alternating pattern
    // Note: Since HW1 isn't provided, this creates a generic 5x5 alternating
    // checkerboard pattern
    public static void createPattern(char a, char b) {
        int size = 5;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Alternating characters based on grid position
                if ((i + j) % 2 == 0) {
                    System.out.print(a + " ");
                } else {
                    System.out.print(b + " ");
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    public static void main(String[] args) {
        System.out.println("Pattern using '*' and '-':");
        createPattern('*', '-');

        System.out.println("\nPattern using 'X' and 'O':");
        createPattern('X', 'O');
    }
}
