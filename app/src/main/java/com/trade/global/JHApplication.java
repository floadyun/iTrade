package com.trade.global;

import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;

import com.orhanobut.logger.Logger;
import com.trade.entity.AcountBean;
import com.trade.entity.User;
import com.trade.util.ActivityUtil;
import com.trade.util.ConstUtil;
import com.trade.util.PreferenceUtil;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
/**
 * Created by yxf on 2017/4/23.
 */

public class JHApplication extends MultiDexApplication {

    public static String TAG =  "Jianhui";

    private static JHApplication jhApplication;

    public AcountBean.UserBean userInfo;

    public static JHApplication getApplication() {
        return jhApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        jhApplication = this;
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("1106038961", "CRxhE1oFxXlLgchv");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
        UMShareAPI.get(this);

        Logger.init(TAG);
    }
    /**
     * 获取用户个人信息
     * @return
     */
    public AcountBean.UserBean getUserInfo() {
        if(userInfo==null){
            AcountBean acountBean = new AcountBean();
            userInfo = acountBean.new UserBean();
            userInfo.setMemloginid(PreferenceUtil.getPreference(getApplicationContext()).getStringPreference(PreferenceUtil.LOGIN_ID,""));
            userInfo.setPhoto(PreferenceUtil.getPreference(getApplicationContext()).getStringPreference(PreferenceUtil.PHOTO,""));
            userInfo.setName(PreferenceUtil.getPreference(getApplicationContext()).getStringPreference(PreferenceUtil.NAME,""));
            userInfo.setScore(PreferenceUtil.getPreference(getApplicationContext()).getStringPreference(PreferenceUtil.SCORE,""));
            userInfo.setAdvancepayment(PreferenceUtil.getPreference(getApplicationContext()).getStringPreference(PreferenceUtil.ADVANCEPAYMENT,""));
            userInfo.setMembertype(PreferenceUtil.getPreference(getApplicationContext()).getStringPreference(PreferenceUtil.MEMBERTYPE,""));
        }
        return userInfo;
    }
    public void setUserInfo(AcountBean.UserBean userInfo) {
        PreferenceUtil.getPreference(getApplicationContext()).setStringPreference(PreferenceUtil.LOGIN_ID,userInfo.getMemloginid());
        PreferenceUtil.getPreference(getApplicationContext()).setStringPreference(PreferenceUtil.PHOTO,userInfo.getPhoto());
        PreferenceUtil.getPreference(getApplicationContext()).setStringPreference(PreferenceUtil.NAME,userInfo.getName());
        PreferenceUtil.getPreference(getApplicationContext()).setStringPreference(PreferenceUtil.SCORE,userInfo.getScore());
        PreferenceUtil.getPreference(getApplicationContext()).setStringPreference(PreferenceUtil.ADVANCEPAYMENT,userInfo.getAdvancepayment());
        PreferenceUtil.getPreference(getApplicationContext()).setStringPreference(PreferenceUtil.MEMBERTYPE,userInfo.getMembertype());

        this.userInfo = userInfo;
    }
    /**
     * 判断是否登录并且跳转
     * @param context
     * @param istoLogin
     * @return
     */
    public boolean isLogin(Context context, boolean istoLogin) {
//        if(null==User.getCurrentUser(User.class)){
//            if(istoLogin){
//                ConstUtil.showNotifyText(context,"您还没有登录，请先登录");
//                ActivityUtil.startLoginActivity(context);
//            }
//            return false;
//        }
        return true;
    }
    /**
     * 获取用户ID
     * @return
     */
    public String getUserId() {
        return PreferenceUtil.getPreference(getApplicationContext()).getStringPreference(PreferenceUtil.LOGIN_ID,"");
    }
}
