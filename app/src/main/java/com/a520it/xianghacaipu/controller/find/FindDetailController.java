package com.a520it.xianghacaipu.controller.find;

import android.content.Context;
import android.util.Log;

import com.a520it.xianghacaipu.bean.disbean.DetailBean;
import com.a520it.xianghacaipu.constant.ActionCon;
import com.a520it.xianghacaipu.constant.NetworkCons;
import com.a520it.xianghacaipu.controller.BaseController;
import com.a520it.xianghacaipu.utils.OkHttpUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

/**
 * Created by simon on 2017/7/17.
 */

public class FindDetailController extends BaseController {
    public FindDetailController(Context context) {
        super(context);
    }

    @Override
    protected void NetworkRequests(int action, Object... valuse) {
        switch (action) {
            case  ActionCon.FINDDETAILDATA:
                requestData(String.valueOf(valuse[0]), new Listerner() {
                    @Override
                    public void onSuccess(Object obj) {
                        mListerent.IModechager(ActionCon.FINDDETAILDATA,obj);
                    }

                    @Override
                    public void onFaiure(Exception e) {

                    }
                });
                break;
        }
    }

    private void requestData(String codeid, final Listerner listener) {
        String url = NetworkCons.getCodeId(codeid);
        Log.v("cherish233","url = "+url);
        OkHttpUtil.getInstent().doGet(ActionCon.FINDDETAILDATA, url, new OkHttpUtil.Listerner() {
            @Override
            public void onError(IOException e) {
                listener.onFaiure(e);
            }

            @Override
            public void onSuccess(int Action, String s) {
                Log.v("cherish233","json:"+s);
                DetailBean detailBean = JSONObject.parseObject(s, DetailBean.class);
                listener.onSuccess(detailBean);
            }
        });
    }

    public interface Listerner {
        void onSuccess(Object obj);

        void onFaiure(Exception e);
    }
}
