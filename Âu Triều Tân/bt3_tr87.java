import java.util.Scanner;

class Date {
    private int day;   // Ngày
    private int month; // Tháng
    private int year;  // Năm

    // Hàm gán để khởi tạo 1 Date
    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Hàm nhập giá trị
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày: ");
        this.day = scanner.nextInt();
        System.out.print("Nhập tháng: ");
        this.month = scanner.nextInt();
        System.out.print("Nhập năm: ");
        this.year = scanner.nextInt();
    }

    // Hàm hiện thông tin
    public void display() {
        System.out.printf("Ngày: %02d/%02d/%d%n", day, month, year);
    }

    // Hàm kiểm tra xem ngày có hợp lệ hay không
    public boolean isValid() {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int[] daysInMonth = { 31, isLeapYear() ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        return day <= daysInMonth[month - 1];
    }

    // Hàm kiểm tra năm nhuận
    private boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

public class bt3_tr87 {
    public static void main(String[] args) {
        // Tạo 1 Date có giá trị là: 09/09/2005
        Date date1 = new Date();
        date1.setDate(9, 9, 2005);
        System.out.print("Giá trị Date 1: ");
        date1.display();

        // Tạo 1 Date bất kỳ nhập giá trị cho nó
        Date date2 = new Date();
        date2.input();
        System.out.print("Giá trị Date 2: ");
        date2.display();

        // Kiểm tra Date vừa nhập có hợp lệ hay không
        if (date2.isValid()) {
            System.out.println("Ngày nhập hợp lệ.");
        } else {
            System.out.println("Ngày nhập không hợp lệ.");
        }
    }
}
