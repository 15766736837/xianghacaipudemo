package com.a520it.xianghacaipu.activity.find;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.activity.BaseActivity;
import com.a520it.xianghacaipu.adapter.find.FindDetailAdapter;
import com.a520it.xianghacaipu.bean.disbean.DetailBean;
import com.a520it.xianghacaipu.bean.disbean.MultiItem;
import com.a520it.xianghacaipu.constant.ActionCon;
import com.a520it.xianghacaipu.controller.find.FindDetailController;
import com.a520it.xianghacaipu.view.FindItemDisDecoration;

import java.util.ArrayList;
import java.util.List;

public class FindItemDetailActivity extends BaseActivity {

    private RecyclerView mDetailRv;
    private FindDetailController mFindDetailController;
    private int mCodeId;

    @Override
    protected void handUI(Message msg) {
        switch (msg.what) {
            case ActionCon.FINDDETAILDATA :
                DetailBean datas = (DetailBean) msg.obj;
                initRecycler(datas);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.a520it.xianghacaipu.R.layout.activity_find_item_detail);
        Intent intent = getIntent();
        mCodeId = intent.getIntExtra("codeId", 0);

        initView();
        initControl();
        requestDatas();


//        http://api.xiangha.com/main6/tie/getInfo?code=24354826&page=1
//        Log.v("cherish233","http://api.xiangha.com/main6/tie/getInfo?code="+ mCodeId +"&page=1");
    }

    private void initControl() {
        mFindDetailController = new FindDetailController(this);
        mFindDetailController.setListerent(this);
    }

    private void initRecycler(DetailBean datas) {
        ArrayList<MultiItem> multiItems = initDatas(datas);
        //适配器
        FindDetailAdapter findDetailAdapter = new FindDetailAdapter(multiItems);
        //布局方式
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //分割线
        FindItemDisDecoration findItemDisDecoration = new FindItemDisDecoration(this, 15);
        mDetailRv.addItemDecoration(findItemDisDecoration);
        mDetailRv.setLayoutManager(linearLayoutManager);
        mDetailRv.setAdapter(findDetailAdapter);
    }

    private ArrayList<MultiItem> initDatas(DetailBean datas) {
        List<DetailBean.DataBean.FloorBean> floor = datas.getData().getFloor();

        ArrayList<MultiItem> multiItems = new ArrayList<>();
        for(int i = 0; i < floor.size(); i++) {
            if(i==0) {
                multiItems.add(new MultiItem(MultiItem.CONTENT,floor.get(i)));
            }else {
                multiItems.add(new MultiItem(MultiItem.COMMENT,floor.get(i)));
            }
        }
        return multiItems;
    }

    private void requestDatas() {
        mFindDetailController.sendAsynchronization(ActionCon.FINDDETAILDATA,mCodeId);
    }

    private void initView() {
        mDetailRv = (RecyclerView) findViewById(com.a520it.xianghacaipu.R.id.find_item_detail_rv);
        ImageView back = (ImageView) findViewById(R.id.find_item_detail_topbar_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
