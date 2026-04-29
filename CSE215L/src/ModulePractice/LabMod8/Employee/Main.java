package ModulePractice.LabMod8.Employee;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n--- Employee Test ---");
        Employee emp = new Employee ("Hasib", 100000);
        emp.displayInfo();
        System.out.println("Bonus: " + emp.calculateBonus(0.8));

        System.out.println("\n--- Manager Test ---");
        Manager mng = new Manager("Hasib", 1000000, "IT", 1000);
        mng.displayInfo();
        System.out.println("Bonus " + mng.calculateBonus(0.9));
    }
}
