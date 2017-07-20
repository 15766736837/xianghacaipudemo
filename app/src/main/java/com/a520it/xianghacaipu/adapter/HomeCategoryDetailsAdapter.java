package com.a520it.xianghacaipu.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.HomeCategoryDetailsBean;
import com.a520it.xianghacaipu.utils.LoadImageUtil;

/**
 * Created by Lai on 2017/7/19.
 */

public class HomeCategoryDetailsAdapter extends MyBaseAdapter<HomeCategoryDetailsBean.DataBean.DishsBean> {
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.home_category_details_item_layout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        HomeCategoryDetailsBean.DataBean.DishsBean dishsBean = mDatas.get(position);
        String nickName = dishsBean.getCustomers().getNickName();
        holder.home_category_details_name_tv.setText(dishsBean.getName());
        holder.home_category_details_burdens_tv.setText(dishsBean.getBurdens());
        holder.home_category_details_nickName_tv.setText(nickName);
        holder.home_category_details_allClick_tv.setText(dishsBean.getAllClick() + "浏览   " + dishsBean.getFavorites() + "收藏");
        LoadImageUtil.getInstance().display(dishsBean.getImg(), holder.home_category_details_iv);
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView home_category_details_iv;
        public TextView home_category_details_name_tv;
        public TextView home_category_details_burdens_tv;
        public TextView home_category_details_nickName_tv;
        public TextView home_category_details_allClick_tv;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.home_category_details_iv = (ImageView) rootView.findViewById(R.id.home_category_details_iv);
            this.home_category_details_name_tv = (TextView) rootView.findViewById(R.id.home_category_details_name_tv);
            this.home_category_details_burdens_tv = (TextView) rootView.findViewById(R.id.home_category_details_burdens_tv);
            this.home_category_details_nickName_tv = (TextView) rootView.findViewById(R.id.home_category_details_nickName_tv);
            this.home_category_details_allClick_tv = (TextView) rootView.findViewById(R.id.home_category_details_allClick_tv);
        }

    }
}
