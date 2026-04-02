import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b;

        System.out.print("Enter the first integer: ");
        a = input.nextInt();
        System.out.print("Enter the second integer: ");
        b = input.nextInt();
        input.close();
        
        int max = max(a, b);
        System.out.println("The maximum value is: " + max);
    }

    public static int max(int m, int n){
        return (m > n) ? m : n;
    }
}