package com.a520it.xianghacaipu.manager;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个线程池
 */

public class ThreadPoolProxy {
    private int mCorePoolSize;
    private int mMaximumPoolSize;
    private long mKeepAliveTime;
    private ThreadPoolExecutor mPoolExecutor;

    public ThreadPoolProxy(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
        mKeepAliveTime = keepAliveTime;     //线程空闲的保存时间,线程空闲多久没有用久销毁
        mMaximumPoolSize = maximumPoolSize; //总的线程个数
        mCorePoolSize = corePoolSize;       //核心线程的个数,核心线程不会被销毁
    }

    public void initThreadPoolExecutor() {
        //保证ThreadPoolExecutor不被重复初始化
        if (mPoolExecutor == null || mPoolExecutor.isShutdown() || mPoolExecutor.isTerminating()) {
            synchronized (ThreadPoolProxy.class) {
                TimeUnit unit = TimeUnit.MILLISECONDS;
                BlockingQueue<Runnable> wordQueue = new LinkedBlockingQueue();
                ThreadFactory threadFactory = Executors.defaultThreadFactory();
                RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();

                mPoolExecutor = new ThreadPoolExecutor(mCorePoolSize, mMaximumPoolSize, mKeepAliveTime, unit,   //时间的单位
                        wordQueue,  //任务队列
                        threadFactory, //线程的工厂
                        handler         //异常捕获器
                );
            }
        }
    }

    //提交任务的方法
    public void submit(Runnable task) {
        initThreadPoolExecutor();
        mPoolExecutor.submit(task);
    }

    //执行任务的方法
    public void execute(Runnable task) {
        initThreadPoolExecutor();
        mPoolExecutor.execute(task);
    }

    //移除任务的方法
    public void remove(Runnable task) {
        initThreadPoolExecutor();
        mPoolExecutor.remove(task);
    }
}
