package com.trade.entity;

import org.json.JSONObject;

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
public class User extends BaseEntity {
    //头像地址
    private String avatorurl;

    private String nickname;

    public String getAvatorurl() {
        return avatorurl;
    }

    public void setAvatorurl(String avatorurl) {
        this.avatorurl = avatorurl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
