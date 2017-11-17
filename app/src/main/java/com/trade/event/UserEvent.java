package com.trade.event;

/**
 * @author :xfyi
 * @version :1.0
 * @copyright : 深圳市创冠新媒体网络传媒有限公司版权所有
 * @creation date: 2017/7/1
 * @description:${desc}
 * @update date :
 */
public class UserEvent extends EventBusType{
    //注册消息传递
    public static String TYPE_EVENT_REGISTER = "type_event_register";

    private String phone;

    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
