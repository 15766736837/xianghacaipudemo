package com.a520it.xianghacaipu.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.constant.NetController;

public class WalletActivity extends BaseActivity {

    private WebView wallet_wv;
    private RelativeLayout activity_wallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        initView();
    }

    private void initView() {
        wallet_wv = (WebView) findViewById(R.id.wallet_wv);
        activity_wallet = (RelativeLayout) findViewById(R.id.activity_wallet);
        //给mWebView配置,让其能够加载javascript
        wallet_wv.getSettings().setJavaScriptEnabled(true);
        //碰到重定向时,会默认打开其他的应用来展示网页
        wallet_wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        //加载界面
        wallet_wv.loadUrl(NetController.WALLET_URL);
    }
}
