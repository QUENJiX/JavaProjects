package assignments.bank;

public class BankTest {
    public static void main(String[] args) {
        Bank myBank = new Bank();

        // Add sample bank accounts to the bank
        myBank.addAccount(new BankAccount(1122, 500.00));
        myBank.addAccount(new BankAccount(1123, 1500.00));
        myBank.addAccount(new BankAccount(1124, 2000.00));
        myBank.addAccount(new BankAccount(1125, 300.00));

        // Test and display the total balance of all accounts
        System.out.println("-----------");
        System.out.println("Bank Status");
        System.out.println("-----------");
        System.out.println("Total Balance: " + myBank.getTotalBalance());

        // Test the count method for accounts with at least 1000.00
        System.out.println("Count of accounts with atleast 1000.00: " + myBank.count(1000.00));
        System.out.println();

        // Test the find method for an existing account (1123)
        System.out.println("--------------------");
        System.out.println("Finding Account 1123");
        System.out.println("--------------------");
        BankAccount foundAccount = myBank.find(1123);
        if (foundAccount != null) {
            System.out.println("Account Found: " + foundAccount.getAccountNumber());
            System.out.println("Balance: " + foundAccount.getBalance());
            System.out.println();
        } else {
            System.out.println("Account not found.\n");
        }

        // Test the find method for a non-existent account (999)
        System.out.println("----------------------------------");
        System.out.println("Finding Account 999 (Non-existent)");
        System.out.println("----------------------------------");
        BankAccount missingAccount = myBank.find(999);
        if (missingAccount != null) {
            System.out.println("Account Found: " + missingAccount.getAccountNumber());
            System.out.println();
        } else {
            System.out.println("Account 999 not found as expected.\n");
        }

        // Test the getMaximum method to find the account with the highest balance
        System.out.println("----------------------------");
        System.out.println("Account with Maximum Balance");
        System.out.println("----------------------------");
        BankAccount maxAccount = myBank.getMaximum();
        if (maxAccount != null) {
            System.out.println("Account Number: " + maxAccount.getAccountNumber());
            System.out.println("Highest Balance: " + maxAccount.getBalance());
        }
        System.out.println();
    }
}
