package com.example.etibo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowPage2 extends AppCompatActivity {

    SmsManager smsManager;
    String message;
    String txtphoneNo;
    ArrayList<String> mapsParameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_page2);

        message = "";
        mapsParameters = new ArrayList<String>();
        smsManager = SmsManager.getDefault();
        txtphoneNo = "8198068706";
    }

    protected void sendSMSMessage() {

        for (String parameters : mapsParameters) {
            message += parameters + "^";
        }

        byte[] smsBody = message.getBytes();
        short port = 6734;

        smsManager.sendDataMessage(txtphoneNo, null, port, smsBody, null, null);

        Intent intent = new Intent(this, ShowPage.class);
        //intent.putStringArrayListExtra("Maps Parameters", mapsParameters);
        startActivity(intent);
    }

    public void goToSend(View view) {

        String firstView = ((EditText) findViewById(R.id.editText)).getText().toString();
        String secondView = ((EditText) findViewById(R.id.editText2)).getText().toString();
        String thirdView = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();
        int error = 0;      // vraiment laid, on changera plus tard
        error +=  check(firstView, 0);
        error += check(secondView, 1);
        if (error == 0){
            mapsParameters.add(firstView);
            mapsParameters.add(secondView);
            mapsParameters.add(thirdView);
            sendSMSMessage();
        }
    }

    private int check(String view, int number) {
        String point;
        if (number == 0) {
            point = "starting";
        } else {
            point = "end";
        }

        if (view.isEmpty()) {
            Toast.makeText(getApplicationContext(), "You forgot to add a " + point + " point", Toast.LENGTH_LONG).show();
            return 1;
        }
        else if (view.contains("^") || view.contains("#") || view.contains("&")) {
            Toast.makeText(getApplicationContext(), "Illegal characters in " + point + " point", Toast.LENGTH_LONG).show();
            return 1;
        }
        else if (view.length() > 72) {
            Toast.makeText(getApplicationContext(), "Your " + point + " address is way too long", Toast.LENGTH_LONG).show();
            return 1;
        } else {
            return 0;
        }
    }
}
