public class xemay  implements sanpham{
    public int gia(String s_model){
        if(s_model.equals("2005"))
            return (2000);
        else return (1500);
    }
    public String getnhasx(){
        return (nhasx);
    }
    public static void main(String args[])
    {
        xemay Xemay = new xemay();
        System.out.println("Ten nha san xuat:  "+ Xemay.getnhasx());
    }
}
