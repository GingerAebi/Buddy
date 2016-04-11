package kr.co.crescentcorp.buddytest.tutorial;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import kr.co.crescentcorp.buddytest.R;


public class Tutorail3Fragment extends Fragment {

    private ImageView iv_gwanghwamoon;
    private ImageView iv_backgroud;
    private Animation dongdong;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_tutorail_3, container, false);

        Bitmap gwanghwamoon = BitmapFactory.decodeResource(getResources(), R.drawable.t3_lightfiredoor);
        Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.t3_land);

        iv_backgroud = (ImageView) rootView.findViewById(R.id.imageView_intro3);
        iv_backgroud.setImageBitmap(background);
//        ((BitmapDrawable)iv_backgroud.getDrawable()).getBitmap().recycle();

        iv_gwanghwamoon = (ImageView) rootView.findViewById(R.id.imageView_gwanghwamoon);
        iv_gwanghwamoon.setImageBitmap(gwanghwamoon);
//        ((BitmapDrawable)iv_gwanghwamoon.getDrawable()).getBitmap().recycle();


        dongdong = AnimationUtils.loadAnimation(getContext(), R.anim.dongdong);
        iv_gwanghwamoon.startAnimation(dongdong);

        return rootView;

    }

}


