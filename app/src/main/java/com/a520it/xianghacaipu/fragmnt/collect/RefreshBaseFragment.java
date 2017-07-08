package com.a520it.xianghacaipu.fragmnt.collect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.fragmnt.BaseFragment;
import com.a520it.xianghacaipu.view.PtrClassicHeader;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;


public abstract class RefreshBaseFragment extends BaseFragment {


    private FrameLayout mNullFl;
    private PtrFrameLayout mFoodRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_refreshbase_layout, null);
        mNullFl = (FrameLayout) view.findViewById(R.id.null_fl);
        mFoodRefreshLayout = (PtrFrameLayout) view.findViewById(R.id.food_refreshLayout);
        //添加子空间
        mNullFl.addView(createView());
        initPtr();
        return view;
    }

    //初始化下拉刷新
    private void initPtr() {

        //这里是一个自定义的头部刷新布局,自带的也有一个布局   new PtrDefaultHandler();
        PtrClassicHeader header = new PtrClassicHeader(getContext());
        //将头布局添加
        mFoodRefreshLayout.addPtrUIHandler(header);
        mFoodRefreshLayout.setHeaderView(header); //设置刷新头布局
        mFoodRefreshLayout.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //在这里写自己下拉刷新数据的请求
                refreshLoadData();
                //需要结束刷新头
                mFoodRefreshLayout.refreshComplete();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                // 默认实现，根据实际情况做改动
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });
    }

    //下拉刷新的具体实现
    protected abstract void refreshLoadData();

    //创建子类的具体布局
    public abstract  View createView();

}
