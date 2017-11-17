package com.trade.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bear.customerview.carouseview.CarouseButton;
import com.trade.R;

/*
 *
 * @copyright : 深圳市创冠新媒体网络传媒有限公司版权所有
 *
 * @author :liuyuxing
 *
 * @version :1.0
 *
 * @creation date: 2017/5/22 0022
 *
 * @description:选择图片/拍照
 *
 * @update date :
 */
public class SelectAlbumFragment extends DialogFragment implements View.OnClickListener {

    private CarouseButton take_picture_btn;

    private CarouseButton select_album_button;

    private CarouseButton cancel_button;

    private SelectAlbumFragment.OnSelectClickListener onSelectClickListener;

    public void setOnSelectClickListener(SelectAlbumFragment.OnSelectClickListener onSelectClickListener) {
        this.onSelectClickListener = onSelectClickListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // 使用不带Theme的构造器, 获得的dialog边框距离屏幕仍有几毫米的缝隙。
        Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置Content前设定
        dialog.setContentView(R.layout.fragment_select_capture);
        dialog.setCanceledOnTouchOutside(true); // 外部点击取消
        // 设置宽度为屏宽, 靠近屏幕底部。
        final Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.AnimBottom);
        final WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM; // 紧贴底部
        lp.width = WindowManager.LayoutParams.MATCH_PARENT; // 宽度持平
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        take_picture_btn = (CarouseButton) dialog.findViewById(R.id.take_picture_btn);
        select_album_button = (CarouseButton) dialog.findViewById(R.id.select_album_button);
        cancel_button = (CarouseButton) dialog.findViewById(R.id.cancel_button);
        take_picture_btn.setOnClickListener(this);
        select_album_button.setOnClickListener(this);
        cancel_button.setOnClickListener(this);
        return dialog;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.take_picture_btn:
                if(null!=onSelectClickListener){
                    onSelectClickListener.OnOpenCamera(this);
                }
                break;
            case R.id.select_album_button:
                if(null!=onSelectClickListener){
                    onSelectClickListener.OnOpenAlbum(this);
                }
                break;
            case R.id.cancel_button:
                dismiss();
                break;
        }
        dismiss();
    }

    public interface OnSelectClickListener{
        void OnOpenAlbum(SelectAlbumFragment dialogFragment);//打开相册
        void OnOpenCamera(SelectAlbumFragment dialogFragment);//打开相机
    }
}
