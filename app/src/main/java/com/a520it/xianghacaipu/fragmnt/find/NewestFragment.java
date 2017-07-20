package com.a520it.xianghacaipu.fragmnt.find;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.activity.find.FindItemDetailActivity;
import com.a520it.xianghacaipu.adapter.NewsRecyclerAdapter;
import com.a520it.xianghacaipu.bean.disbean.NewestBean;
import com.a520it.xianghacaipu.constant.ActionCon;
import com.a520it.xianghacaipu.controller.FindController;
import com.a520it.xianghacaipu.fragmnt.BaseFragment;
import com.a520it.xianghacaipu.view.FindItemDisDecoration;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;

import java.util.List;

import static com.a520it.xianghacaipu.R.color.c_title_text_color;


/**
 * Created by simon on 2017/6/16.
 */

public class NewestFragment extends BaseFragment {

    private LuRecyclerView mDiscoveryRv;
    private SwipeRefreshLayout mSwipeRefresh;
    private FindController mFindController;
    private NewsRecyclerAdapter mNewRecyclerAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private FindItemDisDecoration mDisDecoration;
    private LuRecyclerViewAdapter mLRecyclerViewAdapter;

    @Override
    protected void handleUI(Message msg) {
        switch (msg.what) {
            case ActionCon.NEWDETAILDATA :
                showList(msg.obj);
                break;
            case ActionCon.NEWADDDETAILDATA:
                addListDatas(msg.obj);
                break;
        }
    }

    private void addListDatas(Object obj) {
        NewestBean bean = (NewestBean) obj;
        List<NewestBean.DataBeanX.DataBean> addData = bean.getData().getData();
        mNewRecyclerAdapter.loadMore(addData);
        mDiscoveryRv.refreshComplete(10);
        mLRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void showList(Object obj) {
        NewestBean bean = (NewestBean) obj;
        final List<NewestBean.DataBeanX.DataBean> data = bean.getData().getData();

        mNewRecyclerAdapter = new NewsRecyclerAdapter(getContext(), data);
        mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mDiscoveryRv.setLayoutManager(mLinearLayoutManager);
        if (mDisDecoration == null) {
            mDisDecoration = new FindItemDisDecoration(getContext(), 10);
            mDiscoveryRv.addItemDecoration(mDisDecoration);
        }

        mLRecyclerViewAdapter = new LuRecyclerViewAdapter(mNewRecyclerAdapter);

        mDiscoveryRv.setAdapter(mLRecyclerViewAdapter);

        //设置底部加载文字提示
        mDiscoveryRv.setFooterViewHint("香哈努力加载……", "已经全部为你呈现了", "网络不给力啊，点击再试一次吧");
        mDiscoveryRv.setFooterViewColor(R.color.c_title_text_color,R.color.c_title_text_color,R.color.transparent);

        mNewRecyclerAdapter.setOnItemClickListener(new NewsRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                NewestBean.DataBeanX.DataBean dataBean = data.get(position);
                int code = dataBean.getCode();
                Intent intent = new Intent(getActivity(), FindItemDetailActivity.class);
                intent.putExtra("codeId",code);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.find_fra_newest_layout, null);
        mDiscoveryRv = (LuRecyclerView) view.findViewById(R.id.find_fra_rv);
        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.find_fra_swipe_refresh);
        mSwipeRefresh.setColorSchemeColors(getResources().getColor(c_title_text_color));
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
            mFindController.sendAsynchronization(ActionCon.NEWDETAILDATA);
        } else {
            //接口没有搞清楚,用重复接口
            mFindController.sendAsynchronization(ActionCon.NEWADDDETAILDATA);
        }
    }

    private void initController() {
        mFindController = new FindController(getContext());
        mFindController.setListerent(this);
    }
}
