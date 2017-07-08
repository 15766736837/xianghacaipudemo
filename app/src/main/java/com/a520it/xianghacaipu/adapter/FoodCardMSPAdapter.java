package com.a520it.xianghacaipu.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.FoodCardMSPBean;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ASUS on 2017/6/26.
 */

public class FoodCardMSPAdapter extends BaseAdapter {
    public   ArrayList<FoodCardMSPBean.DataBeanX.DataBean> mData = new ArrayList();

    public void setData(ArrayList<FoodCardMSPBean.DataBeanX.DataBean> data) {
        mData = data;

    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holerView;
        if (convertView == null) {
            holerView = new ViewHolder();
            convertView = View.inflate(parent.getContext(), R.layout.item_list_layout, null);
            holerView.mFoodItemUserphoto = (CircleImageView) convertView.findViewById(R.id.food_item_userphoto);
            holerView.mFoodItemName = (TextView) convertView.findViewById(R.id.food_item_name);
            holerView.mFoodItemTime = (TextView) convertView.findViewById(R.id.food_item_time);
            holerView.mFoodItemNr = (TextView) convertView.findViewById(R.id.food_item_nr);
            holerView.mFoodItemCk = (TextView) convertView.findViewById(R.id.food_item_ck);
            holerView.mFoodItemXx = (TextView) convertView.findViewById(R.id.food_item_xx);
            holerView.mFoodItemDc = (TextView) convertView.findViewById(R.id.food_item_dc);
            convertView.setTag(holerView);
        }else {
            holerView = (ViewHolder) convertView.getTag();
        }
        FoodCardMSPBean.DataBeanX.DataBean dataBean = mData.get(position);
        FoodCardMSPBean.DataBeanX.DataBean.CustomerBean dataBeanCustomer = dataBean.getCustomer();
        holerView.mFoodItemName.setText(dataBeanCustomer.getNickName());
        holerView.mFoodItemTime.setText(dataBean.getTimeShowV43());
        holerView.mFoodItemNr.setText("【 " + dataBean.getTitle() + " 】 " + dataBean.getContent() );
        holerView.mFoodItemCk.setText(dataBean.getClick());
        holerView.mFoodItemXx.setText("评论");
        holerView.mFoodItemDc.setText(dataBean.getIsLike()+"");
        return convertView;
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public static class ViewHolder {
        public View rootView;
        public CircleImageView mFoodItemUserphoto;
        public TextView mFoodItemName;
        public TextView mFoodItemTime;
        public TextView mFoodItemNr;
        public TextView mFoodItemCk;
        public TextView mFoodItemXx;
        public TextView mFoodItemDc;

    }
}
