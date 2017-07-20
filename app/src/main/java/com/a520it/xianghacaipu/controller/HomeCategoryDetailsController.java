package com.a520it.xianghacaipu.controller;

import android.content.Context;

import com.a520it.xianghacaipu.constant.INetWorkAction;
import com.a520it.xianghacaipu.utils.OkHttpUtil;

/**
 * Created by Lai on 2017/7/19.
 */

public class HomeCategoryDetailsController extends BaseController{
    public HomeCategoryDetailsController(Context context) {
        super(context);
    }

    @Override
    protected void NetworkRequests(int action, Object... valuse) {
        if (action == INetWorkAction.HOME_CATEGORY_DETAILS){
            String str = (String) valuse[0];
            OkHttpUtil.getInstent().doGet(action, "http://api.xiangha.com/main6/search/byCaipu?type=caipu&keywords="+str+"&page=1", this);
        }
    }
}
