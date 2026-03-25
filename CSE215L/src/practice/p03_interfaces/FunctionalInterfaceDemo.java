package practice.p03_interfaces;

/**
 * FunctionalInterfaceDemo.java — Functional Interfaces & Built-in Ones
 * =====================================================================
 * CSE215 - Programming Language II
 *
 * 💡 INTUITION: A functional interface has EXACTLY ONE abstract method.
 *    This makes it the perfect target for a LAMBDA expression.
 *
 *    Lambda: (parameters) -> { body }
 *    It's essentially an anonymous implementation of that single method.
 *
 *    Old way:  new Comparator<String>() { public int compare(String a, String b) { return a.compareTo(b); } }
 *    Lambda:   (a, b) -> a.compareTo(b)
 *
 * Topics covered:
 *   1. What makes an interface "functional"
 *   2. @FunctionalInterface annotation
 *   3. Built-in functional interfaces (Predicate, Function, Consumer, Supplier, BiFunction)
 *   4. Composing functional interfaces (chaining)
 *   5. Custom functional interfaces
 *
 * 🔗 SEE ALSO: p08_LambdasAndStreams/LambdaExpressionsDemo.java for lambdas in depth
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceDemo {

    // =========================================================================
    // SECTION 1: CUSTOM FUNCTIONAL INTERFACE
    // =========================================================================

    /**
     * @FunctionalInterface annotation:
     *                      - OPTIONAL but recommended
     *                      - Causes a compile error if the interface has more than
     *                      one abstract method
     *                      - Documents the intent: "This is designed for lambdas"
     *
     *                      📌 RULE: Default and static methods don't count — only
     *                      abstract methods matter.
     */
    @FunctionalInterface
    interface MathOperation {
        double operate(double a, double b);

        // ✅ Default methods are fine — they have a body
        default void printDescription() {
            System.out.println("  A math operation on two numbers");
        }
    }

    @FunctionalInterface
    interface StringProcessor {
        String process(String input);
    }

    // =========================================================================
    // MAIN
    // =========================================================================

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   FUNCTIONAL INTERFACE DEMO                  ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        // =====================================================================
        // SECTION 1: CUSTOM FUNCTIONAL INTERFACE WITH LAMBDAS
        // =====================================================================
        System.out.println("=== 1. CUSTOM FUNCTIONAL INTERFACE ===");

        // Lambda expressions implementing MathOperation
        MathOperation add = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> b != 0 ? a / b : Double.NaN;

        System.out.println("10 + 3 = " + add.operate(10, 3));
        System.out.println("10 - 3 = " + subtract.operate(10, 3));
        System.out.println("10 * 3 = " + multiply.operate(10, 3));
        System.out.println("10 / 3 = " + String.format("%.2f", divide.operate(10, 3)));

        // Passing lambda as a method argument
        System.out.println("\nPassing lambdas as arguments:");
        printResult("Addition", 5, 3, add);
        printResult("Multiplication", 5, 3, multiply);

        // =====================================================================
        // SECTION 2: BUILT-IN FUNCTIONAL INTERFACES (java.util.function)
        // =====================================================================
        System.out.println("\n=== 2. BUILT-IN FUNCTIONAL INTERFACES ===");

        /**
         * 💡 THE BIG FOUR you'll use 90% of the time:
         *
         * Predicate<T> T → boolean "Test something" filter, validate
         * Function<T,R> T → R "Transform" map, convert
         * Consumer<T> T → void "Do something" forEach, logging
         * Supplier<T> () → T "Produce something" factory, lazy init
         *
         * And their multi-argument variants:
         * BiPredicate<T,U> (T, U) → boolean
         * BiFunction<T,U,R> (T, U) → R
         * BiConsumer<T,U> (T, U) → void
         *
         * Specialized for primitives (avoid autoboxing):
         * IntPredicate, LongPredicate, DoublePredicate
         * IntFunction<R>, IntConsumer, IntSupplier
         * IntUnaryOperator, IntBinaryOperator
         */

        // --- Predicate<T>: T → boolean ---
        System.out.println("\n--- Predicate<T>: test something ---");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<String> isLong = s -> s.length() > 5;

        System.out.println("isEven(4):      " + isEven.test(4));
        System.out.println("isEven(7):      " + isEven.test(7));
        System.out.println("isLong(\"Hi\"):   " + isLong.test("Hi"));
        System.out.println("isLong(\"Hello World\"): " + isLong.test("Hello World"));

        // Predicate composition: and(), or(), negate()
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println("isEvenAndPositive(-4): " + isEvenAndPositive.test(-4));
        System.out.println("isOdd(7):              " + isOdd.test(7));

        // Practical: filtering a list
        List<Integer> numbers = Arrays.asList(1, -2, 3, -4, 5, 6, -7, 8);
        System.out.println("\nFiltered (even & positive): " + filter(numbers, isEvenAndPositive));

        // --- Function<T, R>: T → R ---
        System.out.println("\n--- Function<T, R>: transform ---");
        Function<String, Integer> strLength = String::length;
        Function<Integer, String> intToString = n -> "Number: " + n;
        Function<String, String> toUpper = String::toUpperCase;

        System.out.println("strLength(\"Hello\"): " + strLength.apply("Hello"));
        System.out.println("intToString(42): " + intToString.apply(42));

        // Function composition: andThen(), compose()
        Function<String, String> upperThenExclaim = toUpper.andThen(s -> s + "!");
        System.out.println("upperThenExclaim(\"hello\"): " + upperThenExclaim.apply("hello"));

        // compose: applies the argument function FIRST, then this one
        Function<Integer, Integer> doubleIt = n -> n * 2;
        Function<Integer, Integer> addTen = n -> n + 10;
        Function<Integer, Integer> doubleThenAdd = addTen.compose(doubleIt); // doubleIt first, then addTen
        Function<Integer, Integer> addThenDouble = addTen.andThen(doubleIt); // addTen first, then doubleIt
        System.out.println("doubleThenAdd(5): " + doubleThenAdd.apply(5)); // (5*2)+10 = 20
        System.out.println("addThenDouble(5): " + addThenDouble.apply(5)); // (5+10)*2 = 30

        // --- Consumer<T>: T → void ---
        System.out.println("\n--- Consumer<T>: do something ---");
        Consumer<String> printer = s -> System.out.println("  >> " + s);
        Consumer<String> yeller = s -> System.out.println("  >> " + s.toUpperCase() + "!!!");

        printer.accept("Hello");
        yeller.accept("Hello");

        // Consumer chaining with andThen
        Consumer<String> printThenYell = printer.andThen(yeller);
        printThenYell.accept("Wow");

        // --- Supplier<T>: () → T ---
        System.out.println("\n--- Supplier<T>: produce something ---");
        Supplier<Double> randomSupplier = Math::random;
        Supplier<String> greetingSupplier = () -> "Hello, World!";
        Supplier<List<String>> listFactory = ArrayList::new;

        System.out.println("Random: " + randomSupplier.get());
        System.out.println("Greeting: " + greetingSupplier.get());
        System.out.println("New list: " + listFactory.get());

        // --- BiFunction<T, U, R>: (T, U) → R ---
        System.out.println("\n--- BiFunction: two inputs, one output ---");
        BiFunction<String, Integer, String> repeat = (s, n) -> s.repeat(n);
        BiFunction<Integer, Integer, Integer> max = Math::max;

        System.out.println("repeat(\"Ha\", 3): " + repeat.apply("Ha", 3));
        System.out.println("max(10, 20):      " + max.apply(10, 20));

        // --- UnaryOperator<T>: T → T (special case of Function where input and output
        // type are same) ---
        System.out.println("\n--- UnaryOperator<T>: same type in and out ---");
        UnaryOperator<String> exclaim = s -> s + "!";
        UnaryOperator<Integer> square = n -> n * n;

        System.out.println("exclaim(\"Hello\"): " + exclaim.apply("Hello"));
        System.out.println("square(5):         " + square.apply(5));

        // --- BinaryOperator<T>: (T, T) → T ---
        System.out.println("\n--- BinaryOperator<T>: two same-type inputs ---");
        BinaryOperator<Integer> sum = Integer::sum;
        BinaryOperator<String> concat = String::concat;

        System.out.println("sum(3, 4):             " + sum.apply(3, 4));
        System.out.println("concat(\"Hello\", \"!\"): " + concat.apply("Hello", "!"));

        // =====================================================================
        // SECTION 3: PRACTICAL PATTERN — Strategy via Functional Interfaces
        // =====================================================================
        System.out.println("\n=== 3. PRACTICAL: STRATEGY PATTERN ===");

        StringProcessor trimmer = String::trim;
        StringProcessor upper = String::toUpperCase;
        StringProcessor removeSpaces = s -> s.replaceAll("\\s+", "");

        String input = "  Hello World  ";
        System.out.println("Original:      \"" + input + "\"");
        System.out.println("Trimmed:       \"" + trimmer.process(input) + "\"");
        System.out.println("Uppercased:    \"" + upper.process(input) + "\"");
        System.out.println("No spaces:     \"" + removeSpaces.process(input) + "\"");

        System.out.println("\n✅ All demos completed successfully!");
    }

    // =========================================================================
    // HELPER METHODS
    // =========================================================================

    /** Demonstrates passing a functional interface as a parameter */
    private static void printResult(String label, double a, double b, MathOperation op) {
        System.out.printf("  %s: %.0f op %.0f = %.2f%n", label, a, b, op.operate(a, b));
    }

    /** Generic filter method using Predicate */
    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}

/*
 * ╔════════════════════════════════════════════════════════════════════╗
 * ║ FUNCTIONAL INTERFACE CHEAT SHEET ║
 * ╠════════════════════════════════════════════════════════════════════╣
 * ║ Interface │ Method │ Signature │ Use Case ║
 * ╠════════════════════════════════════════════════════════════════════╣
 * ║ Predicate<T> │ test(T) │ T → boolean │ filter ║
 * ║ Function<T,R> │ apply(T) │ T → R │ transform ║
 * ║ Consumer<T> │ accept(T) │ T → void │ forEach ║
 * ║ Supplier<T> │ get() │ () → T │ factory ║
 * ║ UnaryOperator<T> │ apply(T) │ T → T │ modify ║
 * ║ BinaryOperator<T> │ apply(T,T) │ (T,T) → T │ reduce ║
 * ║ BiFunction<T,U,R> │ apply(T,U) │ (T,U) → R │ combine ║
 * ║ BiPredicate<T,U> │ test(T,U) │ (T,U) → bool │ compare ║
 * ║ BiConsumer<T,U> │ accept(T,U) │ (T,U) → void │ Map.forEach ║
 * ╚════════════════════════════════════════════════════════════════════╝
 */
