package com.trade.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.trade.R;
import com.trade.util.ActivityUtil;
import com.trade.util.GlideCacheUtil;

import org.greenrobot.eventbus.EventBus;
import butterknife.BindView;

/**
 * Created by yixiaofei on 2017/3/22 0022.
 */

public class SettingActivity extends BaseActivity{

    /**
     * 头像
     */
    @BindView(R.id.iv_setting_head_img)
    ImageView ivSettingHeadImg;

    /**
     * 用户昵称
     */
    @BindView(R.id.tv_setting_nickname)
    TextView tvSettingNickname;

    /**
     * 缓存大小
     */
    @BindView(R.id.tv_setting_cache)
    TextView tvSettingCache;

    /**
     * 当前版本
     */
    @BindView(R.id.tv_up_version)
    TextView tvUpVersion;

    @Override
    protected void initView() {
        setViewLayout(R.string.setting_title_text,R.layout.activity_setting);
//        EventBus.getDefault().register(this);
       // initData();
        setUserInfo();
    }

    private void setUserInfo(){
//        String photo= PreferenceUtil.getPreference(ARApplication.getArApplication()).getStringPreference(PreferenceUtil.PHOTO,"");
//        String name= PreferenceUtil.getPreference(ARApplication.getArApplication()).getStringPreference(PreferenceUtil.NAME,"");
//        String accoutType=PreferenceUtil.getPreference(ARApplication.getArApplication()).getStringPreference(PreferenceUtil.MEMBERTYPE,"");
//        accoutMobile = PreferenceUtil.getPreference(ARApplication.getArApplication()).getStringPreference(PreferenceUtil.MOBILE,"");
//        String bankCard=PreferenceUtil.getPreference(ARApplication.getArApplication()).getStringPreference(PreferenceUtil.BANKCARD,"0");
//        String password=PreferenceUtil.getPreference(ARApplication.getArApplication()).getStringPreference(PreferenceUtil.PAYWD,"0");
//        String upVersion=PreferenceUtil.getPreference(ARApplication.getArApplication()).getStringPreference(PreferenceUtil.UP_VERSION,"0");
//        if(VersionUtil.isUpVersion(upVersion)){
//            ivSettingUpVersionNew.setVisibility(View.VISIBLE);
//        }
//        //设置用户头像
//        Glide.with(ARApplication.getArApplication()).load(photo).
//                crossFade().placeholder(R.drawable.default_head_portrait).
//                error(R.drawable.default_head_portrait).
//                transform(new GlideCircleTransform(SettingActivity.this)).
//                into(ivSettingHeadImg);
//        //设置用户昵称
//        tvSettingNickname.setText(name);
//        //手机号
//        if(!accoutMobile.equals("")){
//            accoutMobile = accoutMobile.substring(0, 3) + "****" + accoutMobile.substring(accoutMobile.length()-4, accoutMobile.length());
//            tvSettingMobile.setText(accoutMobile);
//        }
//        //判断是否设置过支付密码
//        if ("0".equals(password)){
//            tvSettingballnce.setText(getString(R.string.setting_set_pwd));
//        }else {
//            tvSettingballnce.setText(getString(R.string.setting_up_pwd));
//        }
//        //判断是否绑定过银行卡
//        if ("0".equals(bankCard)){
//            tvSettingMyBankcardText.setText(getString(R.string.setting_bind_bank_card));
//        }else {
//            tvSettingMyBankcardText.setText(getString(R.string.setting_my_bank_card));
//        }
//        tvUpVersion.setText("当前版本V"+ VersionUtil.getVersionName(SettingActivity.this));
//        setCacheData();
    }
    /**
     * 设置缓存数据
     */
    private void setCacheData(){
        try {
            String cacheSize= GlideCacheUtil.getInstance().getCacheSize(SettingActivity.this);
            tvSettingCache.setText(cacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void itemClick(View v) {
        switch (v.getId()){
            //点击头像
            case R.id.rl_setting_header:
                ActivityUtil.startChangeInfoActivity(this);
                break;
            //修改手机号
//            case R.id.rl_setting_up_mobile:
//                ActivityUtil.startUpBindModibleActivity(SettingActivity.this);
//                break;
            //绑定银行卡
//            case R.id.rl_setting_bind_bank_card:
//                String Bankcardnumber=PreferenceUtil.getPreference(ARApplication.getArApplication()).getStringPreference(PreferenceUtil.BANKCARD,"0");
//                if("0".equals(Bankcardnumber)){
//                    ActivityUtil.startBindBankcardActivity(SettingActivity.this);
//                }else {
//                    ActivityUtil.startBankcardDetailActivity(SettingActivity.this);
//                }
//                break;
            //修改支付密码
//            case R.id.rl_setting_set_pwd:
//                ActivityUtil.startSetBalancePswActivity(SettingActivity.this,0);
//                break;
            //退出登录
//            case R.id.btn_unlogin:
//                DialogUtil.showNotifDialog(this,"确定要退出当前账号吗?","确定","取消",new DialogUtil.OnDialogClickEvent(){
//                    @Override
//                    public void positiveClickEvent() {
//                        ActivityUtil.unlogin(SettingActivity.this);
//                        AppManager.getInstance().killActivity(SettingActivity.class);
//                        //通知我的页面
//                        EventBus.getDefault().post(new AcountBean.UserBean());
//                    }
//                    @Override
//                    public void cancelClickEvent() {
//
//                    }
//                });
//                break;
//            //清除缓存
//            case R.id.rl_setting_cache:
//                if(tvSettingCache.getText().toString().equals("0.0KB")){
//                    AbToastUtil.showToast(SettingActivity.this,"无缓存清理");
//                    return;
//                }
//                DialogUtil.showNotifDialog(this,"确定删除全部缓存?","确定","取消",new DialogUtil.OnDialogClickEvent(){
//                    @Override
//                    public void positiveClickEvent() {
//                        showProgressDlg();
//                        GlideCacheUtil.getInstance().clearImageAllCache(SettingActivity.this);
//                    }
//                    @Override
//                    public void cancelClickEvent() {
//
//                    }
//                });
//                break;
//            //版本更新
//            case R.id.rl_setting_up_version:
//                getUpVersion();
//                //showUpVersion();
//                break;
        }
    }

    /**
     * 查看服务器上是否有更新
     */
    private void getUpVersion(){

    }
    /**
     * 版本更新弹窗
     */
    private void showUpVersion(String title ,String message,String updateway,String version,String url){

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}
