package com.example.sensorssample;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class CompassManager{

    private SensorManager sensorManager;
    private Sensor compassSensor;

    public CompassManager(Context context){

        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        compassSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    public void start(){
        if(null != compassSensor){
            Log.d(">>>>>>>>>>>>>>>>>>>>", "timestamp, x, y, z;\n");
            sensorManager.registerListener(compassListener, compassSensor, SensorManager.SENSOR_STATUS_ACCURACY_HIGH);
        }
    }

    public void stop(){
        sensorManager.unregisterListener(compassListener);
    }

    SensorEventListener compassListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            logValues(event.values, event.timestamp);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    };

    private void logValues(float[] xyz, long timestamp){
        String logEntry = String.format("%d, %f, %f, %f;\n", timestamp, xyz[0], xyz[1], xyz[2]);
        Log.d(">>>>>>>>>>>>>>>>>>>>", logEntry);
    }

}
