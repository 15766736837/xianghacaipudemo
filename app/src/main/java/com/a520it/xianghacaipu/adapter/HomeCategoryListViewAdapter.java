package com.a520it.xianghacaipu.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.HomeCategoryBean;

import java.util.List;

/**
 * Created by Lai on 2017/7/18.
 */

public class HomeCategoryListViewAdapter extends MyBaseAdapter<HomeCategoryBean> {

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
        HomeCategoryBean homeCategoryBean = mDatas.get(position);
        viewHolder.home_category_item_tv.setText(homeCategoryBean.getContent());
        viewHolder.home_category_item_line.setVisibility(homeCategoryBean.getSelect() == 0 ? View.INVISIBLE : View.VISIBLE);
        viewHolder.rl.setBackgroundColor(homeCategoryBean.getSelect() == 0 ? 0xFFF0F0F0 :Color.WHITE);
        viewHolder.home_category_item_tv.setTextColor(homeCategoryBean.getSelect() == 0 ? 0xFF797979 : 0xffff533c);
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView home_category_item_line;
        public TextView home_category_item_tv;
        public RelativeLayout rl;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.home_category_item_line = (TextView) rootView.findViewById(R.id.home_category_item_line);
            this.home_category_item_tv = (TextView) rootView.findViewById(R.id.home_category_item_tv);
            this.rl= (RelativeLayout) rootView.findViewById(R.id.rl);
        }

    }

    @Override
    public List<HomeCategoryBean> getItem(int position) {
        return mDatas;
    }
}
