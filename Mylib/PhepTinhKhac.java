package Mylib;
public class PhepTinhKhac {
    public int luyThua(int a,int b) { int kq=1;
        for(int i=1;i<=b;i++) kq *= a;
        return kq;
    }
    public int giaiThua(int n) { int kq=1;
        for(int i=1;i<=n;i++) kq *= i;
        return kq; }
}