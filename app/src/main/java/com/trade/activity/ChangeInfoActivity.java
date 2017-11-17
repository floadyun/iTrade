package com.trade.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bear.customerview.glide.GlideApp;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.trade.R;
import com.trade.entity.User;
import com.trade.fragment.SelectAlbumFragment;
import com.trade.util.ActivityUtil;
import com.trade.util.MediaUtil;
import java.io.File;
import java.util.List;
import butterknife.BindView;

/**
 * @author :xfyi
 * @version :1.0
 * @copyright : 深圳市创冠新媒体网络传媒有限公司版权所有
 * @creation date: 2017/7/3
 * @description:${desc}
 * @update date :
 */
public class ChangeInfoActivity extends BaseActivity {

    @BindView(R.id.change_avator_image)
    ImageView change_avator_image;

    @Override
    protected void initView() {
        setViewLayout(R.string.setting_change_user_name,R.layout.activity_change_infol);
    }
    public void itemClick(View view){
        switch (view.getId()){
            case R.id.change_avator_layout:
                showSelectHeader();
                break;
            case R.id.change_name_view:
                ActivityUtil.startChangeNameActivity(this);
                break;
        }
    }
    /**
     * 设置头像图片
     */
    private void showSelectHeader(){
        SelectAlbumFragment selectAlbumFragment = new SelectAlbumFragment();
        selectAlbumFragment.setOnSelectClickListener(new SelectAlbumFragment.OnSelectClickListener() {
            /**
             * 打开相册
             * @param dialogFragmen
             */
            @Override
            public void OnOpenAlbum(SelectAlbumFragment dialogFragmen) {
                MediaUtil.selectPicture(ChangeInfoActivity.this,PictureMimeType.ofImage());
            }
            /**
             * 打开相机
             * @param dialogFragmen
             */
            @Override
            public void OnOpenCamera(SelectAlbumFragment dialogFragmen) {
                PictureSelector.create(ChangeInfoActivity.this)
                        .openCamera(PictureMimeType.ofImage())
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });
        selectAlbumFragment.show(getSupportFragmentManager(),"SelectAlbumFragment");
    }
    List<LocalMedia> selectList;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    uploadAvator(selectList.get(0).getCutPath());
                    break;
            }
        }
    }
    /**
     * 上传头像
     * @param imagePath
     */
    private void uploadAvator(String imagePath){

    }
}
