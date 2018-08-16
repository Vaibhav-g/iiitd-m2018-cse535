package com.example.rk.assign_mc1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends Activity {

    final String TAG = "Activity States";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        EditText name,course;
        Button s, clear;

        name=(EditText)findViewById(R.id.editText1);
        course=(EditText)findViewById(R.id.editText2);

        s=(Button) findViewById(R.id.button1);
        clear=(Button)findViewById(R.id.button2);
    }

    public void onStart(){
        super.onStart();
        Log.d(TAG,"Activity1 Oncreate");
    }

    public void onRestart(){
        super.onRestart();
        Log.d(TAG,"Activity1 OnRestart");
    }

    public void onResume(){
        super.onResume();
        Log.d(TAG,"Activity1 OnResume");
    }

    public void onPause(){
        super.onPause();
        Log.d(TAG,"Activity1 OnPause");
    }

    public void onStop(){
        super.onStop();
        Log.d(TAG,"Activity1 OnStop");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"Activity1 OnDestroy");
    }

    public void onClickclear(View v)

    {

        if(v.getId()==R.id.button2)
        {
            EditText name,roll,branch,course1,course2,course3,course4;

            name=(EditText)findViewById(R.id.editText1);
            roll=(EditText)findViewById(R.id.editText2);
            branch=(EditText)findViewById(R.id.editText3);
            course1=(EditText)findViewById(R.id.editText4);
            course2=(EditText)findViewById(R.id.editText5);
            course3=(EditText)findViewById(R.id.editText6);
            course4=(EditText)findViewById(R.id.editText7);

            name.setText("");
            roll.setText("");
            branch.setText("");
            course1.setText("");
            course2.setText("");
            course3.setText("");
            course4.setText("");

        }

    }


    public void onClick(View v)

    {

        if(v.getId()==R.id.button1)
        {

            EditText name,roll,branch,course1,course2,course3,course4;

            name=(EditText)findViewById(R.id.editText1);
            roll=(EditText)findViewById(R.id.editText2);
            branch=(EditText)findViewById(R.id.editText3);
            course1=(EditText)findViewById(R.id.editText4);
            course2=(EditText)findViewById(R.id.editText5);
            course3=(EditText)findViewById(R.id.editText6);
            course4=(EditText)findViewById(R.id.editText7);



            Intent intent1=new Intent(Activity1.this,Activity2.class);

            intent1.putExtra("myname",name.getText().toString());
            intent1.putExtra("myroll",roll.getText().toString());
            intent1.putExtra("mybranch",branch.getText().toString());
            intent1.putExtra("mycourse1",course1.getText().toString());
            intent1.putExtra("mycourse2",course2.getText().toString());
            intent1.putExtra("mycourse3",course3.getText().toString());
            intent1.putExtra("mycourse4",course4.getText().toString());



            startActivity(intent1);
        }

    }


}
