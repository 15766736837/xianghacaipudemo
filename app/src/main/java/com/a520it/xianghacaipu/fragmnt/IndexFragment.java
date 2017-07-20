package com.a520it.xianghacaipu.fragmnt;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.activity.home_category.HoMemodule2CategoryActivity;
import com.a520it.xianghacaipu.activity.home_category.HomeHeadlineItemActivity;
import com.a520it.xianghacaipu.adapter.BannerViewPagerAdapter;
import com.a520it.xianghacaipu.adapter.HomeHeadlineAdapter;
import com.a520it.xianghacaipu.adapter.HomeOptimumAdapter;
import com.a520it.xianghacaipu.adapter.HomePopularityAdapter;
import com.a520it.xianghacaipu.bean.HomeBean;
import com.a520it.xianghacaipu.bean.HomeOptimumBean;
import com.a520it.xianghacaipu.constant.INetWorkAction;
import com.a520it.xianghacaipu.controller.HomeController;
import com.a520it.xianghacaipu.utils.LoadImageUtil;
import com.a520it.xianghacaipu.view.DisDecoration;
import com.a520it.xianghacaipu.view.DropZoomScrollView;
import com.a520it.xianghacaipu.view.HomeOptimumLoadItemView;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ASUS on 2017/6/15.
 */
public class IndexFragment extends BaseFragment implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager mBannerVp;
    private DropZoomScrollView mDropZoomScrollView;
    private HomeController mController;
    private HomeBean mHomeBean;
    private List<HomeBean.DataBean.RecommendBean> mRecommend;
    private List<String> mPicUrl = new ArrayList<>();
    private LinearLayout mPointer;
    private BannerViewPagerAdapter mMyViewPagerAdapter;
    private List<List<HomeBean.DataBean.RecommendBean.ListBean>> mBannerPicLists;

    private ListView mHeadlineLv;
    private HomeHeadlineAdapter mHomeHeadlineAdapter;
    private RecyclerView mPopularityRv;
    private HomePopularityAdapter mPopularityAdapter;
    private TextView mOptimumTitleTv;
    private TextView mOptimumContentRl;
    private ImageView mOptimumIv;
    private HomeOptimumBean mHomeOptimumBean;
    private RecyclerView mHomeOptimumRv;
    private HomeOptimumAdapter mHomeOptimumAdapter;
    private List<HomeBean.DataBean.NousBean> mNous;

    @Override
    protected void handleUI(Message msg) {
        switch (msg.what) {
            case INetWorkAction.HOME_ACTION:
                //解析json
                parseHomeJsonStr(msg);
                //获取轮播图的数据
                getBannerPicStr();
                //初始化指示器
                initPointer();
                //设置adapter的数据
                setAdapterData();
                //设置左边无限轮播,把第一个图片设置为最大值的一半
                setBannerLeftLoop();

                //头条
                initHeadline();
                //人气
                initPopularity();

                List<HomeBean.DataBean.TopicBean> topic = mHomeBean.getData().getTopic();
                LoadImageUtil.getInstance().display(topic.get(0).getImgs(), mOptimumIv);
                mOptimumTitleTv.setText(topic.get(0).getTitle());
                mOptimumContentRl.setText(topic.get(0).getSubtitle());
                break;
            case INetWorkAction.HOME_OPTIMUM:
                String jsonStr = (String) msg.obj;
                mHomeOptimumBean = JSONObject.parseObject(jsonStr, HomeOptimumBean.class);
                mHomeOptimumAdapter.setNewData(mHomeOptimumBean.getData());
                break;
        }
    }

    private void initHeadline() {
        mNous = mHomeBean.getData().getNous();
        mNous.add(null);
        mHomeHeadlineAdapter.setDatas(mNous);
    }

    private void initPopularity() {
        List<HomeBean.DataBean.ActiveUserBean> activeUser = mHomeBean.getData().getActiveUser();
        mPopularityAdapter.setDatas(activeUser);
        DisDecoration disDecoration = new DisDecoration(getContext(), 50);
        mPopularityRv.addItemDecoration(disDecoration);
    }

    private void parseHomeJsonStr(Message msg) {
        String jsonStr = (String) msg.obj;
        mHomeBean = JSONObject.parseObject(jsonStr, HomeBean.class);
    }

    private void getBannerPicStr() {
        HomeBean.DataBean data = mHomeBean.getData();
        mRecommend = data.getRecommend();
        mBannerPicLists = new ArrayList<>();
        for (int i = 0; i < mRecommend.size(); i++) {
            HomeBean.DataBean.RecommendBean recommendBean = mRecommend.get(i);
            mPicUrl.add(recommendBean.getImg());

            //轮播图每一个item对应的一组图片
            List<HomeBean.DataBean.RecommendBean.ListBean> list = recommendBean.getList();
            mBannerPicLists.add(list);
        }

        for (int i = 0; i < mBannerPicLists.size(); i++) {
            List<HomeBean.DataBean.RecommendBean.ListBean> listBeen = mBannerPicLists.get(i);
            for (int j = 0; j < listBeen.size(); j++) {
                mController.sendAsynchronization(INetWorkAction.HOME_BANNER_PIC_ACTION, listBeen.get(j).getImg());
            }
        }
    }

    private void initPointer() {
        //指示器
        for (int i = 0; i < mPicUrl.size(); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 10, 0);
            ImageView pointerImageView = new ImageView(getContext());
            pointerImageView.setImageResource(R.drawable.banner_dot);
            mPointer.addView(pointerImageView, params);
        }
        if (mPointer != null && mPointer.getChildAt(0) != null) {
            ImageView childAt = (ImageView) mPointer.getChildAt(0);
            childAt.setImageResource(R.drawable.banner_dot_selected);
        }
    }

    private void setAdapterData() {
        mMyViewPagerAdapter.setUrl(mPicUrl);
        mMyViewPagerAdapter.setRecommend(mRecommend);
        mMyViewPagerAdapter.notifyDataSetChanged();
    }

    private void setBannerLeftLoop() {
        int diff = 200 % mPicUrl.size(); //偏差
        int index = 200 - diff;
        mBannerVp.setCurrentItem(index);
        mMyViewPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index_layout, container, false);
        initController();
        initView(view);
        initData();
        return view;
    }

    private void initController() {
        mController = new HomeController(getContext());
        mController.setListerent(this);
    }

    private void initView(View view) {
        mBannerVp = (ViewPager) view.findViewById(R.id.vp);
        mDropZoomScrollView = (DropZoomScrollView) view.findViewById(R.id.sv);
        mPointer = (LinearLayout) view.findViewById(R.id.banner_pointer_ll);

        mMyViewPagerAdapter = new BannerViewPagerAdapter(getActivity(), mDropZoomScrollView);
        mBannerVp.setAdapter(mMyViewPagerAdapter);
        mBannerVp.addOnPageChangeListener(this);
        

        view.findViewById(R.id.home_category).setOnClickListener(this);
        view.findViewById(R.id.home_video).setOnClickListener(this);
        view.findViewById(R.id.home_live).setOnClickListener(this);
        view.findViewById(R.id.home_mall).setOnClickListener(this);

        //头条
        mHeadlineLv = (ListView) view.findViewById(R.id.home_headline_lv);
        mHomeHeadlineAdapter = new HomeHeadlineAdapter();
        mHeadlineLv.setAdapter(mHomeHeadlineAdapter);
        mHeadlineLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < 2){
                    int code = mNous.get(position).getCode();
                    Intent intent = new Intent(getActivity(), HomeHeadlineItemActivity.class);
                    intent.putExtra(HomeHeadlineItemActivity.CODE, code);
                    startActivity(intent);
                }else{
                    Toast.makeText(getContext(), "广告", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //人气推荐
        mPopularityRv = (RecyclerView) view.findViewById(R.id.home_popularity_rv);
        mPopularityAdapter = new HomePopularityAdapter(getContext());
        LinearLayoutManager ms = new LinearLayoutManager(getContext());
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);
        mPopularityRv.setLayoutManager(ms);
        mPopularityRv.setAdapter(mPopularityAdapter);

        //最佳
        mOptimumIv = (ImageView) view.findViewById(R.id.home_optimum_iv);
        mOptimumTitleTv = (TextView) view.findViewById(R.id.home_optimum_title_tv);
        mOptimumContentRl = (TextView) view.findViewById(R.id.home_optimum__content_tv);


        mHomeOptimumRv = (RecyclerView) view.findViewById(R.id.home_optimum_rv);
        mHomeOptimumAdapter = new HomeOptimumAdapter();
        LinearLayoutManager homeOptimumRvManager = new LinearLayoutManager(getContext());
        mHomeOptimumRv.setLayoutManager(homeOptimumRvManager);
        /**
         * 解决ScrollView嵌套recycleView滑动延迟
         * setHasFixedSize(true)
         * setNestedScrollingEnabled(false)
         */
        mHomeOptimumRv.setHasFixedSize(true);
        mHomeOptimumRv.setNestedScrollingEnabled(false);
        mHomeOptimumAdapter.setLoadMoreView(new HomeOptimumLoadItemView());
        mHomeOptimumRv.setAdapter(mHomeOptimumAdapter);


/*        mHomeOptimumAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mHomeOptimumRv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.v("lai", "run: ");
                    }
                }, 0);
            }
        }, mHomeOptimumRv);*/
    }

    private void initData() {
        mController.sendAsynchronization(INetWorkAction.HOME_ACTION);
        mController.sendAsynchronization(INetWorkAction.HOME_OPTIMUM);
    }


    //ViewPager的监听器
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        position = position % mPicUrl.size();
        for (int i = 0; i < mPointer.getChildCount(); i++) {
            ImageView childAt = (ImageView) mPointer.getChildAt(i);
            childAt.setImageResource(i == position ? R.drawable.banner_dot_selected : R.drawable.banner_dot);

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //分类模块的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_category:
                Intent categoryIntent = new Intent(getContext(), HoMemodule2CategoryActivity.class);
                startActivity(categoryIntent);
                break;
            case R.id.home_video:
                Toast.makeText(getActivity(), "视频", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_live:
                Toast.makeText(getActivity(), "美食养生", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_mall:
                Toast.makeText(getActivity(), "商城", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
