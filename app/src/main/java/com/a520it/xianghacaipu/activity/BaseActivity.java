package com.a520it.xianghacaipu.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.listerent.IModechagerListerent;


public class BaseActivity extends AppCompatActivity implements IModechagerListerent {

    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            handUI(msg);
            super.handleMessage(msg);
        }
    };

    protected void handUI(Message msg) {
        //空实现
    }

    //接口的返回
    public void IModechager(int action, Object valuse) {
        mHandler.obtainMessage(action, valuse).sendToTarget();
    }


    @Override
    public void onBackPressed() {
        finish();
        this.overridePendingTransition(R.anim.open_enter_anim, R.anim.open_exit_anim);
    }


}
