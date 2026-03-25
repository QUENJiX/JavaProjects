package practice.p11_design_patterns;

/**
 * FactoryPatternDemo.java — Factory Pattern: Creating Objects Without Specifying Exact Class
 * ============================================================================================
 * CSE215 - Programming Language II
 *
 * 💡 INTUITION: The Factory pattern is like a restaurant kitchen.
 *    You (the client) say "I want a burger" — you don't go into the kitchen
 *    and cook it yourself. The kitchen (factory) handles the creation details.
 *
 *    Benefits:
 *      - Client doesn't need to know the exact class being created
 *      - Easy to add new types without changing client code
 *      - Centralizes object creation logic
 *
 * Topics covered:
 *   1. Simple Factory (static factory method)
 *   2. Factory Method pattern
 *   3. Real-world example: Shape factory, Document factory
 *
 * 🔗 SEE ALSO: p11_DesignPatterns/SingletonDemo.java
 * 🔗 SEE ALSO: p02_OOP/PolymorphismDemo.java
 */

import java.util.List;

public class FactoryPatternDemo {

    // =====================================================================
    // Product interface and concrete products
    // =====================================================================

    interface Shape {
        void draw();

        double area();
    }

    static class Circle implements Shape {
        private double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public void draw() {
            System.out.println("    Drawing ● Circle (r=" + radius + ")");
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    static class Rectangle implements Shape {
        private double width, height;

        Rectangle(double w, double h) {
            this.width = w;
            this.height = h;
        }

        @Override
        public void draw() {
            System.out.println("    Drawing ■ Rectangle (" + width + "x" + height + ")");
        }

        @Override
        public double area() {
            return width * height;
        }
    }

    static class Triangle implements Shape {
        private double base, height;

        Triangle(double b, double h) {
            this.base = b;
            this.height = h;
        }

        @Override
        public void draw() {
            System.out.println("    Drawing ▲ Triangle (b=" + base + ", h=" + height + ")");
        }

        @Override
        public double area() {
            return 0.5 * base * height;
        }
    }

    // =====================================================================
    // 1. SIMPLE FACTORY (Static Factory Method)
    // =====================================================================

    /**
     * 💡 A simple factory is a single class/method that decides which
     * concrete class to instantiate based on input.
     *
     * This is NOT technically a GoF pattern, but it's the most common
     * and most practical form.
     */
    static class ShapeFactory {

        /**
         * Creates a shape based on the type string.
         *
         * ✅ BENEFIT: Adding a new shape type only requires changes HERE,
         * not in every place that creates shapes.
         */
        public static Shape createShape(String type, double... params) {
            return switch (type.toLowerCase()) {
                case "circle" -> new Circle(params.length > 0 ? params[0] : 1.0);
                case "rectangle" -> new Rectangle(
                        params.length > 0 ? params[0] : 1.0,
                        params.length > 1 ? params[1] : 1.0);
                case "triangle" -> new Triangle(
                        params.length > 0 ? params[0] : 1.0,
                        params.length > 1 ? params[1] : 1.0);
                default -> throw new IllegalArgumentException("Unknown shape: " + type);
            };
        }
    }

    // =====================================================================
    // 2. FACTORY METHOD PATTERN (GoF)
    // =====================================================================

    /**
     * 📌 RULE: The Factory Method pattern defines an interface for creating
     * objects, but lets subclasses decide which class to instantiate.
     *
     * Structure:
     * Creator (abstract) → defines factoryMethod()
     * ├── ConcreteCreatorA → creates ProductA
     * └── ConcreteCreatorB → creates ProductB
     */

    // --- Products ---
    interface Document {
        void open();

        void save();

        String getType();
    }

    static class PDFDocument implements Document {
        @Override
        public void open() {
            System.out.println("    Opening PDF document");
        }

        @Override
        public void save() {
            System.out.println("    Saving as .pdf");
        }

        @Override
        public String getType() {
            return "PDF";
        }
    }

    static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("    Opening Word document");
        }

        @Override
        public void save() {
            System.out.println("    Saving as .docx");
        }

        @Override
        public String getType() {
            return "Word";
        }
    }

    static class SpreadsheetDocument implements Document {
        @Override
        public void open() {
            System.out.println("    Opening Spreadsheet");
        }

        @Override
        public void save() {
            System.out.println("    Saving as .xlsx");
        }

        @Override
        public String getType() {
            return "Spreadsheet";
        }
    }

    // --- Creator (abstract) ---
    static abstract class DocumentCreator {
        // Factory method — subclasses override this
        abstract Document createDocument();

        // Template method that uses the factory method
        void newDocument() {
            Document doc = createDocument(); // Factory method call
            System.out.println("    Created new " + doc.getType() + " document");
            doc.open();
        }
    }

    // --- Concrete Creators ---
    static class PDFCreator extends DocumentCreator {
        @Override
        Document createDocument() {
            return new PDFDocument();
        }
    }

    static class WordCreator extends DocumentCreator {
        @Override
        Document createDocument() {
            return new WordDocument();
        }
    }

    static class SpreadsheetCreator extends DocumentCreator {
        @Override
        Document createDocument() {
            return new SpreadsheetDocument();
        }
    }

    // =====================================================================
    // 3. ENUM-BASED FACTORY (Modern Java approach)
    // =====================================================================

    /**
     * 💡 Using enums with lambdas for a clean factory approach.
     */
    enum NotificationType {
        EMAIL(() -> System.out.println("    📧 Sending email notification")),
        SMS(() -> System.out.println("    📱 Sending SMS notification")),
        PUSH(() -> System.out.println("    🔔 Sending push notification"));

        private final Runnable sender;

        NotificationType(Runnable sender) {
            this.sender = sender;
        }

        public void send() {
            sender.run();
        }
    }

    // =====================================================================
    // MAIN
    // =====================================================================
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   FACTORY PATTERN DEMO                       ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        // 1. Simple Factory
        System.out.println("=== 1. SIMPLE FACTORY ===");
        Shape circle = ShapeFactory.createShape("circle", 5);
        Shape rect = ShapeFactory.createShape("rectangle", 4, 6);
        Shape tri = ShapeFactory.createShape("triangle", 3, 8);

        List<Shape> shapes = List.of(circle, rect, tri);
        for (Shape s : shapes) {
            s.draw();
            System.out.printf("    Area: %.2f%n%n", s.area());
        }

        /**
         * 💡 Notice: The client code doesn't use 'new Circle()', 'new Rectangle()',
         * etc.
         * It only deals with the Shape interface and the ShapeFactory.
         * If we add a new shape (e.g., Pentagon), we only change ShapeFactory.
         */

        // 2. Factory Method
        System.out.println("=== 2. FACTORY METHOD ===");

        // The creator type determines which document is created
        DocumentCreator[] creators = {
                new PDFCreator(),
                new WordCreator(),
                new SpreadsheetCreator()
        };

        for (DocumentCreator creator : creators) {
            creator.newDocument();
            Document doc = creator.createDocument();
            doc.save();
            System.out.println();
        }

        // 3. Enum-based Factory
        System.out.println("=== 3. ENUM FACTORY ===");
        for (NotificationType type : NotificationType.values()) {
            type.send();
        }

        // Using a specific notification
        NotificationType.EMAIL.send();

        System.out.println("\n✅ All demos completed successfully!");
    }
}

/*
 * ╔═══════════════════════════════════════════════════════════════════╗
 * ║ FACTORY PATTERN SUMMARY ║
 * ╠═══════════════════════════════════════════════════════════════════╣
 * ║ Pattern │ When to Use ║
 * ║───────────────────┼──────────────────────────────────────────────║
 * ║ Simple Factory │ Small # of types, centralized creation ║
 * ║ Factory Method │ Subclasses control which objects are created ║
 * ║ Enum Factory │ Fixed set of types, clean modern syntax ║
 * ╠═══════════════════════════════════════════════════════════════════╣
 * ║ 📌 Use when: object creation logic is complex or varies. ║
 * ║ 📌 Benefit: Open/Closed Principle — open for extension, ║
 * ║ closed for modification. ║
 * ╚═══════════════════════════════════════════════════════════════════╝
 */
