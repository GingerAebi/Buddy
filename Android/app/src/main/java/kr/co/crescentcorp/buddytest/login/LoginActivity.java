package kr.co.crescentcorp.buddytest.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.crescentcorp.buddytest.findbuddy.FindBuddyActivity;
import kr.co.crescentcorp.buddytest.R;
import kr.co.crescentcorp.buddytest.netowrk.Network;
import kr.co.crescentcorp.buddytest.register.Register1Activity;
import kr.co.crescentcorp.buddytest.util.PasswordMaker;
import kr.co.crescentcorp.buddytest.vo.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.editText_login_email)
    EditText et_email;

    @BindView(R.id.editText_login_password)
    EditText et_password;

    private User user;
    private Network network;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        network = Network.getNetworkInstance();
    }

    @OnClick(R.id.imageButton_login)
    void login() {
        user = new User(et_email.getText().toString(), PasswordMaker.make(et_password.getText().toString()));

        try {
            network.getUserProxy().login(user, new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        handleResponse(response.body());
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            Log.e("LoginActivity", "Login Failed By " + e);
        }

    }

    public void handleResponse(String responseBody) {
        Log.i("login", responseBody);
        if (responseBody.equals("Login_Success")) {
            Log.i("login", responseBody);
            Intent intent = new Intent(this, FindBuddyActivity.class);
            startActivity(intent);

        } else {
            Log.i("login", "" + responseBody.equals("Login_Success"));
        }
    }


    @OnClick(R.id.textView_login_createUser)
    void createUser() {
        Intent intent = new Intent(this, Register1Activity.class);
        startActivity(intent);
    }
}

