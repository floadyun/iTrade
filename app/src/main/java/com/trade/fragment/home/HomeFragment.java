package com.trade.fragment.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.trade.R;
import com.trade.adapter.HomeMutipleAdapter;
import com.trade.entity.TestEntitiy;
import com.trade.fragment.BaseFragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

/*
 * @copyright : yixf
 *
 * @author : yixf
 *
 * @version :1.0
 *
 * @creation date: 2017/11/18
 *
 * @description:个人中心
 */
public class HomeFragment extends BaseFragment{

    @BindView(R.id.home_recycler)
    RecyclerView home_recycler;

    private HomeMutipleAdapter homeAdapter;

    private static HomeFragment homeFragment;

    public static synchronized HomeFragment newInstance(){
        if(homeFragment==null){
            homeFragment = new HomeFragment();
        }
        return homeFragment;
    }
    @Override
    protected void initFragemntView() {
        setFragmentView(R.layout.fragment_home);

        List<TestEntitiy> mDatas = new ArrayList<>();
        mDatas.add(new TestEntitiy(0));
        mDatas.add(new TestEntitiy(1));
        mDatas.add(new TestEntitiy(2));
        mDatas.add(new TestEntitiy(3));

        homeAdapter = new HomeMutipleAdapter(mDatas);
        
        home_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        home_recycler.setAdapter(homeAdapter);
    }
}
