package kr.co.crescentcorp.buddytest.tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.crescentcorp.buddytest.R;
import kr.co.crescentcorp.buddytest.login.LoginActivity;


public class StartActivity extends AppCompatActivity {
    private ImageView startButton;
    private Context mContext;

    @OnClick(R.id.textView_tutorial1_login)
    void login() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mContext = this;

        startButton = (ImageView) findViewById(R.id.imageView_tutorial1_start_btn);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TutorialActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}


