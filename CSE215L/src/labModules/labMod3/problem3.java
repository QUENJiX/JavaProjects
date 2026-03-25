/* Problem 3: Declare a double array of size 10, then assign the values as you see fit. After that, if the
numbers are NOT IN proper order, sort them in ascending order (small to large). For
example, if an array has a value of 5 6 2 8 1, the sorted array will be 1 2 5 6 8
*/

package labModules.labMod3;

public class problem3 {
    public static void main(String[] args) {
        double[] array = { 3.4, 5.6, 7.8, 9.0, 1.2, 4.5, 6.7, 8.9, 0.1, 2.3 };
        double temp;
        // Sorting the array in ascending order using bubble sort
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        // Printing the sorted array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
