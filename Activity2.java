package com.example.rk.assign_mc1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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
        Log.d(TAG,"Activity2 Oncreate");
    }

    public void onRestart(){
        super.onRestart();
        Log.d(TAG,"Activity2 OnRestart");
    }

    public void onResume(){
        super.onResume();
        Log.d(TAG,"Activity2 OnResume");
    }

    public void onPause(){
        super.onPause();
        Log.d(TAG,"Activity2 OnPause");
    }

    public void onStop(){
        super.onStop();
        Log.d(TAG,"Activity2 OnStop");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"Activity2 OnDestroy");
    }


}
