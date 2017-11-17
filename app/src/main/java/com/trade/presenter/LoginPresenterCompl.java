package com.trade.presenter;
/*
 *
 * @copyright : 深圳市创冠新媒体网络传媒有限公司版权所有
 *
 * @author :yixiaofei
 *
 * @version :1.0
 *
 * @creation date: 2017/4/22 0022
 *
 * @description:${desc}
 *
 * @update date :
 */

import android.content.Context;

//import com.bear.customerview.http.Entity.BaseObserver;
import com.trade.entity.AcountBean;
import com.trade.view.ILoginView;

public class LoginPresenterCompl implements ILoginPresenter{

    private Context context;

    private ILoginView loginView;

    public LoginPresenterCompl(Context context, ILoginView iLoginView){
        this.context = context;

        this.loginView = iLoginView;
    }
    @Override
    public void loginToServer(String userName, String password) {

    }
}
