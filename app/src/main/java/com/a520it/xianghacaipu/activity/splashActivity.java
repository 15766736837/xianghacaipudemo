package com.a520it.xianghacaipu.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;

import com.a520it.xianghacaipu.R;
import com.mob.MobSDK;

import cn.sharesdk.onekeyshare.OnekeyShare;

public class splashActivity extends BaseActivity {

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            startActivity(new Intent(splashActivity.this,MainActivity.class));
            finish();
            super.handleMessage(msg);
        }
    };
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //初始化分享
        MobSDK.init(getApplication(),"1f82da6455f21","9763a4aee7ee4c90e989f3709bf0d8dd");


        setContentView(R.layout.activity_splash);
        mLinearLayout = (LinearLayout) findViewById(R.id.activity_splash);
        //初始化动画
        initAnim();
        //发送消息
        mHandler.sendEmptyMessageDelayed(3,3000);
    }

    private void initAnim() {
        ObjectAnimator anim = ObjectAnimator.ofFloat(mLinearLayout, "alpha",0.1f,0.3f, 0.5f, 0.8f, 1f);
        anim.setDuration(3000);// 动画持续时间
        anim.start();
    }


}
