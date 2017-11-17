package com.trade.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.orhanobut.logger.Logger;
import com.trade.R;
import com.trade.entity.AcountBean;
import com.trade.entity.User;
import com.trade.event.UserEvent;
import com.trade.presenter.ILoginPresenter;
import com.trade.presenter.LoginPresenterCompl;
import com.trade.util.ConstUtil;
import com.trade.view.ILoginView;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;
import java.util.Map;
import butterknife.BindView;
/**
 * Created by yixiaofei on 2017/2/24 0024.
 */

public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.login_phone_text)
    EditText phoneText;

    @BindView(R.id.login_password_text)
    EditText passwordText;

    private ILoginPresenter loginPresenter;

    @Override
    protected void initView() {
        setViewLayout(R.string.login_text,R.layout.activity_login);
        EventBus.getDefault().register(this);//在当前界面注册一个订阅者

        loginPresenter = new LoginPresenterCompl(this,this);
    }
    /**
     * 按钮点击事件相应
     * @param view
     */
    public void loginButtonEvent(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.login_btn:
                login();
                break;
            case R.id.forget_password_btn:
                intent.setClass(this, RegisterActivity.class);
                intent.putExtra(ConstUtil.REGISTER_PAGE_TYPE,ConstUtil.FORGET_PASSWORD_TYPE);
                startActivity(intent);
                break;
            case R.id.phone_register_btn:
                intent.setClass(this, RegisterActivity.class);
                intent.putExtra(ConstUtil.REGISTER_PAGE_TYPE,ConstUtil.REGISTER_TYPE);
                startActivity(intent);
                break;
            case R.id.qq_login_btn:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, this);
                break;
            case R.id.wechat_login_btn:
                //微信登录
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, this);
                break;
            case R.id.sina_login_btn:
                //新浪微博
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.SINA, this);
                break;
        }
    }
    /**
     * 开始登录
     */
    private void login(){
        String userName = phoneText.getText().toString();
        String password = passwordText.getText().toString();
        if(!TextUtils.isEmpty(userName)) {
            if (!TextUtils.isEmpty(password)) {

            } else {
                ConstUtil.showNotifyText(this, "手机号码不能为空");
            }
        }
    }
    @Override
    public void loginSuccess(AcountBean.UserBean userBean) {
        ConstUtil.showNotifyText(this,"登录成功");
        this.finish();
    }
    @Override
    public void loginFailed() {
        ConstUtil.showNotifyText(this,"登录失败，请检查用户名和密码!");
    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }
    @Override
    public void onComplete(final SHARE_MEDIA share_media, int i, Map<String, String> map) {
        ConstUtil.showNotifyText(this,"onComplete......"+map.get("name"));

    }
    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
        ConstUtil.showNotifyText(this,"onError......");
    }
    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {
        ConstUtil.showNotifyText(this,"onCancel......");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    @Subscribe
    public void onEventMainThread(UserEvent userEvent){
        if(userEvent.getEventType().equals(UserEvent.TYPE_EVENT_REGISTER)){
            phoneText.setText(userEvent.getPhone());
            passwordText.setText(userEvent.getPassword());
            loginPresenter.loginToServer(userEvent.getPhone(),userEvent.getPassword());
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//取消注册
    }
}
