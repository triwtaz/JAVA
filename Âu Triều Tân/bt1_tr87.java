import java.util.Scanner;

class Diem {
    private int x; // Hoành độ
    private int y; // Tung độ

    // Hàm gán tọa độ cho 1 điểm
    public void Gan(int hoanh, int tung) {
        this.x = hoanh;
        this.y = tung;
    }

    // Hàm nhập tọa độ cho 1 điểm
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập hoành độ: ");
        this.x = scanner.nextInt();
        System.out.print("Nhập tung độ: ");
        this.y = scanner.nextInt();
    }

    // Hàm in ra màn hình tọa độ điểm theo dạng (x,y)
    public void Indiem() {
        System.out.println("(" + x + ", " + y + ")");
    }

    // Hàm xuất ra giá trị hoành độ của điểm
    public int PutX() {
        return x;
    }

    // Hàm xuất ra giá trị tung độ của điểm
    public int PutY() {
        return y;
    }

    // Hàm tính khoảng cách từ điểm đến gốc tọa độ
    public double KhoangCachGoc() {
        return Math.sqrt(x * x + y * y);
    }

    // Hàm tạo điểm đối xứng qua gốc tọa độ
    public Diem DiemDoiXung() {
        Diem d = new Diem();
        d.Gan(-this.x, -this.y);
        return d;
    }

    // Tính khoảng cách A đến B
    public double KhoangCach(Diem d) {
        return Math.sqrt(Math.pow(this.x - d.x, 2) + Math.pow(this.y - d.y, 2));
    }
}
public class bt1_tr87 {
    public static void main(String[] args) {
        // Tạo ra điểm A tọa độ (6,8)
        Diem A = new Diem();
        A.Gan(6, 8);
        System.out.print("Tọa độ điểm A: ");
        A.Indiem();

        // Tạo ra điểm B với giá trị nhập từ bàn phím
        Diem B = new Diem();
        B.Nhap();
        System.out.print("Tọa độ điểm B: ");
        B.Indiem();

        // Tạo ra điểm C đối xứng với điểm B qua gốc tọa độ
        Diem C = B.DiemDoiXung();
        System.out.print("Tọa độ điểm C (đối xứng B qua gốc tọa độ): ");
        C.Indiem();

        // Tính khoảng cách từ điểm B đến gốc tọa độ
        double khoangCachB = B.KhoangCachGoc();
        System.out.println("Khoảng cách từ điểm B đến gốc tọa độ: " + khoangCachB);

        // Tính khoảng cách từ điểm A đến gốc toạ độ
        double khoangCachA = A.KhoangCachGoc();
        System.out.println("Khoảng cách từ điểm A đến gốc tọa độ: " + khoangCachA);

        // Tính khoảng cách giữa hai điểm A và B
        double khoangCachAB = A.KhoangCach(B);
        System.out.println("Khoảng cách giữa điểm A và B: " + khoangCachAB);
    }
}
