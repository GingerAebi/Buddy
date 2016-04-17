package kr.co.crescentcorp.buddytest.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import kr.co.crescentcorp.buddytest.R;

public class Register1Activity extends AppCompatActivity {


    private EditText et_email;
    private EditText et_lastName;
    private EditText et_firstName;

    private ImageView iv_email_checker;
    private ImageView iv_lastName_checker;
    private ImageView iv_firstName_checker;

    private RegisterController registerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        initViews();
        addWatcher();

    }

    private void initViews() {
        et_email = (EditText) findViewById(R.id.editText_register_email);
        et_lastName = (EditText) findViewById(R.id.editText_register_lastName);
        et_firstName = (EditText) findViewById(R.id.editText_register_firstName);

        iv_email_checker = (ImageView) findViewById(R.id.imageView_register_check_id);
        iv_lastName_checker = (ImageView) findViewById(R.id.imageView_register_check_lastName);
        iv_firstName_checker = (ImageView) findViewById(R.id.imageView_register_check_firstName);

    }

    private void addWatcher() {
        et_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (registerController.emailCheck(s.toString())) {
                    iv_email_checker.setVisibility(View.VISIBLE);
                } else {
                    iv_email_checker.setVisibility(View.INVISIBLE);
                }
            }
        });
        et_lastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (registerController.nameCheck(s.toString())) {
                    iv_lastName_checker.setVisibility(View.VISIBLE);
                } else {
                    iv_lastName_checker.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (registerController.nameCheck(s.toString())) {
                    iv_firstName_checker.setVisibility(View.VISIBLE);
                } else {
                    iv_firstName_checker.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
