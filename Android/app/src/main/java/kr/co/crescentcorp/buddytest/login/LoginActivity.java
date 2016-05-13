package kr.co.crescentcorp.buddytest.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.crescentcorp.buddytest.R;
import kr.co.crescentcorp.buddytest.register.Register1Activity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.textView_login_createUser) void createUser() {

        Intent intent = new Intent(this, Register1Activity.class);
        startActivity(intent);
    }
}

