package kr.co.crescentcorp.buddytest.tutorial;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
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


public class Tutorial4Fragment extends Fragment {

    private Animation handAnimation;

    @BindView(R.id.imageView_tutorial4_hand)
    ImageView iv_hand;

    @BindView(R.id.imageView_tutorial4_background)
    ImageView iv_background;

    private int animationIdx = 1;

    private Bitmap[] images = new Bitmap[3];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setImages();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_tutorial_4, container, false);
        ButterKnife.bind(this, rootView);
        Picasso.with(getActivity()).load(R.drawable.t4_hand_1).into(iv_hand);
        Picasso.with(getActivity()).load(R.drawable.t4_fill_circle).into(iv_background);

        // animation delete
        //setAnimation();
        //imageView.startAnimation(handAnimation);

        return rootView;

    }

    private void setImages() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;

        images[0] = BitmapFactory.decodeResource(getResources(), R.drawable.t4_hand_1, options);
        images[1] = BitmapFactory.decodeResource(getResources(), R.drawable.t4_hand_2, options);
        images[2] = BitmapFactory.decodeResource(getResources(), R.drawable.t4_hand_3, options);
    }

    private void setAnimation() {
        handAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.shake_hand);
        handAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.i("Test", "start");
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                switch (animationIdx) {
                    case 1:
                        iv_hand.setImageBitmap(images[1]);
                        animationIdx = 2;
                        break;
                    case 2:
                        iv_hand.setImageBitmap(images[2]);
                        animationIdx = 3;
                        break;
                    case 3:
                        iv_hand.setImageBitmap(images[0]);
                        animationIdx = 1;
                        break;
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        iv_hand.startAnimation(handAnimation);
                    }
                }, 10);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.i("Test", "repeat");
            }

        });
    }

}


