package com.a520it.xianghacaipu.fragmnt.home_banner;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.HomeOptimumAdapter;
import com.a520it.xianghacaipu.bean.HomeOptimumBean;
import com.a520it.xianghacaipu.constant.INetWorkAction;
import com.a520it.xianghacaipu.controller.BannerFragmentController;
import com.a520it.xianghacaipu.fragmnt.BaseFragment;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Lai on 2017/7/17.
 */

public class BreakfastFragment extends BaseFragment {

    private BannerFragmentController mBannerFragmentController;
    private RecyclerView mHomeOptimumBreakfastFragment;
    private HomeOptimumAdapter mHomeOptimumAdapter;
    private HomeOptimumBean mHomeOptimumBean;

    @Override
    protected void handleUI(Message msg) {
        if (msg.what == INetWorkAction.HOME_BANNER_BREAKFAST_FRAGMENT) {
            String jsonStr = (String) msg.obj;
            mHomeOptimumBean = JSONObject.parseObject(jsonStr, HomeOptimumBean.class);
            mHomeOptimumAdapter.setNewData(mHomeOptimumBean.getData());
        }
    }

    private void initController() {
        mBannerFragmentController = new BannerFragmentController(getContext());
        mBannerFragmentController.setListerent(this);
    }

    private void initData() {
        mBannerFragmentController.sendAsynchronization(INetWorkAction.HOME_BANNER_BREAKFAST_FRAGMENT);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initController();
        initData();
        View view = View.inflate(getContext(), R.layout.home_banner_breakfast_layout, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mHomeOptimumBreakfastFragment = (RecyclerView) view.findViewById(R.id.home_optimum_breakfast_fragment);
        mHomeOptimumAdapter = new HomeOptimumAdapter();
        LinearLayoutManager homeOptimumRvManager = new LinearLayoutManager(getContext());
        mHomeOptimumBreakfastFragment.setLayoutManager(homeOptimumRvManager);
        mHomeOptimumBreakfastFragment.setAdapter(mHomeOptimumAdapter);
    }
}
