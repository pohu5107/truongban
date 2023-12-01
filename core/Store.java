package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Store {

    public static HashMap<String, String> DATA_AC_NV = new HashMap<>();
    public static HashMap<String, String> DATA_AC_QT = new HashMap<>();
    public static HashMap<String, String> DATA_AC_NS = new HashMap<>();
    public static HashMap<String, String> DATA_AC_TC = new HashMap<>();
    public static HashMap<String, String> DATA_AC_NL = new HashMap<>();
    public static HashMap<String, String> DATA_AC_TB = new HashMap<>();
    public static HashMap<String, String> UNDEFINE = new HashMap<>();
    public static List<String> listNhanVien = new ArrayList<>();

    public Store() {
        Connection.State request = new Connection.State();
        List<String[]> response_quantri = request.getData(Connection.State.path_data_QuanTri);
        for (String[] value : response_quantri) {
            if (value[0].equalsIgnoreCase("quan tri")) {
                DATA_AC_QT.put(value[1], value[2]);
            } else if (value[0].equalsIgnoreCase("nhan vien")) {
                DATA_AC_NV.put(value[1], value[2]);
            } else if (value[0].equalsIgnoreCase("tai chinh")) {
                DATA_AC_TC.put(value[1], value[2]);
            } else if (value[0].equalsIgnoreCase("nhan luc")) {
                DATA_AC_NL.put(value[1], value[2]);
            } else if (value[0].equalsIgnoreCase("nhan su")) {
                DATA_AC_NS.put(value[1], value[2]);
            } else if (value[0].equalsIgnoreCase("truong ban")) {
                DATA_AC_TB.put(value[1], value[2]);
            }
        }
        List<String[]> response_nhanvien = request.getData(Connection.State.path_data_QuanTri);
        
        List<String[]> response_truongban = request.getData(Connection.State.path_data_QuanTri);


        for (String[] value : response_nhanvien) {

        }

        for(String[] value : response_truongban){

        }
        
    }

}