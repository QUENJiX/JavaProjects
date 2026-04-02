package labModules.labMod8.Employee;

public class Manager extends Employee {
    private String department;
    private int employeeCount;

    public Manager() {
    }

    public Manager(String name, double salary, String department, int employeeCount) {
        super(name, salary);
        this.department = department;
        this.employeeCount = employeeCount;
    }

    public void setDept(String dept) {
        this.department = dept;
    }

    public String getDept() {
        return department;
    }

    public void setEmployeeCount(int empCount) {
        this.employeeCount = empCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Employee Count: " + employeeCount);
    }

    @Override
    public double calculateBonus(double bonus) {
        return super.calculateBonus(bonus) + (500 * employeeCount);
    }
}
