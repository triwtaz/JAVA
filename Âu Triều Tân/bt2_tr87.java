import java.util.Scanner;

class Clock {
    private int hours;   // Giờ
    private int minutes; // Phút
    private int seconds; // Giây

    // Hàm gán để khởi tạo 1 Clock
    public void setClock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        normalize(); // Đảm bảo giá trị hợp lệ
    }

    // Hàm nhập giá trị
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giờ: ");
        this.hours = scanner.nextInt();
        System.out.print("Nhập phút: ");
        this.minutes = scanner.nextInt();
        System.out.print("Nhập giây: ");
        this.seconds = scanner.nextInt();
        normalize(); // Đảm bảo giá trị hợp lệ
    }

    // Hàm in giá trị ra màn hình
    public void print() {
        System.out.printf("Thời gian: %02d:%02d:%02d%n", hours, minutes, seconds);
    }

    // Hàm làm tròn thời gian
    public void roundTime() {
        // Lấy số giây thừa từ giây
        int extraSeconds = seconds / 60;
        seconds = seconds % 60;

        // Cộng phút từ giây thừa
        minutes += extraSeconds;

        // Lấy số phút thừa từ phút
        int extraMinutes = minutes / 60;
        minutes = minutes % 60;

        // Cộng giờ từ phút thừa
        hours += extraMinutes;

        // Làm tròn giờ (giờ có thể vượt quá 24)
        hours = hours % 24;
    }

    // Hàm đảm bảo giá trị hợp lệ
    private void normalize() {
        // Chuyển đổi giây thành phút
        int extraMinutes = seconds / 60;
        seconds = seconds % 60;
        minutes += extraMinutes;

        // Chuyển đổi phút thành giờ
        int extraHours = minutes / 60;
        minutes = minutes % 60;
        hours += extraHours;

        // Chuyển đổi giờ (giờ có thể vượt quá 24)
        hours = hours % 24;
    }
}

public class bt2_tr87 {
    public static void main(String[] args) {
        // Tạo 1 Clock có giá trị là: 9:15:38
        Clock clock1 = new Clock();
        clock1.setClock(9, 15, 38);
        System.out.print("Giá trị Clock 1: ");
        clock1.print();

        // Tạo 1 Clock bất kỳ nhập giá trị cho nó
        Clock clock2 = new Clock();
        clock2.input();
        System.out.print("Giá trị Clock 2: ");
        clock2.print();

        // Làm tròn Clock vừa nhập ở trên (nếu được) và in ra màn hình
        clock2.roundTime();
        System.out.print("Giá trị Clock 2 sau khi làm tròn: ");
        clock2.print();
    }
}
