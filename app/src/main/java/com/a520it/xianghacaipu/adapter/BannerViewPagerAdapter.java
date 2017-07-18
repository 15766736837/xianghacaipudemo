package com.a520it.xianghacaipu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.activity.home_category.HomeBannerDetailsActivity;
import com.a520it.xianghacaipu.bean.HomeBean;
import com.a520it.xianghacaipu.listerent.SetBannerListener;
import com.a520it.xianghacaipu.utils.LoadImageUtil;
import com.a520it.xianghacaipu.view.DropZoomScrollView;

import java.util.List;

import static com.a520it.xianghacaipu.R.id.iv;

/**
 * Created by Lai on 2017/6/21.
 */

public class BannerViewPagerAdapter extends PagerAdapter implements SetBannerListener{

    private ImageView mIv;
    private int mCount = 0;
    private int mData;

    private DropZoomScrollView mDropZoomScrollView;
    private Context mContext;
    private List<String> mUrl;
    private List<HomeBean.DataBean.RecommendBean> mRecommend;
    private ImageView mBannreIv;


    public BannerViewPagerAdapter(Context context, DropZoomScrollView sv) {
        mContext = context;
        mDropZoomScrollView = sv;
    }

    public void setRecommend(List<HomeBean.DataBean.RecommendBean> recommend) {
        mRecommend = recommend;
    }

    public void setUrl(List<String> url) {
        mUrl = url;
    }

    @Override
    public int getCount() {
        mDropZoomScrollView.setListener(this);
        return mUrl != null ? Integer.MAX_VALUE : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position = position % mUrl.size();
        View view = View.inflate(mContext, R.layout.banner_item_layout, null);
        initView(view);

        //加载图片
        LoadImageUtil.getInstance().display(mUrl.get(position), mBannreIv);

        //保证分类图片位置不变
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mIv.getLayoutParams();
        layoutParams.rightMargin = 50 + mData / 2;
        layoutParams.topMargin = 50;
        mIv.setLayoutParams(layoutParams);

        //设置分类(早餐,午餐...)
        setCategory(position);

        container.addView(view);

        //ViewPager Item的点击事件
        final int finalPosition = position;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, HomeBannerDetailsActivity.class);
                intent.putExtra("position", finalPosition);
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    private void initView(View view) {
        mBannreIv = (ImageView) view.findViewById(iv);
        mIv = (ImageView) view.findViewById(R.id.tv);
    }

    private void setCategory(int position) {
        switch (mRecommend.get(position).getType()) {
            case 1:
                mIv.setImageResource(R.drawable.i_ico_homepage_sancan_zao);
                break;
            case 2:
                mIv.setImageResource(R.drawable.i_ico_homepage_sancan_zhong);
                break;
            case 3:
                mIv.setImageResource(R.drawable.i_ico_homepage_sancan_wan);
                break;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        if (mCount > 0) {
            mCount--;
            return POSITION_NONE;

        }
        return super.getItemPosition(object);
    }

    @Override
    public void notifyDataSetChanged() {
        mCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public void setData(int data) {
        mData = data;
        notifyDataSetChanged();
    }
}
