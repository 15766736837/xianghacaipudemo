package com.a520it.xianghacaipu.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.CollectAdapter;
import com.a520it.xianghacaipu.utils.ActivityUtils;

import static com.a520it.xianghacaipu.R.id.collect_return_iv;

//我的收藏界面
public class CollectActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mCollectReturnIv;
    private ImageView mCollectSouxunIv;
    private TextView mCollectFoodTv;
    private TextView mCollectConcernTv;
    private TextView mCollectToplineTv;
    private ViewPager mCollectVp;
    private LinearLayout mActivityCollect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        initView();
        mCollectFoodTv.performClick(); //默认点击一次
    }

    private void initView() {
        findViewById(collect_return_iv).setOnClickListener(this);
        mCollectSouxunIv = (ImageView) findViewById(R.id.collect_souxun_iv);
        mCollectFoodTv = (TextView) findViewById(R.id.collect_food_tv);
        mCollectFoodTv.setOnClickListener(this);
        mCollectConcernTv = (TextView) findViewById(R.id.collect_concern_tv);
        mCollectConcernTv.setOnClickListener(this);
        mCollectToplineTv = (TextView) findViewById(R.id.collect_topline_tv);
        mCollectToplineTv.setOnClickListener(this);

        mCollectVp = (ViewPager) findViewById(R.id.collect_vp);
        CollectAdapter collectAdapter = new CollectAdapter(getSupportFragmentManager());
        mCollectVp.setAdapter(collectAdapter);
        mCollectVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case  0:
                        setTextColer(mCollectFoodTv);
                        break;
                    case  1:
                        setTextColer(mCollectConcernTv);
                        break;
                    case  2:
                        setTextColer(mCollectToplineTv);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        mActivityCollect = (LinearLayout) findViewById(R.id.activity_collect);
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.collect_return_iv:  //点击关闭
                ActivityUtils.finshActivity(this);
                break;
            case  R.id.collect_food_tv:  //菜谱
                setTextColer(mCollectFoodTv);
                mCollectVp.setCurrentItem(0,true);
                break;
            case  R.id.collect_concern_tv:  //美食帖
                mCollectVp.setCurrentItem(1,true);
                break;
            case  R.id.collect_topline_tv:  //头条
                mCollectVp.setCurrentItem(2,true);

                break;
        }
    }

    /**
     * 动态改变颜色和大小
     * @param view
     */
    private  void  setTextColer(View view){
        if (mCollectFoodTv == view){
            mCollectFoodTv.setSelected(true);
            mCollectFoodTv.setTextSize(15);
        }else {
            mCollectFoodTv.setSelected(false);
            mCollectFoodTv.setTextSize(13);
        }


        if (mCollectConcernTv == view){
            mCollectConcernTv.setSelected(true);
            mCollectConcernTv.setTextSize(15);
        }else {
            mCollectConcernTv.setSelected(false);
            mCollectConcernTv.setTextSize(13);
        }

        if (mCollectToplineTv == view){
            mCollectToplineTv.setSelected(true);
            mCollectToplineTv.setTextSize(15);
        }else {
            mCollectToplineTv.setSelected(false);
            mCollectToplineTv.setTextSize(13);
        }


    }
}
