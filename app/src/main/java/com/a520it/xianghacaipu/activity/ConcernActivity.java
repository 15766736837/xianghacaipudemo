package com.a520it.xianghacaipu.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.ConcernAdpapter;

public class ConcernActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout mSettingReturnLl;
    private TextView mConcernFonsTv;
    private TextView mConcernConcernTv;
    private LinearLayout mActivityConcern;
    private ViewPager mViewPager;
    private ConcernAdpapter mConcernAdpapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concern);
        initView();
        mConcernConcernTv.performClick();//默认点击一次

    }


    private void initView() {
        findViewById(R.id.setting_return_ll).setOnClickListener(this);
        mConcernFonsTv = (TextView) findViewById(R.id.concern_fons_tv);
        mConcernConcernTv = (TextView) findViewById(R.id.concern_concern_tv);
        mActivityConcern = (LinearLayout) findViewById(R.id.activity_concern);
        //设置Adapter
        mViewPager = (ViewPager) findViewById(R.id.concern_vp);
        mConcernAdpapter = new ConcernAdpapter(getSupportFragmentManager());
        mViewPager.setAdapter(mConcernAdpapter);
        //设置监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        onClick(mConcernFonsTv);
                        break;
                    case 1:
                        onClick(mConcernConcernTv);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mConcernFonsTv.setOnClickListener(this);
        mConcernConcernTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.concern_fons_tv:   //粉丝
                mConcernFonsTv.setSelected(true);
                mConcernConcernTv.setSelected(false);
                mViewPager.setCurrentItem(0,true);
                break;
            case R.id.concern_concern_tv:  //关注
                mConcernConcernTv.setSelected(true);
                mConcernFonsTv.setSelected(false);
                mViewPager.setCurrentItem(1,true);
                break;
            case R.id.setting_return_ll:
                finish();
                this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
    }
}





