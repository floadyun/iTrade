package com.trade.activity;

import android.widget.Button;
import android.widget.EditText;

import com.bear.customerview.baseui.AppManager;
import com.trade.R;
import com.trade.entity.User;
import com.trade.event.UserEvent;
import com.trade.util.ConstUtil;
import org.greenrobot.eventbus.EventBus;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yixiaofei on 2017/2/25 0025.
 */

public class SetPasswordActivity extends BaseActivity {

    private String account;

    private String smsCode;

    private int pageType;

    @BindView(R.id.forget_password_text_1)
    EditText passwordText1;

    @BindView(R.id.forget_password_text_2)
    EditText getPasswordText2;

    @BindView(R.id.verify_password_btn)
    Button verifyBtn;

    @Override
    protected void initView() {
        pageType = getIntent().getIntExtra(ConstUtil.REGISTER_PAGE_TYPE,ConstUtil.REGISTER_TYPE);
        account = getIntent().getStringExtra(ConstUtil.ACCOUNT_DATA);
        smsCode = getIntent().getStringExtra(ConstUtil.SMS_CODE_DATA);

        if(pageType==ConstUtil.REGISTER_TYPE){
            setViewLayout(R.string.phone_register_text,R.layout.activity_set_password);
            verifyBtn.setText(getResources().getString(R.string.register_immediately_text));
        }else if(pageType==ConstUtil.FORGET_PASSWORD_TYPE){
            setViewLayout(R.string.find_password_text,R.layout.activity_set_password);
            verifyBtn.setText(getResources().getString(R.string.sure_text));
        }
    }
    /**
     * 验证密码
     */
    @OnClick(R.id.verify_password_btn) void verifyPassword(){
        String password1 = passwordText1.getText().toString();
        String password2 = getPasswordText2.getText().toString();
        if(!password1.isEmpty()){
            if(password1.length()>7){
                if(!password2.isEmpty()){
                    if(password1.equals(password2)){
                        if(pageType== ConstUtil.REGISTER_TYPE){
                            registerAccount(account,password1);
                        }else if(pageType==ConstUtil.FORGET_PASSWORD_TYPE){
                            setPassword(account,password1);
                        }
                    }else{
                        showToastText("密码输入不一致，请重新输入");
                    }
                }else{
                    showToastText("请确认登录密码");
                }
            }else{
                showToastText("密码长度8-16位");
            }
        }else{
            showToastText("请输入登录密码");
        }
    }
    /**
     * 开始注册
     */
    private void registerAccount(final String phone, final String password){

    }
    /**
     * 注册成功
     * @param phone
     */
    private void registerSuccess(String phone,String password){
        UserEvent userEvent = new UserEvent();
        userEvent.setEventType(UserEvent.TYPE_EVENT_REGISTER);
        userEvent.setPhone(phone);
        userEvent.setPassword(password);
        EventBus.getDefault().post(userEvent);
        AppManager.getInstance().killActivity(RegisterActivity.class);
        AppManager.getInstance().killActivity(SetPasswordActivity.class);
    }
    /**
     * 设置密码
     * @param phone
     * @param password
     */
    private void setPassword(String phone,String password){
//        User.resetPasswordBySMSCode()
    }
}
