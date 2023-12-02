package model;

import java.util.HashMap;
import java.util.Scanner;

public class QTFunction extends AbQTFunction {
   public QTFunction() {
   }

   Scanner inputs = new Scanner(System.in);

   public void findAcount(HashMap<String, String> data, TaiKhoan user) {
      System.out.print("nhan ma nhan vien:");
      String manv = inputs.nextLine();
      for (String key : data.keySet()) {
         if (data.get(key).equalsIgnoreCase(manv)) {
            System.out.println("ten tai khoan:" + key);
            System.out.println("mat khau:" + data.get(key));
            user.setUserName(key);
            user.setPass(manv);
            return;
         }
      }
      System.out.println("nhan vien khong ton tai");
   }

   @Override
   public void setAcount(TaiKhoan user, HashMap<String, String> data) {
      this.findAcount(data, user);
      if (user.getUserName().length() == 0) {
         return;
      }
      data.remove(user.getUserName());
      int select = 0;
      do {
         System.out.println("--------tuy chon sua------");
         System.out.println("1 su email nguoi dung");
         System.out.println("2.su mat khau nguoi dung");
         System.out.println("3.thoat");
         System.out.print("nhap tuy chon:");
         select = inputs.nextInt();
         if (select == 3) {
            System.out.println("---------------------------");
            System.out.println("thoat");
            System.out.println("----------------------------");
         }
         if (select < 1 || select > 2) {
            System.out.println("tuy chon khong chinh sac vui long nhap lai");
         }
      } while (select < 1 || select > 2);
      user.setUserName(inputs.nextLine());
      data.put(user.getUserName(), user.getPass());
   }
}
