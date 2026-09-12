package com.toklite.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;

public class MainActivity extends Activity {
    // When you have a hosted TokLite URL, replace the value below.
    // Example: https://example.com/toklite/
    private static final String HOSTED_URL = "";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView web = findViewById(R.id.webview);
        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setMediaPlaybackRequiresUserGesture(false);
        s.setAllowFileAccess(true);
        s.setAllowContentAccess(true);

        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        if (HOSTED_URL.trim().isEmpty()) {
            web.loadUrl("file:///android_asset/index.html");
        } else {
            web.loadUrl(HOSTED_URL);
        }
    }

    @Override
    public void onBackPressed() {
        WebView web = findViewById(R.id.webview);
        if (web.canGoBack()) web.goBack();
        else super.onBackPressed();
    }
}
