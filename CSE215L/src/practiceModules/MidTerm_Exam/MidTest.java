package practiceModules.MidTerm_Exam;

public class MidTest {
    public static void main(String[] args) {
        Executive exc = new Executive("Hasib", "Executive");
        Manager mng = new Manager("Bushra", "Manager");

        System.out.println("\nTesting Executive");
        exc.requestLeave(12);
        exc.requestLeave(10);
        exc.cancelLeave(5);

        System.out.println("\nTesting Manager");
        mng.requestLeave(20);
        mng.requestLeave(12);
    }
}
