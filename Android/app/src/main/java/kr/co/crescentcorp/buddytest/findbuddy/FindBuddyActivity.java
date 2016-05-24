package kr.co.crescentcorp.buddytest.findbuddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.crescentcorp.buddytest.R;
import kr.co.crescentcorp.buddytest.vo.User;

public class FindBuddyActivity extends AppCompatActivity {

    ActionBar actionBar;

    Animation ripple;
    Animation ripple2;
    User loginUser;

    @BindView(R.id.imageView_findBuddy_ring)
    ImageView ring1;

    @BindView(R.id.imageView_findBuddy_ring2)
    ImageView ring2;

    @OnClick(R.id.imageView_findBuddy_find)
    void toasttt(){
        Toast.makeText(this, loginUser.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_buddy);
        ButterKnife.bind(this);

        loginUser = getUserFromIntent();

        actionBar = getSupportActionBar();
        setCustomActionBar();

        ripple = AnimationUtils.loadAnimation(this, R.anim.ripple);
        ripple2 = AnimationUtils.loadAnimation(this, R.anim.ripple2);

        ring1.startAnimation(ripple);
        ring2.startAnimation(ripple2);
    }

    private User getUserFromIntent() {
        Intent intent = getIntent();
        return (User)intent.getSerializableExtra("User");
    }

    private void setCustomActionBar() {
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        View customView = LayoutInflater.from(this).inflate(R.layout.actionbar_findbuddy, null);
        actionBar.setCustomView(customView);

    }

}
