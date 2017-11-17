package com.trade.fragment;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.trade.R;
import com.trade.adapter.base.CommonAdapter;
import com.trade.adapter.base.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

/**
 * Created by yixiaofei on 2017/3/21 0021.
 */

public class TradeCircleFragment extends BaseFragment {

    private static TradeCircleFragment tradeFragment;

    @BindView(R.id.trade_tool_bar)
    Toolbar tradeBar;

    @BindView(R.id.trade_recycler)
    RecyclerView tradeRecycler;

    @BindView(R.id.trade_drawer_layout)
    DrawerLayout drawerLayout;

    private List<String> leftDatas;

    private ViewHolder currentHolder;

    public static synchronized TradeCircleFragment newInstance(){
        if(tradeFragment==null){
            tradeFragment = new TradeCircleFragment();
        }
        return tradeFragment;
    }
    @Override
    protected void initFragemntView() {
        setFragmentView(R.layout.fragment_trading_circle);

        tradeBar.setTitle("最新资讯");
        tradeBar.setTitleTextColor(getResources().getColor(R.color.white_color));
        tradeBar.setNavigationIcon(R.drawable.title_back_selector);

        leftDatas = new ArrayList<>();
        leftDatas.add("最新资讯");
        leftDatas.add("财经日历");
        leftDatas.add("交易感悟");
        leftDatas.add("EA交流");
        leftDatas.add("晒单分享");
        leftDatas.add("休闲娱乐");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        tradeRecycler.setLayoutManager(layoutManager);
        final CommonAdapter<String> commonAdapter = new CommonAdapter(getContext(),R.layout.trade_left_item_layout,leftDatas) {
            private int curSelectRow = -1;	//当前被选中的行索引
            @Override
            public void convert(ViewHolder holder, Object o) {

            }
            @Override
            public void onBindViewHolder(final ViewHolder holder, final int position) {
                holder.setOnClickListener(R.id.trade_left_layout, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        curSelectRow = position;
                        tradeBar.setTitle(leftDatas.get(position));
//                        holder.setTextColor(R.id.trade_left_text,R.color.colorAccent);
                        drawerLayout.closeDrawers();
                    }
                });
//                if(curSelectRow == position){
                    holder.setBackgroudColor(R.id.trade_left_layout,R.color.app_backgroud_color);
                    holder.setTextColor(R.id.trade_left_text,R.color.colorAccent);
//                }else{
//                    holder.setBackgroudColor(R.id.trade_left_layout,R.color.white_color);
//                    holder.setTextColor(R.id.trade_left_text,R.color.back_color);
//                }
                holder.setText(R.id.trade_left_text,leftDatas.get(position));
            }
        };
        tradeRecycler.setAdapter(commonAdapter);
    }
}
