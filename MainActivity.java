package com.example.rk.mcassign2;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends Activity implements View.OnClickListener {

    Button play,stop,dnld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=(Button) findViewById(R.id.btplay);
        stop=(Button) findViewById(R.id.btstop);
        dnld=(Button) findViewById(R.id.btdnload);


        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        dnld.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == play) {
            startService(new Intent(this, MyMusicService.class));
        }
        else if(v == stop){
            stopService(new Intent(this, MyMusicService.class));
        }

        else if(v == dnld){
            startService(new Intent(this, DownloadService.class));
//
//            String myurl="faculty.iiitd.ac.in/~mukulika/s1.mp3";
//            boolean status=false;
//            try {
//                InetAddress ip=InetAddress.getByName("google.com");
//                status=!ip.equals("");
//
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            }
//
//            if(status==true)
//            {
//                DownloadManager.Request req= new DownloadManager.Request(Uri.parse(myurl));
//                req.allowScanningByMediaScanner();
//                req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//
//                DownloadManager dm=(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
//
//
//                dm.enqueue(req);
//            }

        }

    }
}
