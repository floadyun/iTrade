package com.trade.fragment.home;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.trade.R;
import com.trade.adapter.MasonryAdapter;
import com.trade.adapter.base.CommonAdapter;
import com.trade.adapter.base.ViewHolder;
import com.trade.entity.ShareBean;
import com.trade.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yxf on 2017/5/6.
 */

public class ShareFragment extends BaseFragment {

    @BindView(R.id.share_recycler)
    RecyclerView share_recycler;

    private List<ShareBean> shareList;

    @Override
    protected void initFragemntView() {
        super.initFragemntView();

        setFragmentView(R.layout.fragment_share_layout);

        initRecyclerView();
    }
    private void initRecyclerView(){
        shareList = new ArrayList<>();
        shareList.add(new ShareBean(R.drawable.app_splash,"晒单分享一"));
        shareList.add(new ShareBean(R.drawable.app_splash,"晒单分享二"));
        shareList.add(new ShareBean(R.drawable.app_splash,"晒单分享三"));
        shareList.add(new ShareBean(R.drawable.app_splash,"晒单分享四"));
        shareList.add(new ShareBean(R.drawable.app_splash,"晒单分享五"));

        //设置layoutManager
        share_recycler.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        share_recycler.addItemDecoration(decoration);

        share_recycler.setAdapter(new MasonryAdapter(shareList));
    }
}
