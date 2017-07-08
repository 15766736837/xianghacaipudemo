package com.a520it.xianghacaipu.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.a520it.xianghacaipu.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/27 0027.
 */

public class ImgGridViewAdapter extends BaseAdapter {
    private  ArrayList<Bitmap> mImages;
    private Context mContext;
    public ImgGridViewAdapter(ArrayList<Bitmap> imageViews,Context c) {
        mImages = imageViews;
        mContext = c;
    }

    @Override
    public int getCount() {
        return mImages!=null?mImages.size():0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv ;
        if(convertView==null) {
            convertView = View.inflate(mContext, R.layout.img_view, null);
            iv = (ImageView) convertView.findViewById(R.id.iv);
            convertView.setTag(iv);
        }else {
            iv = (ImageView) convertView.getTag();
        }
        iv.setImageBitmap(mImages.get(position));
        return convertView;
    }

}
