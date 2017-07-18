package com.a520it.xianghacaipu.controller;

import android.content.Context;

import com.a520it.xianghacaipu.constant.NetController;

/**
 * Created by ASUS on 2017/7/7.
 */

public class MyIndentController extends  BaseController {



    public MyIndentController(Context context) {
        super(context);
    }

    @Override
    protected void NetworkRequests(int action, Object... valuse) {
        switch (action){
            case NetController.MYINDENT_ALL_ACTION:
        mOkHttpUtil.doGet(NetController.MYINDENT_ALL_ACTION,NetController.MYINDENT_ALL,this);

            break;
        }
    }
}
