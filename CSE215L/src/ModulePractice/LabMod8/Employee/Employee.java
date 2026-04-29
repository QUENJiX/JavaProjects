package ModulePractice.LabMod8.Employee;

public class Employee {
    private String name;
    private double salary;

    public Employee() {
        this.name = "Unknown";
        this.salary = 0.0;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return this.salary;
    }public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Salary " + getSalary());
    }

    // e.calculateBonus()
    public double calculateBonus(double bonus){
        return (getSalary() * bonus);
    }
}
