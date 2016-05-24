package kr.co.crescentcorp.buddytest.netowrk;

import java.io.IOException;

import kr.co.crescentcorp.buddytest.vo.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by GingerAebi on 2016. 5. 13..
 */
public class UserProxy {
    UserService service;

    public UserProxy(Retrofit retrofit) {
        service = retrofit.create(UserService.class);
    }

    public void registerUser(User user, Callback<String> callback) throws IOException {
        Call<String> call = service.createUser(user.email, user.password, user.firstName, user.lastName, user.userType);
        call.enqueue(callback);

    }

    public void login(User user, Callback<LoginResponse> callback) throws IOException {
        Call<LoginResponse> call = service.login(user.email, user.password);
        call.enqueue(callback);
    }

    public void loginBySession(String sessionKey, Callback<User> callback) throws IOException {
        Call<User> call = service.loginBySession(sessionKey);
        call.enqueue(callback);
    }


}
