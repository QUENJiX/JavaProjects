package labModules.labMod3;

/*
 * Problem 6: Take an Integer Array of size 20. Then, find the Median 
 * of the array (Sort the array FIRST).
 */
public class Problem6 {
    public static void main(String[] args) {
        // Array of size 20 populated with random distinct numbers
        int[] arr = { 15, 3, 9, 8, 2, 11, 20, 1, 5, 13, 18, 4, 10, 19, 7, 6, 17, 12, 16, 14 };

        // Sorting the array first (using Bubble Sort)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Finding the median
        // Since the array size (20) is even, median is the average of the two middle
        // If the array size were odd, we would take the middle element directly as the median
        // elements
        int midIndex1 = (arr.length / 2) - 1; // Index 9
        int midIndex2 = arr.length / 2; // Index 10

        double median = (arr[midIndex1] + arr[midIndex2]) / 2.0;

        System.out.println("Sorted Array:");
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println("\n\nThe Median is: " + median);
    }
}
