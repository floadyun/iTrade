package com.trade.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.trade.R;
import com.trade.adapter.base.CommonAdapter;
import com.trade.adapter.base.ViewHolder;
import com.trade.entity.CurrencyEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yxf on 2017/5/3.
 */

public class CurrencyActivity extends BaseActivity {

    @BindView(R.id.currency_recycler)
    RecyclerView recyclerView;

    private List<CurrencyEntity> currencyList;

    @Override
    protected void initView() {
        setViewLayout(R.string.currency_title_text,R.layout.activity_currency_layout);

        initData();
    }
    private void initData(){
        currencyList = new ArrayList<>();
        currencyList.add(new CurrencyEntity());
        currencyList.add(new CurrencyEntity());
        currencyList.add(new CurrencyEntity());
        currencyList.add(new CurrencyEntity());
        currencyList.add(new CurrencyEntity());
        currencyList.add(new CurrencyEntity());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CommonAdapter(this,R.layout.item_currency_layout,currencyList) {
            @Override
            public void convert(ViewHolder holder, Object o) {

            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }
        });
    }
}
