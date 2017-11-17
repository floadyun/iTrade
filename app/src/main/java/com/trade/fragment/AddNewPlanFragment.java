package com.trade.fragment;

import android.content.Intent;
import android.net.Uri;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.czm.xcricheditor.EditItem;
import com.czm.xcricheditor.XCRichEditor;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.orhanobut.logger.Logger;
import com.trade.R;
import com.trade.entity.TradePlan;
import com.trade.entity.User;
import com.trade.global.JHApplication;
import com.trade.util.ActivityUtil;
import com.trade.util.MediaUtil;
import com.trade.widget.ArrowRowView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yixiaofei on 2017/3/21 0021.
 */

public class AddNewPlanFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener{

    private static AddNewPlanFragment addFragment;
    //计划标题
    @BindView(R.id.add_plan_title)
    EditText planTitle;
    //开仓价
    @BindView(R.id.plan_open_price_text)
    EditText openPrice;
    //目标价
    @BindView(R.id.plan_target_price_text)
    EditText targetPrice;
    //止损价
    @BindView(R.id.plan_stop_price_text)
    EditText stopPrice;
    //计划内容
    @BindView(R.id.plan_content_text)
    XCRichEditor contentText;

    @BindView(R.id.plan_radio_group)
    RadioGroup radioGroup;

    @BindView(R.id.plan_attention_radio_btn)
    RadioButton attentionBtn;

    @BindView(R.id.currency_view)
    ArrowRowView currency_view;

    public static synchronized AddNewPlanFragment newInstance(){
        if(addFragment==null){
            addFragment = new AddNewPlanFragment();
        }
        return addFragment;
    }
    @Override
    protected void initFragemntView() {
        setFragmentView(R.layout.fragment_add_plan);

        radioGroup.setOnCheckedChangeListener(this);
    }
    /**
     * 选择交易品种
     */
    @OnClick(R.id.currency_view)void selectCurrency(){
        ActivityUtil.startCurrencyActivity(getContext());
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
    /**
     * 发布计划
     */
    @OnClick(R.id.publish_plan_btn)void publishPlan(){
        if(!JHApplication.getApplication().isLogin(getContext(),true)){
            return;
        }
        if(null!=contentText.getEditImages()&&!contentText.getEditImages().isEmpty()){
            String[] imagePaths = new String[contentText.getEditImages().size()];
            for (int i=0;i<contentText.getEditImages().size();i++){
                imagePaths[i] = contentText.getEditImages().get(i);
            }
        }else{
            addPlane();
        }
    }
    private void addPlane(){
        showProgress("创建中...");

    }
    /**
     * 选择图片
     */
    @OnClick(R.id.select_pic_btn)void selectPicture(){
        MediaUtil.selectPicture(getActivity(),PictureMimeType.ofImage());
    }
    List<LocalMedia> selectList;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    List<EditItem> richItems = new ArrayList<>();
                    for (int i=0;i<selectList.size();i++){
                        EditItem item = new EditItem();
                        item.setUri(Uri.parse(selectList.get(i).getCutPath()));
                        item.setImagepath(selectList.get(i).getCutPath());
                        item.setType(1);
                        item.setContent(selectList.get(i).getCompressPath());
                        richItems.add(item);
                    }
                    contentText.addImage(richItems);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    Logger.d("onActivityResult:" + selectList.size());
                    break;
            }
        }
    }
}
