package com.a520it.xianghacaipu.utils;

import com.a520it.xianghacaipu.manager.ThreadPoolProxy;

/**
 * 线程池的工厂,用于生产不同用途的线程
 */

public class ThreadPoolProxyFactory {
    //普通下载线程池
    private static ThreadPoolProxy mThreadPoolProxyNormal;
    //专门用于下载的线程池
    private static ThreadPoolProxy mThreadPoolProxyDownload;

    //初始化两个不同的线程池
    public static ThreadPoolProxy createThreadPoolProxyNomal(){
        if (mThreadPoolProxyNormal == null){
            /**
             * 参数一:核心线程的个数
             * 参数二:最大线程的个数
             * 参数三:线程空闲的时间
             */
            mThreadPoolProxyNormal = new ThreadPoolProxy(3, 3, 3000);
        }
        return mThreadPoolProxyNormal;
    }

    public static ThreadPoolProxy createThreadPoolProxyDownload(){
        if (mThreadPoolProxyDownload == null){
            mThreadPoolProxyDownload = new ThreadPoolProxy(4, 4, 3000);
        }
        return mThreadPoolProxyDownload;
    }
}
