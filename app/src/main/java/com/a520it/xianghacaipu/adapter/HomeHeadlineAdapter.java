package com.a520it.xianghacaipu.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.HomeBean;
import com.a520it.xianghacaipu.utils.LoadImageUtil;

/**
 * Created by Lai on 2017/7/7.
 */

public class HomeHeadlineAdapter extends MyBaseAdapter<HomeBean.DataBean.NousBean> {
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.home_headline_item_layout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        HomeBean.DataBean.NousBean nousBean = mDatas.get(position);
        if (nousBean != null) {
            holder.home_headline_title_tv.setText(nousBean.getTitle());
            holder.home_headline_source_tv.setText(nousBean.getClassifyname());
            holder.home_headline_comment_tv.setText(nousBean.getAllClick() + "浏览 " +
                    nousBean.getCommentCount() + "评论");
            LoadImageUtil.getInstance().display(nousBean.getImg(), holder.home_headline_iv);
        } else {
            String url = "http://pgdt.gtimg.cn/gdt/0/DAANQMiAUAALQABZBYuR6GDPj5EqnN.jpg/0?ck=8f75d9c9e745946734b630b644c9c45c";
            holder.home_headline_title_tv.setText("拼多多,爱美的女性请进,衣服免费送...");
            holder.home_headline_source_tv.setText("广告");
            holder.home_headline_comment_tv.setText("8888浏览 " + "38评论");
            LoadImageUtil.getInstance().display(url, holder.home_headline_iv);
        }
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView home_headline_iv;
        public TextView home_headline_title_tv;
        public TextView home_headline_source_tv;
        public TextView home_headline_comment_tv;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.home_headline_iv = (ImageView) rootView.findViewById(R.id.home_headline_iv);
            this.home_headline_title_tv = (TextView) rootView.findViewById(R.id.home_headline_title_tv);
            this.home_headline_source_tv = (TextView) rootView.findViewById(R.id.home_headline_source_tv);
            this.home_headline_comment_tv = (TextView) rootView.findViewById(R.id.home_headline_comment_tv);
        }

    }
}
