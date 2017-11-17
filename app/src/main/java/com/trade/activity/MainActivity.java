package com.trade.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.trade.R;
import com.trade.fragment.AddNewPlanFragment;
import com.trade.fragment.FindFragment;
import com.trade.fragment.UserFragment;
import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SupportActivity implements BottomNavigationBar.OnTabSelectedListener{

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initNavigationBar();
    }

    /**
     * 初始化NaviationBar
     */
    private void initNavigationBar(){
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_bottom_home, "首页")).setActiveColor(R.color.colorAccent)
//                .addItem(new BottomNavigationItem(R.drawable.ic_bottom_attention, "关注")).setActiveColor(R.color.colorAccent)
                .addItem(new BottomNavigationItem(R.drawable.ic_bottom_add, "新建")).setActiveColor(R.color.colorAccent)
//                .addItem(new BottomNavigationItem(R.drawable.ic_bottom_cycle, "交易圈")).setActiveColor(R.color.colorAccent)
                .addItem(new BottomNavigationItem(R.drawable.ic_bottom_my, "我的")).setActiveColor(R.color.colorAccent)
                .setFirstSelectedPosition(0)
                .initialise();
        fragments = getFragmentList();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }
    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.content_layout, FindFragment.newInstance());
        transaction.commit();
    }

    /**
     * 返回Fragment列表
     * @return
     */
    public static List<Fragment> getFragmentList(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(FindFragment.newInstance());
//        fragments.add(AttentionFragment.newInstance());
        fragments.add(AddNewPlanFragment.newInstance());
//        fragments.add(TradeCircleFragment.newInstance());
        fragments.add(UserFragment.newInstance());
        return fragments;
    }
    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.replace(R.id.content_layout, fragment);
                } else {
                    ft.add(R.id.content_layout,fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }
    }
    @Override
    public void onTabReselected(int position) {

    }
    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fragments.get(1).onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}