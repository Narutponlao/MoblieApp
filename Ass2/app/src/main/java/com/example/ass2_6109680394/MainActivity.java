package com.example.ass2_6109680394;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorInfo sensor_info = new SensorInfo();
    SensorManager sensorManager;
    Boolean shown_dialog = false;
    Handler handler = new Handler();
    private final int shake_threshold = 10;

    private Runnable pollTask = new Runnable() {
        @Override
        public void run() {
            showDialog();
            handler.postDelayed(pollTask, 500);

        }
    };

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    protected void onPause() {
        super.onPause();

        sensorManager.unregisterListener(this);
       handler.removeCallbacks(pollTask);
    }
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        handler.postDelayed(pollTask, 500);
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type;
        type = sensorEvent.sensor.getType();


        if (type == Sensor.TYPE_ACCELEROMETER) {
            sensor_info.accX = sensorEvent.values[0];
            sensor_info.accY = sensorEvent.values[1];
            sensor_info.accZ = sensorEvent.values[2];
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void showDialog() {
        int number,infoarr;
        Random rand = new Random();
        number = rand.nextInt(10)+1;
        infoarr = rand.nextInt(10);
        String[] massage2=getResources().getStringArray(R.array.info);

        if ((Math.abs(sensor_info.accX) > shake_threshold) ||
                (Math.abs(sensor_info.accY) > shake_threshold) ||
                (Math.abs(sensor_info.accZ) > shake_threshold)) {
            if (!shown_dialog) {
                shown_dialog = true;
                final AlertDialog.Builder viewDialog = new AlertDialog.Builder(this);

                viewDialog.setTitle("โชคของคุณวันนี้");
                viewDialog.setMessage(massage2[infoarr]);

                viewDialog.setPositiveButton("OK",

                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                shown_dialog = false;
                            }
                        });
                viewDialog.show();
            }//end if

        }//end method
    }
}