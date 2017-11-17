package com.trade.activity;

import android.support.v7.app.AppCompatActivity;

/*
 *
 * @copyright : 深圳市腾飞科技有限公司版权所有
 *
 * @author : ${Author}
 *
 * @version :1.0
 *
 * @creation date: 2017/6/24
 *
 * @description:个人中心
 *
 * @update date :
 */
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import com.bear.customerview.baseui.AppManager;
import com.bear.customerview.util.ToastUtil;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.umeng.analytics.MobclickAgent;
/*
 *
 * @copyright : 深圳市创冠新媒体网络传媒有限公司版权所有
 *
 * @author :yixiaofei
 *
 * @version :1.0
 *
 * @creation date: 2017/5/22 0022
 *
 * @description:所有activity基类
 *
 * @update date :
 */

public class AppBaseActivity extends AppCompatActivity {
    /**
     * 进度提示宽
     */
    public KProgressHUD kProgressHUD;

    protected Context mContext;

    protected static final String TAG = "XUNJI";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        mContext = this;
    }
    /**
     * 信息提示
     * @param text
     */
    protected void showToastText(String text){
        ToastUtil.showToast(getApplicationContext(),text);
    }
    /**
     * 启动进度条
     *
     * @param strMessage
     *            进度条显示的信息
     *            当前的activity
     */
    public void showProgressDlg(String title, String strMessage) {
        if (null == kProgressHUD&&!isFinishing()) {
            kProgressHUD  =KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setCancellable(true)
                    .setAnimationSpeed(2)
                    .setDimAmount(0.5f)
                    .show();
            if(!title.isEmpty()){
                kProgressHUD.setLabel(title);
            }
            if(!strMessage.isEmpty()){
                kProgressHUD.setDetailsLabel(strMessage);
            }
        }
    }

    /**
     * 启动进度条
     * @param title
     */
    public void showProgressDlg(String title) {
        showProgressDlg(title,"");
    }
    /**
     *启动进度条
     *进度条显示的信息
     * 当前的activity
     */
    public void showProgressDlg() {
        showProgressDlg("","");
    }

    /**
     * 动态设置progress进度
     * @param text
     */
    public  void setProressText(String text){
        if (null != kProgressHUD&&!isFinishing()) {
            kProgressHUD.setLabel(text);
        }
    }
    /**
     * 结束进度条
     */
    public  void stopProgressDlg() {
        if (null != kProgressHUD) {
            kProgressHUD.dismiss();
            kProgressHUD = null;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
    /***
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(android.view.MotionEvent event) {
        dismissKeyboard();
        return true;
    }
    /**
     * 隐藏键盘
     */
    protected void dismissKeyboard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        try {
            if(null!=this.getCurrentFocus().getWindowToken()){
                imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
            }
        }catch (Exception e){

        }
    }
    @Override
    public void onBackPressed() {
        finishSelf();
    }
    protected void finishSelf(){
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().killActivity(this);
    }
    /**
     * 打印调试级别日志
     *
     * @param format
     * @param args
     */
    protected void logDebug(String format, Object... args) {
        logMessage(Log.DEBUG, format, args);
    }

    /**
     * 打印信息级别日志
     *
     * @param format
     * @param args
     */
    protected void logInfo(String format, Object... args) {
        logMessage(Log.INFO, format, args);
    }

    /**
     * 打印错误级别日志
     *
     * @param format
     * @param args
     */
    protected void logError(String format, Object... args) {
        logMessage(Log.ERROR, format, args);
    }
    /**
     * 打印日志
     *
     * @param level
     * @param format
     * @param args
     */
    private void logMessage(int level, String format, Object... args) {
        String formattedString = String.format(format, args);
        showToastText("..."+args);
        switch (level) {
            case Log.DEBUG:
                Log.d(TAG, formattedString);
                break;
            case Log.INFO:
                Log.i(TAG, formattedString);
                break;
            case Log.ERROR:
                Log.e(TAG, formattedString);
                break;
        }
    }
}
