package kr.co.crescentcorp.buddytest.netowrk;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GingerAebi on 2016. 5. 13..
 */
public class Network {

    private static Network network;

    private Retrofit retrofit;
    private UserProxy userProxy;

    public static Network getNetworkInstance() {
        if(network == null) {
            network = new Network();
        }
        return network;
    }

    private Network() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder().baseUrl("http://188.166.210.190:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        userProxy = new UserProxy(retrofit);
    }

    public UserProxy getUserProxy() {
        return userProxy;
    }

}