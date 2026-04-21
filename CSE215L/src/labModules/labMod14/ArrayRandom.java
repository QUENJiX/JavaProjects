package labModules.labMod14;

import java.util.Scanner;

import java.util.Scanner;

public class ArrayRandom {
    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = (int) (Math.random() * 10000);
        }

        Scanner input = new Scanner(System.in);
        try {
            int index = input.nextInt();
            System.out.println(a[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index is out of bounds.");
        } catch (Exception e) {
            System.out.println("Invalid input.");
        } finally {
            input.close();
        }
    }
}