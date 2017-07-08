package com.a520it.xianghacaipu.fragmnt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.FindFraSmartTabViewPagerAdapter;
import com.a520it.xianghacaipu.fragmnt.find.DiscoveryFragment;
import com.a520it.xianghacaipu.fragmnt.find.NewestFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ASUS on 2017/6/15.
 */
public class FindFragment extends  BaseFragment{

    private SmartTabLayout mSmarttablayout;
    private ViewPager mViewPager;
    private FindFraSmartTabViewPagerAdapter mTabVpAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_layout, container, false);
        mSmarttablayout = (SmartTabLayout) view.findViewById(R.id.find_frag_smarttablayout);
        mViewPager = (ViewPager) view.findViewById(R.id.find_frag_viewpager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        setSmartTab();
    }

    private void setSmartTab() {
        String[] stringArray = getResources().getStringArray(R.array.find_titles);
        List<String> strings = Arrays.asList(stringArray);
        ArrayList<String> titleArr = new ArrayList<>(strings);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new DiscoveryFragment());
        fragments.add(new NewestFragment());

        mTabVpAdapter = new FindFraSmartTabViewPagerAdapter(getFragmentManager(), fragments, titleArr);
        mViewPager.setAdapter(mTabVpAdapter);
        mSmarttablayout.setViewPager(mViewPager);

    }

    private void initData() {

    }


}
