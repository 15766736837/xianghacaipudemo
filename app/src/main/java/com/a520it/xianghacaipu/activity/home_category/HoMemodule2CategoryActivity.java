package com.a520it.xianghacaipu.activity.home_category;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.HomeCategoryGridViewAdapter;
import com.a520it.xianghacaipu.adapter.HomeCategoryListViewAdapter;
import com.a520it.xianghacaipu.bean.HomeCategoryBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.a520it.xianghacaipu.R.id.integrate_return_iv;

public class HoMemodule2CategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnTouchListener {
    private ListView mCategoryLv;
    private GridView mCategoryGv;
    private String[] mListDatas = {"热门", "肉类", "蛋/奶", "鱼类", "水产", "蔬菜", "豆类", "果品类", "五谷杂粮", "药食", "调味品", "其他", "菜式", "菜系", "特色", "烘焙", "主食", "器具", "烹饪方式"};
    private String[] mGridDatas = {"家常菜", "早餐", "素菜", "下饭菜", "凉菜", "面食", "川菜", "粥", "东北菜", "西餐", "面条", "汤羹"};
    private String[] mGridDatas2 = {"猪肉", "排骨", "猪蹄", "猪肚", "五花肉", "猪肝", "猪血", "猪腰", "猪皮", "猪耳朵", "猪心", "猪肺"};

    private List<HomeCategoryBean> mHomeCategoryBeans;
    private HomeCategoryListViewAdapter mAdapter;
    private HomeCategoryGridViewAdapter mGridViewAdapter;
    private ImageView mIntegrate_return_iv;

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
        mCategoryLv = (ListView) findViewById(R.id.category_lv);
        mCategoryGv = (GridView) findViewById(R.id.category_gv);
        mIntegrate_return_iv = (ImageView) findViewById(integrate_return_iv);

        mGridViewAdapter = new HomeCategoryGridViewAdapter();
        mGridViewAdapter.setDatas(Arrays.asList(mGridDatas));
        mCategoryGv.setAdapter(mGridViewAdapter);
    }

    private void initData() {
        mHomeCategoryBeans = new ArrayList<>();
        for (int i = 0; i < mListDatas.length; i++) {
            HomeCategoryBean homeCategoryBean = new HomeCategoryBean();
            homeCategoryBean.setContent(mListDatas[i]);
            if (i == 0) {
                homeCategoryBean.setSelect(1);
            } else {
                homeCategoryBean.setSelect(0);
            }
            mHomeCategoryBeans.add(homeCategoryBean);
        }
    }

    private void initListView() {
        mAdapter = new HomeCategoryListViewAdapter();
        mAdapter.setDatas(mHomeCategoryBeans);
        mCategoryLv.setAdapter(mAdapter);
        mIntegrate_return_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initEvent() {
        mCategoryLv.setOnItemClickListener(this);
        mCategoryLv.setOnTouchListener(this);

        mCategoryGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = mGridViewAdapter.getItem(position);
                // TODO: 2017/7/19
                Intent intent = new Intent(HoMemodule2CategoryActivity.this, HomeCategoryDetailsActivity.class);
                intent.putExtra(HomeCategoryDetailsActivity.DATA, item);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mCategoryLv.smoothScrollToPositionFromTop(position, 0, 300);
        List<HomeCategoryBean> item = mAdapter.getItem(position);
        //把每一个Item复位
        for (int i = 0; i < item.size(); i++) {
            item.get(i).setSelect(0);
        }
        item.get(position).setSelect(1);
        mAdapter.notifyDataSetChanged();

        if (position % 2 == 0){
            mGridViewAdapter.setDatas(Arrays.asList(mGridDatas));
        }else{
            mGridViewAdapter.setDatas(Arrays.asList(mGridDatas2));
        }
        mGridViewAdapter.notifyDataSetChanged();
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
