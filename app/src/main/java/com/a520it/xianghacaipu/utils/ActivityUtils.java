package com.a520it.xianghacaipu.utils;

import android.app.Activity;

import com.a520it.xianghacaipu.R;

/**
 * Created by ASUS on 2017/7/3.
 */

public class ActivityUtils {

    //退出界面动画
    public  static  void  finshActivity(Activity context){
        context.finish();
        context.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);

    }

    //跳转界面动画
    public  static  void  statrActivity(Activity context){
        context.overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
    }

}
