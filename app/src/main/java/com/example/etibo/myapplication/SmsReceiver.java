package com.example.etibo.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;

public class SmsReceiver extends BroadcastReceiver {

    public SmsReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs;
        String str = "";
/*
        if (bundle != null) {
            // Retrieve the SMS Messages received
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];

            // For every SMS message received
            for (int i=0; i < msgs.length; i++) {
                // Convert Object array
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);

                /* To only receive from a specific phone number */
                //if (msgs[i].getOriginatingAddress() == "8198068706") {

                    //str += msgs[i].getMessageBody().toString();
                    //str += "\n";
                //}
        if (bundle != null){
            // Retrieve the Binary SMS data
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];

            // For every SMS message received (although multipart is not supported with binary)
            for (int i=0; i<msgs.length; i++) {
                byte[] data;

                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                data = msgs[i].getUserData();
                if (msgs[i].getOriginatingAddress().equalsIgnoreCase("8198068706")) {

                    for (int index=0; index < data.length; index++) {
                        str += Character.toString((char) data[index]);
                    }

                    str += "\n";
                }
            }
            try {
                ShowPage.getInstance().receive(str);
                //ShowPage.getInstance().updateTextView(str);
            } catch (Exception e) {

            }
            this.abortBroadcast();
        }
    }
}