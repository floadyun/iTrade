package com.trade.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.trade.R;
import butterknife.ButterKnife;

/**
 * Created by yixiaofei on 2017/2/25 0025.
 */

public abstract class BaseActivity extends AppBaseActivity {

    protected RelativeLayout toolbar;

    protected TextView titleText;

    private RelativeLayout contentLayout;

    public RelativeLayout backLayout;

    protected Button rightButton;

    protected ImageButton rightImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base_layout);

        toolbar = (RelativeLayout) findViewById(R.id.tool_bar);

        backLayout = (RelativeLayout) findViewById(R.id.base_back_layout);
        titleText = (TextView) findViewById(R.id.title_text);
        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishSelf();
            }
        });

        contentLayout = (RelativeLayout) findViewById(R.id.base_content_layout);

        rightButton = (Button) findViewById(R.id.tool_bar_right_btn);
        rightImage = (ImageButton) findViewById(R.id.tool_bar_right_img);

        initView();
    }

    /**
     * 隐藏标题栏
     */
    public void hideTitle() {
        getSupportActionBar().hide();
    }
    // 实例化presenter
//    public abstract T initPresenter();

    protected Activity getActivity() {
        return this;
    }

    /**
     * 抽象方法，初始化子类View
     */
    protected abstract void initView();

    /**
     * 显示右侧菜单选择
     */
    public void showRightButton(String text) {
        rightButton.setText(text);
        rightButton.setVisibility(View.VISIBLE);

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rightButtonClick();
            }
        });
    }

    /**
     * 显示右侧菜单选择
     */
    public void showRightButton(int rightButtonId) {
        rightButton.setText(getResources().getString(rightButtonId));
        rightButton.setVisibility(View.VISIBLE);

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rightButtonClick();
            }
        });
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        titleText.setText(title);
    }

    /**
     * 设置标题
     *
     * @param titleId
     */
    public void setTitle(int titleId) {
        titleText.setText(getResources().getString(titleId));
    }

    /**
     * 显示右侧按钮
     */
    public void showRightButtonView() {
        rightButton.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏右侧按钮
     */
    public void hideRightButtonView() {
        rightButton.setVisibility(View.GONE);
    }

    /**
     * 初始化view，继承此类的都要重写此方法
     */
    protected void setViewLayout(int titleId, int layoutId) {
        titleText.setText(getResources().getString(titleId));
        View view = getLayoutInflater().inflate(layoutId, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ButterKnife.bind(this, view);
        contentLayout.addView(view);
    }

    /**
     * 初始化view，继承此类的都要重写此方法
     */
    protected void setViewLayout(int titleId, View view) {
        titleText.setText(getResources().getString(titleId));
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ButterKnife.bind(this, view);
        contentLayout.addView(view);
    }

    /**
     * 初始化view，继承此类的都要重写此方法
     */
    protected void setViewLayout(int layoutId) {
        View view = getLayoutInflater().inflate(layoutId, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ButterKnife.bind(this, view);
        contentLayout.addView(view);
    }

    protected void rightButtonClick() {

    }
}