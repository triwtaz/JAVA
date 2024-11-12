// Bài 9 trang 89

import java.util.Scanner;

class Clock {
    private int hour;  // Giờ
    private int minute; // Phút
    private int second; // Giây

    // Hàm khởi tạo mặc định
    public Clock() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    // Hàm khởi tạo có tham số
    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        normalizeTime();
    }

    // Phương thức nhập giờ
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giờ: ");
        this.hour = scanner.nextInt();
        System.out.print("Nhập phút: ");
        this.minute = scanner.nextInt();
        System.out.print("Nhập giây: ");
        this.second = scanner.nextInt();
        normalizeTime();
    }

    // Phương thức xuất giờ
    public void xuat() {
        System.out.printf("Giờ: %02d:%02d:%02d%n", hour, minute, second);
    }

    // Phương thức chuẩn hóa giờ
    private void normalizeTime() {
        if (second >= 60) {
            minute += second / 60;
            second = second % 60;
        }
        if (minute >= 60) {
            hour += minute / 60;
            minute = minute % 60;
        }
        hour = hour % 24; // Chỉ cần giữ trong 24 giờ
    }
}

class ChuyenBay extends Clock {
    private String maSoChuyenBay;   // Mã số chuyến bay
    private String hangHangKhong;    // Hãng hàng không

    // Hàm khởi tạo mặc định
    public ChuyenBay() {
        super(); // Gọi hàm khởi tạo của lớp Clock
        this.maSoChuyenBay = "";
        this.hangHangKhong = "";
    }

    // Hàm khởi tạo có tham số
    public ChuyenBay(int hour, int minute, int second, String maSoChuyenBay, String hangHangKhong) {
        super(hour, minute, second); // Gọi hàm khởi tạo của lớp Clock
        this.maSoChuyenBay = maSoChuyenBay;
        this.hangHangKhong = hangHangKhong;
    }

    // Phương thức nhập thông tin chuyến bay
    public void nhap() {
        super.nhap(); // Nhập giờ bay
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã số chuyến bay: ");
        maSoChuyenBay = scanner.nextLine();
        System.out.print("Nhập hãng hàng không: ");
        hangHangKhong = scanner.nextLine();
    }

    // Phương thức xuất thông tin chuyến bay
    public void xuat() {
        super.xuat(); // Xuất giờ bay
        System.out.println("Mã số chuyến bay: " + maSoChuyenBay);
        System.out.println("Hãng hàng không: " + hangHangKhong);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng chuyến bay: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm

        ChuyenBay[] chuyenBays = new ChuyenBay[n];

        // Nhập thông tin các chuyến bay
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin chuyến bay thứ " + (i + 1) + ":");
            chuyenBays[i] = new ChuyenBay();
            chuyenBays[i].nhap();
        }

        // Xuất thông tin các chuyến bay
        System.out.println("\nDanh sách các chuyến bay:");
        for (ChuyenBay cb : chuyenBays) {
            cb.xuat();
            System.out.println("---------------------");
        }
    }
}
