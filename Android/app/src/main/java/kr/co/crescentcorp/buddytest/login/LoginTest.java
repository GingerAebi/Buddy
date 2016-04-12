package kr.co.crescentcorp.buddytest.login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendAuth;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import kr.co.crescentcorp.buddytest.R;

public class LoginTest extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;

    private IWXAPI api;
    private Button wechatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_test);
        mContext = this;

        api = WXAPIFactory.createWXAPI(this, WeChatConstants.APP_ID);



        wechatButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login_wechat :
                startWeChatLogin();
                break;
        }
    }

    private void startWeChatLogin() {
        SendAuth.Req requestAuth = new SendAuth.Req();
        requestAuth.scope = "snsapi_userinfo";
        requestAuth.state = "";

    }
}
