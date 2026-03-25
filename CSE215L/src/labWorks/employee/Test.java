package labWorks.employee;

public class Test {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Random", 50000);
        Manager mgr1 = new Manager("Hasib", 100000, "Sales", 5);

        System.out.println("Employee Information:");
        emp1.displayInfo();
        System.out.println("Bonus: " + emp1.calculateBonus(0.1));

        System.out.println("\nManager Information:");
        mgr1.displayInfo();
        System.out.println("Bonus: " + mgr1.calculateBonus(0.1));
    }
}
