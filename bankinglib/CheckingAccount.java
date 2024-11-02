package bankinglib;

class CheckingAccount extends Account {
    private double phigiaodich; // Transaction fee

    public CheckingAccount(String accountNumber, String accountName, double balance, double transactionFee) {
        super(accountNumber, accountName, balance);
        this.phigiaodich = transactionFee;
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + phigiaodich);
    }

    public double getTransactionFee() {
        return phigiaodich;
    }
}

