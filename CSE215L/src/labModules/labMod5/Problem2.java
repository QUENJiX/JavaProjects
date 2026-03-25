package labModules.labMod5;

/* * Problem 2: Consider the UML Class Diagram, where you must implement the Student class and 
 * test the methods.
 * Student
 * - name : String
 * - ID : String
 * - dept : String
 */

class Student {
    private String name;
    private String ID;
    private String dept;

    // Default constructor
    public Student() {
        this.name = "Unknown";
        this.ID = "0000000";
        this.dept = "Undeclared";
    }

    // Parameterized constructor
    public Student(String name, String ID, String dept) {
        this.name = name;
        this.ID = ID;
        this.dept = dept;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.ID;
    }

    public String getDept() {
        return this.dept;
    }

    // Method to print all info
    public void printInfo() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Student ID: " + this.ID);
        System.out.println("Department: " + this.dept);
        System.out.println("---------------------------");
    }
}

public class Problem2 {
    public static void main(String[] args) {
        // Testing default constructor
        Student student1 = new Student();
        System.out.println("Initial Default Student:");
        student1.printInfo();

        // Testing setters
        student1.setName("Alice");
        student1.setID("2410001");
        student1.setDept("ECE");
        System.out.println("Updated Default Student:");
        student1.printInfo();

        // Testing parameterized constructor
        Student student2 = new Student("Bob", "2410002", "CSE");
        System.out.println("Parameterized Student:");
        student2.printInfo();
    }
}