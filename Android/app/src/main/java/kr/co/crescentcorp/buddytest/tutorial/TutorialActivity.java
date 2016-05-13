package kr.co.crescentcorp.buddytest.tutorial;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import kr.co.crescentcorp.buddytest.R;
import me.relex.circleindicator.CircleIndicator;

public class TutorialActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private PagerAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        mViewPager = (ViewPager) findViewById(R.id.viewpager_tutorial);
        mPageAdapter = new PagerAdapter(getSupportFragmentManager());
        mPageAdapter.addFragement(new Tutorial2Fragment());
        mPageAdapter.addFragement(new Tutorial3Fragment());
        mPageAdapter.addFragement(new Tutorial4Fragment());
        mPageAdapter.addFragement(new Tutorial5Fragment());

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        mViewPager.setAdapter(mPageAdapter);
        indicator.setViewPager(mViewPager);

    }

}
