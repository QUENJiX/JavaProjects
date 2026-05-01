package LabFinal_Demo;

public class Student {
    private String id;
    private String name;
    private int completedCredits;

    public Student() {
        this.id = "000";
        this.name = "Unknown";
        this.completedCredits = 0;
    }

    public Student(String id, String name, int completedCredits) {
        this.id = id;
        this.name = name;
        this.completedCredits = completedCredits;
    }

    public String getName() {
        return name;
    }

    public int getCompletedCredits() {
        return completedCredits;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Completed Credits: " + completedCredits);
    }
}
