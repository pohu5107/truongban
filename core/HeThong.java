package core;

import java.util.HashMap;
import java.util.List;

import service.PhanQuyen;
import service.User;
import service.Menu.NguoiQuanTri;
import service.Menu.qlNhanLuc;
import service.Menu.qlNhanSu;
import service.Menu.qlTaiChinh;
import service.Menu.TruongBan;

public class HeThong {
    public static Integer state = 10;

    public static void heThong() {
        if (state == 0) {
            return;
        }
        User newUser = new User();
        PhanQuyen newPhanQuyen = new PhanQuyen();
        newUser.login();
        newPhanQuyen.PhanQuyenTK(User.userAcount);
        return;
    }

    public static HashMap<String, String> getDATA(int selector) {
        Store init = new Store();
        if (selector == 1) {
            return Store.DATA_AC_NV;
        }
        if (selector == 2) {
            return Store.DATA_AC_QT;
        }
        if (selector == 3) {
            return Store.DATA_AC_NS;
        }
        if (selector == 4) {
            return Store.DATA_AC_NL;
        }
        if (selector == 5) {
            return Store.DATA_AC_TC;
        }
        if (selector == 6) {
            return Store.DATA_AC_TB;
        }
        return Store.UNDEFINE;
    }

    public static List<String> getList(int selector) {
        return Store.listNhanVien;
    }

    public static void setDATA() {

    }

    public static void connect(int selector) {
        switch (selector) {
            case 1: {
                System.out.println("chuc nang chua cap nhat");
                return;
            }
            case 2: {

                NguoiQuanTri.chucNang();
                if (state == 9) {
                    heThong();
                    return;
                }
                return;
            }
            case 3: {
                qlNhanSu.ChucNang();
                if (state == 9) {
                    heThong();
                    return;
                }
                return;
            }
            case 4: {
                qlNhanLuc.ChucNang();
                if (state == 9) {
                    heThong();
                    return;
                }
                return;
            }
            case 5: {
                qlTaiChinh.ChucNang();
                if (state == 9) {
                    heThong();
                    return;
                }
                return;
            }
            case 6:{ // phu dang lam
                TruongBan.ChucNang();
                if (state == 9) {
                    heThong();
                    return;
                }
                return;
            }

            default:
                return;
        }

    }

}