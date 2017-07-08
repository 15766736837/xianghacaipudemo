package com.a520it.xianghacaipu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.FoodCardMSPAdapter;
import com.a520it.xianghacaipu.bean.FoodCardMSPBean;
import com.a520it.xianghacaipu.bean.FoodCardUserInfoBean;
import com.a520it.xianghacaipu.controller.FoodCardController;
import com.a520it.xianghacaipu.view.ListViewForScrollView;
import com.a520it.xianghacaipu.view.PtrClassicHeader;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

import static com.a520it.xianghacaipu.constant.NetController.FOOD_MSP_ACION;
import static com.a520it.xianghacaipu.constant.NetController.FOOD_USERIMFO_ACION;


//美食帖
public class FoodCardActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mFoodReturnIv;
    private ImageView mFoodMoreIv;
    private CircleImageView mFoodUserphoto;
    private TextView mFoodUsernameTv;
    private TextView mFoodUserinfoTv;
    private TextView mFoodUsertimeTv;
    private Button mFoodUserinfosBt;
    private TextView mFoodFoodCarNameTv;
    private TextView mFoodFoodCarCountTv;
    private LinearLayout mFoodFoodCarTv;
    private TextView mFoodCpTvName;
    private TextView mFoodCpTvCount;
    private LinearLayout mFoodCpTv;
    private RelativeLayout mFoodNullRl;
    private ListViewForScrollView mFoodLv;
    private PtrFrameLayout mFoodRefreshLayout;
    private FoodCardController mFoodCardController;
    private FoodCardMSPAdapter mFoodCardMSPAdapter;
    private Button mEndButton;
    private ImageView mEmdIv;
    public  static  final  String FROM_ACION  = "from_acion";  //判断从哪个界面进来
    private int mFormAcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_card);
        initData();
        initView();
        initController();
        requestUserInfoData();
        requestMSP(); //请求美食谱数据

    }
    //获取传递的数据
       private void initData() {
           Intent intent = getIntent();
           mFormAcion = intent.getIntExtra(FROM_ACION, 0);
       }

    //请求美食谱数据
    private void requestMSP() {
        mFoodCardController.sendAsynchronization(FOOD_MSP_ACION);
    }


    @Override
    protected void handUI(Message msg) {
        switch (msg.what){
            case FOOD_USERIMFO_ACION:
              String jsonStr = (String) msg.obj;
                FoodCardUserInfoBean foodCardUserInfoBean = JSON.parseObject(jsonStr, FoodCardUserInfoBean.class);
                changeUI(foodCardUserInfoBean.getData());
                break;
            case FOOD_MSP_ACION:
             String MSPjsonStr = (String) msg.obj;
                FoodCardMSPBean foodCardMSPBean = JSON.parseObject(MSPjsonStr, FoodCardMSPBean.class);
                setListData(foodCardMSPBean.getData());
                break;
        }
    }

    //设置数据
    private void setListData(FoodCardMSPBean.DataBeanX data) {
        //美食谱的数据
        List<FoodCardMSPBean.DataBeanX.DataBean> dataBeen = data.getData();
        //设置数据
        mFoodCardMSPAdapter.setData((ArrayList<FoodCardMSPBean.DataBeanX.DataBean>) dataBeen);

        //刷新数据
        mFoodCardMSPAdapter.notifyDataSetChanged();
    }

    //改变用户信息
    private void changeUI(FoodCardUserInfoBean.DataBean data) {
        FoodCardUserInfoBean.DataBean.UserinfoBean userinfo = data.getUserinfo();
       mFoodUsernameTv.setText(userinfo.getNickName());
        mFoodUserinfoTv.setText(userinfo.getDishCount() + "粉丝" + " · " + userinfo.getIsGourmet()+"赞"
                + " · " + userinfo.getFanNum()+ "人气");
        mFoodUsertimeTv.setText(userinfo.getInTime() + "加入");

    }

    //请求用户数据
    private void requestUserInfoData() {
        mFoodCardController.sendAsynchronization(FOOD_USERIMFO_ACION);
    }

    //初始化网络请求管理
    private void initController() {
        mFoodCardController = new FoodCardController(this);
        mFoodCardController.setListerent(this);
    }


    private void initView() {
        mFoodReturnIv = (ImageView) findViewById(R.id.food_return_iv);
        mFoodReturnIv  .setOnClickListener(this);
        mFoodMoreIv = (ImageView) findViewById(R.id.food_more_iv);
        mFoodMoreIv  .setOnClickListener(this);
        //用户信息
        mFoodUserphoto = (CircleImageView) findViewById(R.id.food_userphoto);
        mFoodUsernameTv = (TextView) findViewById(R.id.food_username_tv);
        mFoodUserinfoTv = (TextView) findViewById(R.id.food_userinfo_tv);
        mFoodUsertimeTv = (TextView) findViewById(R.id.food_usertime_tv);
        mFoodUserinfosBt = (Button) findViewById(R.id.food_userinfos_bt);
        mFoodUserinfosBt.setOnClickListener(this);
        //美食帖
        mFoodFoodCarNameTv = (TextView) findViewById(R.id.food_food_car_name_tv);
        mFoodFoodCarCountTv = (TextView) findViewById(R.id.food_food_car_count_tv);
        mFoodFoodCarTv = (LinearLayout) findViewById(R.id.food_food_car_tv);
        mFoodFoodCarTv.setOnClickListener(this);
        //菜谱
        mFoodCpTvName = (TextView) findViewById(R.id.food_cp_tv_name);
        mFoodCpTvCount = (TextView) findViewById(R.id.food_cp_tv_count);
        mFoodCpTv = (LinearLayout) findViewById(R.id.food_cp_tv);
        mFoodCpTv.setOnClickListener(this);

        //添加一个尾布局
        View endLayout = View.inflate(getApplicationContext(), R.layout.item_food_end_layout, null);
        mEndButton = (Button) endLayout.findViewById(R.id.food_end_bt);
        mEmdIv = (ImageView) endLayout.findViewById(R.id.food_end_iv);
        mEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEndButton.setVisibility(View.GONE);
                mEmdIv.setVisibility(View.VISIBLE);
            }
        });

        //内容
        mFoodNullRl = (RelativeLayout) findViewById(R.id.food_null_rl);
        mFoodLv = (ListViewForScrollView) findViewById(R.id.food_lv);
        mFoodLv.addFooterView(endLayout);
        mFoodCardMSPAdapter = new FoodCardMSPAdapter();
        Log.i("TAG","----");
        mFoodLv.setAdapter(mFoodCardMSPAdapter);
        Log.i("TAG","----");


        //下拉刷新
        mFoodRefreshLayout = (PtrFrameLayout) findViewById(R.id.food_refreshLayout);
        PtrClassicHeader header = new PtrClassicHeader(this);
        mFoodRefreshLayout.addPtrUIHandler(header);

        mFoodRefreshLayout.setHeaderView(header);
        mFoodRefreshLayout.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                mFoodCardMSPAdapter.mData = null;
                mFoodCardMSPAdapter.notifyDataSetChanged();
                requestMSP();
                mFoodRefreshLayout.refreshComplete();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                // 默认实现，根据实际情况做改动
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });

        //根据传递的值默认点击一次
        if (mFormAcion == 0){
            mFoodFoodCarTv.performClick();
        }else {
            mFoodCpTv.performClick();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.food_userinfos_bt:  //个人信息
                startActivity(new Intent(this,UserInfoActivity.class));
                this.overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                break;
            case R.id.food_return_iv:  //退出
                finish();
                this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
                break;
            case R.id.food_more_iv:  //更多

                break;
            case R.id.food_food_car_tv:  //美食帖
                //设置字体颜色
                mFoodFoodCarNameTv.setSelected(true);
                mFoodFoodCarCountTv.setSelected(true);
                mFoodCpTvName.setSelected(false);
                mFoodCpTvCount.setSelected(false);
//                if (mFoodLv != null){
//                    FixedViewUtil.setListViewHeightBasedOnChildren(mFoodLv);
//                }
                mFoodNullRl.setVisibility(View.GONE);
                mFoodLv.setVisibility(View.VISIBLE);
                break;
            case R.id.food_cp_tv:  //菜谱
                Log.i("TAG","-----?");
                //设置字体颜色
                mFoodFoodCarNameTv.setSelected(false);
                mFoodFoodCarCountTv.setSelected(false);
                mFoodCpTvName.setSelected(true);
                mFoodCpTvCount.setSelected(true);
                mFoodLv.setVisibility(View.GONE);
                mFoodNullRl.setVisibility(View.VISIBLE);
                break;

        }
    }

    @Override
    public void onBackPressed() {
        finish();
        this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
    }


}
