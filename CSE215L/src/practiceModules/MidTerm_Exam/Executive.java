package practiceModules.MidTerm_Exam;

public class Executive extends Employee {
    private final int maxLeaveAtOnce = 10;

    public Executive(String name, String designation) {
        super(name, designation);
    }

    // o.requestLeave(10)
    public void requestLeave(int days){
        if(days <= 0){
            System.out.println("How could you be so dumb. You are Fired!");
        } else if (days > maxLeaveAtOnce){
            System.out.println("Maximum leave amount exceeded.");
        } else if ((getUsedLeave() + days) > totalLeave){
            System.out.println("Maximum leave amount exceeded.");
        } else{
            System.out.println("Your leave of " + days + " is approved. Enjoy mofo!"); 
            int ul = getUsedLeave(); // 15
            ul = ul + days; // 15 + 10 = 25
            System.out.println("Leave update: " + ul + "/" + totalLeave); // 25/35
        }
    }
    
    public void cancelLeave(int days) {
        if(days <= 0){
            System.out.println("How could you be so dumb. You are Fired!");
        } else if (days > getUsedLeave()) {
            System.out.println("Amount exceeds used leaves.");
        } else {
            System.out.println("Your leave CANCEL request for " + days + " is approved. Get back to work NOW.");
            int ul = getUsedLeave();
            ul = ul - days;
            System.out.println("Leave update: " + ul + "/" + totalLeave); // 15/35
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }
}
