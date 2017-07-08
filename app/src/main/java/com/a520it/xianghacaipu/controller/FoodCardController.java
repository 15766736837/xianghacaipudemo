package com.a520it.xianghacaipu.controller;

import android.content.Context;

import com.a520it.xianghacaipu.constant.NetController;

/**
 * Created by ASUS on 2017/6/26.
 */

public class FoodCardController extends  BaseController {

    public FoodCardController(Context context) {
        super(context);
    }

    @Override
    protected void NetworkRequests(int action, Object... valuse) {
        switch (action){
            case NetController.FOOD_USERIMFO_ACION:
                mOkHttpUtil.doGet(action, NetController.FOOD_USERIMFO,this);
                break;
            case NetController.FOOD_MSP_ACION:
                mOkHttpUtil.doGet(action,NetController.FOOD_MSP,this);
                break;
        }

    }
}
