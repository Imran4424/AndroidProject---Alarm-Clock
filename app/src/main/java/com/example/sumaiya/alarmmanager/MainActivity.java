package com.example.sumaiya.alarmmanager;

import com.example.imu.alarmclock.StopAlarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{

    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker)  findViewById(R.id.timepicker);

        findViewById(R.id.buttonSetAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                if(Build.VERSION.SDK_INT >=23) {
                calendar.set(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH),
                        timePicker.getHour(),
                        timePicker.getMinute()

                );
            }else {
                    calendar.set(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH),
                        timePicker.getCurrentHour(),
                        timePicker.getCurrentMinute(),
                        0
                );
             }
             setAlarm(calendar.getTimeInMillis());
        }
    });
}

    private void setAlarm(long timeInMillis) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, MyAlarm.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);

        alarmManager.setRepeating(AlarmManager.RTC,timeInMillis,AlarmManager.INTERVAL_DAY,pendingIntent);


        Toast.makeText(this, "Alarm is set", Toast.LENGTH_SHORT).show();
    }


    /**
    * This code will move you to new activity
    * */

    public void StopAlarm(View view)
    {
        Intent intent = new Intent(this, StopAlarm.class);
        startActivity(intent);
    }
}
