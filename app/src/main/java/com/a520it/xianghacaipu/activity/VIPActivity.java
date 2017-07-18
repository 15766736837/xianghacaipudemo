package com.a520it.xianghacaipu.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.constant.NetController;

public class VIPActivity extends BaseActivity {

    private WebView mVipWv;
    private RelativeLayout mActivityVip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        initView();
    }

    private void initView() {
        mVipWv = (WebView) findViewById(R.id.vip_wv);
        mActivityVip = (RelativeLayout) findViewById(R.id.activity_vip);
        //给mWebView配置,让其能够加载javascript
        mVipWv.getSettings().setJavaScriptEnabled(true);
        //碰到重定向时,会默认打开其他的应用来展示网页
        mVipWv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        //加载界面
        mVipWv.loadUrl(NetController.VIP_URL);
    }
}
