package practiceModules.student;

public class Student {
    private String name;
    private String ID;
    private String dept;

    public Student() {
        this.name = "No name";
        this.ID = "000";
        this.dept = "N/A";
    }

    public Student(String n, String ID, String dept) {
        this.name = n;
        this.ID = ID;
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }public String getName() {
        return this.name;
    }

    public void setID(String ID){
        this.ID = ID;
    }public String getID(){
        return this.ID;
    }

    public void setDept(String dept){
        this.dept = dept;
    }public String getDept(){
        return this.dept;
    }

    public void printInfo(){
        System.out.println("Student Name: " + this.name);
        System.out.println("ID: " + this.ID);
        System.out.println("Department: " + this.dept);
    }
}
