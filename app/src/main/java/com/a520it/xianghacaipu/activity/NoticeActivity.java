package com.a520it.xianghacaipu.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.FriendAdapter;
import com.a520it.xianghacaipu.bean.recipe.FriendBean;
import com.a520it.xianghacaipu.listerent.MyItemListener;
import com.a520it.xianghacaipu.utils.LoadImageUtil;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/7/17 0017.
 */
public class NoticeActivity extends BaseActivity implements View.OnClickListener, MyItemListener {
//
//    private boolean isCheck = false;
//
//    private MyItemListener mMyItemListener;
    private TextView mEnsureTv;
    private EditText mFilterEdt;
    private RecyclerView mFriendsRv;
    private ArrayList<FriendBean> mDatas;
    private FriendAdapter mFriendAdapter;
    private FriendBean mBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        initView();
        initEvent();
    }

    private void initEvent() {
        //获取输入的值
        String s = mFilterEdt.getText().toString();

    }


    private void initView() {
        findViewById(R.id.back_tv).setOnClickListener(this);
        mEnsureTv = (TextView) findViewById(R.id.ensure_tv);
        mEnsureTv.setOnClickListener(this);
        mFilterEdt = (EditText) findViewById(R.id.filter_edt);

        mFilterEdt.setSelection(mFilterEdt.length());
        mFriendsRv = (RecyclerView) findViewById(R.id.friends_rv);
        mDatas = new ArrayList<>();
        //获取数据
        for (int i = 0; i < 5; i++) {
            mDatas.add(new FriendBean(R.mipmap.ic_launcher, "用户名" + i, false));
        }
        mFriendAdapter = new FriendAdapter(this, mDatas);
        mFriendsRv.setLayoutManager(new LinearLayoutManager(this));
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mFriendsRv.setHasFixedSize(true);
        mFriendsRv.setAdapter(mFriendAdapter);
        //设置增加或删除条目的动画
        mFriendsRv.setItemAnimator(new DefaultItemAnimator());
        mFriendAdapter.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ensure_tv:
                toPosting();
                break;
            case R.id.back_tv:
                finish();
        }
    }

    private void toPosting() {
        ArrayList<String> str = new ArrayList<>();
        //获取到选中的item
        if (mDatas != null) {
            for (int i = 0; i < mDatas.size(); i++) {
                //将选择的用户的用户名返回
                if (mDatas.get(i).getIsCheck()) {
                    //获取当前item的用户名
                    String user_name = "@ " + mDatas.get(i).getUser_name();
                    str.add(user_name);
                    Log.i("mylog", "onClick: ===========" + user_name);
                }
            }
        }
        Intent intent = new Intent(this,PostingActivity.class);
        intent.putStringArrayListExtra("username",str);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemClick(View view, int posion) {
        mBean = mDatas.get(posion);
        if (mBean != null) {
            mBean.setIsCheck(!mBean.getIsCheck());
            mFriendAdapter.notifyDataSetChanged();
        }
    }


}
