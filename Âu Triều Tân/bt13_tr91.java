import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MonHoc1 {
    private String maMonHoc;   // Mã môn học
    private String tenMonHoc;   // Tên môn học
    private int soTiet;         // Số tiết

    // Hàm khởi tạo
    public MonHoc1(String maMonHoc, String tenMonHoc, int soTiet) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTiet = soTiet;
    }

    // Phương thức nhập thông tin môn học
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã môn học: ");
        maMonHoc = scanner.nextLine();
        System.out.print("Nhập tên môn học: ");
        tenMonHoc = scanner.nextLine();
        System.out.print("Nhập số tiết: ");
        soTiet = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm
    }

    // Phương thức xuất thông tin môn học
    public void xuat() {
        System.out.println("Mã môn học: " + maMonHoc);
        System.out.println("Tên môn học: " + tenMonHoc);
        System.out.println("Số tiết: " + soTiet);
    }
}

class HocVien {
    private String soCCCD;       // Số CCCD hoặc mã định danh
    private String tenHocVien;    // Tên học viên
    private List<MonHoc> danhSachMonHoc; // Danh sách các môn học

    // Hàm khởi tạo
    public HocVien(String soCCCD, String tenHocVien) {
        this.soCCCD = soCCCD;
        this.tenHocVien = tenHocVien;
        this.danhSachMonHoc = new ArrayList<>();
    }

    // Phương thức nhập thông tin học viên
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số CCCD hoặc mã định danh: ");
        soCCCD = scanner.nextLine();
        System.out.print("Nhập tên học viên: ");
        tenHocVien = scanner.nextLine();

        // Nhập danh sách môn học
        System.out.print("Nhập số lượng môn học đăng ký: ");
        int soLuongMonHoc = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm

        for (int i = 0; i < soLuongMonHoc; i++) {
            System.out.println("Nhập thông tin môn học thứ " + (i + 1) + ":");
            MonHoc monHoc = new MonHoc("", "", 0);
            monHoc.nhap();
            danhSachMonHoc.add(monHoc);
        }
    }

    // Phương thức xuất thông tin học viên
    public void xuat() {
        System.out.println("Số CCCD hoặc mã định danh: " + soCCCD);
        System.out.println("Tên học viên: " + tenHocVien);
        System.out.println("Danh sách môn học đã đăng ký:");
        for (MonHoc monHoc : danhSachMonHoc) {
            monHoc.xuat();
            System.out.println("---------------------");
        }
    }

    // Phương thức kiểm tra số lượng môn học
    public boolean coItNhatHaiMonHoc() {
        return danhSachMonHoc.size() >= 2;
    }
}

public class bt13_tr91 {
    private List<HocVien> danhSachHocVien; // Danh sách học viên

    // Hàm khởi tạo
    public bt13_tr91() {
        danhSachHocVien = new ArrayList<>();
    }

    // Phương thức thêm học viên
    public void themHocVien() {
        HocVien hocVien = new HocVien("", "");
        hocVien.nhap();
        danhSachHocVien.add(hocVien);
        System.out.println("Thêm học viên thành công.");
    }

    // Phương thức hiển thị thông tin học viên
    public void hienThiHocVien() {
        if (danhSachHocVien.isEmpty()) {
            System.out.println("Chưa có học viên nào.");
            return;
        }
        System.out.println("\nDanh sách học viên:");
        for (HocVien hocVien : danhSachHocVien) {
            hocVien.xuat();
            System.out.println("---------------------");
        }
    }

    // Phương thức hiển thị học viên đăng ký ít nhất hai môn học
    public void hienThiHocVienCoItNhatHaiMonHoc() {
        System.out.println("\nDanh sách học viên đăng ký ít nhất hai môn học:");
        boolean found = false;
        for (HocVien hocVien : danhSachHocVien) {
            if (hocVien.coItNhatHaiMonHoc()) {
                hocVien.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có học viên nào đăng ký ít nhất hai môn học.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bt13_tr91 qlHocVien = new bt13_tr91();
        int luaChon;

        do {
            System.out.println("\n--- Quản lý học viên ---");
            System.out.println("1. Thêm học viên");
            System.out.println("2. Hiển thị thông tin học viên");
            System.out.println("3. Hiển thị học viên đăng ký ít nhất hai môn học");
            System.out.println("0. Thoát");
            System.out.print("Chọn lựa chọn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

            switch (luaChon) {
                case 1:
                    qlHocVien.themHocVien();
                    break;
                case 2:
                    qlHocVien.hienThiHocVien();
                    break;
                case 3:
                    qlHocVien.hienThiHocVienCoItNhatHaiMonHoc();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (luaChon != 0);
    }
}
