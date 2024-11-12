
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MonHoc {
    private String maMonHoc;   // Mã môn học
    private String tenMonHoc;   // Tên môn học
    private int soTinChi;      // Số tín chỉ

    // Hàm khởi tạo
    public MonHoc(String maMonHoc, String tenMonHoc, int soTinChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }

    // Phương thức nhập thông tin môn học
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã môn học: ");
        maMonHoc = scanner.nextLine();
        System.out.print("Nhập tên môn học: ");
        tenMonHoc = scanner.nextLine();
        System.out.print("Nhập số tín chỉ: ");
        soTinChi = scanner.nextInt();
    }

    // Phương thức xuất thông tin môn học
    public void xuat() {
        System.out.println("Mã môn học: " + maMonHoc);
        System.out.println("Tên môn học: " + tenMonHoc);
        System.out.println("Số tín chỉ: " + soTinChi);
    }

    // Getter cho mã môn học
    public String getMaMonHoc() {
        return maMonHoc;
    }

    // Getter cho tên môn học
    public String getTenMonHoc() {
        return tenMonHoc;
    }

    // Getter cho số tín chỉ
    public int getSoTinChi() {
        return soTinChi;
    }
}

public class QuanLyMonHoc {
    private List<MonHoc> danhSachMonHoc; // Danh sách môn học

    // Hàm khởi tạo
    public QuanLyMonHoc() {
        danhSachMonHoc = new ArrayList<>();
    }

    // Phương thức thêm môn học
    public void themMonHoc() {
        MonHoc monHoc = new MonHoc("", "", 0);
        monHoc.nhap();
        danhSachMonHoc.add(monHoc);
        System.out.println("Thêm môn học thành công.");
    }

    // Phương thức xóa môn học
    public void xoaMonHoc(String maMonHoc) {
        boolean found = false;
        for (int i = 0; i < danhSachMonHoc.size(); i++) {
            if (danhSachMonHoc.get(i).getMaMonHoc().equals(maMonHoc)) {
                danhSachMonHoc.remove(i);
                System.out.println("Xóa môn học thành công.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy môn học có mã: " + maMonHoc);
        }
    }

    // Phương thức hiển thị thông tin môn học
    public void hienThiMonHoc() {
        if (danhSachMonHoc.isEmpty()) {
            System.out.println("Chưa có môn học nào.");
            return;
        }
        System.out.println("\nDanh sách môn học:");
        for (MonHoc monHoc : danhSachMonHoc) {
            monHoc.xuat();
            System.out.println("---------------------");
        }
    }

    // Phương thức tìm kiếm môn học
    public void timKiemMonHoc(String tuKhoa) {
        boolean found = false;
        for (MonHoc monHoc : danhSachMonHoc) {
            if (monHoc.getMaMonHoc().equals(tuKhoa) ||
                    monHoc.getTenMonHoc().equalsIgnoreCase(tuKhoa) ||
                    String.valueOf(monHoc.getSoTinChi()).equals(tuKhoa)) {
                monHoc.xuat();
                System.out.println("---------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy môn học nào phù hợp.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyMonHoc qlMonHoc = new QuanLyMonHoc();
        int luaChon;

        do {
            System.out.println("\n--- Quản lý môn học ---");
            System.out.println("1. Thêm môn học");
            System.out.println("2. Xóa môn học");
            System.out.println("3. Hiển thị thông tin môn học");
            System.out.println("4. Tìm kiếm môn học");
            System.out.println("0. Thoát");
            System.out.print("Chọn lựa chọn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

            switch (luaChon) {
                case 1:
                    qlMonHoc.themMonHoc();
                    break;
                case 2:
                    System.out.print("Nhập mã môn học cần xóa: ");
                    String maMonXoa = scanner.nextLine();
                    qlMonHoc.xoaMonHoc(maMonXoa);
                    break;
                case 3:
                    qlMonHoc.hienThiMonHoc();
                    break;
                case 4:
                    System.out.print("Nhập tên môn học, mã môn học hoặc số tín chỉ để tìm kiếm: ");
                    String tuKhoa = scanner.nextLine();
                    qlMonHoc.timKiemMonHoc(tuKhoa);
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
