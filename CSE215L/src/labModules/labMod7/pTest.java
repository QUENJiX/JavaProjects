package labModules.labMod7;

public class pTest {
    public static void main(String[] args) {
        Knight risha = new Knight("Risha", 10, 100, 0);
        Knight hasib = new Knight("Hasib", 15, 80, 25);

        risha.blockAttack();
        hasib.boostDefense();
    }
}
