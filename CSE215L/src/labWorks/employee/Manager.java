package labWorks.employee;

public class Manager extends Employee {
    private String department;
    private int employeeCount;

    public Manager() {
        super();
        this.department = "N/A";
        this.employeeCount = 0;
    }

    public Manager(String name, double salary, String dept, int empCount) {
        super(name, salary);
        this.department = dept;
        this.employeeCount = empCount;
    }

    public void setDept(String dept) {
        this.department = dept;
    }

    public String getDept() {
        return this.department;
    }

    public void setEmployeeCount(int empCount) {
        this.employeeCount = empCount;
    }

    public int getEmployeeCount() {
        return this.employeeCount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + this.department);
        System.out.println("Employee Count: " + this.employeeCount);
    }

    @Override
    public double calculateBonus(double bonus) {
        double regularBonus = super.calculateBonus(bonus);
        double additionalBonus = 500 * this.employeeCount;
        return regularBonus + additionalBonus;
    }

}
