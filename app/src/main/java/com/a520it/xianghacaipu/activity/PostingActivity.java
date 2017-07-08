package com.a520it.xianghacaipu.activity;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);
        Intent intent = getIntent();
        mNow_address = intent.getStringExtra("now_address");
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUESTCODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i("mylog", "onRequestPermissionsResult: 授权成功");
            } else {
                Log.i("mylog", "onRequestPermissionsResult: 授权失败");
            }
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    public void back(View view) {
        finish();
    }

    private void initView() {
        mNextTv = (TextView) findViewById(R.id.next_tv);
        mEdtTitle = (EditText) findViewById(R.id.edt_title);
        mEdtContent = (EditText) findViewById(R.id.edt_content);//文本内容输入框
        mImgFace = (ImageView) findViewById(R.id.img_face);
        mImgAt = (ImageView) findViewById(R.id.img_at);
        mImgUploadPic = (ImageView) findViewById(R.id.img_upload_pic);
        //点击分享图片，跳转到显示图片页面
        mImgUploadPic.setOnClickListener(this);
        mImgUploadPic.performClick();
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


    /**
     * 点击事件处理
     */
    @Override
    public void onClick(View v) {

//                startActivity(new Intent(PostingActivity.this, PictureActivity.class));
        switch (v.getId()){
            case R.id.img_upload_pic://点击分享图片
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
                break;
            case R.id.load_address_tv://点击加载地理位置
                //加载地址需要时间
                load_address();
                break;
        }
    }

    /**
     *  显示地址
     */
    private void load_address() {
        mLoadAddressTv.setText(mNow_address);
    }


}


