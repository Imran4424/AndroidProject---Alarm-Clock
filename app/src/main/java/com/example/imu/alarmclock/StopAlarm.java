package com.example.imu.alarmclock;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import com.example.sumaiya.alarmmanager.R;

public class StopAlarm extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_alarm);

        Button submit = (Button) findViewById(R.id.submit);
        final EditText stopText = (EditText) findViewById(R.id.stopText);

        submit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String text = "i am awake";

                String input = stopText.getText().toString().toLowerCase();

                if (text.equals(input))
                {
                    /**
                     *  this statement is used to exit from a process
                     * */

                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
                else
                {
                    Toast.makeText(StopAlarm.this, "WRONG INPUT", Toast.LENGTH_SHORT).show();
                }

                /**
                 *
                 *  first parameter of make toast is a activity
                 *
                 *  in MainActivity you can simply Write this
                 *
                 *  but in other activity
                 *
                 *  you need to write activity_name.this
                 * */
            }
        });
    }

}
