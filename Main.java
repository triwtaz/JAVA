import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

class Account {
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

class SavingsAccount extends Account {
    private double laisuat; // Interest rate
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

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        // Load accounts from file at startup
        bank.loadAccountsFromFile();

        while (true) {
            System.out.println("1. Thêm tài khoản mới");
            System.out.println("2. Tìm kiếm tài khoản");
            System.out.println("3. Hiển thị tất cả tài khoản");
            System.out.println("4. Tính lãi suất cho tài khoản tiết kiệm");
            System.out.println("5. Nạp tiền");
            System.out.println("6. Rút tiền");
            System.out.println("7. Chuyển tiền");
            System.out.println("8. Lưu tài khoản");
            System.out.println("0. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice) {
                case 1:
                    System.out.print("Nhập số tài khoản: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Nhập tên chủ tài khoản: ");
                    String accountName = scanner.nextLine();
                    System.out.print("Nhập số dư: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Chọn loại tài khoản (1: Tiết kiệm, 2: Thanh toán): ");
                    int type = scanner.nextInt();

                    if (type == 1) {
                        System.out.print("Nhập lãi suất: ");
                        double interestRate = scanner.nextDouble();
                        SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountName, balance, interestRate);
                        bank.addAccount(savingsAccount);
                    } else if (type == 2) {
                        System.out.print("Nhập phí giao dịch: ");
                        double transactionFee = scanner.nextDouble();
                        CheckingAccount checkingAccount = new CheckingAccount(accountNumber, accountName, balance, transactionFee);
                        bank.addAccount(checkingAccount);
                    }
                    break;

                case 2:
                    System.out.print("Nhập số tài khoản cần tìm: ");
                    String searchNumber = scanner.nextLine();
                    Account foundAccount = bank.searchAccount(searchNumber);
                    if (foundAccount != null) {
                        foundAccount.display();
                        if (foundAccount instanceof SavingsAccount) {
                            ((SavingsAccount) foundAccount).displayInterest();
                        }
                    } else {
                        System.out.println("Không tìm thấy tài khoản.");
                    }
                    break;

                case 3:
                    bank.displayAllAccounts();
                    break;

                case 4:
                    System.out.print("Nhập số tài khoản tiết kiệm để tính lãi suất: ");
                    String interestAccountNumber = scanner.nextLine();
                    Account interestAccount = bank.searchAccount(interestAccountNumber);
                    if (interestAccount instanceof SavingsAccount) {
                        ((SavingsAccount) interestAccount).applyInterest();
                        System.out.println("Lãi suất đã được tính cho tài khoản tiết kiệm.");
                        interestAccount.display();
                        ((SavingsAccount) interestAccount).displayInterest();
                    } else {
                        System.out.println("Tài khoản không phải là tài khoản tiết kiệm hoặc không tìm thấy.");
                    }
                    break;

                case 5:
                    System.out.print("Nhập số tài khoản để nạp tiền: ");
                    String depositAccountNumber = scanner.nextLine();
                    Account depositAccount = bank.searchAccount(depositAccountNumber);
                    if (depositAccount != null) {
                        System.out.print("Nhập số tiền nạp: ");
                        double depositAmount = scanner.nextDouble();
                        depositAccount.deposit(depositAmount);
                        System.out.println("Nạp tiền thành công. Số dư hiện tại: " + depositAccount.getSodu());
                    } else {
                        System.out.println("Không tìm thấy tài khoản.");
                    }
                    break;

                case 6:
                    System.out.print("Nhập số tài khoản để rút tiền: ");
                    String withdrawAccountNumber = scanner.nextLine();
                    Account withdrawAccount = bank.searchAccount(withdrawAccountNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Nhập số tiền rút: ");
                        double withdrawAmount = scanner.nextDouble();
                        if (withdrawAccount.withdraw(withdrawAmount)) {
                            System.out.println("Rút tiền thành công. Số dư hiện tại: " + withdrawAccount.getSodu());
                        } else {
                            System.out.println("Số dư không đủ.");
                        }
                    } else {
                        System.out.println("Không tìm thấy tài khoản.");
                    }
                    break;

                case 7:
                    System.out.print("Nhập số tài khoản gửi tiền: ");
                    String fromAccountNumber = scanner.nextLine();
                    Account fromAccount = bank.searchAccount(fromAccountNumber);
                    System.out.print("Nhập số tài khoản nhận tiền: ");
                    String toAccountNumber = scanner.nextLine();
                    Account toAccount = bank.searchAccount(toAccountNumber);
                    if (fromAccount != null && toAccount != null) {
                        System.out.print("Nhập số tiền chuyển: ");
                        double transferAmount = scanner.nextDouble();
                        if (fromAccount.transfer(toAccount, transferAmount)) {
                            System.out.println("Chuyển tiền thành công.");
                            System.out.println("Số dư tài khoản gửi: " + fromAccount.getSodu());
                            System.out.println("Số dư tài khoản nhận: " + toAccount.getSodu());
                        } else {
                            System.out.println("Chuyển tiền không thành công. Số dư không đủ.");
                        }
                    } else {
                        System.out.println("Không tìm thấy tài khoản.");
                    }
                    break;

                case 8:
                    bank.saveAccountsToFile();
                    System.out.println("Tài khoản đã được lưu thành công.");
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
