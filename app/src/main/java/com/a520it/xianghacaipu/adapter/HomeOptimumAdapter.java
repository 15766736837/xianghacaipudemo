package com.a520it.xianghacaipu.adapter;

import android.widget.ImageView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.HomeOptimumBean;
import com.a520it.xianghacaipu.utils.LoadImageUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by Lai on 2017/7/11.
 */

public class HomeOptimumAdapter extends BaseQuickAdapter<HomeOptimumBean.DataBean, BaseViewHolder> {
    public HomeOptimumAdapter() {
        super(R.layout.home_optimum_item_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeOptimumBean.DataBean item) {
        helper.setText(R.id.name_tv, item.getName())
        .setText(R.id.user_name_tv, item.getNickName())
        .setText(R.id.des_tv, item.getAllClick() + "浏览 " + item.getFavorites() + "收藏");
        LoadImageUtil.getInstance().display(item.getImg(), (ImageView) helper.getView(R.id.background_iv));
        LoadImageUtil.getInstance().display(item.getCustomer().getImg(), (ImageView) helper.getView(R.id.avatar_iv));
    }
}
