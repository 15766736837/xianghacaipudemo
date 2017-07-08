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

public class FonsFragmnt extends BaseFragment {
    private LinearLayout fragment_ll;
    private RelativeLayout mNull;
    private ConcernController mConcernController;
    private ConcernBean mConcernBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initController();
        requestData();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_fons_layout, null);
        initView(inflate);
        return inflate;
    }

    //请求数据
    private void requestData() {
        mConcernController.sendAsynchronization(NetController.CONCERN_FONS_ACION);
    }

    //初始化管理器
    private void initController() {
        mConcernController = new ConcernController(getContext());
        mConcernController.setListerent(this);
    }

    private void initView(View inflate) {
        fragment_ll = (LinearLayout) inflate.findViewById(R.id.fragment_ll);
        mNull = (RelativeLayout) inflate.findViewById(R.id.fragment_null);
    }

    @Override
    protected void handleUI(Message msg) {
        switch (msg.what){
            case NetController.CONCERN_FONS_ACION:
               String jsonStr = (String) msg.obj;
                mConcernBean = JSON.parseObject(jsonStr, ConcernBean.class);
                //判断是否请求成功
                if ("网络不稳定".equals(mConcernBean.getData())) {
                    mNull.setVisibility(View.VISIBLE);
                    fragment_ll.setVisibility(View.GONE);
                }
                break;
        }
    }
}
