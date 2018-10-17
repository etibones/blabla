package com.example.etibo.myapplication;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private int MY_PERMISSIONS_REQUEST_SMS_RECEIVE = 10;
    private int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.RECEIVE_SMS, Manifest.permission.SEND_SMS},
                MY_PERMISSIONS_REQUEST_SMS_RECEIVE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG", "HELLO");
    }

    public void goToReceive(View view) {
        Intent intent = new Intent(this, ShowPage.class);
        startActivity(intent);
    }

    public void goToSend(View view) {
        Intent intent = new Intent(this, ShowPage2.class);
        startActivity(intent);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PERMISSIONS_REQUEST_SMS_RECEIVE) {
            // YES!!
            Log.i("TAG", "MY_PERMISSIONS_REQUEST_SMS_RECEIVE --> YES");
        }

        if (requestCode == MY_PERMISSIONS_REQUEST_SEND_SMS) {
            Log.i("TAG", "MY_PERMISSIONS_REQUEST_SEND_SMS --> YES");
        }
    }
}
