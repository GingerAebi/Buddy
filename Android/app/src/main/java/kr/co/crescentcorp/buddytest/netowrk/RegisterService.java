package kr.co.crescentcorp.buddytest.netowrk;

import kr.co.crescentcorp.buddytest.vo.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by GingerAebi on 2016. 5. 10..
 */
public interface RegisterService {
    @FormUrlEncoded
    @POST("/user/create")
    public Call<String> createUser(@Field("email") String email, @Field("password") String password, @Field("firstName") String firstName, @Field("lastName") String lastName, @Field("userType") int userType);

}
