package com.a520it.xianghacaipu.controller;

import android.content.Context;

import com.a520it.xianghacaipu.constant.NetController;

/**
 * Created by ASUS on 2017/6/29.
 */

public class ConcernController extends  BaseController {

    public ConcernController(Context context) {
        super(context);
    }

    @Override
    protected void NetworkRequests(int action, Object... valuse) {
        switch (action){
            case NetController.CONCERN_ACION:
                mOkHttpUtil.doGet(action,NetController.CONCERN_URL,this);
                break;
            case NetController.CONCERN_FONS_ACION:
                mOkHttpUtil.doGet(action,NetController.CONCERN_FONS_URL,this);
                break;
        }
    }
}
