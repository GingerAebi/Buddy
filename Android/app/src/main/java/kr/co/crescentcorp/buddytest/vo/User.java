package kr.co.crescentcorp.buddytest.vo;

/**
 * Created by GingerAebi on 2016. 5. 10..
 */
public class User {
    public static final int USERTYPE_BUDDY = 1;

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public int userType;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userType = 1;
    }
}
