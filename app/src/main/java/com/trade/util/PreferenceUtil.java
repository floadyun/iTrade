package com.trade.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yxf on 2017/1/23.
 * SharedPrefrence存储类
 */

public class PreferenceUtil {
    //用户id
    public static final String LOGIN_ID=  "memloginid";
    //用户头像
    public static final String PHOTO = "photo";
    //账户昵称
    public static final String NAME = "name";
    //账户积分
    public static final String SCORE = "score";
    //账户余额
    public static final String ADVANCEPAYMENT = "advancepayment";
    //账户类型
    public static final String MEMBERTYPE = "membertype";


    private static PreferenceUtil preferenceUtil;

    private static SharedPreferences sharedPreferences;

    private static final String YQK_PREFERENCES = "ar_preferences";

    private Context context;

    public PreferenceUtil(Context context){
        this.context = context;

        sharedPreferences = context.getSharedPreferences(YQK_PREFERENCES,Context.MODE_PRIVATE);
    }

    /**
     * 单例返回
     * @return
     */
    public synchronized static PreferenceUtil getPreference(Context context){
        if(preferenceUtil == null){
            preferenceUtil = new PreferenceUtil(context);
        }
        return preferenceUtil;
    }

    /**
     * 设置Preference的值
     * @param key
     * @param value
     */
    public void setStringPreference(String key,String value){
        sharedPreferences.edit().putString(key,value).commit();
    }

    /**
     * 通过传入的key，返回相应的值
     * @param key
     * @return
     */
    public String getStringPreference(String key,String defaultValue){

        return sharedPreferences.getString(key,defaultValue);
    }

    /**
     * 保存boolean类型的值
     * @param key
     * @param value
     */
    public void setBoolPreference(String key,boolean value){
        sharedPreferences.edit().putBoolean(key,value).commit();
    }

    /**
     * 返回保存的boolean值
     * @param key
     * @param defaultValue
     * @return
     */
    public boolean getBoolPreference(String key,boolean defaultValue){
        return sharedPreferences.getBoolean(key,defaultValue);
    }
}
