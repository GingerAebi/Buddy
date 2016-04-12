package kr.co.crescentcorp.buddytest.tutorial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GingerAebi on 2016. 4. 6..
 */
public class PagerAdapter extends FragmentStatePagerAdapter implements ViewPager.OnFocusChangeListener {

    List<Fragment> fragments = new ArrayList<>();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragement(Fragment fragment) {
        fragments.add(fragment);
        notifyDataSetChanged();
    }

    public void removeView(int index) {
        fragments.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        if (fragments.contains((Fragment) object)) {
            return fragments.indexOf((Fragment) object);
        }
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();  // 총 5개의 page를 보여줍니다.
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        Log.i("Test", "" + v.getId());
    }
}


