package practiceModules.LabQUIZ_1;

public class Trainer {
    private String fullName;
    private String contactEmail;

    public Trainer(String fullname, String contactEmail) {
        this.fullName = fullname;
        this.contactEmail = contactEmail;
    }

    public String getFullName() {
        return this.fullName;
    }public String getContactEmail() {
        return this.contactEmail;
    }

    public void displayInfo(){
        System.out.println("Full Name: " + this.fullName);
        System.out.println("Contact Email: " + this.contactEmail);
    }
}
