package com.a520it.xianghacaipu.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by simon on 2017/6/18.
 */

public class FindItemDisDecoration extends RecyclerView.ItemDecoration {

    private final Context mContext;
    private final int mDividerHeight;

    public FindItemDisDecoration(Context context, int dividerHeight) {
        this.mContext =context;
        mDividerHeight = dividerHeight;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = mDividerHeight;
    }
}
