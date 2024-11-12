import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Nguoi {
    private String hoTen;
    private int namSinh;
    private String gioiTinh;
    private String diaChi;
    private String soCCCD;

    // Phương thức khởi tạo
    public Nguoi(String hoTen, int namSinh, String gioiTinh, String diaChi, String soCCCD) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soCCCD = soCCCD;
    }

    public Nguoi() {

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

    // Getter cho họ tên
    public String getHoTen() {
        return hoTen;
    }

    // Getter cho CCCD
    public String getSoCCCD() {
        return soCCCD;
    }
}

class DanhBa {
    private String soDienThoai;
    private Nguoi chuThueBao;
    private int soPhutGoi;

    // Phương thức khởi tạo
    public DanhBa(String soDienThoai, Nguoi chuThueBao, int soPhutGoi) {
        this.soDienThoai = soDienThoai;
        this.chuThueBao = chuThueBao;
        this.soPhutGoi = soPhutGoi;
    }

    // Phương thức nhập thông tin
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số điện thoại: ");
        soDienThoai = scanner.nextLine();
        chuThueBao.nhap();
        System.out.print("Nhập số phút gọi: ");
        soPhutGoi = scanner.nextInt();
    }

    // Phương thức xuất thông tin
    public void xuat() {
        System.out.println("Số điện thoại: " + soDienThoai);
        chuThueBao.xuat();
        System.out.println("Số phút gọi: " + soPhutGoi);
        System.out.println("Cước chưa có thuế: " + tinhCuoc());
    }

    // Hàm tính cước điện thoại chưa có thuế
    public int tinhCuoc() {
        int cuocThueBao = 27000; // Cước thuê bao
        int cuocPhutGoi = 0;

        if (soPhutGoi <= 200) {
            cuocPhutGoi = soPhutGoi * 120;
        } else if (soPhutGoi <= 1000) {
            cuocPhutGoi = 200 * 120 + (soPhutGoi - 200) * 80;
        } else {
            cuocPhutGoi = 200 * 120 + 800 * 80 + (soPhutGoi - 1000) * 40;
        }

        return cuocThueBao + cuocPhutGoi;
    }

    // Getter cho số điện thoại
    public String getSoDienThoai() {
        return soDienThoai;
    }
}

public class bt4_tr88 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<DanhBa> danhBaList = new ArrayList<>();
        int tongSoTien = 0;

        System.out.print("Nhập số lượng thuê bao: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin thuê bao thứ " + (i + 1) + ":");
            DanhBa danhBa = new DanhBa("", new Nguoi("", 0, "", "", ""), 0);
            danhBa.nhap();
            danhBaList.add(danhBa);
            tongSoTien += danhBa.tinhCuoc();
        }

        System.out.println("\nDanh sách thuê bao:");
        for (DanhBa db : danhBaList) {
            db.xuat();
            System.out.println("---------------------");
        }

        System.out.println("Tổng số tiền thu được: " + tongSoTien + " đồng");

        // Tìm thông tin thuê bao theo số điện thoại
        System.out.print("Nhập số điện thoại để tìm: ");
        String soDienThoaiTim = scanner.nextLine();
        boolean found = false;

        for (DanhBa db : danhBaList) {
            if (db.getSoDienThoai().equals(soDienThoaiTim)) {
                System.out.println("Thông tin thuê bao có số điện thoại " + soDienThoaiTim + ":");
                db.xuat();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy thuê bao có số điện thoại " + soDienThoaiTim);
        }
    }
}
