package com.a520it.xianghacaipu.adapter;

import com.a520it.xianghacaipu.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;


/**
 * Created by ASUS on 2017/7/17.
 */

public class IntegrateAdapter  extends BaseQuickAdapter<String, BaseViewHolder> {


    public IntegrateAdapter() {
        super(R.layout.item_integrate_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.integrate_name_tv, "50元代金券");
    }
}
