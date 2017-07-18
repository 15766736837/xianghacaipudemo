package com.a520it.xianghacaipu.controller;

import android.content.Context;
import android.util.Log;

import com.a520it.xianghacaipu.bean.FindListBean;
import com.a520it.xianghacaipu.bean.disbean.DisBean;
import com.a520it.xianghacaipu.constant.ActionCon;
import com.a520it.xianghacaipu.constant.NetworkCons;
import com.a520it.xianghacaipu.utils.OkHttpUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

/**
 * Created by simon on 2017/6/16.
 */

public class FindController extends BaseController {

    private int mPage;

    public FindController(Context context) {
        super(context);
    }

    @Override
    public void NetworkRequests(int action, Object... values) {
        switch (action) {
            case ActionCon.FINDLISTDATA:
                requestListData(new Listerner() {
                    @Override
                    public void onSuccess(Object obj) {
                        mListerent.IModechager(ActionCon.FINDLISTDATA, obj);
                    }

                    @Override
                    public void onFaiure(Exception e) {

                    }
                });
                break;
            case ActionCon.FINDADDLISTDATA:
                requestAddListData(new Listerner() {
                    @Override
                    public void onSuccess(Object obj) {
                        mListerent.IModechager(ActionCon.FINDADDLISTDATA, obj);
                    }

                    @Override
                    public void onFaiure(Exception e) {

                    }
                });

                break;
            case ActionCon.NEWADDDETAILDATA:
                requestAddListData(new Listerner() {
                    @Override
                    public void onSuccess(Object obj) {
                        mListerent.IModechager(ActionCon.NEWADDDETAILDATA, obj);
                    }

                    @Override
                    public void onFaiure(Exception e) {

                    }
                });

                break;


        }
    }

    private DisBean requestListData(final Listerner listerner) {
        mPage = 1;
        String url = NetworkCons.BASEURL + NetworkCons.getPage(mPage, "");
        Log.v("cherish233", "url=" + url);
        OkHttpUtil.getInstent().doGet(ActionCon.FINDLISTDATA, url, new OkHttpUtil.Listerner() {
            @Override
            public void onError(IOException e) {
                listerner.onFaiure(e);

            }

            @Override
            public void onSuccess(int Action, String s) {
                FindListBean findListBean = JSONObject.parseObject(s, FindListBean.class);
                listerner.onSuccess(findListBean);

            }
        });

        return null;

    }


    private DisBean requestAddListData(final Listerner listerner) {
        String time = NetworkCons.getTime();
        mPage = mPage + 1;
        String url = NetworkCons.BASEURL + NetworkCons.getPage(mPage, time);
        Log.v("cherish233", "url=" + url);
        OkHttpUtil.getInstent().doGet(ActionCon.FINDADDLISTDATA, url, new OkHttpUtil.Listerner() {
            @Override
            public void onError(IOException e) {

            }

            @Override
            public void onSuccess(int Action, String s) {
                FindListBean findListBean = JSONObject.parseObject(s, FindListBean.class);
                listerner.onSuccess(findListBean);
            }
        });

        return null;

    }

    private DisBean requestNewAddListData(final Listerner listerner) {
        String time = NetworkCons.getTime();
        mPage = mPage + 1;
        String url = NetworkCons.BASEURL + NetworkCons.getNewPage(mPage, time);
        OkHttpUtil.getInstent().doGet(ActionCon.FINDADDLISTDATA, url, new OkHttpUtil.Listerner() {
            @Override
            public void onError(IOException e) {

            }

            @Override
            public void onSuccess(int Action, String s) {
                FindListBean findListBean = JSONObject.parseObject(s, FindListBean.class);
                listerner.onSuccess(findListBean);
            }
        });

        return null;

    }


    public interface Listerner {
        void onSuccess(Object obj);

        void onFaiure(Exception e);
    }
}
