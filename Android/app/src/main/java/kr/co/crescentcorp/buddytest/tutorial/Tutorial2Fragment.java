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


public class Tutorial2Fragment extends Fragment {

    @BindView(R.id.imageView_tutorail2_nihao)
    ImageView iv_nihao;
    @BindView(R.id.imageView_tutorial2_background)
    ImageView background;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void loadImage() {
         Picasso.with(getContext()).load(R.drawable.t2_nihao).into(iv_nihao);
         Picasso.with(getContext()).load(R.drawable.t2_bg).into(background);
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_tutorial_2,null);
        ButterKnife.bind(this, view);
        loadImage();
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}


