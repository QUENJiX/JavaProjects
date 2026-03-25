package labWorks.employee;

public class Employee {
    private String name;
    private double salary;

    public Employee() {
        this.name = "";
        this.salary = 0.0;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Salary: " + this.salary);
    }

    public double calculateBonus(double bonus) {
        if (bonus < 0.0 || bonus > 1.0) {
            throw new IllegalArgumentException("Bonus percentage must be between 0.0 and 1.0");
        }
        return this.salary * bonus;
    }
}
