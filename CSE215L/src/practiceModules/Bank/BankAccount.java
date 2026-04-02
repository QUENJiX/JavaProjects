package practiceModules.Bank;

public class BankAccount {
    private String name;
    private String branch;
    private double bankBanlance;

    private static int numberOfAccounts = 0;
    private static double totalAmount = 0.0;
    private static double avgAmount = 0.0;

    public BankAccount(String name, String branch, double bankBalance) {
        this.name = name;
        this.branch = branch;
        this.bankBanlance = bankBalance;

        numberOfAccounts++;
        totalAmount += bankBalance;
        avgAmount = totalAmount / numberOfAccounts;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getBankBalance() {
        return bankBanlance;
    }

    public void setBankBalance(double bankBalance) {
        totalAmount -= this.bankBanlance;
        this.bankBanlance = bankBalance;
        totalAmount += this.bankBanlance;
        avgAmount = totalAmount / numberOfAccounts;
    }

    public static double getTotalAmount() {
        return totalAmount;
    }

    public static double getAvgAmount() {
        return avgAmount;
    }
}
