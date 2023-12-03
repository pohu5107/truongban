package model;

import java.util.Scanner;

public class NhanVien extends ConNguoi {
    Scanner sc = new Scanner(System.in);
    private String MaNV;
    private String MaBoPhan;
    private String MaPhong;
    private String ChucVu;
    private String LoaiHD;
    private String NgayKy;
    private String NgayHetHan;
    private String Gmail;

    public NhanVien() {
        super();

    }

    public NhanVien(String MaNV, String HoTen, String MaBoPhan, String MaPhong,
            String ChucVu, String LoaiHD, String NgayKiHD, String NgayHetHan, String Gmail) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.MaBoPhan = MaBoPhan;
        this.MaPhong = MaPhong;
        this.ChucVu = ChucVu;
        this.LoaiHD = LoaiHD;
        this.NgayKy = NgayKiHD;
        this.NgayHetHan = NgayHetHan;
        this.Gmail = Gmail;
    }

    public NhanVien(String HoTen, String GioiTinh, String DiaChi, String QueQuan, String NgaySinh, String SoDT,
            String DanToc, String TonGiao, String HocVan, String MaNV, String MaBoPhan, String MaPhong,
            String ChucVu, String LoaiHD, String NgayKiHD, String NgayHetHan, String Gmail) {
        super(HoTen, GioiTinh, DiaChi, QueQuan, NgaySinh, SoDT, DanToc, TonGiao, HocVan);
        this.MaNV = MaNV;
        this.MaBoPhan = MaBoPhan;
        this.MaPhong = MaPhong;
        this.ChucVu = ChucVu;
        this.LoaiHD = LoaiHD;
        this.NgayKy = NgayKiHD;
        this.NgayHetHan = NgayHetHan;
        this.Gmail = Gmail;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = sc.nextLine();
    }

    public String getMaBoPhan(){
        return MaBoPhan;
    }

    public void setMaBoPhan(String MaBoPhan){
        this.MaBoPhan = MaBoPhan;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = sc.nextLine();
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = sc.nextLine();
    }

    public String getLoaiHD() {
        return LoaiHD;
    }

    public void setLoaiHD(String LoaiHD) {
        this.LoaiHD = sc.nextLine();
    }

    public String getNgayKy() {
        return NgayKy;
    }

    public void setNgayKy(String NgayKy) {
        this.NgayKy = sc.nextLine();
    }

    public String getNgayHetHan() {
        return NgayHetHan;
    }

    public void setNgayHetHan(String NgayHetHan) {
        this.NgayHetHan = sc.nextLine();
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String Gmail) {
        this.Gmail = sc.nextLine();
    }

    public void input() {
        super.input();
        System.out.print("Nhap Ma Nhan Vien: ");
        setMaNV(MaNV);
        System.out.println("Nhap Ma Bo Phan: ");
        setMaBoPhan(MaBoPhan);
        System.out.print("Nhap Ma Phong: ");
        setMaPhong(MaPhong);
        System.out.print("Nhap Chuc Vu: ");
        setChucVu(ChucVu);
        System.out.print("Nhap LoaiHD: ");
        setLoaiHD(LoaiHD);
        System.out.print("Nhap Ngay Ky: ");
        setNgayKy(NgayKy);
        System.out.print("Nhap Ngay Het Han: ");
        setNgayHetHan(NgayHetHan);
        System.out.print("Nhap Gmail: ");
        setGmail(Gmail);
    }

    public String toString() {
        return getMaNV() + "| " + getMaBoPhan() + "| " + getMaPhong() + "| " + getChucVu() + "| " +
                getLoaiHD() + "| " + getNgayKy() + "| " + getNgayHetHan() + "| " + getGmail();
    }

    

}