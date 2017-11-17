package com.trade.activity;

import android.view.View;
import android.widget.TextView;

import com.bear.customerview.widget.ClearEditText;
import com.trade.R;
import com.trade.entity.User;
import butterknife.BindView;

/**
 * 修改昵称
 * Created by Administrator on 2017/5/10 0010.
 */

public class ChangeNameActivity extends BaseActivity{
    /**
     * 昵称输入框
     */
    @BindView(R.id.et_edit_nickname)
    ClearEditText et_edit_nickname;

    /**
     * 底部提示语
     */
    @BindView(R.id.tv_edit_nickname_hint)
    TextView tvEditnicknameHint;
    /**
     * 初始化
     */
    @Override
    protected void initView() {
        setViewLayout(R.string.edit_nick_name_activity_title,R.layout.activity_edit_nick_name);
        showRightButton("保存");

    }

    /**
     * 显示右侧菜单选择
     */
    public void showRightButton(String text){
        rightButton.setText(text);
        rightButton.setVisibility(View.VISIBLE);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_edit_nickname.getText().toString().trim().equals("")){
                    showToastText("请填写用户昵称");
                }else{
                    UpdateName(et_edit_nickname.getText().toString());
                }
            }
        });
    }
    /**
     * 修改昵称
     */
    private void UpdateName(String nickName) {

    }
}
