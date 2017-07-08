package com.a520it.xianghacaipu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.a520it.xianghacaipu.fragmnt.BaseFragment;
import com.a520it.xianghacaipu.fragmnt.collect.CollectConcernFragment;
import com.a520it.xianghacaipu.fragmnt.collect.CollectFoodFragment;
import com.a520it.xianghacaipu.fragmnt.collect.CollectTopLineFragment;

import java.util.ArrayList;

/**
 * Created by ASUS on 2017/7/3.
 */

public class CollectAdapter extends FragmentPagerAdapter {


    private ArrayList<BaseFragment> mFragments=new ArrayList();

    //创建对象
    public CollectAdapter(FragmentManager fm) {
        super(fm);
        mFragments.add(new CollectFoodFragment());
        mFragments.add(new CollectConcernFragment());
        mFragments.add(new CollectTopLineFragment());

    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

}
