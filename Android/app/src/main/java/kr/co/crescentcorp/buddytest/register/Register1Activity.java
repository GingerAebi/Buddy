package kr.co.crescentcorp.buddytest.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.crescentcorp.buddytest.R;
import kr.co.crescentcorp.buddytest.netowrk.Network;
import kr.co.crescentcorp.buddytest.netowrk.UserProxy;
import kr.co.crescentcorp.buddytest.util.PasswordMaker;
import kr.co.crescentcorp.buddytest.vo.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register1Activity extends AppCompatActivity {

    @BindView(R.id.editText_register_email)
    EditText et_email;
    @BindView(R.id.editText_register_lastName)
    EditText et_lastName;
    @BindView(R.id.editText_register_firstName)
    EditText et_firstName;
    @BindView(R.id.editText_register_pw)
    EditText et_password1;
    @BindView(R.id.editText_register_pwAgain)
    EditText et_password2;

    @BindView(R.id.imageView_register_check_id)
    ImageView iv_email_checker;
    @BindView(R.id.imageView_register_check_lastName)
    ImageView iv_lastName_checker;
    @BindView(R.id.imageView_register_check_firstName)
    ImageView iv_firstName_checker;
    @BindView(R.id.imageView_register_check_pw)
    ImageView iv_password1_checker;
    @BindView(R.id.imageView_register_check_pwAgain)
    ImageView iv_password2_checker;

    @BindView(R.id.imageButton_register_next)
    ImageButton btn_register_next;

    @BindView(R.id.textView_register_info)
    TextView tv_info;

    User user;

    private RegisterController registerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        ButterKnife.bind(this);
        validateUser();

    }

    private void validateUser() {

        registerController = new RegisterController();

        et_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (registerController.isEmail(s.toString())) {
                    iv_email_checker.setVisibility(View.VISIBLE);
                } else {
                    iv_email_checker.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                buttonCheck();
            }
        });
        et_lastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (registerController.isName(s.toString())) {
                    iv_lastName_checker.setVisibility(View.VISIBLE);
                } else {
                    iv_lastName_checker.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                buttonCheck();
            }
        });
        et_firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (registerController.isName(s.toString())) {
                    iv_firstName_checker.setVisibility(View.VISIBLE);
                } else {
                    iv_firstName_checker.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                buttonCheck();
            }
        });

        TextWatcher passWordWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password1 = et_password1.getText().toString();
                String password2 = et_password2.getText().toString();
                if (registerController.isPassword(password1, password2)) {
                    iv_password1_checker.setVisibility(View.VISIBLE);
                    iv_password2_checker.setVisibility(View.VISIBLE);
                } else {
                    iv_password1_checker.setVisibility(View.INVISIBLE);
                    iv_password2_checker.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                buttonCheck();
            }
        };
        et_password1.addTextChangedListener(passWordWatcher);
        et_password2.addTextChangedListener(passWordWatcher);

    }

    private void buttonCheck() {
        if (registerController.checkAll()) {
            btn_register_next.setClickable(true);
        } else {
            btn_register_next.setClickable(false);
        }
    }

    @OnClick(R.id.imageButton_register_next)
    void moveToNext() {
        user = getUser();
        register();
    }

    void register() {
        Network network = Network.getNetworkInstance();
        try {
            UserProxy userProxy = network.getUserProxy();
            userProxy.registerUser(user, new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.isSuccessful()) {
                        Log.i("UserProxy", "Network Success And " + response.body());
                        handleResponse(response.body());
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e("TEST","FAIL!!!" + t);
                }
            });
        } catch (Exception e) {
            Log.e("Register1Activity", "Register Failed by \n" + e);
        }
    }

    @NonNull
    private User getUser() {
        return new User(et_firstName.getText().toString(), et_lastName.getText().toString(), et_email.getText().toString(), PasswordMaker.make(et_password1.getText().toString()));
    }

    private void handleResponse(String response) {
        Log.i("TEST", "RESPONSE : " + response);
        if (response.equals("Email Already EXIST")) {
            tv_info.setText("!!! 이미 존재하는 이메일 입니다 !!!");
        } else if (response.equals("Create User Success")) {
            Intent intent = new Intent(this, Register2Activity.class);
            intent.putExtra("User", user);
            startActivity(intent);
            finish();
        } else {
            tv_info.setText("알 수 없는 응답");
        }
    }

}
