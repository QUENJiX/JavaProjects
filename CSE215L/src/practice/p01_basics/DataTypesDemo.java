package practice.p01_basics;

/**
 * DataTypesDemo.java — Primitive Types, Casting, Strings, Arrays, Operators
 * ==========================================================================
 * CSE215 - Programming Language II
 *
 * 💡 INTUITION: Java is STRONGLY TYPED — every variable has a declared type.
 * Primitives live on the STACK (fast), objects live on the HEAP (flexible).
 *
 * Primitive type hierarchy (implicit casting goes →):
 * byte → short → int → long → float → double
 * ↑
 * char
 *
 * Topics covered:
 * 1. All 8 primitive types with exact ranges
 * 2. Type casting (widening vs narrowing)
 * 3. String basics (see StringDeepDiveDemo for more)
 * 4. Array basics (see ArraysDeepDiveDemo for more)
 * 5. All operators (arithmetic, comparison, logical)
 *
 * 🔗 SEE ALSO: p01_Basics/StringDeepDiveDemo.java (deep-dive strings)
 * 🔗 SEE ALSO: p01_Basics/ArraysDeepDiveDemo.java (deep-dive arrays)
 */

public class DataTypesDemo {
    public static void main(String[] args) {
        // === Primitive Data Types ===

        // Integer types
        byte byteVar = 127; // 1 byte: -128 to 127
        short shortVar = 32767; // 2 bytes: -32,768 to 32,767
        int intVar = 2147483647; // 4 bytes: -2^31 to 2^31-1
        long longVar = 9223372036854775807L; // 8 bytes: -2^63 to 2^63-1 (note the L suffix!)

        // Floating-point types
        float floatVar = 3.14159f; // 4 bytes: ~7 decimal digits (note the f suffix!)
        double doubleVar = 3.141592653589793; // 8 bytes: ~15 decimal digits (default for decimals)

        // Character and Boolean
        char charVar = 'A'; // 2 bytes: Unicode character (0 to 65,535)
        boolean boolVar = true; // JVM-dependent size: true or false

        System.out.println("byte: " + byteVar + ", short: " + shortVar + ", int: " + intVar + ", long: " + longVar);
        System.out.println("float: " + floatVar + ", double: " + doubleVar);
        System.out.println("char: " + charVar + ", boolean: " + boolVar);

        /*
         * ⚠️ GOTCHA — Integer overflow wraps around silently!
         * byte b = 127; b++; → b is now -128 (no error thrown)
         *
         * ⚠️ GOTCHA — Floating-point is APPROXIMATE!
         * 0.1 + 0.2 == 0.3 → false! (it's 0.30000000000000004)
         * For money, use BigDecimal instead of double.
         * For example, BigDecimal price = new BigDecimal("0.1").add(new
         * BigDecimal("0.2")); -> Exactly 0.3
         *
         * 📌 RULE: Default integer literal is int, default decimal is double.
         * Must suffix L for long literals, f for float literals.
         * For example, long bigNum = 1234567890123L; float piApprox = 3.14f;
         */
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2) + " (not exactly 0.3!)");

        // === Type Casting ===

        // Implicit casting (widening): smaller → larger
        int myInt = 100;
        double myDouble = myInt; // int to double automatically -> 100.0
        System.out.println("Implicit cast (int → double): " + myDouble);

        // Explicit casting (narrowing): larger → smaller
        double pi = 3.14159;
        int truncatedPi = (int) pi; // Must cast explicitly, loses decimal -> 3
        System.out.println("Explicit cast (double → int): " + truncatedPi);

        // === String Operations ===

        String greeting = "Hello";
        String name = "World";

        // Concatenation
        String message = greeting + ", " + name + "!";
        System.out.println(message); // Output: Hello, World!

        // String methods
        System.out.println("Length: " + message.length()); // 13
        System.out.println("Uppercase: " + message.toUpperCase()); // HELLO, WORLD!
        System.out.println("Lowercase: " + message.toLowerCase()); // hello, world!
        System.out.println("Substring: " + message.substring(0, 5)); // Hello
        System.out.println("Contains 'World': " + message.contains("World")); // true

        // === Arrays ===

        // Array declaration and initialization
        int[] numbers = { 10, 20, 30, 40, 50 };
        String[] days = new String[7];
        days[0] = "Monday";
        days[1] = "Tuesday";

        // Array iteration
        System.out.println("\nArray elements:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("  numbers[" + i + "] = " + numbers[i]);
        }

        // Enhanced for loop (for-each)
        System.out.println("\nUsing for-each:");
        for (int num : numbers) {
            System.out.println("  Value: " + num);
        }

        // === Operators ===

        int a = 10, b = 3;
        System.out.println("\n=== Arithmetic Operators ===");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b)); // Integer division
        System.out.println("a % b = " + (a % b)); // Modulus (remainder)

        System.out.println("\n=== Comparison Operators ===");
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a >= b: " + (a >= b));

        System.out.println("\n=== Logical Operators ===");
        boolean x = true, y = false;
        System.out.println("x && y: " + (x && y)); // AND (short-circuit: if x is false, y is NOT evaluated)
        System.out.println("x || y: " + (x || y)); // OR (short-circuit: if x is true, y is NOT evaluated)
        System.out.println("!x: " + (!x)); // NOT

        /*
         * ⚠️ GOTCHA — Short-circuit evaluation:
         * && stops at first false, || stops at first true.
         * This matters when the right side has side effects:
         * if (obj != null && obj.getValue() > 0) // Safe! Won't call getValue() if null
         */

        // === Wrapper Classes (Autoboxing) ===
        System.out.println("\n=== Wrapper Classes ===");
        Integer wrappedInt = 42; // Autoboxing: int → Integer
        int unwrapped = wrappedInt; // Unboxing: Integer → int
        System.out.println("Wrapped: " + wrappedInt + ", Unwrapped: " + unwrapped);

        /*
         * 📌 RULE: Each primitive has a wrapper class:
         * int→Integer, double→Double, char→Character, boolean→Boolean, etc.
         * Needed for: Collections (ArrayList<Integer>), null values, utility methods.
         *
         * ⚠️ GOTCHA: == on wrapper objects compares REFERENCES, not values!
         * Integer a2 = 128; Integer b2 = 128; a2 == b2 → false! Use .equals()
         * (Integer caches -128 to 127, so small values may work with ==, but don't rely
         * on it)
         */
    }
}

/*
 * ╔═══════════════════════════════════════════════════════════╗
 * ║ PRIMITIVE TYPES REFERENCE ║
 * ╠═══════════════════════════════════════════════════════════╣
 * ║ Type │ Size │ Range │ Default ║
 * ║──────────┼─────────┼─────────────────────────┼───────────║
 * ║ byte │ 1 byte │ -128 to 127 │ 0 ║
 * ║ short │ 2 bytes │ -32,768 to 32,767 │ 0 ║
 * ║ int │ 4 bytes │ ~±2.1 billion │ 0 ║
 * ║ long │ 8 bytes │ ~±9.2 quintillion │ 0L ║
 * ║ float │ 4 bytes │ ~7 decimal digits │ 0.0f ║
 * ║ double │ 8 bytes │ ~15 decimal digits │ 0.0 ║
 * ║ char │ 2 bytes │ 0 to 65,535 (Unicode) │ '\u0000' ║
 * ║ boolean │ JVM │ true / false │ false ║
 * ╚═══════════════════════════════════════════════════════════╝
 */
