package labTasks.lab7task1;

public class Student {
    // 1. Encapsulated fields to private
    private String fullName;
    private String nsuId;
    private double currentGpa;

    // Default Constructor
    public Student() {
        this.fullName = "Unknown";
        this.nsuId = "0000";
        this.currentGpa = 0.0;
    }

    // Parameterized Constructor
    public Student(String givenName, String givenId, double givenGpa) {
        this.fullName = givenName;
        this.nsuId = givenId;
        this.currentGpa = givenGpa;
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNsuId() {
        return nsuId;
    }

    public void setNsuId(String nsuId) {
        this.nsuId = nsuId;
    }

    public double getCurrentGpa() {
        return currentGpa;
    }

    public void setCurrentGpa(double currentGpa) {
        this.currentGpa = currentGpa;
    }

    // Logic Methods
    public void displayStudentInfo() {
        System.out.println("Student Name: " + this.fullName);
        System.out.println("Student ID: " + this.nsuId);
        System.out.println("Student CGPA: " + this.currentGpa);
    }
}
