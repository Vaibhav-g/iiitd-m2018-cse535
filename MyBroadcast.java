package com.example.rk.mcassign2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        StringBuilder msg=new StringBuilder();
        msg.append("Action Occurred :"+intent.getAction()+"\n");

        Toast.makeText(context,msg.toString(),Toast.LENGTH_LONG).show();

    }
}
