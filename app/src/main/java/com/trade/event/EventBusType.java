package com.trade.event;

import com.tencent.wxop.stat.event.EventType;

/**
 * Created by yixiaofei on 2017/3/23 0023.
 * Event消息传递对象
 * 需要传递的数据 可添加
 */
public class EventBusType{
    //事件类型
    private String eventType;
    //字符串数据
    private String stringValue;
    //整型数据
    private int integerValue;

    public EventBusType() {
    }

    public EventBusType(String eventType) {
        this.eventType = eventType;
    }

    public EventBusType(int integerValue) {
        this.integerValue = integerValue;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }
}
