package com.a520it.xianghacaipu.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
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

    /* uri转化为bitmap */
    public Bitmap getBitmapFromUri(Uri uri, Context c) {
        try {
            // 读取uri所在的图片
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(c.getContentResolver(), uri);
            return bitmap;
        } catch (Exception e) {
            Log.e("[Android]", e.getMessage());
            Log.e("[Android]", "目录为：" + uri);
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 字符串转换成图片
     * @param str
     * @return
     */
    public static Bitmap createBitmap(String str) {
        Bitmap bp = Bitmap.createBitmap(60, 30, Bitmap.Config.ARGB_8888); //画布大小
        Canvas c = new Canvas(bp);
        Paint paint1 = new Paint();
        paint1.setColor(Color.BLACK);
        c.drawColor(Color.BLUE);//画布颜色

        Paint paint2 = new Paint();//画姓名前边的间隔
        paint2.setColor(Color.WHITE);
        paint2.setStrokeWidth(1f);
        c.drawLine(0, 0, 0, 30, paint2);

        Paint paint = new Paint();
        paint.setTextSize(20);//字体大小
        paint.setColor(Color.BLACK);//字体大小
        paint.setFakeBoldText(true); //粗体
        paint.setTextSkewX(0);//斜度
        paint.setTextAlign(Paint.Align.CENTER);
        c.drawText(str, 30, 20, paint);//文字位置
        c.save( Canvas.ALL_SAVE_FLAG );//保存
        c.restore();//
        return bp;
    }

}
