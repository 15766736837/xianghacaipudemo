package com.a520it.xianghacaipu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.fragmnt.BaseFragment;
import com.a520it.xianghacaipu.fragmnt.FindFragment;
import com.a520it.xianghacaipu.fragmnt.IndexFragment;
import com.a520it.xianghacaipu.fragmnt.MyFragment;
import com.a520it.xianghacaipu.fragmnt.XiaoXiFragment;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private FrameLayout mMainFl;
    private ImageView mMainIndexLlIv;
    private TextView mMainIndexLlTv;
    private LinearLayout mMainIndexLl;
    private ImageView mMainFindLlIv;
    private TextView mMainFindLlTv;
    private LinearLayout mMainFindLl;
    private ImageView mMainUploadTv;
    private ImageView mMainXiaoxiLlIv;
    private TextView mMainXiaoxiLlTv;
    private LinearLayout mMainXiaoxiLl;
    private ImageView mMainMyLlIv;
    private TextView mMainMyLlTv;
    private LinearLayout mMainMyLl;
    private LinearLayout mActivityMain;
    private ArrayList<BaseFragment> mMFragments;
    public  static  final  String  FOOD_ID = "food_id";
    public  static  final  String  CONCERN_ID = "food_id";

    /****************                 */
    private LocationClient mLocationClient;
    public BDLocationListener myListener = new MyLocationListener();
    public String now_address ;


    /****************                 */
    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            Log.i("mylog","--->" +location.getAddrStr());
            now_address = location.getAddrStr();
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }

    }
    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备

        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系

        int span=1000;
        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的

        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要

        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        mLocationClient.setLocOption(option);
    }
    /****************                 */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_main);

        /****************                 */
        mLocationClient = new LocationClient(getApplicationContext());
        //        声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        //        注册监听函数
        initLocation();
        mLocationClient.start();
        /****************                 */

        initView();
        initFragment();
        mMainIndexLl.performClick();


    }
    //初始化
    private void initFragment() {
        //创建队列储存
        mMFragments = new ArrayList<>();
        mMFragments.add(new IndexFragment());
        mMFragments.add(new FindFragment());
        mMFragments.add(new XiaoXiFragment());
        mMFragments.add(new MyFragment());
    }



    //fragment切换显示
    private void changeFragment(BaseFragment baseFragment) {
        //开启一个事物
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (! baseFragment.isAdded()){
            transaction.add(R.id.main_fl,baseFragment);
        }

        transaction.show(baseFragment);

        for (BaseFragment fr : mMFragments) {
            if (fr.equals(baseFragment)) {
                continue;
            }
            transaction.hide(fr);
        }

        //提交事务
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_index_ll:   //学做菜
                changeFragment(mMFragments.get(0));
                setSeect(mMainIndexLlIv,mMainIndexLlTv);
                break;
            case R.id.main_find_ll:    //朋友圈
                setSeect(mMainFindLlIv,mMainFindLlTv);
                changeFragment(mMFragments.get(1));
                break;
            case R.id.main_xiaoxi_ll:   //消息
                setSeect(mMainXiaoxiLlIv,mMainXiaoxiLlTv);
                changeFragment(mMFragments.get(2));
                break;
            case R.id.main_my_ll:       //我的
                setSeect(mMainMyLlIv,mMainMyLlTv);
                changeFragment(mMFragments.get(3));
                break;
            case R.id.main_upload_tv:  //发动态
                Intent intent = new Intent(this,PublishActivity.class);
                intent.putExtra("now_address",now_address);
                startActivity(intent);
                break;
        }
    }

    private  void setSeect(View v, View viewe){
        mMainIndexLlIv.setSelected(v == mMainIndexLlIv || viewe == mMainIndexLlIv );
        mMainIndexLlTv.setSelected(v == mMainIndexLlTv || viewe == mMainIndexLlTv );
        mMainFindLlIv.setSelected(v == mMainFindLlIv || viewe == mMainFindLlIv );
        mMainFindLlTv.setSelected(v == mMainFindLlTv || viewe == mMainFindLlTv );
        mMainXiaoxiLlIv.setSelected(v == mMainXiaoxiLlIv || viewe == mMainXiaoxiLlIv );
        mMainXiaoxiLlTv.setSelected(v == mMainXiaoxiLlTv || viewe == mMainXiaoxiLlTv );
        mMainMyLlIv.setSelected(v == mMainMyLlIv || viewe == mMainMyLlIv );
        mMainMyLlTv.setSelected(v == mMainMyLlTv || viewe == mMainMyLlTv );
    }


    private void initView() {
        mMainFl = (FrameLayout) findViewById(R.id.main_fl);
        mMainIndexLlIv = (ImageView) findViewById(R.id.main_index_ll_iv);
        mMainIndexLlTv = (TextView) findViewById(R.id.main_index_ll_tv);
        mMainIndexLl = (LinearLayout) findViewById(R.id.main_index_ll);
        mMainIndexLl.setOnClickListener(this);

        mMainFindLlIv = (ImageView) findViewById(R.id.main_find_ll_iv);
        mMainFindLlTv = (TextView) findViewById(R.id.main_find_ll_tv);
        mMainFindLl = (LinearLayout) findViewById(R.id.main_find_ll);
        mMainFindLl.setOnClickListener(this);

        mMainUploadTv = (ImageView) findViewById(R.id.main_upload_tv);
        mMainUploadTv.setOnClickListener(this);
        mMainXiaoxiLlIv = (ImageView) findViewById(R.id.main_xiaoxi_ll_iv);
        mMainXiaoxiLlTv = (TextView) findViewById(R.id.main_xiaoxi_ll_tv);
        mMainXiaoxiLl = (LinearLayout) findViewById(R.id.main_xiaoxi_ll);
        mMainXiaoxiLl.setOnClickListener(this);

        mMainMyLlIv = (ImageView) findViewById(R.id.main_my_ll_iv);
        mMainMyLlTv = (TextView) findViewById(R.id.main_my_ll_tv);
        mMainMyLl = (LinearLayout) findViewById(R.id.main_my_ll);
        mMainMyLl.setOnClickListener(this);

        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
    }
}
