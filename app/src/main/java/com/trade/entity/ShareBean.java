package com.trade.entity;

/**
 * Created by yxf on 2017/5/7.
 */

public class ShareBean extends BaseEntity {
    private int img;
    private String title;

    public ShareBean(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
