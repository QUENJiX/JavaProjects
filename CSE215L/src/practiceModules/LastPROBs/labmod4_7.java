package practiceModules.LastPROBs;

public class labmod4_7 {
    public static void main(String[] args) {
        //Testing Method 1
        double result_1 = priceCalculation(200);
        System.out.println("Result of Method 1: " + result_1);

        //Testing Method 2
        double result_2 = priceCalculation(100, 200);
        System.out.println("Result of Method 2: " + result_2);

        //Testing Method 3
        double result_3 = priceCalculation(100, 150, 50);
        System.out.println("Result of Method 3: " + result_3);
    }

    // Method 1
    public static double priceCalculation(double price) {
        return price + (price / 2.0);
    }

    // Method 2
    public static double priceCalculation(double price1, double price2) {
        return price1 + price2;
    }

    // Method 3
    public static double priceCalculation(double price1, double price2, double price3) {
        double total = price1 + price2 + price3;

        if(total < 200){
            return total + 50;
        }else if(total >= 200 && total <= 400){
            return total;
        }else{
            return total - 50;
        }
    }
}
