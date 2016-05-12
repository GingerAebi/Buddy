package kr.co.crescentcorp.buddytest.netowrk;

import android.util.Log;

import java.io.IOException;

import kr.co.crescentcorp.buddytest.vo.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by GingerAebi on 2016. 5. 13..
 */
public class RegisterProxy {
    RegisterService service;

    public RegisterProxy(Retrofit retrofit) {
        service = retrofit.create(RegisterService.class);
    }

    public void registerUser(User user, Callback<String> callback) throws IOException {
        Call<String> call = service.createUser(user.email, user.password, user.firstName, user.lastName, user.userType);
        call.enqueue(callback);

    }

}
