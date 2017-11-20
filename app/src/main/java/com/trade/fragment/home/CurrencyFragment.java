package com.trade.fragment.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.trade.R;
import com.trade.adapter.base.CommonAdapter;
import com.trade.adapter.base.ViewHolder;
import com.trade.entity.TradePlan;
import com.trade.fragment.BaseFragment;
import com.trade.util.ActivityUtil;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

/**
 * Created by yxf on 2017/4/3.
 */

public class CurrencyFragment extends BaseFragment {

    private static CurrencyFragment currencyFragment;
    //下拉刷新控件
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    //计划列表
    @BindView(R.id.currency_recycler)
    RecyclerView currencyRecycler;

    private List<TradePlan> plans;

    private CommonAdapter commonAdapter;

    public static synchronized CurrencyFragment newInstance(){
        if(currencyFragment==null){
            currencyFragment = new CurrencyFragment();
        }
        return currencyFragment;
    }

    @Override
    protected void initFragemntView() {
        setFragmentView(R.layout.fragment_currency);

        initRefreshLayout();

        initRecycler();

        getData();
    }
    /**
     * 初始化下拉刷新控件
     */
    private void initRefreshLayout(){
        //设置下拉出现小圆圈是否是缩放出现，出现的位置，最大的下拉位置
        refreshLayout.setProgressViewOffset(true, 50, 200);

        //设置下拉圆圈的大小，两个值 LARGE， DEFAULT
        refreshLayout.setSize(SwipeRefreshLayout.LARGE);

        // 设置下拉圆圈上的颜色，蓝色、绿色、橙色、红色
        refreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        // 通过 setEnabled(false) 禁用下拉刷新
        refreshLayout.setEnabled(true);

        // 设定下拉圆圈的背景
        refreshLayout.setProgressBackgroundColor(R.color.colorAccent);

        /*
         * 设置手势下拉刷新的监听
         */
        refreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        // 刷新动画开始后回调到此方法
                        getData();
                    }
                }
        );
    }
    private void initRecycler(){
        plans = new ArrayList<>();
        currencyRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        commonAdapter = new CommonAdapter(getContext(),R.layout.item_plan_list,plans) {
            @Override
            public void convert(ViewHolder holder, Object o) {

            }
            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                holder.setImageUrl(R.id.item_plan_avator_img,plans.get(position).getUserphoto(),true);
                holder.setText(R.id.item_plan_user_name,plans.get(position).getUsername());
                holder.setText(R.id.item_plan_title,plans.get(position).getPlantitle());
                holder.setText(R.id.item_plan_open_price,plans.get(position).getOpenprice());
                holder.setText(R.id.item_plan_stop_price,plans.get(position).getStopprice());
                holder.setText(R.id.item_plan_target_price,plans.get(position).getTargetprice());
//                holder.setText(R.id.item_plan_crate_time,plans.get(position).getCreatedAt());
                holder.setOnClickListener(R.id.item_plan_view, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityUtil.startPlanDetail(getActivity());
                    }
                });
            }
        };
        currencyRecycler.setAdapter(commonAdapter);
    }
    private void getData(){

    }
}
