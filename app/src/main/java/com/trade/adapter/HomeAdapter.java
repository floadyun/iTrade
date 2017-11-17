package com.trade.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.trade.fragment.BaseFragment;
import com.trade.fragment.home.CalenderFragment;
import com.trade.fragment.home.CurrencyFragment;
import com.trade.fragment.home.ShareFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxf on 2017/4/3.
 */

public class HomeAdapter extends FragmentPagerAdapter {

    private static final String[] tabStr = new String[]{"交易计划","财经日历","晒单分享"};

    private List<BaseFragment> fragments;

    public HomeAdapter(FragmentManager fm){
        super(fm);
        fragments = new ArrayList<>();
        fragments.add(CurrencyFragment.newInstance());
        fragments.add(new CalenderFragment());
        fragments.add(new ShareFragment());
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabStr[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
    @Override
    public int getCount() {
        return tabStr.length;
    }
}
