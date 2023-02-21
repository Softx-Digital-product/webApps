package com.example.webapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ClientCertRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    ProgressBar pgBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//            requestWindowFeature(Window.FEATURE_NO_TITLE);
//            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//            getSupportActionBar().hide();
        webView = findViewById(R.id.webView);
        pgBar = findViewById(R.id.pgBar);
        webView.loadUrl("https://research.bvmdigitalsolutions.com/login.php");

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                pgBar.setVisibility(view.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                pgBar.setVisibility(view.GONE);

                super.onPageFinished(view, url);
            }


        });






    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        }else{
            super.onBackPressed();
        }

    }
}