package com.a520it.xianghacaipu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.step.StepBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/18 0018.
 */

public class AddStepsAdapter extends RecyclerView.Adapter<AddStepsAdapter.ViewHolder> {
    private  ArrayList<StepBean> mDatas;
    private  Context mContext;

    public AddStepsAdapter(Context context, ArrayList<StepBean> steps) {
        mContext =  context;
        mDatas = steps;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_addstep_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mNumTv.setText(mDatas.get(position).getNumber());
    }


    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView mNumTv;
        public EditText mTitle;
        public TextView mAddPhotoTv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mNumTv = (TextView) rootView.findViewById(R.id.num_tv);
            this.mTitle = (EditText) rootView.findViewById(R.id.title);
            this.mAddPhotoTv = (TextView) rootView.findViewById(R.id.add_photo_tv);
        }

    }
}
