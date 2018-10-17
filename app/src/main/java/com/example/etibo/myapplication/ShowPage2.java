package com.example.etibo.myapplication;

import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ShowPage2 extends AppCompatActivity {

    SmsManager smsManager;
    Button sendBtn;
    EditText txtMessage;
    String message;
    String txtphoneNo;
    ArrayList<String> smsBodyParts;
    ArrayList<PendingIntent> sentPendingIntents;
    ArrayList<PendingIntent> deliveredPendingIntents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_page2);

        smsManager = SmsManager.getDefault();
        sentPendingIntents = new ArrayList<PendingIntent>();
        deliveredPendingIntents = new ArrayList<PendingIntent>();
        sendBtn = (Button) findViewById(R.id.btnSendSMS);
        txtphoneNo = "8198068706";
        txtMessage = (EditText) findViewById(R.id.editText2);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
    }

    protected void sendSMSMessage() {

        message = txtMessage.getText().toString();
        byte[] smsBody = message.getBytes();
        short port = 6734;
        //smsBodyParts = smsManager.divideMessage(message);
        //smsManager.sendMultipartTextMessage(txtphoneNo, null, smsBodyParts, sentPendingIntents, deliveredPendingIntents);
        smsManager.sendDataMessage(txtphoneNo, null, port, smsBody, null, null);
        txtMessage.setText("");
    }
}
