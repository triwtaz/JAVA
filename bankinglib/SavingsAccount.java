package bankinglib;

public class SavingsAccount extends Account{
    private double laisuat;
    private double accruedInterest;

    public SavingsAccount(String accountNumber, String accountName, double balance, double interestRate) {
        super(accountNumber, accountName, balance);
        this.laisuat = interestRate;
        this.accruedInterest = 0;
    }

    public void applyInterest() {
        double interest = sodu * laisuat / 100;
        deposit(interest);
        accruedInterest += interest;
    }

    public void displayInterest() {
        System.out.println("Lai suat: " + accruedInterest);
    }

    public double getInterestRate() {
        return laisuat;
    }
}
