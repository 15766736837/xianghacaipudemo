package com.a520it.xianghacaipu.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.step.StepBean;
import com.a520it.xianghacaipu.listerent.IPhotoListener;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/18 0018.
 */

public class AddStepsAdapter extends RecyclerView.Adapter<AddStepsAdapter.ViewHolder> {

    private final Context mContext;
    private final ArrayList<StepBean> mDatas;
    private IPhotoListener mIphotoListener;

    public AddStepsAdapter(Context context, ArrayList<StepBean> steps) {
        mContext = context;
        mDatas = steps;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_addstep_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    public void setOnIphotoListener(IPhotoListener listener) {
        mIphotoListener = listener;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mNumTv.setText(mDatas.get(position).getNumber() + 1 + "");
        Log.i("mylog", "onBindViewHolder: @@@@@@@@@@@@@@@@@"+ (mIphotoListener != null));
        if (mIphotoListener != null) {
            holder.mAddPhotoItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //只有这个方法返回的才是当前item经过一些变换后所处的真正位置。
                    int layoutPosition = holder.getLayoutPosition();
                    Log.i("mylog", "onClick: 当前点击的索引位置 >>>     "+layoutPosition);
                    mIphotoListener.setOnPhotoListener(v,layoutPosition);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView mNumTv;
        public TextView mText;
        public EditText mTitle;
        public ImageView mShowImgItem;
        public FrameLayout mAddPhotoItem;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mNumTv = (TextView) rootView.findViewById(R.id.num_tv);
            this.mTitle = (EditText) rootView.findViewById(R.id.title);
            this.mShowImgItem = (ImageView) rootView.findViewById(R.id.show_img_item);
            this.mAddPhotoItem = (FrameLayout) rootView.findViewById(R.id.add_photo_item);
            this.mText = (TextView) rootView.findViewById(R.id.text);
        }


    }

    public void addData(int position) {
        mDatas.add(position, new StepBean(mDatas.size()));
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

}
