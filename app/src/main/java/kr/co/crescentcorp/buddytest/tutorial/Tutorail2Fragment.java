package kr.co.crescentcorp.buddytest.tutorial;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import kr.co.crescentcorp.buddytest.R;


public class Tutorail2Fragment extends Fragment {

    private Bitmap images[] = new Bitmap[9];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void setImages() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;

        images[0] = BitmapFactory.decodeResource(getResources(), R.drawable.t2_party1, options);
        images[1] = BitmapFactory.decodeResource(getResources(), R.drawable.t2_party2, options);
        images[2] = BitmapFactory.decodeResource(getResources(), R.drawable.t2_party3, options);
        images[3] = BitmapFactory.decodeResource(getResources(), R.drawable.t2_party4, options);
        images[4] = BitmapFactory.decodeResource(getResources(), R.drawable.t2_party5, options);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_tutorail_2, container, false);

        int[] random = new int[10];

        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 4);
            random[i] = num;
        }

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}


