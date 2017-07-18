package com.a520it.xianghacaipu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.a520it.xianghacaipu.R;

/**
 * Created by Administrator on 2017/6/26 0026.
 */

public class PublishActivity extends BaseActivity {


    private String mNow_address;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        Intent intent = getIntent();
        mNow_address = intent.getStringExtra("now_address");
    }

    public void back(View view) {
        finish();
    }

    //发菜谱
    public void sendMenu(View view) {
        startActivity(new Intent(this,SendMenuActivity.class));
    }
    //发帖
    public void posting(View view) {
        Intent intent = new Intent(this,PostingActivity.class);
        intent.putExtra("now_address",mNow_address);
        startActivity(intent);
    }
}
