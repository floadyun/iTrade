package com.bear.customerview.recyclergallery;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bear.customerview.util.ScreenUtils;

/**
 * @author :xfyi
 * @version :1.0
 * @copyright : 深圳市创冠新媒体网络传媒有限公司版权所有
 * @creation date: 2017/6/19
 * @description:adapter中调用onCreateViewHolder, onBindViewHolder
 * @update date :
 */
public class CardAdapterHelper {
    private int mPagePadding = 10;
    private int mShowLeftCardWidth = 10;

    public void onCreateViewHolder(ViewGroup parent, View itemView) {
        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) itemView.getLayoutParams();
        lp.width = parent.getWidth() - ScreenUtils.dp2px(itemView.getContext(), 2 * (mPagePadding + mShowLeftCardWidth));
        itemView.setLayoutParams(lp);
    }

    public void onBindViewHolder(View itemView, final int position, int itemCount) {
        int padding = ScreenUtils.dp2px(itemView.getContext(), mPagePadding);
        itemView.setPadding(padding, 0, padding, 0);
        int leftMarin = position == 0 ? padding + ScreenUtils.dp2px(itemView.getContext(), mShowLeftCardWidth) : 0;
        int rightMarin = position == itemCount - 1 ? padding + ScreenUtils.dp2px(itemView.getContext(), mShowLeftCardWidth) : 0;
        setViewMargin(itemView, leftMarin, 0, rightMarin, 0);
    }

    private void setViewMargin(View view, int left, int top, int right, int bottom) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (lp.leftMargin != left || lp.topMargin != top || lp.rightMargin != right || lp.bottomMargin != bottom) {
            lp.setMargins(left, top, right, bottom);
            view.setLayoutParams(lp);
        }
    }

    public void setPagePadding(int pagePadding) {
        mPagePadding = pagePadding;
    }

    public void setShowLeftCardWidth(int showLeftCardWidth) {
        mShowLeftCardWidth = showLeftCardWidth;
    }
}
