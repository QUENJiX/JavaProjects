package practice.p05_collections;

/**
 * SetDemo.java — HashSet, TreeSet, LinkedHashSet & Set Operations
 * ================================================================
 * CSE215 - Programming Language II
 *
 * 💡 INTUITION: A Set is a collection with NO DUPLICATES.
 *    Think of it like a bag of unique marbles — you can't have two identical marbles.
 *
 *    Three main implementations:
 *      HashSet       → fastest (O(1) add/remove/contains), NO ordering guarantee
 *      LinkedHashSet → maintains INSERTION order, slightly slower than HashSet
 *      TreeSet       → keeps elements SORTED, O(log n) operations
 *
 * Topics covered:
 *   1. HashSet basics (add, remove, contains, iteration)
 *   2. LinkedHashSet (ordered by insertion)
 *   3. TreeSet (sorted set)
 *   4. Set operations: union, intersection, difference, subset
 *   5. Set with custom objects (equals/hashCode importance)
 *
 * 🔗 SEE ALSO: p05_Collections/HashMapDemo.java, p02_OOP/ObjectClassMethodsDemo.java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   SET DEMO                                   ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        // =====================================================================
        // SECTION 1: HASHSET BASICS
        // =====================================================================
        System.out.println("=== 1. HASHSET ===");

        /**
         * 💡 HashSet:
         * - Backed by a HashMap internally
         * - O(1) average for add, remove, contains
         * - NO ordering guarantee (elements may appear in any order!)
         * - Allows ONE null element
         */
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple"); // Duplicate — silently ignored
        fruits.add("Banana"); // Duplicate — silently ignored
        fruits.add(null); // Null is allowed (once)

        System.out.println("Set: " + fruits);
        System.out.println("Size: " + fruits.size()); // 4, not 6
        System.out.println("Contains 'Apple': " + fruits.contains("Apple"));

        // add() returns false if element already exists
        boolean added = fruits.add("Apple");
        System.out.println("Added 'Apple' again? " + added); // false

        // Remove
        fruits.remove(null);
        fruits.remove("Cherry");
        System.out.println("After removals: " + fruits);

        // Iteration
        System.out.println("\nIterating:");
        for (String fruit : fruits) {
            System.out.println("  - " + fruit);
        }

        // =====================================================================
        // SECTION 2: LINKEDHASHSET (Insertion Order)
        // =====================================================================
        System.out.println("\n=== 2. LINKEDHASHSET (Maintains Insertion Order) ===");

        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("First");
        linkedSet.add("Second");
        linkedSet.add("Third");
        linkedSet.add("Fourth");
        linkedSet.add("Second"); // Duplicate — ignored, but order is preserved
        System.out.println("LinkedHashSet: " + linkedSet);
        // Always prints: [First, Second, Third, Fourth]

        // =====================================================================
        // SECTION 3: TREESET (Sorted)
        // =====================================================================
        System.out.println("\n=== 3. TREESET (Sorted) ===");

        /**
         * 💡 TreeSet:
         * - Backed by a TreeMap (red-black tree)
         * - Elements always in SORTED order
         * - O(log n) for add, remove, contains
         * - Does NOT allow null (throws NullPointerException)
         * - Elements must be Comparable or you must provide a Comparator
         */
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(42);
        numbers.add(17);
        numbers.add(85);
        numbers.add(3);
        numbers.add(56);
        System.out.println("TreeSet (auto-sorted): " + numbers);

        // TreeSet-specific methods
        System.out.println("first():   " + numbers.first()); // Smallest
        System.out.println("last():    " + numbers.last()); // Largest
        System.out.println("lower(42): " + numbers.lower(42)); // Greatest element strictly < 42
        System.out.println("higher(42):" + numbers.higher(42)); // Smallest element strictly > 42
        System.out.println("floor(40): " + numbers.floor(40)); // Greatest element ≤ 40
        System.out.println("ceiling(40): " + numbers.ceiling(40)); // Smallest element ≥ 40

        // headSet, tailSet, subSet
        System.out.println("headSet(42):     " + numbers.headSet(42)); // Elements < 42
        System.out.println("tailSet(42):     " + numbers.tailSet(42)); // Elements ≥ 42
        System.out.println("subSet(17, 56):  " + numbers.subSet(17, 56)); // 17 ≤ x < 56

        // TreeSet with custom Comparator
        System.out.println("\n--- TreeSet with Comparator (reverse order) ---");
        TreeSet<String> reverseSet = new TreeSet<>(Comparator.reverseOrder());
        reverseSet.addAll(Arrays.asList("Charlie", "Alice", "Eve", "Bob"));
        System.out.println("Reverse sorted: " + reverseSet);

        // =====================================================================
        // SECTION 4: SET OPERATIONS (Union, Intersection, Difference)
        // =====================================================================
        System.out.println("\n=== 4. SET OPERATIONS ===");

        /**
         * 💡 INTUITION — Set math operations:
         *
         * A = {1, 2, 3, 4, 5} B = {4, 5, 6, 7, 8}
         *
         * UNION (A ∪ B): {1, 2, 3, 4, 5, 6, 7, 8} — everything
         * INTERSECTION (A ∩ B): {4, 5} — shared elements
         * DIFFERENCE (A \ B): {1, 2, 3} — in A but not B
         * SYMMETRIC DIFF (A △ B): {1, 2, 3, 6, 7, 8} — in either but not both
         */

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);

        // Union: addAll
        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("Union (A ∪ B):        " + new TreeSet<>(union));

        // Intersection: retainAll
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Intersection (A ∩ B): " + intersection);

        // Difference: removeAll
        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Difference (A \\ B):   " + difference);

        // Symmetric difference: union minus intersection
        Set<Integer> symmetricDiff = new HashSet<>(union);
        symmetricDiff.removeAll(intersection);
        System.out.println("Symmetric diff (A △ B): " + new TreeSet<>(symmetricDiff));

        // Subset check
        Set<Integer> subset = new HashSet<>(Arrays.asList(2, 3));
        System.out.println("\n{2, 3} is subset of A? " + setA.containsAll(subset));
        System.out.println("A is subset of union?  " + union.containsAll(setA));

        // =====================================================================
        // SECTION 5: PRACTICAL — Remove Duplicates from a List
        // =====================================================================
        System.out.println("\n=== 5. PRACTICAL: REMOVE DUPLICATES ===");

        List<String> withDuplicates = Arrays.asList("A", "B", "C", "A", "B", "D", "C", "E");
        System.out.println("Original list: " + withDuplicates);

        // Method 1: HashSet (order not preserved)
        Set<String> uniqueUnordered = new HashSet<>(withDuplicates);
        System.out.println("Unique (HashSet):       " + uniqueUnordered);

        // Method 2: LinkedHashSet (insertion order preserved)
        Set<String> uniqueOrdered = new LinkedHashSet<>(withDuplicates);
        System.out.println("Unique (LinkedHashSet): " + uniqueOrdered);

        // Convert back to List
        List<String> uniqueList = new ArrayList<>(uniqueOrdered);
        System.out.println("Back to List:           " + uniqueList);

        // =====================================================================
        // SECTION 6: CHOOSING THE RIGHT SET
        // =====================================================================
        /**
         * ╔═════════════════════════════════════════════════════════╗
         * ║ CHOOSING THE RIGHT SET IMPLEMENTATION ║
         * ╠═════════════════════════════════════════════════════════╣
         * ║ Need │ Use │ Why ║
         * ╠═════════════════════════════════════════════════════════╣
         * ║ Fast lookup │ HashSet │ O(1) operations ║
         * ║ Keep order │ LinkedHashSet │ Insertion order ║
         * ║ Sorted │ TreeSet │ Natural/custom order ║
         * ║ Thread-safe │ ConcurrentSkipListSet │ Sorted + safe ║
         * ║ Enum values │ EnumSet │ Bit-vector, fastest ║
         * ╚═════════════════════════════════════════════════════════╝
         */

        System.out.println("\n✅ All demos completed successfully!");
    }
}
