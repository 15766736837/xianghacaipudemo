package com.a520it.xianghacaipu.activity.home_category;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.ImageView;
import android.widget.ListView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.activity.BaseActivity;
import com.a520it.xianghacaipu.adapter.HomeCategoryDetailsAdapter;
import com.a520it.xianghacaipu.adapter.MyBaseAdapter;
import com.a520it.xianghacaipu.bean.HomeCategoryDetailsBean;
import com.a520it.xianghacaipu.constant.INetWorkAction;
import com.a520it.xianghacaipu.controller.HomeCategoryDetailsController;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class HomeCategoryDetailsActivity extends BaseActivity {
    public static final String DATA = "data";
    private String mDataStr;
    private HomeCategoryDetailsController mController;
    private ImageView mIntegrateReturnIv;
    private ListView mHomeCategoryDetailsLv;
    private List<HomeCategoryDetailsBean.DataBean.DishsBean> mDishs;
    private MyBaseAdapter mMyAdapter;

    @Override

    protected void handUI(Message msg) {
        if (msg.what == INetWorkAction.HOME_CATEGORY_DETAILS) {
            String JsonStr = (String) msg.obj;
            HomeCategoryDetailsBean homeCategoryDetailsBean = JSONObject.parseObject(JsonStr, HomeCategoryDetailsBean.class);
            mDishs = homeCategoryDetailsBean.getData().getDishs();
            mMyAdapter.setDatas(mDishs);
            mMyAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_category_details);
        initView();

        Intent intent = getIntent();
        mDataStr = intent.getStringExtra(DATA);

        initController();
        initData();
        initListView();
    }

    private void initController() {
        mController = new HomeCategoryDetailsController(this);
        mController.setListerent(this);
    }

    private void initData() {
        mController.sendAsynchronization(INetWorkAction.HOME_CATEGORY_DETAILS, mDataStr);
    }

    private void initView() {
        mIntegrateReturnIv = (ImageView) findViewById(R.id.integrate_return_iv);
        mHomeCategoryDetailsLv = (ListView) findViewById(R.id.home_Category_Details_lv);
    }

    private void initListView() {
        mMyAdapter = new HomeCategoryDetailsAdapter();
        mHomeCategoryDetailsLv.setAdapter(mMyAdapter);
    }
}
