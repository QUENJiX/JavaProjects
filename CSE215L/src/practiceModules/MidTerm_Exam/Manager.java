package practiceModules.MidTerm_Exam;

public class Manager extends Executive {
    private final int maxLeaveAtOnce = 15;

    public Manager(String name, String designation) {
        super(name, designation);
    }

    @Override
    public void requestLeave(int days) {
        if (days <= 0) {
            System.out.println("How could you be so dumb. You are Fired!");
        } else if (days > maxLeaveAtOnce) {
            System.out.println("Maximum leave amount exceeded.");
        } else if ((getUsedLeave() + days) > totalLeave) {
            System.out.println("Maximum leave amount exceeded.");
        } else {
            System.out.println("Your leave of " + days + " is approved. Enjoy mofo!");
            int ul = getUsedLeave(); 
            ul = ul + days; 
            System.out.println("Leave update: " + ul + "/" + totalLeave);
        }
    }

    @Override
    public void printInfo(){
        super.printInfo();
    }
}
