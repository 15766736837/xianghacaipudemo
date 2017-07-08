package com.a520it.xianghacaipu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by simon on 2017/6/16.
 */

public class FindFraSmartTabViewPagerAdapter extends FragmentPagerAdapter{

    private final ArrayList<Fragment> fragments;
    private final ArrayList<String> titleArr;

    public FindFraSmartTabViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> titleArr) {
        super(fm);
       this.fragments = fragments;
        this.titleArr = titleArr;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    //设置tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titleArr.get(position);
    }
}
