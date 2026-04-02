package practiceModules.student;

public class StudentTest {
    public static void main(String[] args) {
        Student std = new Student("Hasib", "456", "Mathematics");

        std.setName("John Doe");
        std.setID("123");
        std.setDept("Computer Science");

        std.printInfo();
    }
}
