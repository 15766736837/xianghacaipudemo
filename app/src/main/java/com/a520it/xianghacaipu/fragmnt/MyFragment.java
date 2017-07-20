package com.a520it.xianghacaipu.fragmnt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.activity.CollectActivity;
import com.a520it.xianghacaipu.activity.CollectssActivity;
import com.a520it.xianghacaipu.activity.ConcernActivity;
import com.a520it.xianghacaipu.activity.FoodCardActivity;
import com.a520it.xianghacaipu.activity.IntegrateActivity;
import com.a520it.xianghacaipu.activity.LoginActivity;
import com.a520it.xianghacaipu.activity.MyIndentActivity;
import com.a520it.xianghacaipu.activity.SettingActivity;
import com.a520it.xianghacaipu.activity.VIPActivity;
import com.a520it.xianghacaipu.activity.WalletActivity;
import com.a520it.xianghacaipu.listerent.ILoginChangListerent;
import com.a520it.xianghacaipu.utils.SpUtils;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ASUS on 2017/6/15.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener ,ILoginChangListerent{

    private CircleImageView mFragmentPhoto;
    private TextView mFragmentNameTv;
    private TextView mFragmentLoginRl;
    private TextView mFragmentFoodTv;
    private TextView mFragmentMenuTv;
    private TextView mFragmentConcernTv;
    private static  int RESULT = 0;    //登录的返回
    private boolean mLonginSate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_layout, container, false);
        initView(view);
        initData();
        return view;
    }

    //设置数据
    private void initData() {
        mLonginSate = SpUtils.getBoolean(getContext(), SpUtils.AD_LOGINSTATR);
        if (mLonginSate){
            //获取到用户名
            String userName = SpUtils.getString(getContext(), SpUtils.AD_USERNAME);
            mFragmentNameTv.setText(userName);
            mFragmentNameTv.setVisibility(View.VISIBLE);
            mFragmentPhoto.setImageResource(R.drawable.userphoto);
            mFragmentLoginRl.setVisibility(View.INVISIBLE);
        }else {
            //设置未登录
            mFragmentNameTv.setVisibility(View.INVISIBLE);
            mFragmentLoginRl.setVisibility(View.VISIBLE);
            mFragmentPhoto.setImageResource(R.drawable.a_login_personaldata_name);
        }
    }

    private void initView(View view) {
        mFragmentPhoto = (CircleImageView)view.findViewById(R.id.fragment_photo);
        mFragmentNameTv = (TextView) view.findViewById(R.id.fragment_name_tv);
        mFragmentLoginRl = (TextView)view. findViewById(R.id.fragment_login__rl);
        mFragmentLoginRl.setOnClickListener(this);
        mFragmentFoodTv = (TextView) view.findViewById(R.id.fragment_food__tv);
        mFragmentMenuTv = (TextView) view.findViewById(R.id.fragment_menu__tv);
        mFragmentConcernTv = (TextView) view.findViewById(R.id.fragment_concern__tv);
        view. findViewById(R.id.fragment_collect_rl).setOnClickListener(this);
        view. findViewById(R.id.fragment_history__rl).setOnClickListener(this);
         view. findViewById(R.id.fragment_collectss__rl).setOnClickListener(this);
        view. findViewById(R.id.fragment_indent__rl).setOnClickListener(this);
        view.findViewById(R.id.fragment_vip__rl).setOnClickListener(this);
        view. findViewById(R.id.fragment_wallet__rl).setOnClickListener(this);
         view. findViewById(R.id.fragment_integrate__rl).setOnClickListener(this);
         view.findViewById(R.id.fragment_setting__rl).setOnClickListener(this);
         view.findViewById(R.id.fragment_food_rl).setOnClickListener(this);
         view.findViewById(R.id.fragment_menu_rl).setOnClickListener(this);
         view.findViewById(R.id.fragment_cocern_rl).setOnClickListener(this);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_collect_rl:   //我的收藏
                //判断是否登录
                if (mLonginSate){
                    Intent intent = new Intent(getActivity(), CollectActivity.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }else {
                    //跳转到登录界面
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }
                break;
            case R.id.fragment_history__rl:  //浏览历史
                Toast.makeText(getActivity(), "浏览历史", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fragment_food_rl:  //美食帖
                //判断是否登录
                if (mLonginSate){
                    Intent intent = new Intent(getActivity(), FoodCardActivity.class);
                    intent.putExtra(FoodCardActivity.FROM_ACION,0);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }else {
                    //跳转到登录界面
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }
                break;
            case R.id.fragment_collectss__rl:  //本地下载
                Intent intents = new Intent(getActivity(), CollectssActivity.class);
                startActivity(intents);
                getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);

                break;
            case R.id.fragment_menu_rl:  //菜谱
                //判断是否登录
                if (mLonginSate){
                    Intent intent = new Intent(getActivity(), FoodCardActivity.class);
                    intent.putExtra(FoodCardActivity.FROM_ACION,1);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }else {
                    //跳转到登录界面
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }
                break;
            case R.id.fragment_cocern_rl:  //关注
                //判断是否登录
                if (mLonginSate){
                    Intent intent = new Intent(getActivity(), ConcernActivity.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }else {
                    //跳转到登录界面
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }
                break;
            case R.id.fragment_indent__rl:  //我的订单
                //判断是否登录
                if (mLonginSate){
                    Intent intent = new Intent(getActivity(), MyIndentActivity.class);
                    startActivity(intent);

                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }else {
                    //跳转到登录界面
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }
                break;
            case R.id.fragment_vip__rl:     //我的会员
                //判断是否登录
                if (mLonginSate){
                    Intent intent = new Intent(getActivity(), VIPActivity.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }else {
                    //跳转到登录界面
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }

                break;
            case R.id.fragment_wallet__rl:      //我的钱包
                //判断是否登录
                if (mLonginSate){
                    Intent intent = new Intent(getActivity(), WalletActivity.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }else {
                    //跳转到登录界面
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }

                break;
            case R.id.fragment_integrate__rl:  //我的积分
                //判断是否登录
                if (mLonginSate){
                    Intent intent = new Intent(getActivity(), IntegrateActivity.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }else {
                    //跳转到登录界面
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                }

                break;
            case R.id.fragment_setting__rl:     //系统设置
                startActivity(new Intent(getActivity(), SettingActivity.class));
                getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                break;
            case R.id.fragment_login__rl:       //登录
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);

                break;
        }
    }


    @Override
    public void IModechange() {

    }

    @Override
    public void onResume() {
        initData();
        super.onResume();
    }
}
