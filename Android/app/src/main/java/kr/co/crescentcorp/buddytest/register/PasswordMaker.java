package kr.co.crescentcorp.buddytest.register;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by GingerAebi on 2016. 5. 13..
 */
public class PasswordMaker {
    public static  String make(String password) {
        return makeSHA256(password);
    }


    private static String makeSHA256(String str){
        String SHA = "";
        try{
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(str.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < byteData.length ; i++){
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
            }
            SHA = sb.toString();

        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
            SHA = null;
        }
        return SHA;
    }
}
