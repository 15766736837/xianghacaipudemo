package com.a520it.xianghacaipu.view;

import com.a520it.xianghacaipu.R;
import com.chad.library.adapter.base.loadmore.LoadMoreView;

/**
 * Created by Lai on 2017/7/17.
 */

public class HomeOptimumLoadItemView extends LoadMoreView{
    @Override
    public int getLayoutId() {
        return R.layout.home_optimum_load_item_layout;
    }

    /**
     * 如果返回true，数据全部加载完毕后会隐藏加载更多
     * 如果返回false，数据全部加载完毕后会显示getLoadEndViewId()布局
     */
    @Override public boolean isLoadEndGone() {
        return true;
    }

    @Override protected int getLoadingViewId() {
        return R.id.tv;
    }

    @Override protected int getLoadFailViewId() {
        return R.id.tv1;
    }

    /**
     * isLoadEndGone()为true，可以返回0
     * isLoadEndGone()为false，不能返回0
     */
    @Override protected int getLoadEndViewId() {
        return R.id.tv2;
    }
}
