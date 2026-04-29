package MidTerm;

public class Executive extends Employee {
    protected final int maxLeaveAtOnce = 10;

    public Executive(String name, String designation) {super(name, designation);}

    public void requestLeave(int days){
        int totalLeave = 35;
        if(days <= 10 && usedLeave <= 35){
            if((totalLeave-usedLeave) >= days){
                System.out.println( name + "'s leave for " + days + " day(s) is approved.");
                usedLeave += days;
                System.out.println("Updated Used Leaves: " + usedLeave + "/" + totalLeave);
            }else{
                System.out.println("Leave DENIED: You don't have enough remaining leaves.");
            }
        }else{
            System.out.println("Leave DENIED: Maximum leave request is capped at 10 at once.");
        }
    }

    public void cancelLeave(int days){
        if(usedLeave >= days){
            System.out.println("Your leave CANCEL request for " + days + " is approved.");
            usedLeave -= days;
            System.out.println("Updated Used Leaves: " + usedLeave + "/" + totalLeave);
        }else{
            System.out.println("Cancel Request DENIED: Amount Exceeds Used Leaves!");
        }
    }
    
    @Override
    public void printInfo(){super.printInfo();}
}
