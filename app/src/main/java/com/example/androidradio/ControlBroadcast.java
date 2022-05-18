package com.example.androidradio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ControlBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        switch (action) {
            case "PAUSE":
                MainActivity.Instance.pause();
                break;
            case "NEXT":
                MainActivity.Instance.nextUri();
                break;
            case "PREVIOUS":
                MainActivity.Instance.previousUri();
                break;
        }
    }
}
