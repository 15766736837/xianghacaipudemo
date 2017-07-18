package com.a520it.xianghacaipu.controller;

import android.content.Context;

import com.a520it.xianghacaipu.constant.INetWorkAction;
import com.a520it.xianghacaipu.constant.INetWorkRequestUrl;
import com.a520it.xianghacaipu.utils.OkHttpUtil;

/**
 * Created by Lai on 2017/7/18.
 */

public class BannerFragmentController extends BaseController {
    public BannerFragmentController(Context context) {
        super(context);
    }

    @Override
    protected void NetworkRequests(int action, Object... valuse) {
        switch (action) {
            case INetWorkAction.HOME_BANNER_BREAKFAST_FRAGMENT:
                OkHttpUtil.getInstent().doGet(action, INetWorkRequestUrl.HOME_BANNER_BREAKFAST_FRAGMENT_URL, this);
                break;
            case INetWorkAction.HOME_BANNER_LUNCH_FRAGMENT:
                OkHttpUtil.getInstent().doGet(action, INetWorkRequestUrl.HOME_BANNER_LUNCH_FRAGMENT_URL, this);
                break;
            case INetWorkAction.HOME_BANNER_SUPPER_FRAGMENT:
                OkHttpUtil.getInstent().doGet(action, INetWorkRequestUrl.HOME_BANNER_SUPPER_FRAGMENT_URL, this);
                break;
        }

    }
}
