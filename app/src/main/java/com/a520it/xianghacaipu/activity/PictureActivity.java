package com.a520it.xianghacaipu.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.adapter.ImgGridViewAdapter;
import com.a520it.xianghacaipu.utils.GetSDImgUtil;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/29 0029.
 */
public class PictureActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {


    public final static int ALBUM_REQUEST_CODE = 1;


    private GridView mGv;
    private TextView mTvSelected;
    private Button mBtnFinish;
    private ArrayList<Bitmap> mImageViews;
    private int mPic_count = 0;//所选择的图片，默认为没有选择
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        initView();
        mImageViews = new ArrayList<>();
        setImage();
        ImgGridViewAdapter adapter = new ImgGridViewAdapter(mImageViews,this);
        mGv.setAdapter(adapter);
        mGv.setOnItemClickListener(this);

    }

    private void setImage() {
        //判断是否有SD卡
        boolean isHasSDCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        Log.i("mylog", "onClick: 《------------是否有SD卡-------------》" + isHasSDCard);
        if (isHasSDCard) {
            Log.i("mylog", "onClick: 《--------进入，证明存在SD卡--------》");
            //有的话获取SD卡的路径
            File sdPath = Environment.getExternalStorageDirectory();
            //获取SD卡路径下的图片
            ArrayList<Bitmap> datas = GetSDImgUtil.getImage(sdPath);
            if(datas!=null) {
                for (Bitmap image : datas) {
                    //将图片添加到SD卡图片展示列表
                    mImageViews.add(image);
                }
            }else{

                Toast.makeText(this,"没有图片，请拍照!",Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "没有检测到SD卡", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        finish();
    }

    /**
     * 点击相册,就打开系统相册
     */
    public void photo_album(View view) {
//        startActivity(new Intent(this,Album_List.class));
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, ALBUM_REQUEST_CODE);
    }

    /**
     * 调用系统相册，然后通过Uri拿到图片的绝对地址
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == ALBUM_REQUEST_CODE) {
                try {
                    Uri uri = data.getData();
                    final String absolutePath= getAbsolutePath(getApplicationContext(), uri);
                    Log.i("mylog","path=" + absolutePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     *  获取绝对路径
     * @param context
     * @param uri
     * @return
     */
    public String getAbsolutePath(final Context context, final Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = context.getContentResolver().query(uri,
                    new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }
    private void initView() {
        mGv = (GridView) findViewById(R.id.gv);

        mTvSelected = (TextView) findViewById(R.id.tv_selected);
        mBtnFinish = (Button) findViewById(R.id.btn_finish);

        mBtnFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_finish:
                // TODO: 2017/7/4 0004 点击完成
                //将图片进行返回到

                break;
        }
    }
    /**
     * 点击图片item
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //每选中一张图片，就将 mPic_count++ mPic_count <= 8

    }
}
