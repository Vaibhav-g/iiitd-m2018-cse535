package com.example.rk.assign_mc1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends Activity {

    final String TAG = "Activity States";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView name,roll,branch,course1,course2,course3,course4;

        name=(TextView)findViewById(R.id.textname);
        roll=(TextView)findViewById(R.id.textroll);

        branch=(TextView)findViewById(R.id.textbranch);
        course1=(TextView)findViewById(R.id.textcourse1);
        course2=(TextView)findViewById(R.id.textcourse2);
        course3=(TextView)findViewById(R.id.textcourse3);
        course4=(TextView)findViewById(R.id.textcourse4);


        name.setText(getIntent().getStringExtra("myname"));
        roll.setText(getIntent().getStringExtra("myroll"));

        branch.setText(getIntent().getStringExtra("mybranch"));
        course1.setText(getIntent().getStringExtra("mycourse1"));

        course2.setText(getIntent().getStringExtra("mycourse2"));
        course3.setText(getIntent().getStringExtra("mycourse3"));

        course4.setText(getIntent().getStringExtra("mycourse4"));
       }


    public void onStart(){
        super.onStart();
        Log.v(TAG,"Activity2 Oncreate");

        Toast.makeText(this, "Activity 2 Oncreate", Toast.LENGTH_SHORT).show();
    }

    public void onRestart(){
        super.onRestart();
        Log.v(TAG,"Activity2 OnRestart");

        Toast.makeText(this, "Activity 2 Onrestart", Toast.LENGTH_SHORT).show();
    }

    public void onResume(){
        super.onResume();
        Log.v(TAG,"Activity2 OnResume");

        Toast.makeText(this, "Activity2 OnResume", Toast.LENGTH_SHORT).show();
    }

    public void onPause(){
        super.onPause();
        Log.v(TAG,"Activity2 OnPause");

        Toast.makeText(this, "Activity2 OnPause", Toast.LENGTH_SHORT).show();
    }

    public void onStop(){
        super.onStop();
        Log.v(TAG,"Activity2 OnStop");
        Toast.makeText(this, "Activity2 OnStop", Toast.LENGTH_SHORT).show();



    }

    public void onDestroy(){
        super.onDestroy();
        Log.v(TAG,"Activity2 OnDestroy");

        Toast.makeText(this, "Activity2 OnDestroy", Toast.LENGTH_SHORT).show();
    }


}
