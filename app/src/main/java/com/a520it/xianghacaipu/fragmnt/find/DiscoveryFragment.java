package com.a520it.xianghacaipu.fragmnt.find;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.RecyclerAdapter;
import com.a520it.xianghacaipu.bean.FindListBean;
import com.a520it.xianghacaipu.constant.ActionCon;
import com.a520it.xianghacaipu.controller.FindController;
import com.a520it.xianghacaipu.fragmnt.BaseFragment;
import com.a520it.xianghacaipu.view.DisDecoration;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;

import java.util.List;


/**
 * Created by simon on 2017/6/16.
 */

public class DiscoveryFragment extends BaseFragment {

    private LuRecyclerView mDiscoveryRv;
    private FindController mFindController;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapter mRecyclerAdapter;
    private ListView mDiscoveryLv;
    private DisDecoration mDisDecoration;
    private SwipeRefreshLayout mSwipeRefresh;
    private LuRecyclerViewAdapter mLRecyclerViewAdapter;


    @Override
    protected void handleUI(Message msg) {
        switch (msg.what) {
            case ActionCon.FINDLISTDATA:
                showList(msg.obj);
                break;
            case ActionCon.FINDADDLISTDATA:
                addListDatas(msg.obj);
                break;
        }
    }

    private void addListDatas(Object obj) {
        FindListBean bean = (FindListBean) obj;
        List<FindListBean.DataBeanX.DataBean> addData = bean.getData().getData();
        mRecyclerAdapter.loadMore(addData);
        mDiscoveryRv.refreshComplete(10);
        mLRecyclerViewAdapter.notifyDataSetChanged();

    }

    private void showList(Object obj) {
        FindListBean bean = (FindListBean) obj;
        List<FindListBean.DataBeanX.DataBean> data = bean.getData().getData();

        mRecyclerAdapter = new RecyclerAdapter(getContext(), data);
        mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mDiscoveryRv.setLayoutManager(mLinearLayoutManager);
        if (mDisDecoration == null) {
            mDisDecoration = new DisDecoration(getContext(), 13);
            mDiscoveryRv.addItemDecoration(mDisDecoration);
        }

        mLRecyclerViewAdapter = new LuRecyclerViewAdapter(mRecyclerAdapter);

        mDiscoveryRv.setAdapter(mLRecyclerViewAdapter);

        //设置底部加载文字提示
        mDiscoveryRv.setFooterViewHint("拼命加载中", "已经全部为你呈现了", "网络不给力啊，点击再试一次吧");


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_fra_discovery_layout, null);
        mDiscoveryRv = (LuRecyclerView) view.findViewById(R.id.find_fra_rv);
        mDiscoveryLv = (ListView) view.findViewById(R.id.find_fra_lv);

        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.find_fra_swipe_refresh);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initController();
        requestListDatas(true);
        refresh();
        if (mDiscoveryRv != null) {
            loadMore();
        }

    }

    private void loadMore() {
        mDiscoveryRv.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                requestListDatas(false);

            }
        });

    }


    private void refresh() {
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestListDatas(true);
                mSwipeRefresh.setRefreshing(false);
            }
        });
    }


    private void requestListDatas(boolean isFirstRequest) {
        String url = "";

        if (isFirstRequest) {
            mFindController.sendAsynchronization(ActionCon.FINDLISTDATA);
        } else {
            //接口没有搞清楚,用重复接口
            mFindController.sendAsynchronization(ActionCon.FINDADDLISTDATA);
        }
    }

    private void initController() {
        mFindController = new FindController(getContext());
        mFindController.setListerent(this);
    }

}
