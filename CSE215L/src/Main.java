import java.util.Vector;

public class Main {
    public static void main(String[] args) {
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

        Vector<String> names = new Vector<>();
        names.add("Hasib");
        names.add("Risha");
        names.add("Fabiha");
        names.add("Jaima");
        names.size();

        System.out.println("Names in the vector:" + names);

        System.out.println("\nFirst name: " + names.get(0));
        System.out.println("Total names: " + names.size());
        System.out.println("Contains 'Risha': " + names.contains("Risha"));
        System.out.println("\n");

        names.remove(2);
        System.out.println("Names after removal:" + names);
    }
}