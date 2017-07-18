package com.a520it.xianghacaipu.activity;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.IntegrateAdapter;
import com.a520it.xianghacaipu.constant.NetController;
import com.a520it.xianghacaipu.controller.IntegrateController;
import com.a520it.xianghacaipu.view.PtrClassicHeader;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;


public class IntegrateActivity extends BaseActivity {

    private ImageView mIntegrateReturnIv;
    private RecyclerView mIntegrateRv;
    private PtrFrameLayout mIntefrateRefreshLayout;
    private LinearLayout mActivityIntegrate;
    private IntegrateController mIntegrateController;
    private GridLayoutManager mGridLayoutManager;
    private IntegrateAdapter mIntegrateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrate);
        initView();
        initPtr(); //初始化下拉刷新
        initController();  //初始化网络请求
        requestData();  //请求数据
    }

    private void requestData() {
        mIntegrateController.sendAsynchronization(NetController.INTEVRATE_TOP_ACION);
        mIntegrateController.sendAsynchronization(NetController.INTEVRATE_BTOOM_ACION);
    }

    private void initController() {
        mIntegrateController = new IntegrateController(this);
        mIntegrateController.setListerent(this);
    }

    private void initView() {
        mIntegrateReturnIv = (ImageView) findViewById(R.id.integrate_return_iv);

        mIntegrateRv = (RecyclerView) findViewById(R.id.integrate_rv);
        mGridLayoutManager = new GridLayoutManager(this,2);
        mIntegrateRv.setLayoutManager(mGridLayoutManager);
        mIntegrateAdapter = new IntegrateAdapter();
        mIntegrateRv.setAdapter(mIntegrateAdapter);
        //添加头部
        addRecyclerTop();


        mIntefrateRefreshLayout = (PtrFrameLayout) findViewById(R.id.intefrate_refreshLayout);
        mActivityIntegrate = (LinearLayout) findViewById(R.id.activity_integrate);
    }

    //添加头布局
    private void addRecyclerTop() {
        View view = View.inflate(getApplicationContext(), R.layout.item_integrate_top_layout, null);
        mIntegrateAdapter.addHeaderView(view);

    }

    //初始化下拉刷新
    private void initPtr() {
        //这里是一个自定义的头部刷新布局,自带的也有一个布局   new PtrDefaultHandler();
        PtrClassicHeader header = new PtrClassicHeader(this);
        //将头布局添加
        mIntefrateRefreshLayout.addPtrUIHandler(header);
        mIntefrateRefreshLayout.setHeaderView(header); //设置刷新头布局
        mIntefrateRefreshLayout.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //在这里写自己下拉刷新数据的请求
               /* refreshLoadData();*/
                //需要结束刷新头
                mIntefrateRefreshLayout.refreshComplete();
            }
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                // 默认实现，根据实际情况做改动
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });
    }


    //网络请求回调
    @Override
    protected void handUI(Message msg) {
       switch (msg.what){
           case NetController.INTEVRATE_TOP_ACION:
             String jsnStr = (String) msg.obj;
               Log.v("tag",jsnStr);
               break;
           case NetController.INTEVRATE_BTOOM_ACION:
               String jsonStrs = (String) msg.obj;
               Log.v("tag",jsonStrs);
               break;
       }
    }
}
