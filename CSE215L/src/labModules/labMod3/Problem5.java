package labModules.labMod3;

/*
 * Problem 5: Take a 4X4 array and initialize it with specific values. 
 * Calculate and print the sum of each row, column, and diagonal.
 */
public class Problem5 {
    public static void main(String[] args) {
        int[][] matrix = {
                { 4, 2, 7, 6 },
                { 3, 7, 9, -5 },
                { 2, 12, 3, 2 },
                { -1, 4, -3, 9 }
        };

        // Row and Column sums
        for (int i = 0; i < 4; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < 4; j++) {
                rowSum += matrix[i][j]; // Fix row, traverse columns
                colSum += matrix[j][i]; // Fix column, traverse rows
            }
            System.out.println("Sum of Row " + (i + 1) + ": " + rowSum);
            System.out.println("Sum of Column " + (i + 1) + ": " + colSum);
        }

        System.out.println("----------------------------------");

        // Diagonal sums
        int mainDiagonalSum = 0;
        int antiDiagonalSum = 0;

        for (int i = 0; i < 4; i++) {
            mainDiagonalSum += matrix[i][i];
            antiDiagonalSum += matrix[i][3 - i]; // matrix[i][matrix[0].length - 1 - i]
        }

        System.out.println("Sum of Top-Left to Bottom-Right Diagonal: " + mainDiagonalSum);
        System.out.println("Sum of Top-Right to Bottom-Left Diagonal: " + antiDiagonalSum);
    }
}
