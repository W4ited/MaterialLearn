package com.example.materiallearn.Html;

import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

public class JavascriptInterface {
    private WebView web;
    private TextView textView;

    public JavascriptInterface(WebView web, TextView textView) {
        this.web = web;
        this.textView = textView;

    }

    public void toAndroid(String htmlString) {
        Log.d("html", htmlString);
        web.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(htmlString);
            }
        });
    }
}
