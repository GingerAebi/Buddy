package kr.co.crescentcorp.buddytest.tutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.crescentcorp.buddytest.R;


public class Tutorial5Fragment extends Fragment {
    @BindView(R.id.imageView_tutorial5_star)
    ImageView iv_star;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_tutorial_5, container, false);
        ButterKnife.bind(this,rootView);
        Picasso.with(getContext()).load(R.drawable.t5_review).into(iv_star);

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}


