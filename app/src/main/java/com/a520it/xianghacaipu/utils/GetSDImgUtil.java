package com.a520it.xianghacaipu.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/27 0027.
 */

public class GetSDImgUtil {

    public static ArrayList<Bitmap> getImage(File path) {
        ArrayList<Bitmap> datas = new ArrayList<>();
        if (path != null) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].getPath().endsWith(".img") || files[i].getPath().endsWith(".png")) {
                    Bitmap bitmap = BitmapFactory.decodeFile(files[i].getPath());
                    datas.add(bitmap);
                } else if (files[i].isDirectory()) {
                    datas.addAll(getImage(files[i]));
                }
            }
        }
        return datas;
    }
}
