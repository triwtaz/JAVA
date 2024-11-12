import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Dates {
    protected int ngay;   // Ngày
    protected int thang;  // Tháng
    protected int nam;    // Năm

    // Hàm khởi tạo mặc định
    public Dates() {
        this.ngay = 1;
        this.thang = 1;
        this.nam = 2000;
    }

    // Hàm khởi tạo có tham số
    public Dates(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    // Phương thức nhập ngày
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày: ");
        this.ngay = scanner.nextInt();
        System.out.print("Nhập tháng: ");
        this.thang = scanner.nextInt();
        System.out.print("Nhập năm: ");
        this.nam = scanner.nextInt();
    }

    // Phương thức xuất ngày
    public void xuat() {
        System.out.printf("%02d/%02d/%04d\n", ngay, thang, nam);
    }
}

class Nguois extends Dates {
    private String hoLot;   // Họ lót
    private String ten;     // Tên
    private String diaChi;  // Địa chỉ
    private String soCCCD;  // Số CCCD

    // Hàm khởi tạo mặc định
    public Nguois() {
        super();
        this.hoLot = "Nguyễn";
        this.ten = "An";
        this.diaChi = "Hà Nội";
        this.soCCCD = "123456789";
    }

    // Hàm khởi tạo có tham số
    public Nguois(String hoLot, String ten, String diaChi, int ngay, int thang, int nam, String soCCCD) {
        super(ngay, thang, nam);
        this.hoLot = hoLot;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soCCCD = soCCCD;
    }

    // Phương thức nhập thông tin người
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ lót: ");
        hoLot = scanner.nextLine();
        System.out.print("Nhập tên: ");
        ten = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        diaChi = scanner.nextLine();
        System.out.print("Nhập số CCCD: ");
        soCCCD = scanner.nextLine();
        System.out.println("Nhập ngày sinh:");
        super.nhap(); // Nhập ngày từ lớp Date
    }

    // Phương thức xuất thông tin người
    public void xuat() {
        System.out.println("Họ lót: " + hoLot);
        System.out.println("Tên: " + ten);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.print("Ngày sinh: ");
        super.xuat(); // Xuất ngày từ lớp Date
        System.out.println("Số CCCD: " + soCCCD);
    }

    // Getter cho số CCCD
    public String getSoCCCD() {
        return soCCCD;
    }

    // Getter cho tên
    public String getTen() {
        return ten;
    }

    // Phương thức để so sánh theo tên
    public String getHoTen() {
        return hoLot + " " + ten;
    }
}

public class bt8_tr89 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Nguoi> danhSachNguoi = new ArrayList<>();

        System.out.print("Nhập số lượng người: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm

        // Nhập danh sách người
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin người thứ " + (i + 1) + ":");
            Nguoi nguoi = new Nguoi();
            nguoi.nhap();
            danhSachNguoi.add(nguoi);
        }

        // In danh sách người
        System.out.println("\nDanh sách người:");
        for (Nguoi nguoi : danhSachNguoi) {
            nguoi.xuat();
            System.out.println("---------------------");
        }

        // Tìm kiếm thông tin người theo số CCCD
        System.out.print("Nhập số CCCD để tìm: ");
        String soCCCDTim = scanner.nextLine();
        boolean found = false;

        for (Nguoi nguoi : danhSachNguoi) {
            if (nguoi.getSoCCCD().equals(soCCCDTim)) {
                System.out.println("Thông tin người có số CCCD " + soCCCDTim + ":");
                nguoi.xuat();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy người có số CCCD " + soCCCDTim);
        }

        // Sắp xếp danh sách theo thứ tự Alphabet
        Collections.sort(danhSachNguoi, new Comparator<Nguoi>() {
            @Override
            public int compare(Nguoi n1, Nguoi n2) {
                return n1.getHoTen().compareTo(n2.getHoTen());
            }
        });

        // In danh sách sau khi sắp xếp
        System.out.println("\nDanh sách người sau khi sắp xếp theo thứ tự Alphabet:");
        for (Nguoi nguoi : danhSachNguoi) {
            nguoi.xuat();
            System.out.println("---------------------");
        }
    }
}
