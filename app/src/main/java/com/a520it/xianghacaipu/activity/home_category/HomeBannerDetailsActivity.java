package com.a520it.xianghacaipu.activity.home_category;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.fragmnt.BaseFragment;
import com.a520it.xianghacaipu.fragmnt.home_banner.BreakfastFragment;
import com.a520it.xianghacaipu.fragmnt.home_banner.LunchFragment;
import com.a520it.xianghacaipu.fragmnt.home_banner.SupperFragment;
import com.a520it.xianghacaipu.utils.ShareUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeBannerDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView integrate_return_iv;
    private TextView lunch_tv;
    private TextView lunch_line;
    private TextView breakfast_tv;
    private TextView breakfast_line;
    private TextView supper_tv;
    private TextView supper_line;
    private List<BaseFragment> mFragments;
    private ImageView integrate_share_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_banner_details);

        initView();
        int position = getData();
        initFragment();
        setSelect(position);
        initEvent();
    }

    private void initView() {
        integrate_return_iv = (ImageView) findViewById(R.id.integrate_return_iv);
        integrate_share_iv = (ImageView) findViewById(R.id.integrate_share_iv);
        lunch_tv = (TextView) findViewById(R.id.lunch_tv);
        lunch_line = (TextView) findViewById(R.id.lunch_line);
        breakfast_tv = (TextView) findViewById(R.id.breakfast_tv);
        breakfast_line = (TextView) findViewById(R.id.breakfast_line);
        supper_tv = (TextView) findViewById(R.id.supper_tv);
        supper_line = (TextView) findViewById(R.id.supper_line);
    }

    private int getData() {
        Intent intent = getIntent();
        return intent.getIntExtra("position", -1);
    }

    private void setSelect(int position) {
        switch (position) {
            case 0:
                breakfast_tv.setTextColor(Color.WHITE);
                breakfast_line.setVisibility(View.VISIBLE);
                changeFragment(mFragments.get(position));
                break;
            case 1:
                lunch_tv.setTextColor(Color.WHITE);
                lunch_line.setVisibility(View.VISIBLE);
                changeFragment(mFragments.get(position));
                break;
            case 2:
                supper_tv.setTextColor(Color.WHITE);
                supper_line.setVisibility(View.VISIBLE);
                changeFragment(mFragments.get(position));
                break;
        }
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        BreakfastFragment breakfastFragment = new BreakfastFragment();
        LunchFragment lunchFragment = new LunchFragment();
        SupperFragment supperFragment = new SupperFragment();
        mFragments.add(breakfastFragment);
        mFragments.add(lunchFragment);
        mFragments.add(supperFragment);
    }

    private void initEvent() {
        breakfast_tv.setOnClickListener(this);
        lunch_tv.setOnClickListener(this);
        supper_tv.setOnClickListener(this);
        integrate_return_iv.setOnClickListener(this);
        integrate_share_iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.breakfast_tv:
                init();
                setSelect(0);
                break;
            case R.id.lunch_tv:
                init();
                setSelect(1);
                break;
            case R.id.supper_tv:
                init();
                setSelect(2);
                break;
            case R.id.integrate_return_iv:
                finish();
                break;
            case R.id.integrate_share_iv:
                HashMap<String, String> map = new HashMap<>();
                ShareUtils.showShare(this, map);
                break;
        }
    }

    private void init() {
        breakfast_tv.setTextColor(0xFFFDA69A);
        breakfast_line.setVisibility(View.GONE);

        supper_tv.setTextColor(0xFFFDA69A);
        supper_line.setVisibility(View.GONE);

        lunch_tv.setTextColor(0xFFFDA69A);
        lunch_line.setVisibility(View.GONE);
    }

    //fragment切换显示
    private void changeFragment(BaseFragment baseFragment) {
        //开启一个事物
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (!baseFragment.isAdded()) {
            transaction.add(R.id.fragment_fl, baseFragment);
        }

        transaction.show(baseFragment);

        for (BaseFragment fr : mFragments) {
            if (fr.equals(baseFragment)) {
                continue;
            }
            transaction.hide(fr);
        }

        //提交事务
        transaction.commitAllowingStateLoss();
    }
}
