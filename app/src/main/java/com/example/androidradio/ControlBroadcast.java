package com.example.androidradio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

public class ControlBroadcast extends BroadcastReceiver {

    private ControlListener listener;

    public void setListener(@NonNull ControlListener lis) {
        listener = (ControlListener) lis;
        System.out.println("TAG: ".concat(lis.toString()));
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

            System.out.println("INTENT");
        if (action.equals("PAUSE")) {
            if (MainActivity.Instance != null) {
                MainActivity.Instance.pause();
            } else {
                System.out.println("TAG: NULL");
            }

        } else if (action.equals("NEXT")) {
            MainActivity.Instance.nextUri();
            System.out.println("TAG: NEXT");
        } else if (action.equals("PREVIOUS")) {
            MainActivity.Instance.previousUri();
            System.out.println("TAG: PREVOIUS");
        } else {
            System.out.println("TAG: NONE");
        }
    }
}
