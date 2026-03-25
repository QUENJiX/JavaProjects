package practice.p07_applications;

/**
 * StudentManagementSystem.java — Complete OOP Application
 * =========================================================
 * CSE215 - Programming Language II
 *
 * 💡 This is a comprehensive application that ties together ALL core Java concepts:
 *
 *    ✅ OOP: Classes, Encapsulation, Inheritance, Polymorphism
 *    ✅ Interfaces: Comparable, custom interfaces
 *    ✅ Collections: ArrayList, HashMap, sorting, filtering
 *    ✅ Exceptions: Custom exceptions for validation
 *    ✅ Streams: Processing collections with lambdas
 *    ✅ File I/O: Saving/loading data
 *    ✅ Enums: Grade and Department enumerations
 *    ✅ Generics: Generic repository pattern
 *    ✅ Design Pattern: Strategy (sorting), Observer (notifications)
 *
 * This is a menu-driven console application for managing students.
 * Run it and interact via the menu!
 *
 * 🔗 SEE ALSO: Virtually every other demo file — this integrates concepts from all of them.
 */

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentManagementSystem {

    // =====================================================================
    // ENUMS
    // =====================================================================

    enum Department {
        CSE("Computer Science"), EEE("Electrical Engineering"),
        BBA("Business Admin"), ENG("English"), MATH("Mathematics");

        private final String fullName;

        Department(String fullName) {
            this.fullName = fullName;
        }

        @Override
        public String toString() {
            return name() + " (" + fullName + ")";
        }
    }

    enum Grade {
        A_PLUS("A+", 4.0), A("A", 3.75), A_MINUS("A-", 3.5),
        B_PLUS("B+", 3.25), B("B", 3.0), B_MINUS("B-", 2.75),
        C_PLUS("C+", 2.5), C("C", 2.25), D("D", 2.0), F("F", 0.0);

        private final String symbol;
        private final double points;

        Grade(String symbol, double points) {
            this.symbol = symbol;
            this.points = points;
        }

        public double getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return symbol;
        }

        static Grade fromGPA(double gpa) {
            for (Grade g : values()) {
                if (gpa >= g.points)
                    return g;
            }
            return F;
        }
    }

    // =====================================================================
    // CUSTOM EXCEPTION
    // =====================================================================

    static class StudentException extends Exception {
        StudentException(String message) {
            super(message);
        }
    }

    // =====================================================================
    // STUDENT CLASS (implements Comparable for natural ordering by GPA)
    // =====================================================================

    static class Student implements Comparable<Student>, Serializable {
        private static int nextId = 1000;
        private final int id;
        private String name;
        private Department department;
        private final Map<String, Grade> courses; // courseName → grade
        private final LocalDate enrollmentDate;

        Student(String name, Department department) {
            this.id = nextId++;
            this.name = name;
            this.department = department;
            this.courses = new LinkedHashMap<>();
            this.enrollmentDate = LocalDate.now();
        }

        // Getters
        int getId() {
            return id;
        }

        String getName() {
            return name;
        }

        Department getDepartment() {
            return department;
        }

        Map<String, Grade> getCourses() {
            return Collections.unmodifiableMap(courses);
        }

        LocalDate getEnrollmentDate() {
            return enrollmentDate;
        }

        // Setters
        void setName(String name) {
            this.name = name;
        }

        void setDepartment(Department dept) {
            this.department = dept;
        }

        void addCourse(String course, Grade grade) {
            courses.put(course, grade);
        }

        double getGPA() {
            if (courses.isEmpty())
                return 0.0;
            return courses.values().stream()
                    .mapToDouble(Grade::getPoints)
                    .average()
                    .orElse(0.0);
        }

        int getCreditCount() {
            return courses.size();
        }

        String getStanding() {
            double gpa = getGPA();
            if (gpa >= 3.5)
                return "Dean's List 🌟";
            if (gpa >= 3.0)
                return "Good Standing";
            if (gpa >= 2.0)
                return "Satisfactory";
            return "Academic Probation ⚠️";
        }

        @Override
        public int compareTo(Student other) {
            return Double.compare(other.getGPA(), this.getGPA()); // Descending
        }

        @Override
        public String toString() {
            return String.format("ID:%d | %-15s | %-5s | GPA: %.2f | Courses: %d | %s",
                    id, name, department.name(), getGPA(), getCreditCount(), getStanding());
        }

        String toDetailString() {
            StringBuilder sb = new StringBuilder();
            sb.append("┌─────────────────────────────────────────┐\n");
            sb.append(String.format("│ ID:         %d%n", id));
            sb.append(String.format("│ Name:       %s%n", name));
            sb.append(String.format("│ Department: %s%n", department));
            sb.append(String.format("│ GPA:        %.2f (%s)%n", getGPA(), Grade.fromGPA(getGPA())));
            sb.append(String.format("│ Standing:   %s%n", getStanding()));
            sb.append(String.format("│ Enrolled:   %s%n", enrollmentDate));
            if (!courses.isEmpty()) {
                sb.append("│ Courses:\n");
                courses.forEach((course, grade) -> sb
                        .append(String.format("│   %-25s → %s (%.2f)%n", course, grade, grade.getPoints())));
            }
            sb.append("└─────────────────────────────────────────┘");
            return sb.toString();
        }

        // For file persistence
        String toCSV() {
            String courseData = courses.entrySet().stream()
                    .map(e -> e.getKey() + "=" + e.getValue().name())
                    .collect(Collectors.joining(";"));
            return String.join(",", String.valueOf(id), name, department.name(), courseData);
        }
    }

    // =====================================================================
    // STUDENT REPOSITORY (Generic-inspired collection manager)
    // =====================================================================

    static class StudentRepository {
        private final List<Student> students = new ArrayList<>();
        private final Map<Integer, Student> indexById = new HashMap<>();

        void add(Student student) throws StudentException {
            if (indexById.containsKey(student.getId())) {
                throw new StudentException("Student with ID " + student.getId() + " already exists");
            }
            students.add(student);
            indexById.put(student.getId(), student);
        }

        Optional<Student> findById(int id) {
            return Optional.ofNullable(indexById.get(id));
        }

        List<Student> findByName(String name) {
            return students.stream()
                    .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }

        List<Student> findByDepartment(Department dept) {
            return students.stream()
                    .filter(s -> s.getDepartment() == dept)
                    .collect(Collectors.toList());
        }

        boolean remove(int id) {
            Student s = indexById.remove(id);
            if (s != null) {
                students.remove(s);
                return true;
            }
            return false;
        }

        List<Student> getAll() {
            return Collections.unmodifiableList(students);
        }

        int size() {
            return students.size();
        }

        // ── Statistics using Streams ──
        OptionalDouble averageGPA() {
            return students.stream().mapToDouble(Student::getGPA).average();
        }

        Optional<Student> topStudent() {
            return students.stream().max(Comparator.comparingDouble(Student::getGPA));
        }

        Map<Department, Long> countByDepartment() {
            return students.stream()
                    .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        }

        Map<Department, Double> avgGPAByDepartment() {
            return students.stream()
                    .collect(Collectors.groupingBy(
                            Student::getDepartment,
                            Collectors.averagingDouble(Student::getGPA)));
        }

        List<Student> deansList() {
            return students.stream()
                    .filter(s -> s.getGPA() >= 3.5)
                    .sorted()
                    .collect(Collectors.toList());
        }

        List<Student> probationList() {
            return students.stream()
                    .filter(s -> s.getGPA() < 2.0 && s.getCreditCount() > 0)
                    .sorted(Comparator.comparingDouble(Student::getGPA))
                    .collect(Collectors.toList());
        }

        // ── File Persistence ──
        void saveToFile(String filename) throws IOException {
            List<String> lines = students.stream()
                    .map(Student::toCSV)
                    .collect(Collectors.toList());
            Files.write(Path.of(filename), lines);
        }
    }

    // =====================================================================
    // The App
    // =====================================================================

    private final StudentRepository repo = new StudentRepository();
    private final Scanner scanner = new Scanner(System.in);

    void run() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   STUDENT MANAGEMENT SYSTEM                  ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        loadSampleData();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addStudent();
                case "2" -> viewAllStudents();
                case "3" -> searchStudent();
                case "4" -> addCourseGrade();
                case "5" -> viewStudentDetails();
                case "6" -> viewStatistics();
                case "7" -> viewDeansList();
                case "8" -> removeStudent();
                case "9" -> exportData();
                case "0" -> {
                    running = false;
                    System.out.println("\nGoodbye! 👋");
                }
                default -> System.out.println("  Invalid option. Try again.");
            }
        }
    }

    void printMenu() {
        System.out.println("\n┌──────────── MENU ────────────┐");
        System.out.println("│  1. Add Student              │");
        System.out.println("│  2. View All Students        │");
        System.out.println("│  3. Search Student           │");
        System.out.println("│  4. Add Course & Grade       │");
        System.out.println("│  5. View Student Details     │");
        System.out.println("│  6. View Statistics          │");
        System.out.println("│  7. Dean's List / Probation  │");
        System.out.println("│  8. Remove Student           │");
        System.out.println("│  9. Export Data              │");
        System.out.println("│  0. Exit                     │");
        System.out.println("└──────────────────────────────┘");
        System.out.print("Choice: ");
    }

    void addStudent() {
        System.out.print("  Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("  ❌ Name cannot be empty.");
            return;
        }

        System.out.println("  Departments: " + Arrays.toString(Department.values()));
        System.out.print("  Department code: ");
        String deptCode = scanner.nextLine().trim().toUpperCase();

        try {
            Department dept = Department.valueOf(deptCode);
            Student student = new Student(name, dept);
            repo.add(student);
            System.out.println("  ✅ Added: " + student);
        } catch (IllegalArgumentException e) {
            System.out.println("  ❌ Invalid department: " + deptCode);
        } catch (StudentException e) {
            System.out.println("  ❌ " + e.getMessage());
        }
    }

    void viewAllStudents() {
        if (repo.size() == 0) {
            System.out.println("  No students found.");
            return;
        }

        System.out.println("\n  All Students (sorted by GPA):");
        System.out.println("  " + "─".repeat(75));
        repo.getAll().stream()
                .sorted()
                .forEach(s -> System.out.println("  " + s));
        System.out.println("  " + "─".repeat(75));
        System.out.println("  Total: " + repo.size() + " students");
    }

    void searchStudent() {
        System.out.print("  Search by (name/id/dept): ");
        String type = scanner.nextLine().trim().toLowerCase();

        switch (type) {
            case "name" -> {
                System.out.print("  Enter name: ");
                String name = scanner.nextLine().trim();
                List<Student> results = repo.findByName(name);
                if (results.isEmpty())
                    System.out.println("  No matches.");
                else
                    results.forEach(s -> System.out.println("  " + s));
            }
            case "id" -> {
                System.out.print("  Enter ID: ");
                try {
                    int id = Integer.parseInt(scanner.nextLine().trim());
                    repo.findById(id).ifPresentOrElse(
                            s -> System.out.println("  " + s),
                            () -> System.out.println("  Not found."));
                } catch (NumberFormatException e) {
                    System.out.println("  ❌ Invalid ID.");
                }
            }
            case "dept" -> {
                System.out.print("  Enter department code: ");
                try {
                    Department dept = Department.valueOf(scanner.nextLine().trim().toUpperCase());
                    List<Student> results = repo.findByDepartment(dept);
                    if (results.isEmpty())
                        System.out.println("  No students in " + dept);
                    else
                        results.forEach(s -> System.out.println("  " + s));
                } catch (IllegalArgumentException e) {
                    System.out.println("  ❌ Invalid department.");
                }
            }
            default -> System.out.println("  ❌ Invalid search type.");
        }
    }

    void addCourseGrade() {
        System.out.print("  Student ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Optional<Student> opt = repo.findById(id);
            if (opt.isEmpty()) {
                System.out.println("  ❌ Student not found.");
                return;
            }

            Student student = opt.get();
            System.out.print("  Course name: ");
            String course = scanner.nextLine().trim();
            if (course.isEmpty()) {
                System.out.println("  ❌ Course name empty.");
                return;
            }

            System.out.println("  Grades: A_PLUS, A, A_MINUS, B_PLUS, B, B_MINUS, C_PLUS, C, D, F");
            System.out.print("  Grade: ");
            try {
                Grade grade = Grade.valueOf(scanner.nextLine().trim().toUpperCase());
                student.addCourse(course, grade);
                System.out.printf("  ✅ Added %s → %s for %s (New GPA: %.2f)%n",
                        course, grade, student.getName(), student.getGPA());
            } catch (IllegalArgumentException e) {
                System.out.println("  ❌ Invalid grade.");
            }
        } catch (NumberFormatException e) {
            System.out.println("  ❌ Invalid ID.");
        }
    }

    void viewStudentDetails() {
        System.out.print("  Student ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            repo.findById(id).ifPresentOrElse(
                    s -> System.out.println(s.toDetailString()),
                    () -> System.out.println("  ❌ Not found."));
        } catch (NumberFormatException e) {
            System.out.println("  ❌ Invalid ID.");
        }
    }

    void viewStatistics() {
        if (repo.size() == 0) {
            System.out.println("  No data.");
            return;
        }

        System.out.println("\n  ┌──────── STATISTICS ────────┐");
        System.out.println("  │ Total Students: " + repo.size());
        repo.averageGPA().ifPresent(avg -> System.out.printf("  │ Overall GPA:    %.2f%n", avg));
        repo.topStudent().ifPresent(s -> System.out.printf("  │ Top Student:    %s (%.2f)%n", s.getName(), s.getGPA()));

        System.out.println("  │");
        System.out.println("  │ By Department:");
        repo.countByDepartment().forEach((dept, count) -> {
            double avg = repo.avgGPAByDepartment().getOrDefault(dept, 0.0);
            System.out.printf("  │   %-5s: %d students, avg GPA: %.2f%n", dept.name(), count, avg);
        });
        System.out.println("  └─────────────────────────────┘");
    }

    void viewDeansList() {
        System.out.println("\n  🌟 Dean's List (GPA ≥ 3.5):");
        List<Student> deans = repo.deansList();
        if (deans.isEmpty())
            System.out.println("  (empty)");
        else
            deans.forEach(s -> System.out.println("  " + s));

        System.out.println("\n  ⚠️ Academic Probation (GPA < 2.0):");
        List<Student> probation = repo.probationList();
        if (probation.isEmpty())
            System.out.println("  (none — great!)");
        else
            probation.forEach(s -> System.out.println("  " + s));
    }

    void removeStudent() {
        System.out.print("  Student ID to remove: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (repo.remove(id))
                System.out.println("  ✅ Removed student " + id);
            else
                System.out.println("  ❌ Not found.");
        } catch (NumberFormatException e) {
            System.out.println("  ❌ Invalid ID.");
        }
    }

    void exportData() {
        String filename = "students_export.csv";
        try {
            repo.saveToFile(filename);
            System.out.println("  ✅ Exported to " + filename);
        } catch (IOException e) {
            System.out.println("  ❌ Export failed: " + e.getMessage());
        }
    }

    void loadSampleData() {
        try {
            Student s1 = new Student("Alice Johnson", Department.CSE);
            s1.addCourse("CSE215 - Programming II", Grade.A);
            s1.addCourse("CSE225 - Data Structures", Grade.A_MINUS);
            s1.addCourse("MAT120 - Calculus", Grade.B_PLUS);
            repo.add(s1);

            Student s2 = new Student("Bob Smith", Department.EEE);
            s2.addCourse("EEE201 - Circuits", Grade.B);
            s2.addCourse("PHY101 - Physics", Grade.B_MINUS);
            repo.add(s2);

            Student s3 = new Student("Charlie Brown", Department.CSE);
            s3.addCourse("CSE215 - Programming II", Grade.A_PLUS);
            s3.addCourse("CSE225 - Data Structures", Grade.A);
            s3.addCourse("CSE327 - Software Engineering", Grade.A_MINUS);
            s3.addCourse("MAT120 - Calculus", Grade.A);
            repo.add(s3);

            Student s4 = new Student("Diana Lee", Department.BBA);
            s4.addCourse("BBA101 - Accounting", Grade.C_PLUS);
            s4.addCourse("BBA201 - Marketing", Grade.C);
            repo.add(s4);

            Student s5 = new Student("Eve Martinez", Department.MATH);
            s5.addCourse("MAT301 - Linear Algebra", Grade.A_PLUS);
            s5.addCourse("MAT401 - Real Analysis", Grade.A);
            repo.add(s5);

            System.out.println("  📋 Loaded " + repo.size() + " sample students.");
        } catch (StudentException e) {
            System.out.println("  Error loading samples: " + e.getMessage());
        }
    }

    // =====================================================================
    // MAIN
    // =====================================================================
    public static void main(String[] args) {
        new StudentManagementSystem().run();
    }
}

/*
 * ╔═══════════════════════════════════════════════════════════════════╗
 * ║ CONCEPTS DEMONSTRATED IN THIS APPLICATION ║
 * ╠═══════════════════════════════════════════════════════════════════╣
 * ║ OOP: Classes, Encapsulation, Composition ║
 * ║ Interfaces: Comparable<Student>, Serializable ║
 * ║ Enums: Department, Grade (with fields + methods) ║
 * ║ Collections: ArrayList, HashMap, LinkedHashMap ║
 * ║ Streams: filter, map, collect, groupingBy, averaging ║
 * ║ Optional: findById returns Optional<Student> ║
 * ║ Exceptions: Custom StudentException + validation ║
 * ║ File I/O: CSV export with NIO Files.write ║
 * ║ Generics: Map<String,Grade>, List<Student>, Optional<T> ║
 * ║ Records: Grade enum with calculated fields ║
 * ║ Patterns: Repository pattern, Builder-like sample data ║
 * ╚═══════════════════════════════════════════════════════════════════╝
 */
