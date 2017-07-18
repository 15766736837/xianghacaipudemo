package com.a520it.xianghacaipu.activity.home_category;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.HomeCategoryListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class HoMemodule2CategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnTouchListener {

    private ImageView mIntegrateReturnIv;
    private ListView mCategoryLv;
    private FrameLayout mCategoryFl;
    private List<String> mDatas;
    private HomeCategoryListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_memodule2_category);

        initView();
        initData();
        initListView();
        initEvent();
    }

    private void initView() {
        mIntegrateReturnIv = (ImageView) findViewById(R.id.integrate_return_iv);
        mCategoryLv = (ListView) findViewById(R.id.category_lv);
        mCategoryFl = (FrameLayout) findViewById(R.id.category_fl);
    }

    private void initData() {
        mDatas = new ArrayList<>();
        mDatas.add("热门");
        mDatas.add("肉汤");
        mDatas.add("蛋/奶");
        mDatas.add("鱼类");
        mDatas.add("水产");
        mDatas.add("蔬菜");
        mDatas.add("豆类");
        mDatas.add("果品类");
        mDatas.add("五谷杂粮");
        mDatas.add("药食");
        mDatas.add("调味品");
        mDatas.add("其他");
        mDatas.add("菜式");
        mDatas.add("菜系");
        mDatas.add("特色");
        mDatas.add("烘焙");
        mDatas.add("主食");
        mDatas.add("器具");
        mDatas.add("烹饪方式");
    }

    private void initListView() {
        mAdapter = new HomeCategoryListViewAdapter();
        mAdapter.setDatas(mDatas);
        mCategoryLv.setAdapter(mAdapter);
    }

    private void initEvent() {
        mCategoryLv.setOnItemClickListener(this);
        mCategoryLv.setOnTouchListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mCategoryLv.smoothScrollToPositionFromTop(position, 0, 300);
//        view.setBackgroundColor(Color.WHITE);
        View childAt = mCategoryLv.getChildAt(position);
        TextView line = (TextView) childAt.findViewById(R.id.home_category_item_line);
        line.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                mCategoryLv.setBackgroundColor(Color.WHITE);
                break;
            case MotionEvent.ACTION_UP:
                mCategoryLv.setBackgroundColor(0xFFF0F0F0);
                break;
        }
        return false;
    }
}
