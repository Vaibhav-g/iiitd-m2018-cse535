package com.example.rk.assignment4;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener, LocationListener {

    private SensorManager mSensorManager;
    private LocationManager mLocationManager;
    private Sensor mAccelerometer, mGyroscope, mProximity, mOrientation;


    private android.location.LocationListener locListener;

    public long lastTime = 0;
    float last_x = 0, last_y = 0, last_z = 0;
    public int shakecount = 0;

    public static final int SHAKE_THRESHOLD = 10;

    public static MainActivity mInstance;

    public static MainActivity getObj() {
        return mInstance;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);


        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mOrientation = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

    }


    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mOrientation, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mOrientation, SensorManager.SENSOR_DELAY_NORMAL);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {


        if(event.sensor.getType() == Sensor.TYPE_PROXIMITY)
        {
            if(event.values[0] == 0)
                Toast.makeText(this, "Proximity : Near", Toast.LENGTH_SHORT).show();

            else
                Toast.makeText(this, "Proximity : Far", Toast.LENGTH_SHORT).show();
        }
        else if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE)
        {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];

            Toast.makeText(this, "Gyroscope x"+Float.toString(sensorX), Toast.LENGTH_SHORT).show();

            Toast.makeText(this, "Gyroscope y"+Float.toString(sensorY), Toast.LENGTH_SHORT).show();

            Toast.makeText(this, "Gyroscope z"+Float.toString(sensorZ), Toast.LENGTH_SHORT).show();
        }
        else if(event.sensor.getType() == Sensor.TYPE_ORIENTATION)
        {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];



            Toast.makeText(this, "Orientation x"+Float.toString(sensorX), Toast.LENGTH_SHORT).show();

            Toast.makeText(this, "Orientation y"+Float.toString(sensorY), Toast.LENGTH_SHORT).show();

            Toast.makeText(this, "Orientation z"+Float.toString(sensorZ), Toast.LENGTH_SHORT).show();
        }

        else if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            //String name = event.sensor.getName();

            //Accdb.getInstance().insert(event.values[0], event.values[1], event.values[2]);


            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];



            Toast.makeText(this, "Accelerometer"+" x"+Float.toString(x)+" y"+Float.toString(y)+" z"+Float.toString(z) , Toast.LENGTH_SHORT).show();

            long curTime = System.currentTimeMillis();

            if(shakecount ==0){
                last_x = x;
                last_y = y;
                last_z = z;
            }

            if ((curTime - lastTime) > 100)  {

                Toast.makeText(this ,"rk", Toast.LENGTH_SHORT).show();
                long diffTime = (curTime - lastTime);
                lastTime = curTime;

                shakecount=shakecount+1;

                float velocity = Math.abs(x+y+z - last_x - last_y - last_z) / diffTime * 10000;

                if (velocity > SHAKE_THRESHOLD) {

                    Toast.makeText(this, "shake detected with speed: " + velocity, Toast.LENGTH_SHORT).show();
                }
                last_x = x;
                last_y = y;
                last_z = z;
            }


        }





//        float sensorX, sensorY, sensorZ;
//
//        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
//
//        {
//
//
//            sensorX = event.values[0];
//            sensorY = event.values[1];
//            sensorZ = event.values[2];
//
//            //        Toast.makeText(, Toast.LENGTH_SHORT).show();
//
//
//            Toast.makeText(this, "Accelerometer x"+Float.toString(sensorX), Toast.LENGTH_SHORT).show();
//
//            Toast.makeText(this, "Accelerometer y"+Float.toString(sensorY), Toast.LENGTH_SHORT).show();
//
//            Toast.makeText(this, "Accelerometer z"+Float.toString(sensorZ), Toast.LENGTH_SHORT).show();
////            displayX.setText(Float.toString(sensorX));
////            displayY.setText(Float.toString(sensorY));
////            displayZ.setText(Float.toString(sensorZ));
//
//        }
//
//        if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE)
//        {
//
//            sensorX = event.values[0];
//            sensorY = event.values[1];
//            sensorZ = event.values[2];
//
//            Toast.makeText(this, "Gyroscope x"+Float.toString(sensorX), Toast.LENGTH_SHORT).show();
//
//            Toast.makeText(this, "Gyroscope y"+Float.toString(sensorY), Toast.LENGTH_SHORT).show();
//
//            Toast.makeText(this, "Gyroscope z"+Float.toString(sensorZ), Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onLocationChanged(Location location) {
        double lng=location.getLongitude();
        double lat=location.getLatitude();

        Toast.makeText(this, "GPS Running Longitude"+Double.toString(lng)+" Lattitude"+Double.toString(lat) , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}