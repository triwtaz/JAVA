import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class conNguoi {
    protected String hoTen;   // Họ và tên
    protected int namSinh;    // Năm sinh
    protected String gioiTinh; // Giới tính
    protected String diaChi;   // Địa chỉ
    protected String soCCCD;   // Số CCCD

    // Hàm khởi tạo mặc định
    public conNguoi() {
        this.hoTen = "Người A";
        this.namSinh = 2000;
        this.gioiTinh = "Nam";
        this.diaChi = "Hà Nội";
        this.soCCCD = "123456789";
    }

    // Hàm khởi tạo có tham số
    public conNguoi(String hoTen, int namSinh, String gioiTinh, String diaChi, String soCCCD) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soCCCD = soCCCD;
    }

    // Phương thức nhập thông tin
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ và tên: ");
        hoTen = scanner.nextLine();
        System.out.print("Nhập năm sinh: ");
        namSinh = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm
        System.out.print("Nhập giới tính: ");
        gioiTinh = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        diaChi = scanner.nextLine();
        System.out.print("Nhập số CCCD: ");
        soCCCD = scanner.nextLine();
    }

    // Phương thức xuất thông tin
    public void xuat() {
        System.out.println("Họ và tên: " + hoTen);
        System.out.println("Năm sinh: " + namSinh);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Số CCCD: " + soCCCD);
    }
}

class NhanVien extends Nguoi {
    private String maSoNV;      // Mã số nhân viên
    private String phongBan;    // Phòng ban
    private String chucVu;      // Chức vụ
    private double heSoLuong;   // Hệ số lương

    // Hàm khởi tạo mặc định
    public NhanVien() {
        super();
        this.maSoNV = "NV001";
        this.phongBan = "Phòng A";
        this.chucVu = "Nhân viên";
        this.heSoLuong = 1.0;
    }

    // Hàm khởi tạo có tham số
    public NhanVien(String maSoNV, String phongBan, String chucVu, double heSoLuong,
                    String hoTen, int namSinh, String gioiTinh, String diaChi, String soCCCD) {
        super(hoTen, namSinh, gioiTinh, diaChi, soCCCD);
        this.maSoNV = maSoNV;
        this.phongBan = phongBan;
        this.chucVu = chucVu;
        this.heSoLuong = heSoLuong;
    }

    // Phương thức nhập thông tin nhân viên
    @Override
    public void nhap() {
        super.nhap(); // Nhập thông tin từ lớp Nguoi
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã số nhân viên: ");
        maSoNV = scanner.nextLine();
        System.out.print("Nhập phòng ban: ");
        phongBan = scanner.nextLine();
        System.out.print("Nhập chức vụ: ");
        chucVu = scanner.nextLine();
        System.out.print("Nhập hệ số lương: ");
        heSoLuong = scanner.nextDouble();
    }

    // Phương thức xuất thông tin nhân viên
    @Override
    public void xuat() {
        super.xuat(); // Xuất thông tin từ lớp Nguoi
        System.out.println("Mã số nhân viên: " + maSoNV);
        System.out.println("Phòng ban: " + phongBan);
        System.out.println("Chức vụ: " + chucVu);
        System.out.println("Hệ số lương: " + heSoLuong);
        System.out.printf("Lương: %.2f VND\n", tinhLuong());
    }

    // Hàm tính lương
    public double tinhLuong() {
        double heSoPhuCap = 0;
        switch (chucVu) {
            case "Giám đốc":
                heSoPhuCap = 1.0;
                break;
            case "Phó Giám đốc":
                heSoPhuCap = 0.75;
                break;
            case "Trưởng phòng":
                heSoPhuCap = 0.5;
                break;
            case "Phó Trưởng phòng":
                heSoPhuCap = 0.35;
                break;
            default:
                heSoPhuCap = 0;
                break;
        }
        return (heSoLuong * 1800000) + (heSoPhuCap * 1800000);
    }

    // Getter cho mã số nhân viên
    public String getMaSoNV() {
        return maSoNV;
    }
}

public class bt11_tr90 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<NhanVien> danhSachNhanVien = new ArrayList<>();

        System.out.print("Nhập số lượng nhân viên: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm

        // Nhập danh sách nhân viên
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
            NhanVien nv = new NhanVien();
            nv.nhap();
            danhSachNhanVien.add(nv);
        }

        // In danh sách lương của nhân viên
        System.out.println("\nDanh sách lương của nhân viên:");
        for (NhanVien nv : danhSachNhanVien) {
            nv.xuat();
            System.out.println("---------------------");
        }

        // Tìm nhân viên theo mã số
        System.out.print("Nhập mã số nhân viên để tìm: ");
        String maSoTim = scanner.nextLine();
        boolean found = false;

        for (NhanVien nv : danhSachNhanVien) {
            if (nv.getMaSoNV().equals(maSoTim)) {
                System.out.println("Thông tin nhân viên có mã số " + maSoTim + ":");
                nv.xuat();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy nhân viên có mã số " + maSoTim);
        }
    }
}
