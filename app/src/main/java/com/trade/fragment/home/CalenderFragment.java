package com.trade.fragment.home;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.trade.R;
import com.trade.api.ApiHelper;
import com.trade.fragment.BaseFragment;

import butterknife.BindView;

/**
 * Created by yxf on 2017/5/6.
 */

public class CalenderFragment extends BaseFragment {

    @BindView(R.id.calender_web_view)
    WebView calenderView;

    @Override
    protected void initFragemntView() {
        setFragmentView(R.layout.fragment_calender_layout);

        calenderView.setWebChromeClient(new WebChromeClient());
        calenderView.setWebViewClient(new WebViewClient());
        calenderView.loadUrl(ApiHelper.CJRL_URL);
        calenderView.getSettings().setUseWideViewPort(true);//关键点
    }
}
