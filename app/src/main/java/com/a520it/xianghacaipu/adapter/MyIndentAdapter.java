package com.a520it.xianghacaipu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.a520it.xianghacaipu.fragmnt.BaseFragment;
import com.a520it.xianghacaipu.fragmnt.myindent.MyIndentCompleteFragment;
import com.a520it.xianghacaipu.fragmnt.myindent.MyIndentPaymentFragment;
import com.a520it.xianghacaipu.fragmnt.myindent.MyIndentReceivingFragment;
import com.a520it.xianghacaipu.fragmnt.myindent.MyIndentSendOutFragment;
import com.a520it.xianghacaipu.fragmnt.myindent.MyindentAllFragment;

import java.util.ArrayList;

/**
 * Created by ASUS on 2017/7/7.
 */

public class MyIndentAdapter extends FragmentStatePagerAdapter {
    private String[] mTitleName;
    private ArrayList<BaseFragment> mFragments = new ArrayList<>();

    public MyIndentAdapter(FragmentManager fm) {
        super(fm);
        //导航的标题名字
        mTitleName = new String[]{"全部","待付款","待发货","待收货","已完成"};
        mFragments.add(new MyindentAllFragment());
        mFragments.add(new MyIndentPaymentFragment());
        mFragments.add(new MyIndentSendOutFragment());
        mFragments.add(new MyIndentReceivingFragment());
        mFragments.add(new MyIndentCompleteFragment());
    }

    @Override
    public Fragment getItem(int position) {

        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTitleName != null ? mTitleName.length :0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleName[position];
    }
}
