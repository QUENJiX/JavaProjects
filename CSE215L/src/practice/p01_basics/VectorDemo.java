package practice.p01_basics;

import java.util.Scanner;
import java.util.Vector;
/*
 * Vector Functions:
 * add() - adds an element to the end of the vector
 * get() - retrieves the element at a specified index
 * size() - returns the number of elements in the vector
 * remove() - removes the element at a specified index
 * clear() - removes all elements from the vector
 * contains() - checks if the vector contains a specified element
 * isEmpty() - checks if the vector is empty
 */

public class VectorDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector<String> names = new Vector<>();

        System.out.print("Enter the number of names: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            String name = input.next();
            names.add(name);
        }

        names.size();
        System.out.println("\nNames in the vector:" + names);
        System.out.println("\nFirst name: " + names.get(0));
        System.out.println("Total names: " + names.size());

        String toDelete = "John";
        if (names.contains(toDelete)) {
            names.remove(toDelete);
            System.out.println("\n" + toDelete + " has been removed from the vector.");
        } else {
            System.out.println("\n" + toDelete + " is not found in the vector.");
        }
        System.out.println("Names after removal:" + names);
        System.out.println();
        input.close();
    }
}
