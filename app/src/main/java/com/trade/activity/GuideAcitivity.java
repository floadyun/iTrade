package com.trade.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.trade.R;
import com.trade.adapter.GuideAdapter;
import com.trade.util.ConstUtil;
import com.trade.util.PreferenceUtil;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首次启动APP时显示
 */
public class GuideAcitivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    @BindView(R.id.guide_view_pager)
    ViewPager guidePager;

    @BindView(R.id.guide_point_layout)
    LinearLayout pointLayout;//放置圆点

    //最后一页的按钮
    @BindView(R.id.guide_start_btn)
    ImageButton startBtn;

    private int []imageIdArray;//图片资源的数组

    private List<View> viewList;//图片资源的集合

    private ImageView []ivPointArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guide);

        ButterKnife.bind(this);
        //加载ViewPager
        initViewPager();
        //加载底部圆点
        initPoint();
    }

    /**
     * 加载底部圆点
     */
    private void initPoint() {
        //根据ViewPager的item数量实例化数组
        ivPointArray = new ImageView[viewList.size()];
        //循环新建底部圆点ImageView，将生成的ImageView保存到数组中
        int size = viewList.size();
        for (int i = 0;i<size;i++){
            ImageView pointImage = new ImageView(this);
            pointImage.setLayoutParams(new ViewGroup.LayoutParams(50,50));
            pointImage.setScaleType(ImageView.ScaleType.CENTER);
            ivPointArray[i] = pointImage;
            //第一个页面需要设置为选中状态，这里采用两张不同的图片
            if (i == 0){
                pointImage.setImageResource(R.drawable.guide_point_selected);
            }else{
                pointImage.setImageResource(R.drawable.guide_point_normal);
            }
            //将数组中的ImageView加入到ViewGroup
            pointLayout.addView(ivPointArray[i]);
        }
    }
    /**
     * 加载图片ViewPager
     */
    private void initViewPager() {
        //实例化图片资源
        imageIdArray = new int[]{R.drawable.guide_page_1,R.drawable.guide_page_2,R.drawable.guide_page_3};
        viewList = new ArrayList<>();
        //获取一个Layout参数，设置为全屏
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);

        //循环创建View并加入到集合中
        int len = imageIdArray.length;
        for (int i = 0;i<len;i++){
            //new ImageView并设置全屏和图片资源
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setBackgroundResource(imageIdArray[i]);

            //将ImageView加入到集合中
            viewList.add(imageView);
        }
        //View集合初始化好后，设置Adapter
        guidePager.setAdapter(new GuideAdapter(viewList));
        //设置滑动监听
        guidePager.setOnPageChangeListener(this);
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 滑动后的监听
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
        //循环设置当前页的标记图
        int length = imageIdArray.length;
        for (int i = 0;i<length;i++){
            ivPointArray[position].setImageResource(R.drawable.guide_point_selected);
            if (position != i){
                ivPointArray[i].setImageResource(R.drawable.guide_point_normal);
            }
        }
        //判断是否是最后一页，若是则显示按钮
        if (position == imageIdArray.length - 1){
            startBtn.setVisibility(View.VISIBLE);
            pointLayout.setVisibility(View.GONE);
        }else {
            startBtn.setVisibility(View.GONE);
            if(position==imageIdArray.length-2){
                pointLayout.setVisibility(View.VISIBLE);
            }
        }
    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }
    /**
     * 跳转至登录页面
     * @param view
     */
    public void goLogin(View view){
        PreferenceUtil.getPreference(this).setBoolPreference(ConstUtil.IS_FIRST,false);

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

        this.finish();
    }
}
