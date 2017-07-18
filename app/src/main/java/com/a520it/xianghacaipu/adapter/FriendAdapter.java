package com.a520it.xianghacaipu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.recipe.FriendBean;
import com.a520it.xianghacaipu.listerent.MyItemListener;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/17 0017.
 */

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {


    private  ArrayList<FriendBean> mDatas;
    private  Context mContext;
    private MyItemListener mListener;

    public FriendAdapter(Context context, ArrayList<FriendBean> datas) {
        mDatas = datas;
        mContext =context;
    }

    @Override
    public FriendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.friend_item, parent, false);
        ViewHolder vh = new ViewHolder(view,mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(FriendAdapter.ViewHolder holder, int position) {
        holder.userImg.setImageResource(mDatas.get(position).getUser_img());
        holder.userName.setText(mDatas.get(position).getUser_name());
        holder.checkThis.setChecked(mDatas.get(position).getIsCheck());

    }

    @Override
    public int getItemCount() {
        return mDatas!=null?mDatas.size():0;
    }




    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public View rootView;
        public ImageView userImg;
        public TextView userName;
        public CheckBox checkThis;
        public MyItemListener myListener;

        public ViewHolder(View rootView,MyItemListener listener) {
            super(rootView);
            this.rootView = rootView;
            this.userImg = (ImageView) rootView.findViewById(R.id.user_img);
            this.userName = (TextView) rootView.findViewById(R.id.user_name);
            this.checkThis = (CheckBox) rootView.findViewById(R.id.check_this);
            this.myListener = listener;
            rootView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(myListener!=null){
                myListener.onItemClick(v,getAdapterPosition());
            }
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);

    }
    public void setOnItemClickListener(MyItemListener listener){
        this.mListener = listener;

    }
}
