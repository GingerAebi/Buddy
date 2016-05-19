package kr.co.crescentcorp.buddytest.vo;

import java.io.Serializable;

/**
 * Created by GingerAebi on 2016. 5. 10..
 */
public class User implements Serializable{
    public static final int USERTYPE_BUDDY = 1;

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public int userType;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userType = 1;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
