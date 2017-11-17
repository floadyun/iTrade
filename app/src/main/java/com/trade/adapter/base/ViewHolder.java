package com.trade.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bear.customerview.glide.GlideApp;
import com.trade.R;

/**
 * Created by yxf on 2017/4/2.
 */

public class ViewHolder extends RecyclerView.ViewHolder
{
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;

    public ViewHolder(Context context, View itemView, ViewGroup parent)
    {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<View>();
    }
    public static ViewHolder get(Context context, ViewGroup parent, int layoutId)
    {

        View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        ViewHolder holder = new ViewHolder(context, itemView, parent);
        return holder;
    }


    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId)
    {
        View view = mViews.get(viewId);
        if (view == null)
        {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }
    public ViewHolder setText(int viewId, String text)
    {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }
    public ViewHolder setImageResource(int viewId, int resId)
    {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }
    public ViewHolder setImageUrl(int viewId,String url,boolean isCircle){
        if(isCircle){
            GlideApp.getInstance().withGlideCircleTransform(mContext,R.drawable.default_head_portrait,url,(ImageView) getView(viewId));
        }else{
            GlideApp.getInstance().with(mContext,R.drawable.default_head_portrait,url,(ImageView) getView(viewId));
        }
        return this;
    }
    /**
     * 设置文字颜色
     * @param textId
     * @param textColor
     * @return
     */
    public ViewHolder setTextColor(int textId,int textColor){
        TextView textView = getView(textId);
        textView.setTextColor(textColor);
        return this;
    }
    public ViewHolder setBackgroudColor(int viewId, int colorId){
        View view = getView(viewId);
        view.setBackgroundColor(colorId);
        return this;
    }
    public ViewHolder setOnClickListener(int viewId,
                                         View.OnClickListener listener)
    {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }
}