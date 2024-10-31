package Mylib;//import Mylib.*;

import java.util.Scanner; class TestPackage
{
    public static void main(String args[]) { int a,b;
        PhepTinh pheptinh = new PhepTinh();
        PhepTinhKhac ptkhac = new PhepTinhKhac();
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen a: ");
        a = nhap.nextInt(); System.out.print("Nhap vao so nguyen b: ");
        b = nhap.nextInt();
        System.out.println("Tong cua "+a+"+"+b+"= "+pheptinh.cong(a,b));
        System.out.println("Hieu cua "+a+"-"+b+"= "+pheptinh.tru(a,b));
        System.out.println("Tich cua "+a+"*"+b+"= "+pheptinh.nhan(a,b));
        System.out.println("Thuong nguyen cua "+a+"/"+b+"= "+pheptinh.chianguyen(a,b));
        System.out.println("Thuong du cua "+a+"/"+b+"= "+pheptinh.chiadu(a,b));
        System.out.println("Ket qua "+a+"^"+b+" = "+ ptkhac.luyThua(a,b));
        System.out.println("Ket qua "+a+"! = "+ ptkhac.giaiThua(a));
        System.out.println("Ket qua "+b+"! = "+ ptkhac.giaiThua(b)); }
}