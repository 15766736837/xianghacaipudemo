package com.a520it.xianghacaipu.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.a520it.xianghacaipu.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/**
 * Created by Lai on 2017/6/21.
 */

public class LoadImageUtil {
    private static LoadImageUtil mInstance;
    private ImageLoader mImageLoader;
    private DisplayImageOptions mOptions;

    private LoadImageUtil() {
        mImageLoader = ImageLoader.getInstance();
        //解决图片错位的问题,设置缓冲
//        config(R.mipmap.ic_launcher);
        config(0x000000);
    }

    public static LoadImageUtil getInstance() {
        if (mInstance == null) {
            synchronized (LoadImageUtil.class) {
                if (mInstance == null) {
                    mInstance = new LoadImageUtil();
                }
            }
        }
        return mInstance;
    }

    public void display(String url, ImageView imageView) {
        mImageLoader.displayImage(url, imageView, mOptions);
    }

    /**
     * 设置默认图片
     */
    private int mDefaultPicId = R.mipmap.ic_launcher;//记录每次设置的默认展示图片

    public void display(String url, ImageView imageView, int imageRes) {
        if (imageRes != mDefaultPicId) {
            mDefaultPicId = imageRes;//记录
            config(imageRes);
        }
        mImageLoader.displayImage(url, imageView, mOptions);
    }

    private void config(int imageRes) {
        mOptions = new DisplayImageOptions.Builder().showImageOnLoading(imageRes) // resource or drawable
                .resetViewBeforeLoading(false)  // default
                .delayBeforeLoading(100).cacheInMemory(true) // default
                .cacheOnDisk(true) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
                .build();
    }
}
