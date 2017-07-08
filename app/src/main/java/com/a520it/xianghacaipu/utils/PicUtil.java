package com.a520it.xianghacaipu.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 图片的工具类
 */

public class PicUtil {
    /**
     * 缓存图片
     * @param path 缓存的路径
     * @param in    图片的输入流
     * @param picName   图片的名字
     * @throws FileNotFoundException 指定的文件不存在或者打不开
     */
    public static void cacheBannerPic(String path, InputStream in, String picName){
        Bitmap bitmap = BitmapFactory.decodeStream(in);
        File file = new File(path);
        //路径不存在就创建
        if (!file.exists()) {
            file.mkdirs();
        }

        try {
            File picFile = new File(file, "/" + picName);
            FileOutputStream out = null;
            out = new FileOutputStream(picFile);
            BufferedOutputStream mBuff = new BufferedOutputStream(out);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, mBuff);

            mBuff.flush();
            mBuff.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取图片名字,以hashcode的格式
     * @param url
     * @return
     */
    public static String getPicHashCode(String url){
        return url.hashCode() + "";
    }

    /**
     * 从指定目录获取图片
     * @param filePath 图片路径
     * @return
     */
    public static Bitmap readBitmapFromFileDescriptor(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fis.getFD(), null, options);

            int inSampleSize = 1;

            options.inJustDecodeBounds = false;
            options.inSampleSize = inSampleSize;

            return BitmapFactory.decodeFileDescriptor(fis.getFD(), null, options);
        } catch (Exception ex) {
        }
        return null;
    }
}
