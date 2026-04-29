package MidTerm;

public class Employee {
    protected String name;
    protected String designation;
    protected final int totalLeave = 35;
    protected int usedLeave;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public String getName() { return this.name; }
    public void setname(String name) { this.name = name; }

    public String getDesignation() { return this.designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public int getUsedLeave() { return this.usedLeave; }
    public void setUsedLeave(int usedLeave) { this.usedLeave = usedLeave; }

    public void printInfo(){
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Used Leave: " + usedLeave + "/" + totalLeave);
    }
}
