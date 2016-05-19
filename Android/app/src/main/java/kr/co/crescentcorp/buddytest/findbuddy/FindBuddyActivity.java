package kr.co.crescentcorp.buddytest.findbuddy;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.crescentcorp.buddytest.R;

public class FindBuddyActivity extends AppCompatActivity {

    ActionBar actionBar;

    Animation ripple;
    Animation ripple2;

    @BindView(R.id.imageView_findBuddy_ring)
    ImageView ring1;

    @BindView(R.id.imageView_findBuddy_ring2)
    ImageView ring2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_buddy);
        ButterKnife.bind(this);

        actionBar = getSupportActionBar();
        setCustomActionBar();

        ripple = AnimationUtils.loadAnimation(this, R.anim.ripple);
        ripple2 = AnimationUtils.loadAnimation(this, R.anim.ripple2);

        ring1.startAnimation(ripple);
        ring2.startAnimation(ripple2);
    }


    private void setCustomActionBar() {
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        View customView = LayoutInflater.from(this).inflate(R.layout.actionbar_findbuddy, null);
        actionBar.setCustomView(customView);

    }

}
