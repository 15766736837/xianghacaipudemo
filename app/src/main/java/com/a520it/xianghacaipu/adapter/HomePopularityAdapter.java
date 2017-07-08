package com.a520it.xianghacaipu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.HomeBean;
import com.a520it.xianghacaipu.utils.LoadImageUtil;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Lai on 2017/7/7.
 */

public class HomePopularityAdapter extends RecyclerView.Adapter{
    private final Context mContext;
    private List<HomeBean.DataBean.ActiveUserBean> mDatas;

    public void setDatas(List<HomeBean.DataBean.ActiveUserBean> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

    public HomePopularityAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.home_popularity_item_layout, null);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.ActiveUserBean activeUserBean = mDatas.get(position);
        ((MyHolder)holder).setTextView(activeUserBean.getNickName());
        CircleImageView imageView = ((MyHolder) holder).getImageView();
        LoadImageUtil.getInstance().display(activeUserBean.getImg(), imageView);
        int isGourmet = activeUserBean.getIsGourmet();
        ((MyHolder)holder).setVipHide(isGourmet);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private final CircleImageView mPopularityIv;
        private final TextView mPopularityTv;
        private final ImageView mPopularityVIPTv;

        public MyHolder(View itemView) {
            super(itemView);
            mPopularityIv = (CircleImageView) itemView.findViewById(R.id.home_popularity_iv);
            mPopularityTv = (TextView) itemView.findViewById(R.id.home_popularity_tv);
            mPopularityVIPTv = (ImageView) itemView.findViewById(R.id.home_popularity_vip);
        }

        public void setVipHide(int i){
            mPopularityVIPTv.setVisibility(i == 1 ? View.GONE : View.VISIBLE);
        }

        public CircleImageView getImageView(){
            return mPopularityIv;
        }
        
        public void setTextView(String text){
            mPopularityTv.setText(text);
        }
    }
}
