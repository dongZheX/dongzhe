package com.example.noticeme;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

public class NoticeService extends Service {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override

    public int onStartCommand(Intent intent, int flags, int startId) {


        Notification notification = new NotificationCompat.Builder(this)
               .build();
        startForeground(1,notification);

        Intent intent1 = new Intent(this,AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this,0,intent1,0);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),60*1000*60*5,pi);
        return super.onStartCommand(intent, flags, startId);
    }

    public NoticeService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }
}
