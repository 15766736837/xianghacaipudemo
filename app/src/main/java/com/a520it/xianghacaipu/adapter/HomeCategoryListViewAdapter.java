package com.a520it.xianghacaipu.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;

/**
 * Created by Lai on 2017/7/18.
 */

public class HomeCategoryListViewAdapter extends MyBaseAdapter<String> {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.home_category_activity_item_layout, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.home_category_item_tv.setText(mDatas.get(position));

        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView home_category_item_line;
        public TextView home_category_item_tv;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.home_category_item_line = (TextView) rootView.findViewById(R.id.home_category_item_line);
            this.home_category_item_tv = (TextView) rootView.findViewById(R.id.home_category_item_tv);
        }

    }

    public void setItem(int position, int color){

    }
}
