package bankinglib;

public class Account {
    private String sotk; // Account number
    private String tentk; // Account name
    protected double sodu; // Balance

    public Account(String accountNumber, String accountName, double balance) {
        this.sotk = accountNumber;
        this.tentk = accountName;
        this.sodu = balance;
    }

    public void deposit(double amount) {
        sodu += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= sodu) {
            sodu -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(Account toAccount, double amount) {
        if (withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }

    public void display() {
        System.out.println("So tai khoan: " + sotk);
        System.out.println("Ten tai khoan: " + tentk);
        System.out.println("So du: " + sodu);
    }

    public String getSotk() {
        return sotk;
    }

    public String getTentk() {
        return tentk; // Added getter for account name
    }

    public double getSodu() {
        return sodu;
    }
}
