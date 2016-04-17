package kr.co.crescentcorp.buddytest.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.co.crescentcorp.buddytest.R;
import kr.co.crescentcorp.buddytest.register.Register1Activity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_createUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_createUser = (TextView) findViewById(R.id.textView_login_createUser);
        tv_createUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_login_createUser :
                Intent intent = new Intent(this, Register1Activity.class);
                startActivity(intent);
                break;
        }
    }
}
