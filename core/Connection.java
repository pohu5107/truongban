package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface Action {
    public void get();

    public void set();

    public void create();

    public void change();
}

public class Connection implements Action {
    public static class State {
        public static String path_data_QuanTri = "Data\\QuanTri_data\\QuanTri.csv";
        public static String path_data_Nhansu = "Data\\NhanSu_data\\Nhansu.csv";
        public static String path_data_NhanVien = "Data\\NhanVien_data\\NhanVien.csv";
        public static String path_data_TaiChinh = "Data\\TaiChinh_data\\Luong.csv";
        public static String path_data_TruongBan = "Data\\TruongBan_data\\QuanLy.csv";

        public List<String[]> getData(String selector) {
            List<String[]> result = new ArrayList<>();
            try {
                FileReader fileread = new FileReader(selector);
                BufferedReader br = new BufferedReader(fileread);
                String line;
                line = br.readLine();
                while ((line = br.readLine()) != null) {
                    String arr[] = line.split(",");
                    result.add(arr);
                }
                br.close();
                fileread.close();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

            catch (IOException e) {
                e.printStackTrace();
            }

            return result;

        }
    }

    @Override
    public void get() {

    }

    @Override
    public void set() {

    }

    @Override
    public void create() {

    }

    @Override
    public void change() {

    }
}
