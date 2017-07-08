package com.a520it.xianghacaipu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.AlbumAdapter;

/**
 * Created by Administrator on 2017/7/4 0004.
 */
public class Album_List extends BaseActivity {


    private RecyclerView mRecyLv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);
        initView();

    }

    private void initView() {
        mRecyLv = (RecyclerView) findViewById(R.id.recy_lv);
        AlbumAdapter adapter = new AlbumAdapter();
    }
}
