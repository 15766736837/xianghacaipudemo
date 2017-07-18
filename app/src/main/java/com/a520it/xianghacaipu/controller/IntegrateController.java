package com.a520it.xianghacaipu.controller;

import android.content.Context;

import com.a520it.xianghacaipu.constant.NetController;

/**
 * Created by ASUS on 2017/7/17.
 */

public class IntegrateController extends BaseController {
    public IntegrateController(Context context) {
        super(context);
    }

    @Override
    protected void NetworkRequests(int action, Object... valuse) {
        switch (action){
            case NetController.INTEVRATE_TOP_ACION:  //顶部网络请求
                mOkHttpUtil.doGet(NetController.INTEVRATE_TOP_ACION,NetController.INTEVRATE_TOP,this);
                break;
            case NetController.INTEVRATE_BTOOM_ACION:  //底部网络请求
                mOkHttpUtil.doGet(NetController.INTEVRATE_BTOOM_ACION,NetController.INTEVRATE_BTOOM,this);
                break;
        }
    }
}
