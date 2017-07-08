package com.a520it.xianghacaipu.controller;

import android.content.Context;

import com.a520it.xianghacaipu.listerent.IModechagerListerent;
import com.a520it.xianghacaipu.manager.ThreadPoolProxy;
import com.a520it.xianghacaipu.utils.OkHttpUtil;
import com.a520it.xianghacaipu.utils.ThreadPoolProxyFactory;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * Created by ASUS on 2017/6/15.
 */

public abstract class BaseController implements OkHttpUtil.Listerner {

    protected Context mContext;
    //创建一个弱引用接受
    protected WeakReference<Context> mWeakReference;

    protected IModechagerListerent mListerent;

    protected OkHttpUtil mOkHttpUtil;

    public BaseController(Context context) {
        mContext = context;
        //弱引用
        mWeakReference = new WeakReference<>(context);
    }


    //设置接口
    public void setListerent(IModechagerListerent listerent) {
        mListerent = listerent;
        mOkHttpUtil = OkHttpUtil.getInstent();

    }

    //发送异步
    public void sendAsynchronization(final int action, final Object... valuse) {
        ThreadPoolProxy threadPoolProxyNomal = ThreadPoolProxyFactory.createThreadPoolProxyNomal();
        threadPoolProxyNomal.execute(new Runnable() {
            @Override
            public void run() {
                //创建一个网络请求对象
                NetworkRequests(action, valuse);
            }
        });
    }

    //进行网络请求
    protected abstract void NetworkRequests(int action, Object... valuse);

    //网络请求完成后的回调
    @Override
    public void onError(IOException e) {

    }


    @Override
    public void onSuccess(int action, String s) {
        if (mListerent != null) {
            mListerent.IModechager(action, s);
        }
    }


}
