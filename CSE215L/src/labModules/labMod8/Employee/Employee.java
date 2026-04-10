package labModules.labMod8.Employee;

public class Employee {
    private String name;
    private double salary;

    public Employee() {}

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }public double getSalary() {
        return salary;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }

    public double calculateBonus(double bonus) {
        // bonus is expected to be between 0.0 and 1.0
        return salary * bonus;
    }
}
