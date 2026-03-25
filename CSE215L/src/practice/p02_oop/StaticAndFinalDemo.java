package practice.p02_oop;

/**
 * StaticAndFinalDemo.java — static & final Keywords: Every Nuance Explained
 * ===========================================================================
 * CSE215 - Programming Language II
 *
 * 💡 INTUITION:
 * static = "belongs to the CLASS, not to any object"
 * Think of it as shared data/behavior — like a class-wide billboard.
 *
 * final = "cannot be changed after initialization"
 * Think of it as writing in permanent ink.
 *
 * Topics covered:
 * 1. static fields (class variables)
 * 2. static methods
 * 3. static blocks (class initialization)
 * 4. static inner classes (preview — see p09_InnerClasses for full demo)
 * 5. final variables (constants)
 * 6. final methods (cannot be overridden)
 * 7. final classes (cannot be extended)
 * 8. final + static = true constants
 * 9. Common mistakes and gotchas
 *
 * 🔗 SEE ALSO: p02_OOP/ClassExample.java,
 * p09_InnerClasses/InnerClassesDemo.java
 */

public class StaticAndFinalDemo {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   STATIC & FINAL KEYWORDS DEMO              ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        // =====================================================================
        // SECTION 1: STATIC FIELDS
        // =====================================================================
        System.out.println("=== 1. STATIC FIELDS ===");

        /**
         * 💡 INTUITION — Static fields are shared by ALL instances.
         *
         * ┌─── Employee Class ────────────────────┐
         * │ static int count = 0 (SHARED) │
         * │ │
         * │ ┌─── emp1 ───┐ ┌─── emp2 ───┐ │
         * │ │ name="Ali" │ │ name="Bob" │ │
         * │ │ (own copy) │ │ (own copy) │ │
         * │ └────────────┘ └────────────┘ │
         * └───────────────────────────────────────┘
         */

        System.out.println("Employees before creation: " + Employee.getCount());

        Employee e1 = new Employee("Alice");
        Employee e2 = new Employee("Bob");
        Employee e3 = new Employee("Charlie");

        System.out.println("Employees after creation: " + Employee.getCount()); // 3
        System.out.println("Created: " + e1.getInfo() + ", " + e2.getInfo() + ", " + e3.getInfo());
        System.out.println("Company: " + Employee.COMPANY_NAME); // Accessed via CLASS name

        // ⚠️ GOTCHA: You CAN access static members via an instance, but DON'T — it's
        // misleading.
        // System.out.println(e1.COMPANY_NAME); // Works but bad practice. Use
        // Employee.COMPANY_NAME

        // =====================================================================
        // SECTION 2: STATIC METHODS
        // =====================================================================
        System.out.println("\n=== 2. STATIC METHODS ===");

        /**
         * 📌 RULE — Static methods:
         * ✅ Can access static fields and other static methods
         * ❌ CANNOT access instance fields/methods directly (no 'this')
         * ❌ CANNOT use 'this' or 'super'
         *
         * 💡 WHY? Because static methods belong to the class, not an object.
         * There's no "this" when there's no object.
         *
         * ✅ BEST PRACTICE: Use static for utility/helper methods that
         * don't depend on object state (like Math.sqrt(), Arrays.sort()).
         */

        // Static method called on CLASS, not on object
        System.out.println("MathUtils.add(3, 4) = " + MathUtils.add(3, 4));
        System.out.println("MathUtils.isEven(7) = " + MathUtils.isEven(7));
        System.out.println("MathUtils.factorial(5) = " + MathUtils.factorial(5));

        // =====================================================================
        // SECTION 3: STATIC BLOCKS (Static Initializers)
        // =====================================================================
        System.out.println("\n=== 3. STATIC BLOCKS ===");

        /**
         * 💡 INTUITION — Static blocks run ONCE when the class is first loaded.
         * Used for complex initialization of static fields.
         * Runs BEFORE any constructor, BEFORE main() if in the main class.
         */

        System.out.println("Config loaded: " + Config.DB_URL);
        System.out.println("Config loaded: " + Config.MAX_CONNECTIONS);
        // Notice: "Static block executed!" prints BEFORE the Config values
        // (check the Config class below)

        // =====================================================================
        // SECTION 4: FINAL VARIABLES
        // =====================================================================
        System.out.println("\n=== 4. FINAL VARIABLES ===");

        /**
         * 📌 RULE — Final variables:
         * - MUST be assigned exactly once
         * - For primitives: value cannot change
         * - For objects: reference cannot change, but object's CONTENTS can!
         *
         * ⚠️ GOTCHA: final does NOT make objects immutable!
         */

        final int MAX_SCORE = 100;
        System.out.println("MAX_SCORE: " + MAX_SCORE);
        // MAX_SCORE = 200; // ❌ COMPILE ERROR: cannot assign to final variable

        // Final with object reference — reference is locked, not the object!
        final int[] finalArray = { 1, 2, 3 };
        finalArray[0] = 999; // ✅ This is OK — modifying contents
        // finalArray = new int[5]; // ❌ COMPILE ERROR — reassigning reference

        System.out.println("finalArray after modification: " + java.util.Arrays.toString(finalArray));

        // Blank final — assigned later (but only once)
        final String greeting;
        boolean morning = true;
        if (morning) {
            greeting = "Good morning!";
        } else {
            greeting = "Good evening!";
        }
        System.out.println(greeting);

        // =====================================================================
        // SECTION 5: FINAL METHODS & FINAL CLASSES
        // =====================================================================
        System.out.println("\n=== 5. FINAL METHODS & CLASSES ===");

        /**
         * final METHOD → cannot be overridden by subclasses
         * final CLASS → cannot be extended at all
         *
         * 💡 WHEN TO USE: │ EXAMPLES IN JAVA:
         * - Prevent breaking base behavior │ String is final (can't extend it)
         * - Security-sensitive code │ Math is final
         * - Performance (JVM can inline them) │ System is final
         */

        SecurityBase base = new SecurityExtended();
        base.doWork(); // Calls overridden version
        base.authenticate(); // Calls final version — CANNOT be overridden

        // =====================================================================
        // SECTION 6: STATIC + FINAL = TRUE CONSTANTS
        // =====================================================================
        System.out.println("\n=== 6. STATIC FINAL CONSTANTS ===");

        /**
         * 📌 RULE — static final = compile-time constant (if value is known at compile
         * time)
         *
         * Convention: UPPER_SNAKE_CASE for constants
         *
         * public static final double PI = 3.14159265358979;
         * public static final int MAX_RETRY = 3;
         */

        System.out.println("PI:        " + Constants.PI);
        System.out.println("GRAVITY:   " + Constants.GRAVITY);
        System.out.println("APP_NAME:  " + Constants.APP_NAME);
        System.out.println("MAX_USERS: " + Constants.MAX_USERS);

        System.out.println("\n✅ All demos completed successfully!");
    }
}

// =========================================================================
// SUPPORTING CLASSES
// =========================================================================

/** Demonstrates static fields, static methods, and constants */
class Employee {
    // Static field — shared across ALL Employee instances
    private static int count = 0;

    // Static final — a class-level constant
    public static final String COMPANY_NAME = "TechCorp";

    // Instance field — each object gets its own copy
    private String name;

    public Employee(String name) {
        this.name = name;
        count++; // Increment the shared counter
    }

    // Static method — can only access static members
    public static int getCount() {
        // return name; // ❌ ERROR: can't access instance field from static method
        return count;
    }

    // Instance method — can access both static and instance members
    public String getInfo() {
        return name + " works at " + COMPANY_NAME; // ✅ instance + static access OK
    }
}

/** Demonstrates static utility methods */
class MathUtils {
    // Private constructor — prevents instantiation of utility class
    // ✅ BEST PRACTICE for utility classes
    private MathUtils() {
        throw new UnsupportedOperationException("Utility class - do not instantiate");
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++)
            result *= i;
        return result;
    }
}

/** Demonstrates static blocks for class initialization */
class Config {
    public static final String DB_URL;
    public static final int MAX_CONNECTIONS;

    // Static block — runs once when class is loaded
    static {
        System.out.println("  [Config] Static block executed — loading configuration...");
        // In real code, this might read from a file or system properties
        DB_URL = "jdbc:mysql://localhost:3306/mydb";
        MAX_CONNECTIONS = 10;
        System.out.println("  [Config] Configuration loaded successfully!");
    }
}

/** Demonstrates final methods */
class SecurityBase {
    // Final method — subclasses CANNOT override this
    public final void authenticate() {
        System.out.println("SecurityBase: Authentication (final — cannot be overridden)");
    }

    // Regular method — CAN be overridden
    public void doWork() {
        System.out.println("SecurityBase: Doing work");
    }
}

class SecurityExtended extends SecurityBase {
    @Override
    public void doWork() {
        System.out.println("SecurityExtended: Doing specialized work");
    }

    // ❌ This would cause a COMPILE ERROR:
    // @Override
    // public void authenticate() { } // Cannot override final method
}

// ❌ This would cause a COMPILE ERROR:
// class ExtendString extends String { } // String is final — cannot extend

/** Demonstrates static final constants */
class Constants {
    public static final double PI = 3.14159265358979;
    public static final double GRAVITY = 9.81; // m/s²
    public static final String APP_NAME = "MyApp";
    public static final int MAX_USERS = 1000;

    private Constants() {
    } // Prevent instantiation
}

/*
 * ╔═══════════════════════════════════════════════════════════════╗
 * ║ QUICK REFERENCE: static vs final vs static final ║
 * ╠═══════════════════════════════════════════════════════════════╣
 * ║ static field/method → shared by class, not per-object ║
 * ║ final variable → assigned once, can't reassign ║
 * ║ final method → can't be overridden in subclass ║
 * ║ final class → can't be extended (no subclasses) ║
 * ║ static final → class-level constant ║
 * ║ static block → runs once when class first loads ║
 * ║ static method → no access to 'this' or instance data ║
 * ╚═══════════════════════════════════════════════════════════════╝
 */
