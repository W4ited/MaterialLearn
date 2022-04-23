package com.example.materiallearn.Html;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.materiallearn.R;

public class MainActivity2 extends AppCompatActivity {

    private WebView webview;
    private TextView textView;


    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //webview = new WebView(this);
        webview = (WebView) findViewById(R.id.webView_html);
        textView = (TextView) findViewById(R.id.android_html_text);
        //JavascriptInterface javascriptInterface = new JavascriptInterface(webview,textView);

        webview.getSettings().setJavaScriptEnabled(true);   //支持js
        webview.addJavascriptInterface(new JavaHTMLInterface(),"demo");   //demo 交互时候相互定义的名字
        //webview.addJavascriptInterface(javascriptInterface,"demo");

        webview.loadUrl("file:///android_asset/index");


//        try {
//            //设置打开的页面地址
//            webview.loadUrl("file:///android_asset/index");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
       // setContentView(webview);  //new webview 则使用
    }

    class JavaHTMLInterface{
        @android.webkit.JavascriptInterface
        public void toAndroid(String order){
            Log.d("html",order);
            webview.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(order);
                }
            });
        }
    }
}