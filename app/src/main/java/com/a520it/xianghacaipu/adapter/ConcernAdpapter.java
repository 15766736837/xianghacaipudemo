package com.a520it.xianghacaipu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.a520it.xianghacaipu.fragmnt.BaseFragment;
import com.a520it.xianghacaipu.fragmnt.concern.ConcernFragment;
import com.a520it.xianghacaipu.fragmnt.concern.FonsFragmnt;

import java.util.ArrayList;

/**
 * Created by ASUS on 2017/6/29.
 */

public class ConcernAdpapter extends FragmentPagerAdapter{
    //创建几个储存
    ArrayList<BaseFragment> list =  new ArrayList<>();

    public ConcernAdpapter(FragmentManager fm) {

        super(fm);
        //创建时添加到几个
        list.add(new FonsFragmnt());
        list.add(new ConcernFragment());

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
