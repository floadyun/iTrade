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
public interface ILoginPresenter {
//    void authorize(Platform platform);
    /**
     * 登录服务器
     */
    void loginToServer(String userName, String password);
}
