package com.a520it.xianghacaipu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.FindListBean;
import com.a520it.xianghacaipu.utils.LoadImageUtil;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by simon on 2017/6/16.
 */

public class FindRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_FOOT = 0;
    private static final int TYPE_ITEM = 1;
    private final List<FindListBean.DataBeanX.DataBean> mDatas;
    private final Context mContext;

    public FindRecyclerAdapter(Context context, List<FindListBean.DataBeanX.DataBean> data) {
        this.mDatas = data;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_FOOT) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.find_fra_list_foot_layout, parent, false);
            FootViewHolder footViewHolder = new FootViewHolder(view);
            return footViewHolder;
        } else if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.find_fra_list_item_layout, parent, false);
            ItemViewHolder itemViewHolder = new ItemViewHolder(view);
            return itemViewHolder;
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

            return TYPE_ITEM;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof FootViewHolder) {
            
        }else if(holder instanceof ItemViewHolder) {
            ItemViewHolder itemholder = (ItemViewHolder) holder;
            FindListBean.DataBeanX.DataBean dataBean = mDatas.get(position);
            //昵称
            itemholder.mFindFraLvItemName.setText(dataBean.getCustomer().getNickName());
            //头像
            //        AsyncImageLoader.getInstance(mContext).displayImage(dataBean.getCustomer().getImg(), holder.mFindFraLvItemHeadIcon);
            LoadImageUtil.getInstance().display(dataBean.getCustomer().getImg(), itemholder.mFindFraLvItemHeadIcon);
            //更新时间
            itemholder.mFindFraLvItemTime.setText(dataBean.getTimeShow());
            //正文
            itemholder.mFindFraLvItemContext.setText("【" + dataBean.getTitle() + "】" + dataBean.getContent());
            //正文图片
            setContextImg(itemholder, dataBean);
            //看过的数量
            itemholder.mFindFraLvItemCountClick.setText(dataBean.getClick() + "");
            //评论的数量
            itemholder.mFindFraLvItemCountComment.setText(dataBean.getCommentNum() + "");
            //点赞的数量
            itemholder.mFindFraLvItemCountLike.setText(dataBean.getLikeNum() + "");
            //定位
            if (TextUtils.isEmpty(dataBean.getCity())) {
                itemholder.mFindFraLvItemLocation.setVisibility(View.GONE);
            } else {
                itemholder.mFindFraLvItemLocationTv.setText(dataBean.getCity());
            }
            //等级
            setLevel(itemholder, dataBean);
        }

    }

    private void setContextImg(ItemViewHolder holder, FindListBean.DataBeanX.DataBean dataBean) {
        int childCount = holder.mFindFraLvItemImgLl.getChildCount();

        if (childCount != 0) {
            for (int i = 0; i < childCount; i++) {
                holder.mFindFraLvItemImgLl.getChildAt(i).setVisibility(View.GONE);
            }
        }

        int size = dataBean.getImgs().size() >= 3 ? 3 : dataBean.getImgs().size();
        for (int i = 0; i < size; i++) {
            //设置图片控件,并设置属性
            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 220, 1);
            layoutParams.setMargins(5, 5, 5, 5);
            imageView.setLayoutParams(layoutParams);
            //            AsyncImageLoader.getInstance(mContext).displayImage(dataBean.getImgs().get(i), imageView);
            LoadImageUtil.getInstance().display(dataBean.getImgs().get(i), imageView);
            holder.mFindFraLvItemImgLl.addView(imageView);

        }
    }

    private void setLevel(ItemViewHolder holder, FindListBean.DataBeanX.DataBean dataBean) {
        int lv = dataBean.getCustomer().getLv();
        ImageView findFraLvItemLevel = holder.mFindFraLvItemLevel;
        switch (lv) {
            case 0:
                findFraLvItemLevel.setVisibility(View.GONE);
                break;
            case 1:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_01);
                break;
            case 2:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_02);
                break;
            case 3:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_03);
                break;
            case 4:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_04);
                break;
            case 5:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_05);
                break;
            case 6:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_06);
                break;
            case 7:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_07);
                break;
            case 8:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_08);
                break;
            case 9:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_09);
                break;
            case 10:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_10);
                break;
            case 11:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_11);
                break;
            case 12:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_12);
                break;
            case 13:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_13);
                break;
            case 14:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_14);
                break;
            case 15:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_15);
                break;
            case 16:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_16);
                break;
            case 17:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_17);
                break;
            case 18:
                findFraLvItemLevel.setImageResource(R.drawable.z_z_ico_level_18);
                break;
        }
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void loadMore(List<FindListBean.DataBeanX.DataBean> addData) {
        mDatas.addAll(addData);
        notifyDataSetChanged();
    }

    public class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View itemView) {
            super(itemView);

        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView mFindFraLvItemHeadIcon;
        private TextView mFindFraLvItemName;
        private ImageView mFindFraLvItemLevel;
        private TextView mFindFraLvItemTime;
        private TextView mFindFraLvItemContext;
        private LinearLayout mFindFraLvItemLocation;
        private TextView mFindFraLvItemLocationTv;
        private TextView mFindFraLvItemCountClick;
        private TextView mFindFraLvItemCountComment;
        private TextView mFindFraLvItemCountLike;
        private LinearLayout mFindFraLvItemImgLl;


        public ItemViewHolder(View itemView) {
            super(itemView);
            //要手动添加属性,不然布局会显示不正常
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            itemView.setLayoutParams(layoutParams);

            mFindFraLvItemHeadIcon = (CircleImageView) itemView.findViewById(R.id.find_fra_lv_item_head_icon);
            mFindFraLvItemName = (TextView) itemView.findViewById(R.id.find_fra_lv_item_name);
            mFindFraLvItemLevel = (ImageView) itemView.findViewById(R.id.find_fra_lv_item_level);
            mFindFraLvItemTime = (TextView) itemView.findViewById(R.id.find_fra_lv_item_time);
            mFindFraLvItemContext = (TextView) itemView.findViewById(R.id.find_fra_lv_item_context);
            mFindFraLvItemLocation = (LinearLayout) itemView.findViewById(R.id.find_fra_lv_item_location);

            mFindFraLvItemLocationTv = (TextView) itemView.findViewById(R.id.find_fra_lv_item_location_tv);
            mFindFraLvItemCountClick = (TextView) itemView.findViewById(R.id.find_fra_lv_item_count_care);
            mFindFraLvItemCountComment = (TextView) itemView.findViewById(R.id.find_fra_lv_item_count_comment);
            mFindFraLvItemCountLike = (TextView) itemView.findViewById(R.id.find_fra_lv_item_count_good);
            mFindFraLvItemImgLl = (LinearLayout) itemView.findViewById(R.id.find_fra_lv_item_show_pic);

        }
    }


}
