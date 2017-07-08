package com.a520it.xianghacaipu.fragmnt.collect;

import android.view.View;

import com.a520it.xianghacaipu.R;

/**
 * Created by ASUS on 2017/7/3.
 */

public class CollectTopLineFragment  extends RefreshBaseFragment{

    @Override
    protected void refreshLoadData() {
      //  Toast.makeText(getContext(), "头条", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View createView() {
        View inflate = View.inflate(getContext(), R.layout.fragment_collect_toopline_layout, null);
        return inflate;
    }
}
