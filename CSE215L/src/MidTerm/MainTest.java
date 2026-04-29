package MidTerm;

public class MainTest {
    public static void main(String[] args) {
        Executive exc = new Executive("Alice", "Executive");
        Manager mng = new Manager("Bob", "Manager");

        System.out.println("\nExecutive " + exc.getName() + "'s Leave Request Test");
        System.out.println("-------------------------------------------------------------");
        exc.requestLeave(8);
        exc.requestLeave(12);
        exc.requestLeave(10);
        System.out.println("-------------------------------------------------------------\n");

        System.out.println("Executive " + mng.getName() + "'s Leave Request Test");
        System.out.println("-------------------------------------------------------------");
        mng.requestLeave(14);
        mng.requestLeave(16);
        System.out.println("-------------------------------------------------------------\n");

        System.out.println("Updated Employee Information");
        System.out.println("-------------------------------------------------------------");
        System.out.println("\n--Executive " + exc.getName() + "'s info:--");
        exc.printInfo();
        System.out.println("\n--Manager " + mng.getName() + "'s Info:--");
        mng.printInfo();
        System.out.println("-------------------------------------------------------------\n");

        System.out.println("Executive " + exc.getName() + "'s Leave Cancelation Test");
        System.out.println("-------------------------------------------------------------");
        exc.cancelLeave(5);
        exc.cancelLeave(10);
        System.out.println("-------------------------------------------------------------\n");

        System.out.println("Executive " + exc.getName() + "'s Updated Information");
        System.out.println("-------------------------------------------------------------");
        exc.printInfo();
        System.out.println("-------------------------------------------------------------\n");

    }
}
