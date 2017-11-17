package com.trade.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trade.R;
import com.trade.entity.ShareBean;

import java.util.List;

/**
 * Created by yxf on 2017/5/7.
 */
public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView> {

    private List<ShareBean> products;

    public MasonryAdapter(List<ShareBean> list) {
        products = list;
    }
    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_share_layout, viewGroup, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, int position) {
        masonryView.imageView.setImageResource(products.get(position).getImg());
        masonryView.textView.setText(products.get(position).getTitle());

    }
    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class MasonryView extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_share_img);
            textView = (TextView) itemView.findViewById(R.id.item_share_title);
        }

    }
}