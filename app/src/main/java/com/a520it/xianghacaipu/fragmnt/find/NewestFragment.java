package com.a520it.xianghacaipu.fragmnt.find;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a520it.xianghacaipu.fragmnt.BaseFragment;

/**
 * Created by simon on 2017/6/16.
 */

public class NewestFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText(getClass().getSimpleName());
        textView.setGravity(Gravity.CENTER);

        return textView;
    }
}
