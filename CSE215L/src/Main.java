import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] array = {3, 2, 7, 5, 11, 17, 27, 19, 32, 29};
        // 0 1 2 3  4  5  6  7  8  9
        // 3 2 7 5 11 17 27 19 32 29
        // 1st Swap: 2, 3, 7, 5, 11, 17, 27, 19, 32, 29
        // 3rd Swap: 2, 3, 5, 7, 11, 17, 27, 19, 32, 29
        // 2, 3, 5, 7, 11, 17, 19, 27, 29, 32


        //sort the array in ascending order
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) { // 3 > 2
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (double num : array) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}