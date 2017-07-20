package com.a520it.xianghacaipu.activity.home_category;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.utils.ShareUtils;


public class HomeHeadlineItemActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIntegrateReturnIv;
    private ImageView mIntegrateShareIv;
    private RelativeLayout mActivityHomeBannerDetails;
    private WebView mHomeHeadlineItemWv;
    private LinearLayout mActivityHomeHeadlineItem;
    public final static String CODE = "code";
    private int mCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_headline_item);

        Intent intent = getIntent();
        mCode = intent.getIntExtra(CODE, -1);

        initView();
        initWebView();
        initEvent();
    }

    private void initView() {
        mIntegrateReturnIv = (ImageView) findViewById(R.id.integrate_return_iv);
        mIntegrateShareIv = (ImageView) findViewById(R.id.integrate_share_iv);
        mActivityHomeBannerDetails = (RelativeLayout) findViewById(R.id.activity_home_banner_details);
        mHomeHeadlineItemWv = (WebView) findViewById(R.id.home_headline_item_wv);
        mActivityHomeHeadlineItem = (LinearLayout) findViewById(R.id.activity_home_headline_item);
    }

    private void initWebView() {
        Log.v("lai", "initWebView: ");
        //给mWebView配置,让其能够加载javascript
        mHomeHeadlineItemWv.getSettings().setJavaScriptEnabled(true);
        //碰到重定向时,会默认打开其他的应用来展示网页
        mHomeHeadlineItemWv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        //加载界面
        mHomeHeadlineItemWv.loadUrl("http://appweb.xiangha.com/zhishi/nousInfo?code=" + mCode + "");
    }

    private void initEvent() {
        mIntegrateReturnIv.setOnClickListener(this);
        mIntegrateShareIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.integrate_return_iv:
                finish();
                break;
            case R.id.integrate_share_iv:
                ShareUtils.showShare(this, null);
                break;
        }
    }
}
