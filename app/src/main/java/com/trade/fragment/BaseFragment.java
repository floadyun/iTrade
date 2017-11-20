package com.trade.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bear.customerview.util.ToastUtil;
import com.orhanobut.logger.Logger;
import com.trade.activity.AppBaseActivity;

import butterknife.ButterKnife;

/**
 * Created by yixiaofei on 2017/2/25 0025.
 */

public abstract class BaseFragment extends Fragment {

    protected View baseView;

    protected LayoutInflater layoutInflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (baseView == null) {
            layoutInflater = inflater;
            initFragemntView();
        }
        return baseView;
    }
    protected abstract void initFragemntView();

    protected  void setFragmentView(int layoutId){
        baseView = layoutInflater.inflate(layoutId,null);
        ButterKnife.bind(this,baseView);
    }
    /**
     * 加载进度显示
     * @param title
     * @param strMessage
     */
    protected void showProgress(String title, String strMessage){
        try {
            AppBaseActivity baseActivity = (AppBaseActivity) getActivity();
            if(baseActivity!=null){
                baseActivity.showProgressDlg(title,strMessage);
            }
        }catch (Exception e){
            Logger.d("showProgress......."+e.toString());
        }
    }

    /**
     * 加载进度显示
     * @param title
     */
    public void showProgress(String title){
        showProgress(title,"");
    }
    /**
     * 加载进度显示
     */
    public void showProgress(){
        showProgress("","");
    }

    /**
     * 停止加载进度
     */
    public void stopProgress(){
        try {
            AppBaseActivity baseActivity = (AppBaseActivity) getActivity();
            if(baseActivity!=null){
                baseActivity.stopProgressDlg();
            }
        }catch (Exception e){
            Logger.d("stopProgressDlg......."+e.toString());
        }
    }
    /**
     * 信息提示
     * @param text
     */
    protected void showToastText(String text){
        ToastUtil.showToast(getContext(),text);
    }
}
