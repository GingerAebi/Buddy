package kr.co.crescentcorp.buddytest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import kr.co.crescentcorp.buddytest.tutorial.StartActivity;
import kr.co.crescentcorp.buddytest.user.CreateUserActivity;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = this;

        findViewById(R.id.button_main_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CreateUserActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.button_main_tutorial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StartActivity.class);
                startActivity(intent);
            }
        });

    }
}
