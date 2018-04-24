package com.sunzn.script;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView web = findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void send(String message) {
                Log.e("JavaScript", message);
            }
        }, "androidObject");
        web.loadUrl("file:///android_asset/demo.html");
    }
}
