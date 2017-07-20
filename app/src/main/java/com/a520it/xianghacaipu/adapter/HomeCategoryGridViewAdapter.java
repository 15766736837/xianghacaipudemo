package com.a520it.xianghacaipu.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;

/**
 * Created by Lai on 2017/7/19.
 */

public class HomeCategoryGridViewAdapter extends MyBaseAdapter<String>{
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(parent.getContext(), R.layout.home_category_grid_item, null);
        TextView tv = (TextView) view.findViewById(R.id.home_category_item_tv);
        tv.setText(mDatas.get(position));
        return view;
    }

    @Override
    public String getItem(int position) {
        return mDatas.get(position);
    }
}
