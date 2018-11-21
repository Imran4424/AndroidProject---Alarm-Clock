package com.example.sumaiya.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;



public class MyAlarm extends BroadcastReceiver
{


    @Override
    public void onReceive(Context context, Intent intent)
    {
        final MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);

        mediaPlayer.start();

    }


}
