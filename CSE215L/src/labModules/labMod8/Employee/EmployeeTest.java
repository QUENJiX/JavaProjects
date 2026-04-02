package labModules.labMod8.Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("--- Testing Employee ---");
        Employee emp = new Employee("John Doe", 50000);
        emp.displayInfo();
        System.out.println("Bonus (10%): " + emp.calculateBonus(0.10));

        System.out.println("\n--- Testing Manager ---");
        Manager mgr = new Manager("Alice Smith", 80000, "IT", 5);
        mgr.displayInfo();
        System.out.println("Bonus (10%): " + mgr.calculateBonus(0.10));
    }
}
