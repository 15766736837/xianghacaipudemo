package com.a520it.xianghacaipu.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;

/**
 * Created by Lai on 2017/6/30.
 */

public class HomeCategoryView extends LinearLayout{

    private ImageView mIv;
    private TextView mTv;

    public HomeCategoryView(Context context) {
        this(context, null);
    }

    public HomeCategoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.VERTICAL);

        View.inflate(context, R.layout.home_category_view, this);
        mIv = (ImageView) findViewById(R.id.home_iv);
        mTv = (TextView) findViewById(R.id.home_tv);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HomeCategoryView);
        initWidget(typedArray);

    }

    private void initWidget(TypedArray typedArray) {
        String textStr = typedArray.getString(R.styleable.HomeCategoryView_text);
        mTv.setText(textStr);

        Drawable drawable = typedArray.getDrawable(R.styleable.HomeCategoryView_src);
        mIv.setImageDrawable(drawable);
    }
}
