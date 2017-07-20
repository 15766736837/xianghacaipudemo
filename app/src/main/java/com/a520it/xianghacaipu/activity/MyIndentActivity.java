package com.a520it.xianghacaipu.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.MyIndentAdapter;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class MyIndentActivity extends BaseActivity {

    private LinearLayout mMyindentReturnIv;
    private SmartTabLayout mMyindentTabs;
    private ViewPager mMyindentVp;
    private LinearLayout mActivityMyIndent;
    private MyIndentAdapter mMyIndentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_indent);
        initView();
    }

    private void initView() {
        mMyindentReturnIv = (LinearLayout) findViewById(R.id.myindent_return_iv);
        mMyindentTabs = (SmartTabLayout) findViewById(R.id.myindent_tabs);
        mMyindentVp = (ViewPager) findViewById(R.id.myindent_vp);
        mActivityMyIndent = (LinearLayout) findViewById(R.id.activity_my_indent);
        //设置导航栏
        mMyIndentAdapter = new MyIndentAdapter(getSupportFragmentManager());
        mMyindentVp.setAdapter(mMyIndentAdapter);
        mMyindentTabs.setViewPager(mMyindentVp);
    }


}
