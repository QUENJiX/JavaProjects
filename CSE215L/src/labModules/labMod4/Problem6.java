package labModules.labMod4;

/* * Problem 6: Declare a double array of size 10, then assign the values as you see fit. 
 * After that, if the numbers are NOT IN proper order, sort them in ascending order (small to large). 
 */
public class Problem6 {
    public static void main(String[] args) {
        // Declaring a double array of size 10
        double[] arr = { 5.5, 6.2, 2.1, 8.9, 1.4, 3.3, 9.0, 4.7, 7.8, 0.5 };

        System.out.println("Original Array:");
        printArray(arr);

        // Sorting the array in ascending order using Bubble Sort algorithm
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("\nSorted Array (Ascending):");
        printArray(arr);
    }

    // Helper method to print the array cleanly
    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
