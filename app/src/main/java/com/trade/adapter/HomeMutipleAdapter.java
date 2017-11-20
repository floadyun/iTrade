package com.trade.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.bear.customerview.glide.GlideApp;
import com.bear.customerview.widget.banner.BGABanner;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.trade.R;
import com.trade.adapter.base.CommonAdapter;
import com.trade.adapter.base.ViewHolder;
import com.trade.entity.Banner;
import com.trade.entity.TestEntitiy;
import java.util.ArrayList;
import java.util.List;

/*
 * @copyright : yixf
 *
 * @author : yixf
 *
 * @version :1.0
 *
 * @creation date: 2017/11/19
 *
 * @description:个人中心
 */
public class HomeMutipleAdapter extends BaseMultiItemQuickAdapter<TestEntitiy,BaseViewHolder> {

    public HomeMutipleAdapter(List<TestEntitiy> data) {
        super(data);
        addItemType(0, R.layout.include_home_banner);
        addItemType(1, R.layout.include_home_menu);
        addItemType(2, R.layout.home_type_course);
        addItemType(3, R.layout.item_recycler_layout);
    }
    @Override
    protected void convert(BaseViewHolder helper, TestEntitiy item) {
            switch (item.getItemType()){
                case 0:
                    setTopBanner(helper);
                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    RecyclerView item_recycler = helper.getView(R.id.item_recycler);
                    List<Banner> banners = new ArrayList<>();
                    banners.add(new Banner());
                    banners.add(new Banner());
                    banners.add(new Banner());
                    banners.add(new Banner());
                    banners.add(new Banner());
                    banners.add(new Banner());
                    item_recycler.setLayoutManager(new GridLayoutManager(mContext,2));
                    item_recycler.setAdapter(new CommonAdapter(mContext,R.layout.item_course_layout,banners) {
                        @Override
                        public void convert(ViewHolder holder, Object o) {

                        }

                        @Override
                        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

                        }
                    });
                    break;
            }
    }
    /**
     * 初始化首页的商品广告条
     */
    private void initImageSlider(BaseViewHolder helper) {

        SliderLayout sliderLayout = helper.getView(R.id.home_slider);
//        indicator = (PagerIndicator) v.findViewById(R.id.custom_indicator);

        //准备好要显示的数据
        List<String> imageUrls = new ArrayList<>();
        final List<String> descriptions = new ArrayList<>();
        imageUrls.add("http://m.360buyimg.com/mobilecms/s300x98_jfs/t2416/102/20949846/13425/a3027ebc/55e6d1b9Ne6fd6d8f.jpg");
        imageUrls.add("http://m.360buyimg.com/mobilecms/s300x98_jfs/t1507/64/486775407/55927/d72d78cb/558d2fbaNb3c2f349.jpg");
        imageUrls.add("http://m.360buyimg.com/mobilecms/s300x98_jfs/t1363/77/1381395719/60705/ce91ad5c/55dd271aN49efd216.jpg");
        descriptions.add("新品推荐");
        descriptions.add("时尚男装");
        descriptions.add("家电秒杀");

        for (int i = 0; i < imageUrls.size(); i++) {
            //新建三个展示View，并且添加到SliderLayout
            TextSliderView tsv = new TextSliderView(mContext);
            tsv.image(imageUrls.get(i)).description(descriptions.get(i));
            final int finalI = i;
            tsv.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
//                    Toast.makeText(getActivity(), descriptions.get(finalI), Toast.LENGTH_SHORT).show();
                }
            });
            sliderLayout.addSlider(tsv);
        }

        //对SliderLayout进行一些自定义的配置
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setDuration(3000);
        //      sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//        sliderLayout.setCustomIndicator(indicator);
    }

    private void setTopBanner(BaseViewHolder helper){//准备好要显示的数据
        final List<String> imageUrls = new ArrayList<>();
        final List<String> descriptions = new ArrayList<>();
        imageUrls.add("http://m.360buyimg.com/mobilecms/s300x98_jfs/t2416/102/20949846/13425/a3027ebc/55e6d1b9Ne6fd6d8f.jpg");
        imageUrls.add("http://m.360buyimg.com/mobilecms/s300x98_jfs/t1507/64/486775407/55927/d72d78cb/558d2fbaNb3c2f349.jpg");
        imageUrls.add("http://m.360buyimg.com/mobilecms/s300x98_jfs/t1363/77/1381395719/60705/ce91ad5c/55dd271aN49efd216.jpg");
        descriptions.add("新品推荐");
        descriptions.add("时尚男装");
        descriptions.add("家电秒杀");
        BGABanner banner = helper.getView(R.id.home_slider);
        banner.setDelegate(new BGABanner.Delegate<View, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, String model, int position) {

            }
        });
        banner.setAdapter(new BGABanner.Adapter<View, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, View itemView, String model, int position) {
                ImageView  itemImage =  itemView.findViewById(R.id.item_banner_image);
                GlideApp.getInstance().with(mContext,R.drawable.home_top_pic,imageUrls.get(position),itemImage);
            }
        });

        banner.setData(R.layout.item_banner_image, imageUrls, null);
    }
}
