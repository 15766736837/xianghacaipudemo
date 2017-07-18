package com.a520it.xianghacaipu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.recipe.FuLiaoBean;
import com.a520it.xianghacaipu.bean.recipe.ZhuLiaoBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/14 0014.
 */

public class AddFuLiaoAdapter extends RecyclerView.Adapter<AddFuLiaoAdapter.ViewHolder> {


    private  ArrayList<FuLiaoBean> mDatas;

    public AddFuLiaoAdapter(ArrayList<FuLiaoBean> datas) {
        mDatas = datas;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public AddFuLiaoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_addzhuliao, parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(AddFuLiaoAdapter.ViewHolder holder, int position) {
            holder.mOneEdt.setHint("如：油");
            holder.mTowEdt.setHint("如：适量");

    }

    @Override
    public int getItemCount() {
        return mDatas!=null?mDatas.size():0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public EditText mOneEdt;
        public EditText mTowEdt;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mOneEdt = (EditText) rootView.findViewById(R.id.one_edt);
            this.mTowEdt = (EditText) rootView.findViewById(R.id.tow_edt);
        }

    }
}
