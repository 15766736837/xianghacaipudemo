package com.a520it.xianghacaipu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.utils.SpUtils;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout mSetting_return_rl;
    private LinearLayout mSetting_user_rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    private void initView() {
        findViewById(R.id.setting_return_iv).setOnClickListener(this);
        findViewById(R.id.setting_news_rl).setOnClickListener(this);
        findViewById(R.id.setting_cache__rl).setOnClickListener(this);
        findViewById(R.id.setting_version__rl).setOnClickListener(this);
        findViewById(R.id.setting_friends__rl).setOnClickListener(this);
        findViewById(R.id.setting_evaluate__rl).setOnClickListener(this);
        findViewById(R.id.fragment_me_rl).setOnClickListener(this);
        mSetting_return_rl = (RelativeLayout) findViewById(R.id.setting_return_rl);
        mSetting_return_rl.setOnClickListener(this);
        mSetting_user_rl = (LinearLayout) findViewById(R.id.setting_user_rl);
        mSetting_user_rl .setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_return_iv:  //点击退出
                finish();
                this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
                break;
            case R.id.setting_news_rl:    //消息通知
                startActivity(new Intent(this,NewsActivity.class));
                SettingActivity.this.overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);

                break;
            case R.id.setting_cache__rl: //清理缓存
                break;
            case R.id.setting_version__rl://检查新版本
                break;
            case R.id.setting_friends__rl: //邀请好友
                break;
            case R.id.setting_evaluate__rl: //评价
                break;
            case R.id.fragment_me_rl: //关于我们
                break;
            case R.id.setting_return_rl: //退出登录
                SpUtils.setBoolean(getApplicationContext(),SpUtils.AD_LOGINSTATR,false);
                finish();
                this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
                break;
            case R.id.setting_user_rl: //用户界面
                break;
        }
    }

    @Override
    public void onBackPressed() {
        //退出界面的动画
        finish();
        this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
    }

    @Override
    protected void onResume() {
        //判断是否显示用户信息和退出登录
            boolean longinSate = SpUtils.getBoolean(getApplicationContext(), SpUtils.AD_LOGINSTATR);
            if (longinSate){
                mSetting_return_rl.setVisibility(View.VISIBLE);
                mSetting_user_rl.setVisibility(View.VISIBLE);
            }
        super.onResume();
    }



}
