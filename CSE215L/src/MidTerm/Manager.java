package MidTerm;

public class Manager extends Executive{
    protected final int maxLeaveAtOnce = 15;

    public Manager(String name, String designation) {super(name, designation);}

    @Override
    public void requestLeave(int days) {
        int totalLeave = 35;
        if (days <= 15 && usedLeave <= 35) {
            if ((totalLeave - usedLeave) >= days) {
                System.out.println(name + "'s leave for " + days + " is approved.");
                usedLeave += days;
                System.out.println("Updated Used Leaves: " + usedLeave + "/" + totalLeave);
            } else {
                System.out.println("Leave DENIED: You don't have enough remaining leaves!");
            }
        } else {
            System.out.println("Leave DENIED: Maximum leave request is capped at 15 at once.");
        }
    }

    @Override
    public void printInfo() {super.printInfo();}
}
