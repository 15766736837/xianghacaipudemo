package com.a520it.xianghacaipu.fragmnt.myindent;

import android.view.View;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.fragmnt.collect.RefreshBaseFragment;

/**
 * Created by ASUS on 2017/7/7.
 */

public class MyIndentReceivingFragment extends RefreshBaseFragment {
    @Override
    protected void refreshLoadData() {

    }

    @Override
    public View createView() {
        View inflate = View.inflate(getContext(), R.layout.fragment_myindent_null, null);
        return inflate;
    }
}
