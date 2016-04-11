package kr.co.crescentcorp.buddytest.tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import kr.co.crescentcorp.buddytest.R;
import kr.co.crescentcorp.buddytest.tutorial.TutorialActivity;


public class StartActivity extends AppCompatActivity {
    private ImageView startButton;
    private Context mContext;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mContext = this;

        startButton = (ImageView) findViewById(R.id.imageView_tutorial1_start_btn);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,TutorialActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}


