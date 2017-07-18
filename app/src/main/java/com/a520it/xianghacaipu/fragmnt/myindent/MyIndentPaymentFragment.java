package com.a520it.xianghacaipu.fragmnt.myindent;

import android.view.View;
import android.widget.ListView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.MyIndentAllAdapter;
import com.a520it.xianghacaipu.fragmnt.collect.RefreshBaseFragment;

/**
 * Created by ASUS on 2017/7/7.
 */

public class MyIndentPaymentFragment extends RefreshBaseFragment {
    private View mInflate;
    private ListView mLv;
    @Override
    protected void refreshLoadData() {

    }

    @Override
    public View createView() {
        mInflate = View.inflate(getContext(), R.layout.fragment_myindentall_layout, null);
        mLv = (ListView) mInflate.findViewById(R.id.fragment_myindent_lv);
        MyIndentAllAdapter myIndentAllAdapter = new MyIndentAllAdapter();
        mLv.setAdapter(myIndentAllAdapter);
        return mInflate;
    }
}
