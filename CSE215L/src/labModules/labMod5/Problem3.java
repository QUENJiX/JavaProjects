package labModules.labMod5;

/* * Problem 3: You are tasked to make a BankAccount Class that contains instance and static variables.
 * Figure out which variables are static, create getters/setters, static methods for totals, 
 * and test with 5 instances.
 */

class BankAccount {
    // Instance variables (Exclusive to an object instance)
    private String name;
    private String branch;
    private double bankBalance;

    // Static variables (Represented by the whole class)
    private static int numberOfAccounts = 0;
    private static double totalAmount = 0.0;
    private static double avgAmount = 0.0;

    // Constructor
    public BankAccount(String name, String branch, double bankBalance) {
        this.name = name;
        this.branch = branch;
        this.bankBalance = bankBalance;

        // Update class-wide static variables
        numberOfAccounts++;
        totalAmount += bankBalance;
        updateAverage();
    }

    // Getters and Setters for instance variables
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double newBalance) {
        // Remove old balance from total and add new balance
        totalAmount = totalAmount - this.bankBalance + newBalance;
        this.bankBalance = newBalance;
        updateAverage();
    }

    // Private helper to calculate average internally
    private static void updateAverage() {
        if (numberOfAccounts > 0) {
            avgAmount = totalAmount / numberOfAccounts;
        }
    }

    // Static methods belonging to the entire Class
    public static double getTotalAmount() {
        return totalAmount;
    }

    public static double getAvgAmount() {
        return avgAmount;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        // Creating five instances of BankAccount
        BankAccount acc1 = new BankAccount("John", "Dhaka Main", 1000.0);
        // BankAccount acc2 = new BankAccount("Sarah", "Gulshan", 2500.0);
        // BankAccount acc3 = new BankAccount("Mike", "Banani", 1500.0);
        // BankAccount acc4 = new BankAccount("Emma", "Uttara", 3000.0);
        // BankAccount acc5 = new BankAccount("David", "Mirpur", 2000.0);

        // Printing the total and average balances using Class methods
        System.out.println("Total Balance across all accounts: $" + BankAccount.getTotalAmount());
        System.out.println("Average Balance across all accounts: $" + BankAccount.getAvgAmount());

        // Demonstrating a balance update to show static variables update dynamically
        System.out.println("\nUpdating John's balance to $5000...");
        acc1.setBankBalance(5000.0);

        System.out.println("New Total Balance: $" + BankAccount.getTotalAmount());
        System.out.println("New Average Balance: $" + BankAccount.getAvgAmount());
    }
}
