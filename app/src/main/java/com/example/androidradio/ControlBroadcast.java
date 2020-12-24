package com.example.androidradio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ControlBroadcast extends BroadcastReceiver {

    public ControlListener listener;

    public void setListener(ControlListener lis) {
        this.listener = lis;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

            System.out.println("INTENT");
        if (action.equals("PAUSE")) {
            if (listener != null) {
                listener.pause();
            } else {
                System.out.println("TAG: NULL");
            }

            System.out.println("TAG: PAUSE");
        } else if (action.equals("NEXT")) {
            System.out.println("TAG: NEXT");
        } else if (action.equals("PREVIOUS")) {
            System.out.println("TAG: PREVOIUS");
        } else {
            System.out.println("TAG: NONE");
        }
    }
}
