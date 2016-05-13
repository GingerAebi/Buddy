package kr.co.crescentcorp.buddytest.tutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.crescentcorp.buddytest.R;


public class Tutorial3Fragment extends Fragment {

    @BindView(R.id.imageView_gwanghwamoon)
    ImageView iv_gwanghwamoon;
    @BindView(R.id.imageView_intro3)
    ImageView iv_backgroud;
    private Animation dongdong;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_tutorial_3, container, false);
        ButterKnife.bind(this, rootView);
        Picasso.with(getContext()).load(R.drawable.t3_lightfiredoor).into(iv_gwanghwamoon);
        Picasso.with(getContext()).load(R.drawable.t3_land).into(iv_backgroud);

        dongdong = AnimationUtils.loadAnimation(getContext(), R.anim.dongdong);
        // animation delete
//        iv_gwanghwamoon.startAnimation(dongdong);

        return rootView;

    }

}


