package kr.co.crescentcorp.buddytest.register;

/**
 * Created by JaeBong on 2016-04-17.
 */
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

    public boolean emailCheck(String email) {
        if (email.contains("@") && email.contains(".")) {
            return emailCheck = true;
        }
        return emailCheck = false;
    }

    public boolean nameCheck(String name) {
        if (name.length() > 0) {
            return nameCheck = true;
        }
        return nameCheck = false;
    }
}
