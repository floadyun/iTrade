package com.trade.view;

import com.trade.entity.AcountBean;
import com.umeng.socialize.UMAuthListener;

/**
 * Created by yxf on 2017/4/16.
 */

public interface ILoginView extends UMAuthListener{
    void loginSuccess(AcountBean.UserBean userInfo);
    void loginFailed();
}
