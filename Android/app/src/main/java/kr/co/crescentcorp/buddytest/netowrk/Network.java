package kr.co.crescentcorp.buddytest.netowrk;

import java.util.logging.Level;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GingerAebi on 2016. 5. 13..
 */
public class Network {

    private Retrofit retrofit;

    public Network() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …

// add logging as last interceptor
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder().baseUrl("http://188.166.210.190:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public RegisterProxy getRegisterProxy() {
        return new RegisterProxy(retrofit);
    }
}
