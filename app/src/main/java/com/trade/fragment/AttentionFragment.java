package com.trade.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.trade.R;
import com.trade.adapter.base.CommonAdapter;
import com.trade.adapter.base.ViewHolder;
import com.trade.entity.AttentionBean;
import com.trade.util.ActivityUtil;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yanzhenjie.recyclerview.swipe.touch.OnItemMoveListener;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yixiaofei on 2017/3/21 0021.
 */

public class AttentionFragment extends BaseFragment {

    private static AttentionFragment attentionFragment;

    @BindView(R.id.attention_list)
    SwipeMenuRecyclerView attentionRecycler;

    private List<AttentionBean> attentionList;

    private CommonAdapter<AttentionBean> commonAdapter;

    public static synchronized AttentionFragment newInstance(){
        if(attentionFragment==null){
            attentionFragment = new AttentionFragment();
        }
        return attentionFragment;
    }
    @Override
    protected void initFragemntView() {
        setFragmentView(R.layout.fragment_attention);

        initRecyclerView();
    }

    /**
     * 跳转至交易圈
     */
    @OnClick(R.id.friend_action_layout) void toFriendAciton(){
        ActivityUtil.startTradeCircle(getContext());
    }
    private void initRecyclerView(){
        attentionList = new ArrayList<>();
        attentionList.add(new AttentionBean());
        attentionList.add(new AttentionBean());
        attentionList.add(new AttentionBean());
        attentionList.add(new AttentionBean());
        attentionList.add(new AttentionBean());
        attentionList.add(new AttentionBean());
        attentionList.add(new AttentionBean());
        attentionList.add(new AttentionBean());

        //如果布局大小一致有利于优化
        attentionRecycler.setHasFixedSize(true);
        //使用线性布局管理器
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext());
        attentionRecycler.setLayoutManager(layout);
        commonAdapter = new CommonAdapter<AttentionBean>(getContext(),R.layout.attention_layout_item,attentionList){
            @Override
            public void convert(ViewHolder holder, AttentionBean AttentionBean) {

            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                holder.setOnClickListener(R.id.attention_item_layout, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityUtil.startUserInfo(getActivity());
                    }
                });
            }
        };
//        attentionRecycler.setItemViewSwipeEnabled(true); // 开启滑动删除。
        attentionRecycler.setAdapter(commonAdapter);
        attentionRecycler.setSwipeMenuCreator(new SwipeMenuCreator() {
            @Override
            public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
                SwipeMenuItem closeItem = new SwipeMenuItem(getContext())
                        .setBackgroundColor(R.color.colorAccent)
                        .setText(R.string.attention_delete_text) // 图片。
                        .setWidth(200) // 菜单宽度。
                        .setHeight(50); // 菜单高度。
                swipeRightMenu.addMenuItem(closeItem); // 在右侧添加一个菜单。
            }
        });
        // 设置操作监听。
        attentionRecycler.setOnItemMoveListener(new OnItemMoveListener() {
            @Override
            public boolean onItemMove(int fromPosition, int toPosition) {
                return false;
            }
            @Override
            public void onItemDismiss(int position) {
                // Item被侧滑删除时，删除数据，并更新adapter。
                attentionList.remove(position);
                commonAdapter.notifyItemRemoved(position);
            }
        });// 监听拖拽，更新UI。
    }
}
