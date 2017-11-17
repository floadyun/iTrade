package com.trade.activity;

import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bear.customerview.carouseview.CarouseButton;
import com.trade.R;
import com.trade.entity.User;
import com.trade.util.ActivityUtil;
import com.trade.util.ConstUtil;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
/**
 * Created by yixiaofei on 2017/2/24 0024.
 */

public class RegisterActivity extends BaseActivity{

    private static final int REFRESH_VEFIRI_BTN = 0;

    private int pageType;

    @BindView(R.id.register_phone_text)
    EditText phoneText;

    @BindView(R.id.register_vefiricode_text)
    EditText vefiricodeText;

    @BindView(R.id.user_protocol_text)
    TextView protocolText;

    @BindView(R.id.get_verification_code_btn)
    CarouseButton verifiBtn;

    @BindView(R.id.user_protocol_layout)
    LinearLayout protocolLayout;

    private boolean isRefresh = true;

    private int time;

    private String verifiCode;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case REFRESH_VEFIRI_BTN:
                    time--;
                    if(time==1){
                        setVerfiButton(true);
                        isRefresh = false;
                    }else if(time>0){
                        verifiBtn.setText(time+"s后重新发送");
                    }
                    break;
            }
        }
    };
    @Override
    protected void initView() {
        pageType = getIntent().getIntExtra(ConstUtil.REGISTER_PAGE_TYPE,0);
        if(pageType== ConstUtil.REGISTER_TYPE){
            setViewLayout(R.string.phone_register_text,R.layout.activity_register);
        }else if(pageType==ConstUtil.FORGET_PASSWORD_TYPE){
            setViewLayout(R.string.find_password_text,R.layout.activity_register);
            protocolLayout.setVisibility(View.GONE);
        }
        protocolText.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG );
    }
    public void registerButtonEvent(View view){
        switch (view.getId()){
            case R.id.get_verification_code_btn:
                getVefiricode(phoneText.getText().toString());
                break;
            case R.id.verification_login_btn:
                verificationContent();
                break;
        }
    }
    /**
     * 开始登录，验证是否都填入相应的内容
     */
    private void verificationContent(){
       final String phoneNum = phoneText.getText().toString();
        if(!TextUtils.isEmpty(phoneNum)){
            if(!TextUtils.isEmpty(vefiricodeText.getText().toString())){
                verifiCode = vefiricodeText.getText().toString();
            }else{
                ConstUtil.showNotifyText(this,"请输入短信验证码");
            }
        }else{
            ConstUtil.showNotifyText(this,"请输入手机号码");
        }
    }
    /**
     * 检测该手机号码是否已注册同时获取验证码
     */
    private void getVefiricode(final String phoneNum){
        if(!TextUtils.isEmpty(phoneNum)){
            if(ConstUtil.isMobilePhone(phoneNum)){

            }else{
                ConstUtil.showNotifyText(this,"请输入正确的手机号码");
            }
        }else{
            ConstUtil.showNotifyText(this,"手机号码不能为空");
        }
    }
    /**
     * 获取验证码
     * @param phoneNum
     */
    private void getVerificationCode(final String phoneNum){

    }
    /**
     * 设置验证码按钮是否可点击
     * @param isClickable
     */
    private void setVerfiButton(boolean isClickable){
        verifiBtn.setClickable(isClickable);
        if(isClickable){
            verifiBtn.setBackGroundAndFrameColor(R.color.colorAccent,R.color.colorPrimaryDark,5);
            verifiBtn.setText("获取验证码");
        }else{
            verifiBtn.setBackGroundAndFrameColor(R.color.noraml_gray_color,R.color.noraml_gray_color,5);
        }
    }
    /**
     * 打开用户注册协议
     */
    @OnClick(R.id.user_protocol_text)void openProtocol(){

    }
    /**
     * 获取验证码失败后重新发送
     */
    private void sendVerificationCode(){
        isRefresh = true;
        time = 60;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(isRefresh){
                    try{
                        Thread.sleep(1000);
                        handler.sendEmptyMessage(REFRESH_VEFIRI_BTN);
                    }catch (Exception e){

                    }
                }
            }
        }).start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRefresh = false;
    }
}
