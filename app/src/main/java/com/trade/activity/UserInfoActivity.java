package com.trade.activity;

import android.support.v4.view.ViewPager;

import com.bear.customerview.widget.PagerSlidingTabStrip;
import com.trade.R;
import com.trade.adapter.UserPageAdapter;
import butterknife.BindView;

/**
 * Created by yxf on 2017/4/30.
 */

public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.user_pager_tab)
    PagerSlidingTabStrip pagerStrip;

    @BindView(R.id.user_view_pager)
    ViewPager userPager;

    @Override
    protected void initView() {
        setViewLayout(R.string.attention_text, R.layout.activity_user_info);

        userPager.setAdapter(new UserPageAdapter(getSupportFragmentManager()));
        pagerStrip.setViewPager(userPager);
    }
}
