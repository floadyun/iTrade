package com.trade.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/*
 * @copyright : yixf
 *
 * @author : yixf
 *
 * @version :1.0
 *
 * @creation date: 2017/11/19
 *
 * @description:个人中心
 */
public class TestEntitiy implements MultiItemEntity {

    private int itemType;

    public TestEntitiy(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
