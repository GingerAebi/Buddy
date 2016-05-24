package kr.co.crescentcorp.buddytest;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import kr.co.crescentcorp.buddytest.findbuddy.FindBuddyActivity;
import kr.co.crescentcorp.buddytest.netowrk.Network;
import kr.co.crescentcorp.buddytest.netowrk.UserProxy;
import kr.co.crescentcorp.buddytest.tutorial.StartActivity;
import kr.co.crescentcorp.buddytest.login.LoginActivity;
import kr.co.crescentcorp.buddytest.vo.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private UserProxy userProxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = this;
        Network network = Network.getNetworkInstance();
        userProxy = network.getUserProxy();
        String sessionKey = getSessionKey();
        Log.i("MainActivity",sessionKey);

        if (!sessionKey.equals("ERROR")) {
            sessionLogin(sessionKey);
        }else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void sessionLogin(String sessionKey) {
        try {
            userProxy.loginBySession(sessionKey, new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        handleResponse(response.body());
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(context, "Network error1", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException e) {
            Toast.makeText(context, "Network error2", Toast.LENGTH_SHORT).show();
            Log.e("MainActivity", e.toString());
        }
    }

    private void handleResponse(User user) {
        Intent intent = new Intent(this, FindBuddyActivity.class);
        intent.putExtra("User", user);
        startActivity(intent);
        finish();
    }

    public String getSessionKey() {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        return pref.getString("SessionKey", "ERROR");
    }

}
