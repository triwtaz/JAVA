// Bài 10 trang 90

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Nguoi {
    protected String hoTen;     // Họ và tên
    protected int namSinh;      // Năm sinh
    protected String gioiTinh;   // Giới tính
    protected String diaChi;     // Địa chỉ
    protected String soCCCD;     // Số CCCD

    // Hàm khởi tạo
    public Nguoi() {
    }

    public Nguoi(String hoTen, int namSinh, String gioiTinh, String diaChi, String soCCCD) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soCCCD = soCCCD;
    }

    // Phương thức nhập thông tin người
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

    // Phương thức xuất thông tin người
    public void xuat() {
        System.out.println("Họ và tên: " + hoTen);
        System.out.println("Năm sinh: " + namSinh);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Số CCCD: " + soCCCD);
    }
}

class SinhVien extends Nguoi {
    private String maSoSV;       // Mã số sinh viên
    private String lop;          // Lớp
    private double diemTBTK;     // Điểm trung bình toàn khóa

    // Hàm khởi tạo
    public SinhVien() {
    }

    public SinhVien(String maSoSV, String lop, double diemTBTK) {
        this.maSoSV = maSoSV;
        this.lop = lop;
        this.diemTBTK = diemTBTK;
    }

    // Phương thức nhập thông tin sinh viên
    @Override
    public void nhap() {
        super.nhap(); // Gọi phương thức nhập từ lớp Nguoi
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã số sinh viên: ");
        maSoSV = scanner.nextLine();
        System.out.print("Nhập lớp: ");
        lop = scanner.nextLine();
        System.out.print("Nhập điểm trung bình toàn khóa: ");
        diemTBTK = scanner.nextDouble();
    }

    // Phương thức xuất thông tin sinh viên
    @Override
    public void xuat() {
        super.xuat(); // Gọi phương thức xuất từ lớp Nguoi
        System.out.println("Mã số sinh viên: " + maSoSV);
        System.out.println("Lớp: " + lop);
        System.out.println("Điểm trung bình toàn khóa: " + diemTBTK);
        System.out.println("Xếp loại tốt nghiệp: " + xepLoai());
    }

    // Hàm xếp loại tốt nghiệp
    public String xepLoai() {
        if (diemTBTK >= 9.0) return "Xuất sắc";
        else if (diemTBTK >= 8.0) return "Giỏi";
        else if (diemTBTK >= 7.0) return "Khá";
        else if (diemTBTK >= 5.5) return "Trung bình";
        else return "Không đủ điều kiện tốt nghiệp";
    }

    // Getter cho mã số sinh viên
    public String getMaSoSV() {
        return maSoSV;
    }
}

public class Main10 {
    private List<SinhVien> danhSachSinhVien; // Danh sách sinh viên

    // Hàm khởi tạo
    public Main10() {
        danhSachSinhVien = new ArrayList<>();
    }

    // Phương thức thêm sinh viên
    public void themSinhVien() {
        SinhVien sinhVien = new SinhVien();
        sinhVien.nhap();
        danhSachSinhVien.add(sinhVien);
        System.out.println("Thêm sinh viên thành công.");
    }

    // Phương thức hiển thị danh sách sinh viên
    public void hienThiDanhSach() {
        if (danhSachSinhVien.isEmpty()) {
            System.out.println("Chưa có sinh viên nào.");
            return;
        }
        System.out.println("\nDanh sách sinh viên:");
        for (SinhVien sinhVien : danhSachSinhVien) {
            sinhVien.xuat();
            System.out.println("---------------------");
        }
    }

    // Phương thức hiển thị thông tin sinh viên theo mã số
    public void hienThiSinhVienTheoMa(String maSoSV) {
        boolean found = false;
        for (SinhVien sinhVien : danhSachSinhVien) {
            if (sinhVien.getMaSoSV().equals(maSoSV)) {
                sinhVien.xuat();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên có mã số: " + maSoSV);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main10 qlSinhVien = new Main10();
        int luaChon;

        do {
            System.out.println("\n--- Quản lý sinh viên ---");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Hiển thị thông tin sinh viên theo mã số");
            System.out.println("0. Thoát");
            System.out.print("Chọn lựa chọn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    int soLuong = scanner.nextInt();
                    scanner.nextLine(); // Xóa bộ đệm
                    for (int i = 0; i < soLuong; i++) {
                        System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
                        qlSinhVien.themSinhVien();
                    }
                    break;
                case 2:
                    qlSinhVien.hienThiDanhSach();
                    break;
                case 3:
                    System.out.print("Nhập mã số sinh viên cần tìm: ");
                    String maSo = scanner.nextLine();
                    qlSinhVien.hienThiSinhVienTheoMa(maSo);
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
