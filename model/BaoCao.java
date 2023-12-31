package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BaoCao {
    private String filePath = "Data\\TruongBan_data\\QuanLy.csv";

    // In nhan vien da nghi viec
    public void InNhanVienDaNghi() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.printf("%-30s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Ho Ten", "Ma Bo Phan", "Ma Phong", "Ngay Ky",
                    "Ngay Het Han", "Luong Khen Thuong","Luong Ki Luat");
            // bo qua dong dau tien
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 7 && !data[7].trim().isEmpty()) {
                    String hoTen = data[0].trim();
                    String maBoPhan = data[1].trim();
                    String maPhong = data[2].trim();
                    String ngayDangKyStr = data[4].trim();
                    String ngayHetHanStr = data[5].trim();
                    String luongKhenThuong = data[6].trim();
                    String luongKiLuat = data[7].trim();
                    // Chuyển đổi ngày từ chuỗi sang LocalDate
                    LocalDate ngayHetHan = parseLocalDate(ngayHetHanStr, "dd/MM/yyyy");
                    // Kiem tra neu ngay het han da qua thoi gian hien tai, in thong tin nhan vien nghi viec
                    if (ngayHetHan.isBefore(LocalDate.now())) {
                        System.out.printf("%-30s%-15s%-15s%-15s%-15s%-15s%-15s\n", hoTen, maBoPhan, maPhong, ngayDangKyStr,
                                ngayHetHanStr, luongKhenThuong, luongKiLuat);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // bao cao theo nhan vien con lam
    public void InNhanVienConLam() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.printf("%-30s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Ho Ten", "Ma Bo Phan", "Ma Phong", "Ngay Ky",
                    "Ngay Het Han", "Luong Khen Thuong","Luong Ki Luat");
            // Bỏ qua dòng đầu tiên (ghi chú)
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 7 && !data[6].trim().isEmpty()) {
                    String hoTen = data[0].trim();
                    String maBoPhan = data[1].trim();
                    String maPhong = data[2].trim();
                    String ngayDangKyStr = data[4].trim();
                    String ngayHetHanStr = data[5].trim();
                    String luongKhenThuong = data[6].trim();
                    String luongKiLuat = data[7].trim();
                    // Chuyển đổi ngày từ chuỗi sang localDate
                    LocalDate ngayHetHan = parseLocalDate(ngayHetHanStr, "dd/MM/yyyy");
                    // Lay nam hien tai, kiem tra nhan vien còn lam trong nãm nay
                    if (ngayHetHan.isAfter(LocalDate.now()) || ngayHetHan.isEqual(LocalDate.now())) {
                        System.out.printf("%-30s%-15s%-15s%-15s%-15s%-15s%-15s\n", hoTen, maBoPhan, maPhong, ngayDangKyStr,
                                ngayHetHanStr, luongKhenThuong, luongKiLuat);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static LocalDate parseLocalDate(String dateString, String... formats) {
        for (String format : formats) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                return LocalDate.parse(dateString, formatter);
            } catch (Exception e) {
                // Bỏ qua khi có lỗi
            }
        }
        return null;
    }


    // bao cao thong tin theo chuc vu
    public void InTheoChucVu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chon chuc vu (1. Nhan vien, 2. Quan ly): ");
        int choice = scanner.nextInt();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.printf("%-30s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Ho Ten", "Ma Bo Phan", "Ma Phong", "Ngay Ky",
                    "Ngay Het Han", "Luong Khen Thuong","Luong Ki Luat");
            // Bỏ qua dòng đầu tiên (ghi chú)
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Kiểm tra nếu nhân viên có lương khen thưởng
                if (data.length >= 7 && !data[6].trim().isEmpty()) {
                    String hoTen = data[0].trim();
                    String maBoPhan = data[1].trim();
                    String maPhong = data[2].trim();
                    String ngayDangKyStr = data[4].trim();
                    String ngayHetHanStr = data[5].trim();
                    String luongKhenThuong = data[6].trim();
                    String luongKiLuat = data[7].trim();
                    // Kiểm tra chức vụ
                    switch (choice) {
                        case 1: // Nhan vien
                            if ("nhan vien".equalsIgnoreCase(data[3].trim())) {
                                System.out.printf("%-30s%-15s%-15s%-15s%-15s%-15s%-15s\n", hoTen, maBoPhan, maPhong,
                                        ngayDangKyStr, ngayHetHanStr, luongKhenThuong, luongKiLuat);
                            }
                            break;
                        case 2: // Quan ly
                            if ("quan ly".equalsIgnoreCase(data[3].trim())) {
                                System.out.printf("%-30s%-15s%-15s%-15s%-15s%-15s%-15s\n", hoTen, maBoPhan, maPhong,
                                        ngayDangKyStr, ngayHetHanStr, luongKhenThuong, luongKiLuat);
                            }
                            break;
                        default:
                            System.out.println("Lua chon khong hop le.");
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
