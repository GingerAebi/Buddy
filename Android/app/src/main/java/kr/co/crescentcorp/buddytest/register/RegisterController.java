package kr.co.crescentcorp.buddytest.register;

public class RegisterController {

    public boolean emailCheck;
    public boolean nameCheck;
    public boolean passwordCheck;

    public boolean checkAll() {
        if (emailCheck && nameCheck && passwordCheck) {
            return true;
        }
        return false;
    }

    public boolean isEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            return emailCheck = true;
        }
        return emailCheck = false;
    }

    public boolean isName(String name) {
        if (name.length() > 0) {
            return nameCheck = true;
        }
        return nameCheck = false;
    }

    public boolean isPassword(String password1, String password2) {
        if(password1.length() > 5 && password1.equals(password2)) {
            return passwordCheck = true;
        }
        return passwordCheck = false;
    }
}
