package com.a520it.xianghacaipu.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.a520it.xianghacaipu.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserInfoActivity extends BaseActivity {

    private LinearLayout mSettingReturnIv;
    private CircleImageView mFoodUserphoto;
    private LinearLayout mActivityUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initView();
        initEvent();
    }

    private void initEvent() {
        mSettingReturnIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                UserInfoActivity.this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
            }
        });
    }

    private void initView() {
        mSettingReturnIv = (LinearLayout) findViewById(R.id.setting_return_iv);
        mFoodUserphoto = (CircleImageView) findViewById(R.id.food_userphoto);
        mActivityUserInfo = (LinearLayout) findViewById(R.id.activity_user_info);
    }

    @Override
    public void onBackPressed() {
        finish();
        UserInfoActivity.this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
    }
}
