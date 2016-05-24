package kr.co.crescentcorp.buddytest.register;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.soundcloud.android.crop.Crop;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.crescentcorp.buddytest.R;
import kr.co.crescentcorp.buddytest.vo.User;

public class Register2Activity extends AppCompatActivity {

    User user;

    @BindView(R.id.textView_r2_hello)
    TextView tv_hello;
    @BindView(R.id.textView_r2_email)
    TextView tv_email;
    @BindView(R.id.imageView_r2_photo)
    ImageView iv_profile;

    @BindView(R.id.editText_r2_birth)
    EditText et_birth;

    @BindView(R.id.imageButton_r2_next)
    ImageButton ib_next;

    @BindView(R.id.imageView_r2_women)
    ImageView iv_women;

    @BindView(R.id.imageView_r2_man)
    ImageView iv_man;


    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        if (requestCode == Crop.REQUEST_PICK && resultCode == RESULT_OK) {
            beginCrop(result.getData());
        } else if (requestCode == Crop.REQUEST_CROP) {
            handleCrop(resultCode, result);
        }
    }

    private void beginCrop(Uri source) {
        Uri destination = Uri.fromFile(new File(getCacheDir(), "cropped"));
        Crop.of(source, destination).asSquare().start(this);
    }

    private void handleCrop(int resultCode, Intent result) {
        if (resultCode == RESULT_OK) {
            iv_profile.setImageURI(Crop.getOutput(result));
        } else if (resultCode == Crop.RESULT_ERROR) {
            Toast.makeText(this, Crop.getError(result).getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        user = (User) getIntent().getSerializableExtra("User");
        Log.i("user", user.toString());
        tv_hello.setText(user.firstName + "   你好");
        tv_email.setText(user.email);

        ib_next.setClickable(false);

        et_birth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() == 6) {
                    ib_next.setClickable(true);
                } else {
                    ib_next.setClickable(false);
                }
            }
        });
    }

    @OnClick(R.id.imageView_r2_photo)
    void selectPicture() {
        Crop.pickImage(this);
    }



    @OnClick({R.id.imageView_r2_man, R.id.imageView_r2_women})
    void toggleImage() {

    }



    @OnClick(R.id.imageButton_r2_next)
    void moveToNext() {

    }

}

