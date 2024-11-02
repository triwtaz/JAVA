package bankinglib;

import java.io.*;
import java.util.ArrayList;

class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();
    private static final String FILE_NAME = "accounts.txt";

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account searchAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getSotk().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        for (Account account : accounts) {
            account.display();
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).displayInterest();
            }
            System.out.println();
        }
    }

    public void loadAccountsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String accountNumber = parts[0];
                    String accountName = parts[1];
                    double balance = Double.parseDouble(parts[2]);
                    int accountType = Integer.parseInt(parts[3]);
                    if (accountType == 1) { // Savings account
                        double interestRate = Double.parseDouble(parts[4]);
                        SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountName, balance, interestRate);
                        accounts.add(savingsAccount);
                    } else if (accountType == 2) { // Checking account
                        double transactionFee = Double.parseDouble(parts[4]);
                        CheckingAccount checkingAccount = new CheckingAccount(accountNumber, accountName, balance, transactionFee);
                        accounts.add(checkingAccount);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi tải tài khoản: " + e.getMessage());
        }
    }

    public void saveAccountsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Account account : accounts) {
                String accountType = (account instanceof SavingsAccount) ? "1" : "2";
                String additionalInfo = (account instanceof SavingsAccount)
                        ? String.valueOf(((SavingsAccount) account).getInterestRate())
                        : String.valueOf(((CheckingAccount) account).getTransactionFee());
                writer.write(String.join(",",
                        account.getSotk(),
                        account.getTentk(),
                        String.valueOf(account.getSodu()),
                        accountType,
                        additionalInfo));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu tài khoản: " + e.getMessage());
        }
    }
}

