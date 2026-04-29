package practiceModules.MidTerm_Exam;

public class Employee {
    private String name;
    private String designation;
    protected final int totalLeave = 35;
    private int usedLeave;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
        this.usedLeave = 0;
    }

    public String getname() {
        return this.name;
    }public void setname(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return this.designation;
    }public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getUsedLeave() {
        return this.usedLeave;
    }public void setUsedLeave(int usedLeave) {
        this.usedLeave = usedLeave;
    }

    public void printInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Designation: " + this.designation);
        System.out.println("Used Leave: " + this.usedLeave);
    }
}
