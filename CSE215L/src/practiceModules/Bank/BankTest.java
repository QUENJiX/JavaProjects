package practiceModules.Bank;

public class BankTest {
    public static void main(String[] args) {
        BankAccount ac1 = new BankAccount("Hasib", "Bashundhara", 100);
        // BankAccount ac2 = new BankAccount("Jaima", "Uttara", 200);
        // BankAccount ac3 = new BankAccount("Risha", "Mohammadpur", 300);
        // BankAccount ac4 = new BankAccount("Fabiha", "Mughda", 400);
        // BankAccount ac5 = new BankAccount("Zarin", "idk", 10);

        System.out.println("Total Amount: " + BankAccount.getTotalAmount());
        System.out.println("Average Amount: " + BankAccount.getAvgAmount());
        
        ac1.setBankBalance(1000);
        System.out.println("After setting/updating the bankBalance of Account-2 to 1000");
        System.out.println("Total Amount: " + BankAccount.getTotalAmount());
        System.out.println("Average Amount: " + BankAccount.getAvgAmount());
    }
}
