package labModules.labMod14;

import java.util.Scanner;

public class Homework {

    public static void method1() {
        System.out.println("--- Method 1: Even Integers Array ---");
        Scanner input = new Scanner(System.in);
        int[] evens = new int[5];
        int count = 0;
        int sum = 0;
        int maxSquare = -1;

        while (count < 5) {
            try {
                System.out.print("Enter an even integer for index " + count + ": ");
                int num = input.nextInt();

                if (num % 2 != 0) {
                    throw new Exception("Even integers only");
                }

                evens[count] = num;
                sum += num;

                int square = num * num;
                if (square > maxSquare) {
                    maxSquare = square;
                }

                count++;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Sum of elements: " + sum);
        System.out.println("Maximum of the squares: " + maxSquare);
        input.close();
    }

    public static void method2() {
        System.out.println("\n--- Method 2: Vowels Array ---");
        Scanner input = new Scanner(System.in);
        char[] vowels = new char[10];
        int count = 0;

        while (count < 10) {
            try {
                System.out.print("Enter a vowel for index " + count + ": ");
                char c = input.next().charAt(0);
                char lowerC = Character.toLowerCase(c);

                if (lowerC != 'a' && lowerC != 'e' && lowerC != 'i' && lowerC != 'o' && lowerC != 'u') {
                    throw new Exception("Vowels Only");
                }

                vowels[count] = c;
                count++;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Vowels collected: ");
        for (char v : vowels) {
            System.out.print(v + " ");
        }
        System.out.println();
        input.close();
    }

    public static void method3() {
        System.out.println("\n--- Method 3: Out of Bounds Trap ---");

        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2;
        }

        try {
            int trap = arr[24];
            System.out.println("Value: " + trap);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This is an array of size 20!");
        }
    }

    public static void main(String[] args) {
        method1();
        method2();
        method3();
    }
}
