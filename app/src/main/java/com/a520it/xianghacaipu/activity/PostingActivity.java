package com.a520it.xianghacaipu.activity;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.activity.album.GifSizeFilter;
import com.a520it.xianghacaipu.utils.LoadImageUtil;
import com.a520it.xianghacaipu.utils.SpUtils;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.filter.Filter;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.ArrayList;
import java.util.List;

//发帖页面
public class PostingActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mNextTv;
    private EditText mEdtTitle;
    private EditText mEdtContent;
    private ImageView mAddress;
    private TextView mLoadAddressTv;
    private ImageView mImgFace;
    private ImageView mImgAt;
    private ImageView mImgUploadPic;
    private LinearLayout mFaceMoreLl;
    private LinearLayout mActivityMain;
    private int REQUESTCODE = 0;//返回码
    private String mNow_address;//获取到的地址
    private static int REQUEST_CODE_POSTING = 100;//点击图片返回码
    List<Uri> mSelected; //图片的地址
    private String mUsername;
    private String mEdt;
    private ArrayList<String> mUsername1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);
        mEdt = SpUtils.getString(getApplicationContext(), "edt");
        Intent intent = getIntent();
        //获取到定位地址
        mNow_address = intent.getStringExtra("now_address");
        //获取到需要@ 的用户名
        mUsername1 = intent.getStringArrayListExtra("username");
        initAddPermission();//动态添加权限
        initView();

    }

    //动态添加网络权限
    private void initAddPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            REQUESTCODE = 0;
            ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUESTCODE);
        }
    }


    public void back(View view) {
        finish();
    }

    private void initView() {
        mEdtTitle = (EditText) findViewById(R.id.edt_title);
        mEdtContent = (EditText) findViewById(R.id.edt_content);//文本内容输入框
        if (mEdt != null) {
            mEdtContent.setText(mEdt);
        }
        String s = mEdtContent.getText().toString();
        if (mUsername1 != null) {
            for (int i = 0; i < mUsername1.size(); i++) {
                String s1 = mUsername1.get(i);
                //如果 字符串中没有 相同的 就添加
                if (s.indexOf(s1) == -1) {
                    s = s + s1;
                }
                mEdtContent.setText(s);
            }
        }

        mImgAt = (ImageView) findViewById(R.id.img_at);
        mImgAt.setOnClickListener(this);
        mImgUploadPic = (ImageView) findViewById(R.id.img_upload_pic);
        //点击分享图片，跳转到显示图片页面
        mImgUploadPic.setOnClickListener(this);
//        mImgUploadPic.performClick();//设置默认点击
        mFaceMoreLl = (LinearLayout) findViewById(R.id.face_more_ll);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
        //设置焦点监听
        mEdtContent.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                //当点击输入文本控件时才会显示最下方的 LinearLayout
                mFaceMoreLl.setVisibility(hasFocus ? View.VISIBLE : View.GONE);
            }
        });

        mAddress = (ImageView) findViewById(R.id.address);
        //是否显示当前的地址
        mLoadAddressTv = (TextView) findViewById(R.id.load_address_tv);
        mLoadAddressTv.setOnClickListener(this);
    }

    private void saveInputText(EditText edtContent) {
        SharedPreferences sp = SpUtils.getSP(getApplicationContext());
        SpUtils.setString(getApplicationContext(), "edt", "" + edtContent.getText().toString());
        Log.i("mylog", "saveInputText: .............." + edtContent.getText().toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_upload_pic://点击分享图片
                Matisse.from(PostingActivity.this)
                        .choose(MimeType.ofAll(), false)
                        .countable(true)
                        .capture(true)
                        .captureStrategy(
                                new CaptureStrategy(true, "com.zhihu.matisse.sample.fileprovider"))
                        .maxSelectable(9)
                        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                        .gridExpectedSize(240)
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .forResult(REQUEST_CODE_POSTING);
                break;
            case R.id.load_address_tv://点击加载地理位置
                //加载地址需要时间
                // TODO: 2017/7/12 0012 未完善
                load_address();
                break;
            case R.id.img_at:
                //清除 艾特 过的字符串
                if (mUsername1 != null) {
                    mUsername1.clear();
                }
                saveInputText(mEdtContent);
                startActivity(new Intent(this, NoticeActivity.class));
                finish();

                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mEdtContent.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_POSTING && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            Log.d("Matisse", "mSelected: " + mSelected);
            if (mSelected != null) {
                //遍历数组 获取到每个bitmap
                for (int i = 0; i < mSelected.size(); i++) {
                    //将图片展示到EditText中
                    //调用工具方法 将uri 转换成bitmap
                    Bitmap bitmap = LoadImageUtil.getInstance().getBitmapFromUri(mSelected.get(i), this);
                    //变成指定宽高的缩略图
                    Bitmap bitmap1 = ThumbnailUtils.extractThumbnail(bitmap, 100, 100);
                    //将缩略图设置到EditText中，但是点击下一步的时候把没有缩略的原图发布
                    addBitmap2Edt(bitmap1);
                }
            }
        }
    }

    private void addBitmap2Edt(Bitmap bitmap) {
        //获取光标位置
        int start = mEdtContent.getSelectionStart();
        SpannableString span = new SpannableString("1");
        span.setSpan(new ImageSpan(bitmap), span.length() - 1, span.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        if (mEdtContent != null) {
            Editable text = mEdtContent.getText();
            text.insert(start, span);
            mEdtContent.setText(text);
            mEdtContent.setSelection(start + span.length());
        }
    }

    //设置地区文本
    private void load_address() {
        mLoadAddressTv.setText(mNow_address);
    }

    public void next_step(View view) {
        //判断如果收尾有空格 就去掉
        if (mEdtTitle.getText().toString().trim().length() == 0 || mEdtContent.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "必须填写标题和内容", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(this, ChooseCircleActivity.class));
        }
    }
}


