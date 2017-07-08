package com.a520it.xianghacaipu.fragmnt.concern;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.ConcernBean;
import com.a520it.xianghacaipu.constant.NetController;
import com.a520it.xianghacaipu.controller.ConcernController;
import com.a520it.xianghacaipu.fragmnt.BaseFragment;
import com.alibaba.fastjson.JSON;

/**
 * Created by ASUS on 2017/6/29.
 */

public class ConcernFragment extends BaseFragment {


    private ConcernController mConcernController;
    private ConcernBean mConcernBean;
    private View mInflate;
    private LinearLayout mConcernLl;
    private RelativeLayout mNullRl;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initController(); //初始化管理器
        requestData();  //请求数据
        mInflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_concern_layout, null);
        initView(mInflate);
        return mInflate;
    }

    //请求数据
    private void requestData() {
        mConcernController.sendAsynchronization(NetController.CONCERN_ACION);
    }

    private void initController() {
        mConcernController = new ConcernController(getContext());
        mConcernController.setListerent(this);
    }

    @Override
    protected void handleUI(Message msg) {
        switch (msg.what) {
            case NetController.CONCERN_ACION:
                String jsonStr = (String) msg.obj;
                mConcernBean = JSON.parseObject(jsonStr, ConcernBean.class);
                //判断是否请求成功
                if ("网络不稳定".equals(mConcernBean.getData())) {
                    mNullRl.setVisibility(View.VISIBLE);
                    mConcernLl.setVisibility(View.GONE);
                }
                break;

        }
    }

    private void initView(View mInflate) {
        mConcernLl = (LinearLayout) mInflate.findViewById(R.id.concern_ll);
        mNullRl = (RelativeLayout) mInflate.findViewById(R.id.fragment_null);

    }
}
