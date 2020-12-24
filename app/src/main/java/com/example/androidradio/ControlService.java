package com.example.androidradio;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ControlService extends Service {
    private Looper serviceLooper;
    private ServiceHandler serviceHandler;


    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {

        }
    }

    @Override
    public void onCreate() {
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        serviceLooper = thread.getLooper();
        serviceHandler = new ServiceHandler(serviceLooper);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Radio";
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel("RADIO", name, importance);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        createNotificationChannel();
        Intent notificationIntent = new Intent(this, ControlService.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Intent prevIntent = new Intent(this, ControlBroadcast.class);
        prevIntent.setAction("PREVIOUS");

        Intent pauseIntent = new Intent(this, ControlBroadcast.class);
        pauseIntent.setAction("PAUSE");

        Intent nextIntent = new Intent(this, ControlBroadcast.class);
        nextIntent.setAction("NEXT");

        PendingIntent prevPendingIntent = PendingIntent.getBroadcast(this, 1, prevIntent, 0);
        PendingIntent pausePendingIntent = PendingIntent.getBroadcast(this, 2, pauseIntent, 0);
        PendingIntent nextPendingIntent = PendingIntent.getBroadcast(this, 3, nextIntent, 0);

        Notification notification = new NotificationCompat.Builder(this, "RADIO")
                .setContentTitle(MainActivity.song)
                .setContentText(MainActivity.song_artist)
                .setSmallIcon(R.drawable.exo_notification_small_icon)
                .setContentIntent(pendingIntent)
                .setColorized(true)
                .setColor(429496729)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .addAction(R.drawable.exo_notification_previous, "Previous", prevPendingIntent)
                .addAction(R.drawable.exo_notification_pause, "Pause", pausePendingIntent)
                .addAction(R.drawable.exo_notification_next, "Next", nextPendingIntent)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                    .setShowActionsInCompactView(1))
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), MainActivity.image)).build();

        startForeground(255, notification);

        return START_NOT_STICKY;
    }
    @Nullable

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
