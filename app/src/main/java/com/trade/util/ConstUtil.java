package com.trade.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by yixiaofei on 2017/2/25 0025.
 * 提供项目所需的静态变量
 */
public class ConstUtil {
    //BOMB后端架构
    public static final String BOMB_ID = "147b8d6bd2678206d32dbf21c1b33b4c";
    //app
    public static final String IS_FIRST =  "is_first";
    //注册页面数据传递
    public static final String REGISTER_PAGE_TYPE = "pageType";
    //传递账号数据
    public static final String ACCOUNT_DATA = "account";
    //注册传递短信数据
    public static final String SMS_CODE_DATA = "sms_data";
    //立即注册
    public static final int REGISTER_TYPE = 0;
    //忘记密码
    public static final int FORGET_PASSWORD_TYPE = 1;
    /**
     * 第一次初始化网络请求
     */
    public static final int TYPE_INIT_FROM = 111;
    /**
     * 上拉加载
     */
    public static final int TYPE_IS_FROM_PULLUP = 222;
    /**
     * 下拉加载
     */
    public static final int TYPE_IS_FROM_PULL = 333;

    public static void showNotifyText(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
    public static void showNotifyText(Context context,int resId){
        if (context != null) {
            CharSequence text = context.getResources().getText(resId);
            Toast.makeText(context,text.toString(),Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * 判断手机格式是否正确
     * @param mobiles
     * @return
     * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
     * 联通：130、131、132、152、155、156、185、186
     * 电信：133、153、180、189、（1349卫通）
     * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
     */
    public static boolean isMobilePhone(String mobiles) {
        //"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        String telRegex = "[1][34578]\\d{9}" ;
        if (TextUtils.isEmpty(mobiles)) return false ;
        else return mobiles.matches( telRegex ) ;
    }
}
