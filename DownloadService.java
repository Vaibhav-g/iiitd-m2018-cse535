package com.example.rk.mcassign2;

import android.app.DownloadManager;
import android.app.IntentService;

import android.content.Intent;

import android.net.Uri;

import android.support.annotation.Nullable;


public class DownloadService extends IntentService{


    public DownloadService() {
        super("DownloadIntentService");
    }

    public void onCreate(){
        super.onCreate();
    }

    @Override

//    public DownloadService(String name) {
//        super(name);
//    }

    protected void onHandleIntent(@Nullable Intent intent) {

        String myurl="faculty.iiitd.ac.in/~mukulika/s1.mp3";

        DownloadManager.Request req= new DownloadManager.Request(Uri.parse(myurl));
        req.allowScanningByMediaScanner();
        req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        DownloadManager dm;
        dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);


        dm.enqueue(req);

    }
}

