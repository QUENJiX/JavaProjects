package practice.p08_lambdas_streams;

/**
 * MethodReferenceDemo.java — Method References: Shorthand for Lambdas
 * =====================================================================
 * CSE215 - Programming Language II
 *
 * 💡 INTUITION: A method reference is a lambda that JUST calls one existing method.
 *    Instead of writing the plumbing, you point directly to the method.
 *
 *    Lambda:            x -> System.out.println(x)
 *    Method Reference:  System.out::println
 *
 *    The compiler figures out the parameter passing automatically.
 *
 * Four types of method references:
 *   ┌───────────────────────┬──────────────────────────┬─────────────────────────────┐
 *   │ Type                  │ Syntax                   │ Lambda Equivalent           │
 *   ├───────────────────────┼──────────────────────────┼─────────────────────────────┤
 *   │ Static method         │ ClassName::staticMethod  │ (args) -> Class.method(args)│
 *   │ Instance (bound)      │ instance::method         │ (args) -> obj.method(args)  │
 *   │ Instance (unbound)    │ ClassName::method        │ (obj, args) -> obj.method() │
 *   │ Constructor           │ ClassName::new           │ (args) -> new ClassName(args│
 *   └───────────────────────┴──────────────────────────┴─────────────────────────────┘
 *
 * 🔗 SEE ALSO: p08_LambdasAndStreams/LambdaExpressionsDemo.java
 * 🔗 SEE ALSO: p08_LambdasAndStreams/StreamsDemo.java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class MethodReferenceDemo {

        public static void main(String[] args) {
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║   METHOD REFERENCE DEMO                      ║");
                System.out.println("╚══════════════════════════════════════════════╝\n");

                // =====================================================================
                // TYPE 1: STATIC METHOD REFERENCE — ClassName::staticMethod
                // =====================================================================
                System.out.println("=== 1. Static Method Reference ===");

                /**
                 * 💡 When a lambda just calls a static method, use a static method reference.
                 *
                 * Lambda: (s) -> Integer.parseInt(s)
                 * Reference: Integer::parseInt
                 */

                // Instead of: Function<String, Integer> parse = s -> Integer.parseInt(s);
                Function<String, Integer> parse = Integer::parseInt;
                System.out.println("Parsed '42': " + parse.apply("42"));

                // With streams
                List<String> numberStrings = List.of("10", "20", "30", "40");
                List<Integer> numbers = numberStrings.stream()
                                .map(Integer::parseInt) // Static method reference
                                .collect(Collectors.toList());
                System.out.println("Parsed list: " + numbers);

                // Math.abs as a reference
                UnaryOperator<Integer> absolute = Math::abs;
                System.out.println("abs(-7): " + absolute.apply(-7));

                // Custom static method reference
                List<String> names = List.of("alice", "bob", "charlie");
                List<String> capitalized = names.stream()
                                .map(MethodReferenceDemo::capitalize) // Our own static method
                                .collect(Collectors.toList());
                System.out.println("Capitalized: " + capitalized);

                // =====================================================================
                // TYPE 2: BOUND INSTANCE METHOD — instance::method
                // =====================================================================
                System.out.println("\n=== 2. Bound Instance Method Reference ===");

                /**
                 * 💡 "Bound" because the object is already known (bound to a specific
                 * instance).
                 *
                 * String greeting = "Hello";
                 * Lambda: () -> greeting.toUpperCase()
                 * Reference: greeting::toUpperCase
                 *
                 * The instance (greeting) is captured, just like in a lambda closure.
                 */

                String prefix = "LOG: ";
                // Instead of: Function<String, String> logger = msg -> prefix.concat(msg);
                Function<String, String> logger = prefix::concat;
                System.out.println(logger.apply("System started"));
                System.out.println(logger.apply("Processing data"));

                // System.out is a bound instance — System.out::println is the classic example
                List.of("Alpha", "Beta", "Gamma").forEach(System.out::println);

                // Using an instance's method
                String sentence = "the quick brown fox";
                Predicate<String> containsFox = sentence::contains;
                System.out.println("Contains 'fox': " + containsFox.test("fox"));
                System.out.println("Contains 'cat': " + containsFox.test("cat"));

                // =====================================================================
                // TYPE 3: UNBOUND INSTANCE METHOD — ClassName::instanceMethod
                // =====================================================================
                System.out.println("\n=== 3. Unbound Instance Method Reference ===");

                /**
                 * 💡 "Unbound" because no specific object is provided — it comes from the
                 * stream.
                 * The first parameter of the lambda BECOMES the object the method is called on.
                 *
                 * Lambda: (s) -> s.toUpperCase()
                 * Reference: String::toUpperCase
                 *
                 * ⚠️ GOTCHA: This is the trickiest type. The method reference looks like a
                 * static reference (ClassName::method), but it's calling an INSTANCE method.
                 * Java figures out that the stream element IS the instance.
                 */

                // String::toUpperCase — called ON each string in the stream
                List<String> words = List.of("hello", "world", "java");
                List<String> upper = words.stream()
                                .map(String::toUpperCase) // (s) -> s.toUpperCase()
                                .collect(Collectors.toList());
                System.out.println("Upper: " + upper);

                // String::length — the String in the stream is the object
                List<Integer> lengths = words.stream()
                                .map(String::length) // (s) -> s.length()
                                .collect(Collectors.toList());
                System.out.println("Lengths: " + lengths);

                // String::isEmpty — object from stream
                List<String> mixed = List.of("hello", "", "world", "", "java");
                long emptyCount = mixed.stream()
                                .filter(String::isEmpty) // (s) -> s.isEmpty()
                                .count();
                System.out.println("Empty strings: " + emptyCount);

                // Two-parameter example: String::compareTo
                // Lambda: (s1, s2) -> s1.compareTo(s2) → String::compareTo
                List<String> sorted = new ArrayList<>(words);
                sorted.sort(String::compareToIgnoreCase);
                System.out.println("Sorted: " + sorted);

                // =====================================================================
                // TYPE 4: CONSTRUCTOR REFERENCE — ClassName::new
                // =====================================================================
                System.out.println("\n=== 4. Constructor Reference ===");

                /**
                 * 💡 Instead of: (args) -> new ClassName(args)
                 * Write: ClassName::new
                 *
                 * Java picks the right constructor based on the functional interface parameter
                 * types.
                 */

                // Supplier (no-arg constructor)
                Supplier<ArrayList<String>> listMaker = ArrayList::new;
                ArrayList<String> freshList = listMaker.get();
                freshList.add("Created via constructor reference!");
                System.out.println(freshList);

                // Function (one-arg constructor: String → StringBuilder)
                Function<String, StringBuilder> sbMaker = StringBuilder::new;
                StringBuilder sb = sbMaker.apply("Hello");
                sb.append(" World");
                System.out.println("StringBuilder: " + sb);

                // Array constructor reference (special syntax for creating arrays)
                Function<Integer, String[]> arrayMaker = String[]::new;
                String[] arr = arrayMaker.apply(5); // new String[5]
                System.out.println("Array length: " + arr.length);

                // Commonly used with streams toArray
                String[] nameArray = words.stream()
                                .map(String::toUpperCase)
                                .toArray(String[]::new); // Constructor reference for array
                System.out.println("Array: " + Arrays.toString(nameArray));

                // With custom class
                record Point(int x, int y) {
                }
                // Using BiFunction for two-arg constructor
                BiFunction<Integer, Integer, Point> pointMaker = Point::new;
                Point p = pointMaker.apply(3, 7);
                System.out.println("Point: " + p);

                // =====================================================================
                // PRACTICAL COMPARISON: Lambda vs Method Reference
                // =====================================================================
                System.out.println("\n=== 5. Lambda vs Method Reference — When to Use Which ===");

                List<String> data = List.of("banana", "apple", "cherry", "date");

                /**
                 * ✅ USE method reference when it's a simple delegation to one method.
                 * ❌ DON'T use when you need extra logic beyond the method call.
                 */

                // ✅ Direct method call → method reference is cleaner
                data.forEach(System.out::println); // vs. s -> System.out.println(s)
                data.stream().map(String::length); // vs. s -> s.length()
                data.stream().sorted(String::compareTo); // vs. (a, b) -> a.compareTo(b)

                // ❌ Extra logic needed → keep the lambda
                data.stream().map(s -> s.substring(0, 2)); // Can't simplify
                data.stream().filter(s -> s.length() > 4); // Can't simplify
                data.stream().map(s -> "Item: " + s); // Can't simplify

                System.out.println("(See source code for readable vs forced examples)");

                // =====================================================================
                // ADVANCED: Composing with Method References
                // =====================================================================
                System.out.println("\n=== 6. Method References in Composition ===");

                List<Integer> nums = List.of(3, -1, 4, -1, 5, -9, 2, 6);

                // Chain: filter positives → sort → collect
                List<Integer> result = nums.stream()
                                .filter(n -> n > 0) // Lambda (needs condition logic)
                                .sorted(Integer::compareTo) // Method reference
                                .collect(Collectors.toList());
                System.out.println("Positive sorted: " + result);

                // Comparator composition with method references
                List<String> fruits = List.of("Banana", "apple", "Cherry", "date", "elderberry");
                fruits.stream()
                                .sorted(String.CASE_INSENSITIVE_ORDER)
                                .forEach(System.out::println);

                System.out.println("\n✅ All demos completed successfully!");
        }

        // Helper static method used in static method reference demo
        private static String capitalize(String s) {
                if (s == null || s.isEmpty())
                        return s;
                return Character.toUpperCase(s.charAt(0)) + s.substring(1);
        }
}

/*
 * ╔═════════════════════════════════════════════════════════════════╗
 * ║ METHOD REFERENCE QUICK REFERENCE ║
 * ╠═════════════════════════════════════════════════════════════════╣
 * ║ Type │ Syntax │ Example ║
 * ║────────────────┼───────────────────────┼───────────────────────║
 * ║ Static │ ClassName::method │ Integer::parseInt ║
 * ║ Bound │ instance::method │ System.out::println ║
 * ║ Unbound │ ClassName::method │ String::toUpperCase ║
 * ║ Constructor │ ClassName::new │ ArrayList::new ║
 * ║ Array ctor │ Type[]::new │ String[]::new ║
 * ╠═════════════════════════════════════════════════════════════════╣
 * ║ 📌 RULE: Use method ref when lambda ONLY calls one method. ║
 * ║ 📌 RULE: Keep lambda if you need extra logic or parameters. ║
 * ╚═════════════════════════════════════════════════════════════════╝
 */
