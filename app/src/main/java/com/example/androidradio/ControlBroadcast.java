package com.example.androidradio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

public class ControlBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (action.equals("PAUSE")) {
            MainActivity.Instance.pause();
        } else if (action.equals("NEXT")) {
            MainActivity.Instance.nextUri();
        } else if (action.equals("PREVIOUS")) {
            MainActivity.Instance.previousUri();
        }
    }
}
