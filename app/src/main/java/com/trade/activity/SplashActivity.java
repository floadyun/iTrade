package com.trade.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.trade.R;
import com.trade.util.ConstUtil;
import com.trade.util.PreferenceUtil;

public class SplashActivity extends Activity implements Runnable{
    //倒计时5秒进入
    private static final int TIME_COUNT = 1;

    private boolean isGoHome = true;

    private int time=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        new Thread(this).start();
    }

    @Override
    public void run() {
        while (isGoHome){
            try {
                Thread.sleep(1000);
                if(time<TIME_COUNT){
                    time++;
                }else{
                    gotoGuideAcvitity();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isGoHome = false;
    }

    public void gotoGuideAcvitity(View view){
        gotoGuideAcvitity();
    }
    /**
     * 跳转至向导页面
     */
    private void gotoGuideAcvitity(){
        isGoHome = false;
        Intent intent;
        if(PreferenceUtil.getPreference(this).getBoolPreference(ConstUtil.IS_FIRST,true)){
            intent = new Intent(this,GuideAcitivity.class);
        }else{
            intent = new Intent(this,MainActivity.class);
        }
        startActivity(intent);
        this.finish();
    }
}
