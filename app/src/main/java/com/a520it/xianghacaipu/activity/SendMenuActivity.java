package com.a520it.xianghacaipu.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.activity.album.GifSizeFilter;
import com.a520it.xianghacaipu.adapter.AddFuLiaoAdapter;
import com.a520it.xianghacaipu.adapter.AddItemAdapter;
import com.a520it.xianghacaipu.adapter.AddStepsAdapter;
import com.a520it.xianghacaipu.bean.recipe.FuLiaoBean;
import com.a520it.xianghacaipu.bean.recipe.ZhuLiaoBean;
import com.a520it.xianghacaipu.bean.step.StepBean;
import com.a520it.xianghacaipu.listerent.IPhotoListener;
import com.a520it.xianghacaipu.utils.LoadImageUtil;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.filter.Filter;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
public class SendMenuActivity extends BaseActivity implements View.OnClickListener {

    private final int REQUEST_CODE_PHOTO = 102;
    private final int REQUEST_CODE_SENDMENU = 101;
    List<Uri> mSelected; //图片的地址


    private TextView mCloseTv;
    private TextView mAddPhotoTv;
    private RecyclerView mAddZhuliaoLv;
    public TextView mAddZhuliaoTv;
    private RecyclerView mAddFuliaoLv;
    public TextView mAddFuliaoTv;
    private RecyclerView mStepsLv;
    private Button mAddSetpsBtn;
    private CheckBox mAgreedCb;
    private Button mOkBtn;
    private TextView mDeleteTv;
    private TextView mDraftBoxTv;
    private ImageView mShowImg;
    private RelativeLayout mRlShowTv;
    private TextView mLookTv;
    private AddItemAdapter mAddZORFLiaoAdapter;
    private ArrayList<ZhuLiaoBean> mZhuLiao = new ArrayList<>();
    private ArrayList<FuLiaoBean> mFuLiao = new ArrayList<>();
    private AddFuLiaoAdapter mAddFuLiaoAdapter;
    private ArrayList<StepBean> mSteps;
    private AddStepsAdapter mAddStepsAdapter;
    private Bitmap mBitmap ;
    private List<Uri> mUris;
    private ImageView mIv;
    private TextView mTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_menu_layout);
        initView();

    }

    /**
     * 返回按钮
     */
    public void back(View view) {
        finish();
    }

    /**
     * 存草稿按钮
     */
    public void save_draft(View view) {

    }

    private void initView() {
        //顶部提示的标题
        mCloseTv = (TextView) findViewById(R.id.close_tv);
        mLookTv = (TextView) findViewById(R.id.look_tv);
        mRlShowTv = (RelativeLayout) findViewById(R.id.show_title);

        //添加效果图
        mShowImg = (ImageView) findViewById(R.id.show_img);
        mAddPhotoTv = (TextView) findViewById(R.id.add_photo_tv);

        //添加主料
        mAddZhuliaoTv = (TextView) findViewById(R.id.add_zhuliao_tv);
        //设置图片和文字的间距
        mAddZhuliaoTv.setCompoundDrawablePadding(8);
        mAddZhuliaoLv = (RecyclerView) findViewById(R.id.add_zhuliao_rv);
        mAddZhuliaoLv.setLayoutManager(new LinearLayoutManager(this));
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mAddZhuliaoLv.setHasFixedSize(true);
        mAddZORFLiaoAdapter = new AddItemAdapter(mZhuLiao);
        mAddZhuliaoLv.setAdapter(mAddZORFLiaoAdapter);

        //添加辅料
        mAddFuliaoTv = (TextView) findViewById(R.id.add_fuliao_tv);
        //设置图片和文字的间距
        mAddFuliaoTv.setCompoundDrawablePadding(8);
        mAddFuliaoLv = (RecyclerView) findViewById(R.id.add_fuliao_rv);
        mAddFuliaoLv.setLayoutManager(new LinearLayoutManager(this));
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mAddFuliaoLv.setHasFixedSize(true);
        mAddFuLiaoAdapter = new AddFuLiaoAdapter(mFuLiao);
        mAddFuliaoLv.setAdapter(mAddFuLiaoAdapter);


        mSteps = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mSteps.add(new StepBean(i));
        }
        mStepsLv = (RecyclerView) findViewById(R.id.steps_rv);
        mAddStepsAdapter = new AddStepsAdapter(this, mSteps);
        mStepsLv.setLayoutManager(new LinearLayoutManager(this));
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mStepsLv.setHasFixedSize(true);
        //设置增加或删除条目的动画
        mStepsLv.setItemAnimator(new DefaultItemAnimator());
        mStepsLv.setAdapter(mAddStepsAdapter);
        mAddStepsAdapter.setOnIphotoListener(new IPhotoListener() {
            @Override
            public void setOnPhotoListener(View view, int posion) {
                Log.i("mylog", "setOnPhotoListener: 进入方法");
                setImgPhotoListener();
                mIv = (ImageView) view.findViewById(R.id.show_img_item);
                mTv = (TextView) view.findViewById(R.id.text);
                view.findViewById(R.id.add_photo_item).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setImgPhotoListener();
                    }
                });
            }
        });

        // TODO: 2017/7/15 0015
        //添加步骤
        mAddSetpsBtn = (Button) findViewById(R.id.add_setps_btn);
        //选择同意
        mAgreedCb = (CheckBox) findViewById(R.id.agreed_cb);
        //正式发布
        mOkBtn = (Button) findViewById(R.id.ok_btn);
        //删除这个草稿
        mDeleteTv = (TextView) findViewById(R.id.delete_tv);
        //草稿箱
        mDraftBoxTv = (TextView) findViewById(R.id.draft_box_tv);

        mShowImg.setOnClickListener(this);
        mCloseTv.setOnClickListener(this);
        mAddPhotoTv.setOnClickListener(this);
        mAddZhuliaoTv.setOnClickListener(this);
        mAddFuliaoTv.setOnClickListener(this);
        mAddSetpsBtn.setOnClickListener(this);
        mOkBtn.setOnClickListener(this);
        mDeleteTv.setOnClickListener(this);
        mDraftBoxTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_tv:
                mRlShowTv.setVisibility(View.GONE);//设置隐藏掉
                break;
            case R.id.add_photo_tv:
                //添加菜谱效果图
                add_menuImg();
                break;
            case R.id.show_img:
                //再次添加菜谱效果图
                add_menuImg();
                break;
            case R.id.add_zhuliao_tv://点击添加主料
                //向下添加item
                addItem(true);
                break;
            case R.id.add_fuliao_tv://点击添加辅料
                addItem(false);
                break;

            case R.id.add_setps_btn://添加步骤
                mSteps.add(new StepBean(mSteps.size()));
                mAddStepsAdapter.notifyDataSetChanged();
//                mAddStepsAdapter.addData(mSteps.size());
                break;

            case R.id.ok_btn:
                if(mAgreedCb.isChecked()){
                    Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.delete_tv://删除草稿

                break;
            case R.id.draft_box_tv://草稿箱

                break;
        }
    }


    private void addItem(boolean zorf) {
        if (zorf) {//添加默认item
            mZhuLiao.add(new ZhuLiaoBean("", ""));
            mAddZORFLiaoAdapter.notifyDataSetChanged();
        } else {
            mFuLiao.add(new FuLiaoBean("", ""));
            mAddFuLiaoAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SENDMENU && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            Log.d("Matisse", "mSelected: " + mSelected);
            if (mSelected != null) {
                //遍历数组 获取到每个bitmap
                for (int i = 0; i < mSelected.size(); i++) {
                    //将图片展示到EditText中
                    Log.e("mylog", "onActivityResult: ----------" + mSelected.get(i));
                    //调用工具方法 将uri 转换成bitmap
                    Bitmap bitmap = LoadImageUtil.getInstance().getBitmapFromUri(mSelected.get(i), this);
                    //变成指定宽高的缩略图
                    Bitmap bitmap1 = ThumbnailUtils.extractThumbnail(bitmap, 400, 300);
                    //将bitmap设置到 ImageView中
                    setImage(bitmap1);
                }
            }
        } else if (requestCode == REQUEST_CODE_PHOTO && resultCode == RESULT_OK) {
            mUris = Matisse.obtainResult(data);
            Log.d("Matisse", "mSelected: " + mUris);
            if (mUris != null) {
                Log.i("mylog", "onActivityResult: 获取到了图片地址  ");
                //遍历数组 获取到每个bitmap
                for (int i = 0; i < mUris.size(); i++) {
                    //将图片展示到EditText中
                    Log.e("mylog", "onActivityResult: ----------" + mUris.get(i));
                    //调用工具方法 将uri 转换成bitmap
                    Bitmap bitmap = LoadImageUtil.getInstance().getBitmapFromUri(mUris.get(i), this);
                    //变成指定宽高的缩略图
                    mBitmap = ThumbnailUtils.extractThumbnail(bitmap, 100, 100);
                    //将bitmap设置到Adapter ImageView中
                    Log.i("mylog", "setOnPhotoListener: mBitmap  -------->>>>>   "+mBitmap);
                    mIv.setImageBitmap(mBitmap);
                    mIv.setVisibility(View.VISIBLE);
                    mTv.setVisibility(View.GONE);
                }
            }
        }

    }

    private void setImage(Bitmap bitmap) {
        mShowImg.setImageBitmap(bitmap);
        mShowImg.setVisibility(View.VISIBLE);
        mAddPhotoTv.setVisibility(View.GONE);
    }

    private void add_menuImg() {
        Log.i("mylog", "add_menuImg: 加载菜谱效果图---------------");
        Matisse.from(SendMenuActivity.this)
                .choose(MimeType.ofAll(), false)
                .countable(true)
                .capture(true)
                .captureStrategy(
                        new CaptureStrategy(true, "com.zhihu.matisse.sample.fileprovider"))
                .maxSelectable(1)
                .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                .gridExpectedSize(240)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(REQUEST_CODE_SENDMENU);
    }

    public void setImgPhotoListener() {
        Log.i("mylog", "setOnPhotoListener: 点击了添加步骤图片");
        Matisse.from(this)
                .choose(MimeType.ofAll(), false)
                .countable(true)
                .capture(true)
                .captureStrategy(
                        new CaptureStrategy(true, "com.zhihu.matisse.sample.fileprovider"))
                .maxSelectable(1)
                .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                .gridExpectedSize(240)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(REQUEST_CODE_PHOTO);
    }
}
