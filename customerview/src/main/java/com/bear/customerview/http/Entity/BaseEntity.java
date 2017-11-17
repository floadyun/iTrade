package com.bear.customerview.http.Entity;


/**
 * Created by yixiaofei on 2017/3/6 0006.
 */

public class BaseEntity{

    private int status;

    private int timeStamp;

    private String token;

    private String remark;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
