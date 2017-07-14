package com.developers.siddharth.batterypercentagebrassignment;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyBroad myBroad = new MyBroad();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // defining intent filter
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = getApplicationContext().registerReceiver(null, ifilter);

        // Are we charging / charged?
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        // getting value in the string
        String bateria = String.valueOf(status);
        TextView tvv = (TextView) findViewById(R.id.tv);
        // setting the percentage in the textview taken
        tvv.setText("Battery percentage left: "+bateria);
        // receiver registered
        registerReceiver(myBroad,ifilter);
    }
}
