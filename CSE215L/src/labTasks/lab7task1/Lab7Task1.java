package labTasks.lab7task1;

public class Lab7Task1 {
    public static void main(String[] args) {
        Student ghostStudent = new Student();
        Student zamilBhai = new Student("Zamil", "2110123442", 3.9);

        // 2. Used setter instead of direct field access
        ghostStudent.setCurrentGpa(3.5);

        System.out.println("--- First Object ---");
        ghostStudent.displayStudentInfo();

        System.out.println("\n--- Second Object ---");
        zamilBhai.displayStudentInfo();
    }
}
