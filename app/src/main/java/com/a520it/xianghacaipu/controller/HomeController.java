package com.a520it.xianghacaipu.controller;

import android.content.Context;

import com.a520it.xianghacaipu.constant.INetWorkAction;
import com.a520it.xianghacaipu.constant.INetWorkRequestUrl;
import com.a520it.xianghacaipu.utils.OkHttpUtil;


/**
 * Created by Lai on 2017/6/19.
 */

public class HomeController extends BaseController {
    public HomeController(Context context) {
        super(context);
    }

    @Override
    protected void NetworkRequests(int action, Object... valuse) {
        switch (action) {
            case INetWorkAction.HOME_ACTION:
                OkHttpUtil.getInstent().doGet(action, INetWorkRequestUrl.HOME_REQUEST_URl, this);
                break;
        }
    }
}
