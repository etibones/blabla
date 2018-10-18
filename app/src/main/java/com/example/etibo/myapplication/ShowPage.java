package com.example.etibo.myapplication;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowPage extends AppCompatActivity {
    private static ShowPage ins;
    private SmsReceiver smsReceiver;
    private String[] mapsParameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_page);
        // Register a broadcast receiver
        smsReceiver = new SmsReceiver();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DATA_SMS_RECEIVED");
        intentFilter.setPriority(10);
        intentFilter.addDataScheme("sms");
        intentFilter.addDataAuthority("*", "6734");
        registerReceiver(smsReceiver, intentFilter);
        ins = this;
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            unregisterReceiver(smsReceiver);
        } catch (Exception e) {

        }

    }

    public static ShowPage getInstance() {
        return ins;
    }

    public void receive(String sms) {
        //mapsParameters = sms.split("^");
        updateTheTextView(sms);
    }
    public void updateTheTextView(final String t) {
        ShowPage.this.runOnUiThread(new Runnable() {
            public void run() {
                TextView textV1 = findViewById(R.id.textView2);
                textV1.setText(t);
            }
        });
    }
/*
    public void updatePageView(final String code) {
        ShowPage.this.runOnUiThread(new Runnable() {
            public void run() {
                WebView webView = (WebView)findViewById(R.id.webView);
                webView.loadData(code , "text/html" , "utf-8");

            }
        });
    }*/
}
