class SinhVien {
    private String hoten; // Họ tên sinh viên
    private String mssv;  // Mã số sinh viên
    private String lop;    // Lớp

    // Hàm khởi tạo mặc định
    public SinhVien() {
        this.hoten = "Nguyễn Văn A";
        this.mssv = "123456";
        this.lop = "K01";
    }

    // Hàm khởi tạo với các đối số
    public SinhVien(String hoten, String mssv, String lop) {
        this.hoten = hoten;
        this.mssv = mssv;
        this.lop = lop;
    }

    // Phương thức trả về họ tên sinh viên
    public String getHoten() {
        return hoten;
    }

    // Phương thức trả về mã số sinh viên
    public String getMssv() {
        return mssv;
    }

    // Phương thức trả về lớp của sinh viên
    public String getLop() {
        return lop;
    }
}

public class bt5_tr88 {
    public static void main(String[] args) {
        // Tạo sinh viên với giá trị mặc định
        SinhVien sv1 = new SinhVien();
        System.out.println("Sinh viên 1:");
        System.out.println("Họ tên: " + sv1.getHoten());
        System.out.println("MSSV: " + sv1.getMssv());
        System.out.println("Lớp: " + sv1.getLop());

        // Tạo sinh viên với thông tin nhập từ người dùng
        SinhVien sv2 = new SinhVien("Trần Văn B", "654321", "K02");
        System.out.println("\nSinh viên 2:");
        System.out.println("Họ tên: " + sv2.getHoten());
        System.out.println("MSSV: " + sv2.getMssv());
        System.out.println("Lớp: " + sv2.getLop());
    }
}
