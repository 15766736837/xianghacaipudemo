package com.a520it.xianghacaipu.adapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lai on 2017/7/7.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    List<T> mDatas;

    public void setDatas(List<T> data) {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }

        mDatas = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
