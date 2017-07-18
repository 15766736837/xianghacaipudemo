package com.a520it.xianghacaipu.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.a520it.xianghacaipu.R;

/**
 * Created by ASUS on 2017/7/11.
 */

public class MyIndentAllAdapter extends BaseAdapter {


    @Override
    public int getCount() {
        return 1;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_myindent_all_layout, null);

        return inflate;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
