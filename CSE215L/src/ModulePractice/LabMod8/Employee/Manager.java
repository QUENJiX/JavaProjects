package ModulePractice.LabMod8.Employee;

public class Manager extends Employee {
    private String department;
    private int employeeCount;

    public Manager() {}

    public Manager (String name, double salary, String department, int employeeCount){
        super(name, salary);
        this.department = department;
        this.employeeCount = employeeCount;
    }


    public void setDepartment(String department) {
        this.department = department;
    }public String getDepartment() {
        return department;
    }
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }public int getEmployeeCount() {
        return employeeCount;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Department " + getDepartment());
        System.out.println("Employee Count " + employeeCount);
    }

    @Override
    public double calculateBonus(double bonus){
        return super.calculateBonus(bonus) + (500*getEmployeeCount());
    }
}
