package labModules.labMod14;

import java.util.Scanner;

public class HomeworkMethods {

    public static void main(String[] args) {
        method1();
        method2();
        method3();
    }

    public static void method1() {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];
        int count = 0;
        int sum = 0;
        int maxSquare = Integer.MIN_VALUE;

        while (count < 5) {
            try {
                System.out.print("\nEnter an even integer: ");
                int num = input.nextInt();
                if (num % 2 != 0) {
                    throw new IllegalArgumentException("Even integers only");
                }
                arr[count] = num;
                sum += num;
                int square = num * num;
                if (square > maxSquare) {
                    maxSquare = square;
                }
                count++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                input.next();
            }
        }
        System.out.println(sum);
        System.out.println(maxSquare);
    }

    public static void method2() {
        Scanner input = new Scanner(System.in);
        char[] arr = new char[10];
        int count = 0;

        while (count < 10) {
            try {
                System.out.print("\nEnter a vowel: ");
                char ch = input.next().charAt(0);
                char lower = Character.toLowerCase(ch);
                if (lower != 'a' && lower != 'e' && lower != 'i' && lower != 'o' && lower != 'u') {
                    throw new IllegalArgumentException("Vowels Only");
                }
                arr[count] = ch;
                count++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void method3() {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = i;
        }

        try {
            System.out.println(arr[24]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nThis is an array of size 20!");
        }
    }
}