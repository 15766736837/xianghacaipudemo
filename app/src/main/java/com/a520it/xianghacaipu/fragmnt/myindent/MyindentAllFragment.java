package com.a520it.xianghacaipu.fragmnt.myindent;

import android.view.View;
import android.widget.ListView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.controller.MyIndentController;
import com.a520it.xianghacaipu.fragmnt.collect.RefreshBaseFragment;

/**
 * Created by ASUS on 2017/7/7.
 * 全部订单
 */

public class MyindentAllFragment extends RefreshBaseFragment {


    private View mInflate;
    private ListView mLv;

    @Override
    protected void refreshLoadData() {

    }

    @Override
    public View createView() {
        initController();  //初始化网络请求
        mInflate = View.inflate(getContext(), R.layout.fragment_myindentall_layout, null);
        mLv = (ListView) mInflate.findViewById(R.id.fragment_myindent_lv);

        return mInflate;
    }

    private void initController() {
        new MyIndentController(getActivity());
    }
}
