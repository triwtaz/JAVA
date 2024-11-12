class MyPham {
    protected String tenmp; // Tên mỹ phẩm
    protected String nhasx;  // Nhà sản xuất
    protected int dongia;    // Đơn giá

    // Hàm khởi tạo mặc định
    public MyPham() {
        this.tenmp = "Mỹ phẩm mặc định";
        this.nhasx = "Nhà sản xuất mặc định";
        this.dongia = 100000; // Đơn giá mặc định
    }

    // Hàm khởi tạo với tham số
    public MyPham(String tenmp, String nhasx, int dongia) {
        this.tenmp = tenmp;
        this.nhasx = nhasx;
        this.dongia = dongia;
    }

    // Phương thức tính giá bán
    public float giaBan() {
        return dongia + (dongia * 0.05f); // Giá bán = đơn giá + 5%
    }

    // Phương thức tính thành tiền
    public float thanhTien(int soluong) {
        return soluong * dongia; // Thành tiền = số lượng * đơn giá
    }

    // Phương thức xuất thông tin
    public void xuatThongTin() {
        System.out.println("Tên mỹ phẩm: " + tenmp);
        System.out.println("Nhà sản xuất: " + nhasx);
        System.out.println("Đơn giá: " + dongia);
    }
}

class DauGoi extends MyPham {

    // Hàm khởi tạo với tham số
    public DauGoi(String tenmp, String nhasx, int dongia) {
        super(tenmp, nhasx, dongia);
    }

    // Cài đặt lại phương thức giá bán
    @Override
    public float giaBan() {
        return dongia * 1.5f; // Giá bán = đơn giá * 1.5
    }

    // Cài đặt lại phương thức tính thành tiền
    @Override
    public float thanhTien(int soluong) {
        return super.thanhTien(soluong) * 1.05f; // Thành tiền nhân thêm 5% thuế VAT
    }
}

public class bt6_tr88 {
    public static void main(String[] args) {
        // Tạo đối tượng MyPham
        MyPham myPham = new MyPham("Kem chống nắng", "Công ty A", 200000);
        myPham.xuatThongTin();
        System.out.println("Giá bán: " + myPham.giaBan());
        System.out.println("Thành tiền cho 3 sản phẩm: " + myPham.thanhTien(3));
        System.out.println("---------------------");

        // Tạo đối tượng DauGoi
        DauGoi dauGoi = new DauGoi("Dầu gội X", "Công ty B", 150000);
        dauGoi.xuatThongTin();
        System.out.println("Giá bán: " + dauGoi.giaBan());
        System.out.println("Thành tiền cho 2 sản phẩm: " + dauGoi.thanhTien(2));
    }
}
