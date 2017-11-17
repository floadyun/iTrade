package com.trade.fragment;

import android.support.v4.view.ViewPager;

import com.bear.customerview.widget.PagerSlidingTabStrip;
import com.trade.R;
import com.trade.adapter.HomeAdapter;
import butterknife.BindView;

/**
 * Created by yixiaofei on 2017/3/21 0021.
 */

public class FindFragment extends BaseFragment{

    private static FindFragment findFragment;

    @BindView(R.id.home_tabs)
    PagerSlidingTabStrip pagerTab;

    @BindView(R.id.home_view_pager)
    ViewPager viewPager;

    public static synchronized FindFragment newInstance(){
        if(findFragment==null){
            findFragment = new FindFragment();
        }
        return findFragment;
    }
    @Override
    protected void initFragemntView() {
        setFragmentView(R.layout.fragment_find);

        viewPager.setAdapter(new HomeAdapter(getFragmentManager()));
        // Bind the tabs to the ViewPager
        pagerTab.setViewPager(viewPager);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
