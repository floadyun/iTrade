package com.bear.customerview.util;

import android.app.Activity;

import com.bear.customerview.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

/**
 * Created by elsonfeng on 2017/9/7.
 */

public class PictureSelectUtil {
    /**
     * 选择文件
     * @param context
     * @param picType
     * @param selectModel
     * @param isCapture
     * @param ucropWidth
     * @param ucropHeight
     * @param isCrop
     * @param isRound
     * @param maxNum
     */
    public static void selectFile(Activity context,int picType,int selectModel,boolean isCapture,int ucropWidth,int ucropHeight,boolean isCrop,boolean isRound,int maxNum){
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector.create(context)
                .openGallery(picType)//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .theme(R.style.picture_default_style)//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .maxSelectNum(maxNum)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(3)// 每行显示个数 int
                .selectionMode(selectModel)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .previewVideo(true)// 是否可预览视频 true or false
                .enablePreviewAudio(false) // 是否可播放音频 true or false
                .compressGrade(Luban.THIRD_GEAR)// luban压缩档次，默认3档 Luban.THIRD_GEAR、Luban.FIRST_GEAR、Luban.CUSTOM_GEAR
                .isCamera(isCapture)// 是否显示拍照按钮 true or false
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                .enableCrop(isCrop)// 是否裁剪 true or false
                .compress(!isCrop)// 是否压缩 true or false
                .compressMode(PictureConfig.SYSTEM_COMPRESS_MODE)//系统自带 or 鲁班压缩 PictureConfig.SYSTEM_COMPRESS_MODE or LUBAN_COMPRESS_MODE
                .glideOverride(160,160)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .withAspectRatio(ucropWidth,ucropHeight)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示 true or false
                .isGif(false)// 是否显示gif图片 true or false
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(isRound)// 是否圆形裁剪 true or false
                .showCropFrame(!isRound)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .showCropGrid(!isRound)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .openClickSound(true)// 是否开启点击声音 true or false
                .selectionMedia(null)// 是否传入已选图片 List<LocalMedia> list
//                .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
//                .cropCompressQuality(80)// 裁剪压缩质量 默认90 int
//                .compressMaxKB(1024)//压缩最大值kb compressGrade()为Luban.CUSTOM_GEAR有效 int
//                .compressWH(ucropWidth,ucropHeight) // 压缩宽高比 compressGrade()为Luban.CUSTOM_GEAR有效  int
//                .cropWH(ucropWidth,ucropHeight)// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
//                .rotateEnabled(true) // 裁剪是否可旋转图片 true or false
//                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
                .videoQuality(1)// 视频录制质量 0 or 1 int
                .recordVideoSecond(15)//视频秒数录制 默认60s int
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }
    /**
     * 选择图片，传入列表
     * @param context
     * @param picType
     * @param selectModel
     * @param isCapture
     * @param ucropWidth
     * @param ucropHeight
     * @param isCrop
     * @param isRound
     */
    public static void selectFileByMedial(Activity context, int picType, int selectModel, boolean isCapture, int ucropWidth, int ucropHeight, boolean isCrop, boolean isRound, List<LocalMedia> localMedias){
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector.create(context)
                .openGallery(picType)//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .theme(R.style.picture_default_style)//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .maxSelectNum(5)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(3)// 每行显示个数 int
                .selectionMode(selectModel)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .previewVideo(true)// 是否可预览视频 true or false
                .enablePreviewAudio(false) // 是否可播放音频 true or false
                .compressGrade(Luban.THIRD_GEAR)// luban压缩档次，默认3档 Luban.THIRD_GEAR、Luban.FIRST_GEAR、Luban.CUSTOM_GEAR
                .isCamera(isCapture)// 是否显示拍照按钮 true or false
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                .enableCrop(isCrop)// 是否裁剪 true or false
                .compress(!isCrop)// 是否压缩 true or false
                .compressMode(PictureConfig.SYSTEM_COMPRESS_MODE)//系统自带 or 鲁班压缩 PictureConfig.SYSTEM_COMPRESS_MODE or LUBAN_COMPRESS_MODE
                .glideOverride(160,160)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .withAspectRatio(ucropWidth,ucropHeight)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示 true or false
                .isGif(false)// 是否显示gif图片 true or false
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(isRound)// 是否圆形裁剪 true or false
                .showCropFrame(!isRound)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .showCropGrid(!isRound)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .openClickSound(true)// 是否开启点击声音 true or false
                .selectionMedia(localMedias)// 是否传入已选图片 List<LocalMedia> list
//                .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
//                .cropCompressQuality(80)// 裁剪压缩质量 默认90 int
//                .compressMaxKB(1024)//压缩最大值kb compressGrade()为Luban.CUSTOM_GEAR有效 int
//                .compressWH(ucropWidth,ucropHeight) // 压缩宽高比 compressGrade()为Luban.CUSTOM_GEAR有效  int
//                .cropWH(ucropWidth,ucropHeight)// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
//                .rotateEnabled(true) // 裁剪是否可旋转图片 true or false
//                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
                .videoQuality(1)// 视频录制质量 0 or 1 int
                .recordVideoSecond(30)//视频秒数录制 默认60s int
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }
    /**
     * 打开相机
     * @param context
     * @param ucropWidth
     * @param ucropHeight
     * @param isCrop
     * @param isRound
     */
    public static void openCamera(Activity context,int ucropWidth,int ucropHeight,boolean isCrop,boolean isRound){
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector.create(context)
                .openCamera(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .theme(R.style.picture_default_style)//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .maxSelectNum(9)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(3)// 每行显示个数 int
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .previewVideo(true)// 是否可预览视频 true or false
                .enablePreviewAudio(false) // 是否可播放音频 true or false
                .compressGrade(Luban.THIRD_GEAR)// luban压缩档次，默认3档 Luban.THIRD_GEAR、Luban.FIRST_GEAR、Luban.CUSTOM_GEAR
                .isCamera(false)// 是否显示拍照按钮 true or false
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                .enableCrop(isCrop)// 是否裁剪 true or false
                .compress(!isCrop)// 是否压缩 true or false
                .compressMode(PictureConfig.SYSTEM_COMPRESS_MODE)//系统自带 or 鲁班压缩 PictureConfig.SYSTEM_COMPRESS_MODE or LUBAN_COMPRESS_MODE
                .glideOverride(160,160)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .withAspectRatio(ucropWidth,ucropHeight)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示 true or false
                .isGif(false)// 是否显示gif图片 true or false
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(isRound)// 是否圆形裁剪 true or false
                .showCropFrame(!isRound)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .showCropGrid(!isRound)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .openClickSound(true)// 是否开启点击声音 true or false
                .selectionMedia(null)// 是否传入已选图片 List<LocalMedia> list
//                .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
//                .cropCompressQuality(80)// 裁剪压缩质量 默认90 int
//                .compressMaxKB(1024)//压缩最大值kb compressGrade()为Luban.CUSTOM_GEAR有效 int
//                .compressWH(ucropWidth,ucropHeight) // 压缩宽高比 compressGrade()为Luban.CUSTOM_GEAR有效  int
//                .cropWH(ucropWidth,ucropHeight)// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
//                .rotateEnabled(true) // 裁剪是否可旋转图片 true or false
//                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
                .videoQuality(1)// 视频录制质量 0 or 1 int
                .recordVideoSecond(30)//视频秒数录制 默认60s int
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }
}
