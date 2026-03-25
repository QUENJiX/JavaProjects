package labModules.labMod4;

/* * Problem 7: Create THREE methods named double priceCalculation(), where the parameter 
 * sets and implementation is given as follows...
 */
public class Problem7 {

    // Method 1: One product. Adds half of the price.
    public static double priceCalculation(double price) {
        return price + (price / 2);
    }

    // Method 2: Two products. Adds prices together.
    public static double priceCalculation(double p1, double p2) {
        return p1 + p2;
    }

    // Method 3: Three products. Logic based on total price thresholds.
    public static double priceCalculation(double p1, double p2, double p3) {
        double total = p1 + p2 + p3;

        if (total < 200) {
            return total + 50; // Increase by 50
        } else if (total >= 200 && total <= 400) {
            return total; // Return as is
        } else {
            return total - 50; // Lower by 50
        }
    }

    public static void main(String[] args) {
        // Testing Method 1
        double result1 = priceCalculation(100.0);
        System.out.println("Result of 1 parameter (Input: 100): " + result1);

        // Testing Method 2
        double result2 = priceCalculation(45.5, 54.5);
        System.out.println("Result of 2 parameters (Input: 45.5, 54.5): " + result2);

        // Testing Method 3
        double result3a = priceCalculation(50, 50, 50); // Total 150 (< 200)
        System.out.println("Result of 3 params (Total < 200): " + result3a);

        double result3b = priceCalculation(100, 100, 100); // Total 300 (Between 200 & 400)
        System.out.println("Result of 3 params (200 <= Total <= 400): " + result3b);

        double result3c = priceCalculation(200, 200, 100); // Total 500 (> 400)
        System.out.println("Result of 3 params (Total > 400): " + result3c);
    }
}
