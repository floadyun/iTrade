package com.trade.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.trade.fragment.BaseFragment;
import com.trade.fragment.UserFragment;
import com.trade.fragment.user.MyCommentFragment;
import com.trade.fragment.user.MyPlanFragment;
import com.trade.fragment.user.MyShareFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxf on 2017/5/7.
 */

public class UserPageAdapter extends FragmentPagerAdapter {

    private static String[] userTabs = new String[]{
      "交易计划","晒单分享","评论"
    };

    private List<BaseFragment> userFragments;

    public UserPageAdapter(FragmentManager fm) {
        super(fm);
        userFragments = new ArrayList<>();
        userFragments.add(new MyPlanFragment());
        userFragments.add(new MyShareFragment());
        userFragments.add(new MyCommentFragment());
    }
    @Override
    public Fragment getItem(int position) {
        return userFragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return userTabs[position];
    }

    @Override
    public int getCount() {
        return userTabs.length;
    }
}
