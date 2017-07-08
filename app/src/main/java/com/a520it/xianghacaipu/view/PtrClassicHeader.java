package com.a520it.xianghacaipu.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.a520it.xianghacaipu.R;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by ASUS on 2017/6/21.
 */

public class PtrClassicHeader extends FrameLayout  implements PtrUIHandler{


    private ImageView mPush;

    public PtrClassicHeader(Context context) {
        super(context);
        initView();
    }

    public PtrClassicHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public PtrClassicHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    //初始化自定义布局文件
    private void initView() {
        View header = LayoutInflater.from(getContext()).inflate(R.layout.item_push_header_layout, this);
        mPush = (ImageView) header.findViewById(R.id.header_iv);
    }


   public void  initAnim(){
       ObjectAnimator anim = ObjectAnimator.ofFloat(mPush, "rotation", 0f, 180f);
       anim.setDuration(500);
       anim.start();

   }

    @Override
    public void onUIReset(PtrFrameLayout frame) {

    }

    //刷新的初始界面
    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
            initAnim();


    }

    //刷新过程时调用
    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {

    }

    //刷新完成后调用,向上移动时调用
    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {

    }

    //重复下拉
    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {





}
}
