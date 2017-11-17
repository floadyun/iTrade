package com.trade.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.trade.R;
import com.trade.activity.AboutActivity;
import com.trade.activity.ChangeInfoActivity;
import com.trade.activity.ChangeNameActivity;
import com.trade.activity.CurrencyActivity;
import com.trade.activity.GuideAcitivity;
import com.trade.activity.LoginActivity;
import com.trade.activity.MainActivity;
import com.trade.activity.OpenAccoutActivity;
import com.trade.activity.PlanDetailActivity;
import com.trade.activity.SetPasswordActivity;
import com.trade.activity.SettingActivity;
import com.trade.activity.TradeCircleActivity;
import com.trade.activity.UserInfoActivity;

/*
 *
 * @Copyright : 深圳市创冠新媒体网络传媒有限公司版权所有
 *
 * @author :liuyuxing
 *
 * @version :1.0
 *
 * @creation date: 2017/3/22 0022
 *
 * @description:
 *
 * @update date :
 */
public class ActivityUtil {
    /**
     * 跳转至主页
     * @param context
     */
    public static void startMainActivity(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }
    /**
     * 跳转至引导页
     * @param context
     */
    public static void toGuideActivity(Context context){
        Intent intent = new Intent(context,GuideAcitivity.class);
        context.startActivity(intent);
    }
    /**
     * 跳转至注册页面
     */
    public static void toRegister(Context context,int pageType){

    }
    /**
     * 设置登录密码
     * @param context
     * @param pageType
     */
    public static void startSetPassword(Context context,int pageType,String acuont,String smsCode){
        Intent intent = new Intent(context,SetPasswordActivity.class);
        intent.putExtra(ConstUtil.REGISTER_PAGE_TYPE,pageType);
        intent.putExtra(ConstUtil.ACCOUNT_DATA,acuont);
        intent.putExtra(ConstUtil.SMS_CODE_DATA,smsCode);
        context.startActivity(intent);
    }
    /**
     * 开始登录
     * @param context
     */
    public static void startLoginActivity(Context context){
        Intent intent = new Intent();
        intent.setClass(context, LoginActivity.class);
        context.startActivity(intent);
    }

    /**
     * 设置
     * @param context
     */
    public static void startSettingActivity(Context context){
        Intent intent = new Intent();
        intent.setClass(context, SettingActivity.class);
        context.startActivity(intent);
    }
    /**
     * 设置
     * @param context
     */
    public static void startChangeInfoActivity(Context context){
        Intent intent = new Intent();
        intent.setClass(context, ChangeInfoActivity.class);
        context.startActivity(intent);
    }
    /**
     * 设置
     * @param context
     */
    public static void startChangeNameActivity(Context context){
        Intent intent = new Intent();
        intent.setClass(context, ChangeNameActivity.class);
        context.startActivity(intent);
    }
    /**
     * 跳转至货币选择
     * @param context
     */
    public static void startCurrencyActivity(Context context){
        Intent intent = new Intent();
        intent.setClass(context, CurrencyActivity.class);
        context.startActivity(intent);
    }
    /**
     * 跳转至计划详情页面
     * @param context
     */
    public static void startPlanDetail(Context context){
        Intent intent = new Intent();
        intent.setClass(context, PlanDetailActivity.class);
        context.startActivity(intent);
    }
    /**
     * 跳转至用户个人空间
     */
    public static void startUserInfo(Context context){
        Intent intent = new Intent();
        intent.setClass(context, UserInfoActivity.class);
        context.startActivity(intent);
    }
    /**
     * 跳转至交易圈
     * @param context
     */
    public static void startTradeCircle(Context context){
        Intent intent = new Intent();
        intent.setClass(context, TradeCircleActivity.class);
        context.startActivity(intent);
    }
    /**
     * 极速开户
     * @param context
     */
    public static void startOpenAccount(Context context){
        Intent intent = new Intent();
        intent.setClass(context, OpenAccoutActivity.class);
        context.startActivity(intent);
    }
    /**
     * 极速开户
     * @param context
     */
    public static void startAboutActivity(Context context){
        Intent intent = new Intent();
        intent.setClass(context, AboutActivity.class);
        context.startActivity(intent);
    }
}
