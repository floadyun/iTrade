package com.trade.fragment;

import android.widget.ImageView;
import android.widget.TextView;

import com.bear.customerview.glide.GlideApp;
import com.trade.R;
import com.trade.entity.User;
import com.trade.global.JHApplication;
import com.trade.util.ActivityUtil;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yixiaofei on 2017/3/21 0021.
 */

public class UserFragment extends BaseFragment implements UMShareListener{

    private static UserFragment userFragment;

    @BindView(R.id.my_avator)
    ImageView avatorImage;

    @BindView(R.id.nickname_text)
    TextView nickname_text;

    private User user;

    public static synchronized UserFragment newInstance(){
        if(userFragment==null){
            userFragment = new UserFragment();
        }
        return userFragment;
    }
    @Override
    protected void initFragemntView() {
        setFragmentView(R.layout.fragment_user);
    }
    @Override
    public void onResume() {
        super.onResume();
        setUserInfo();
    }
    /**
     * 设置用户个人信息
     */
    private void setUserInfo(){
//        user = User.getCurrentUser(User.class);
        if(null!=user){
            GlideApp.getInstance().withGlideRoundTransform(getContext(),R.drawable.default_head_portrait,user.getAvatorurl(),avatorImage);
            nickname_text.setText(user.getNickname());
        }
    }
    /**
     * 跳转至设置页面
     */
    @OnClick(R.id.user_setting_btn)void toSettingActivity(){
        ActivityUtil.startSettingActivity(getContext());
    }
    /**
     * 跳转至登录页面
     */
    @OnClick(R.id.my_avator)void toLogin(){
        JHApplication.getApplication().isLogin(getContext(),true);
    }

    /**
     * 跳转至个人中心
     */
    @OnClick(R.id.user_dynamic_layout)void toUserInfo(){
        ActivityUtil.startUserInfo(getActivity());
    }
    /**
     * 分享给好友
     */
    @OnClick(R.id.user_share_view)void shareFriend(){
        new ShareAction(getActivity()).withText("hello")
                .setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.SINA)
                .setCallback(this).open();
    }
    /**
     * 极速开户
     */
    @OnClick(R.id.user_open_account_view)void openAccount(){
        ActivityUtil.startOpenAccount(getActivity());
    }
    /**
     * 关于简汇
     */
    @OnClick(R.id.user_about_view)void toAboutActivity(){
        ActivityUtil.startAboutActivity(getActivity());
    }
    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }
    @Override
    public void onResult(SHARE_MEDIA share_media) {

    }
    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {

    }
    @Override
    public void onCancel(SHARE_MEDIA share_media) {

    }
}
