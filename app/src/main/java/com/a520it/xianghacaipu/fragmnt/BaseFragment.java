package com.a520it.xianghacaipu.fragmnt;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;

import com.a520it.xianghacaipu.listerent.IModechagerListerent;


//fragment的基类
public class BaseFragment extends Fragment implements IModechagerListerent {

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //具体操作由子类实现
            handleUI(msg);
            super.handleMessage(msg);
        }
    };

    //子类实现修改UI的方法
    protected void handleUI(Message msg) {
        //空实现
    }

    ;


    //获取到传回的数据
    @Override
    public void IModechager(int action, Object valuse) {
        //发回主线程修改ui
        mHandler.obtainMessage(action, valuse).sendToTarget();
    }
}
