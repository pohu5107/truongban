package model;

interface check {
    public boolean checkEmail(String email);

    public boolean nullInput(String input);

    public boolean dateFormat(String input);
}

public class checkError implements check {
    @Override
    public boolean checkEmail(String email) {
        String ePattern = "^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    @Override
    public boolean nullInput(String input) {
        return input.length() == 0;
    }

    @Override
    public boolean dateFormat(String input) {
        // dinh dang ngay thang dd/mm/yy vd:02/12/2023
        return input.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})");
    }

}
