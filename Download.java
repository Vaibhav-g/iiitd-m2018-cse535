package com.example.rk.mcassign2;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.UnknownHostException;



public class Download extends AsyncTask<Void,Void,Void> {
//
//    public Download(Context mcontext){
//
//    Context=mcontext;
//
//    }


    @Override
    protected Void doInBackground(Void... voids) {
//        String myurl="faculty.iiitd.ac.in/~mukulika/s1.mp3";
//
//        DownloadManager.Request req= new DownloadManager.Request(Uri.parse(myurl));
//        req.allowScanningByMediaScanner();
//        req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//
//        DownloadManager dm;
//        dm = (DownloadManager) Context.getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
//
//
//        dm.enqueue(req);
//
//



        return null;
    }


    protected void onPostExecute(Void result)
    {
       // super.onPostExecute(result);
     //   Toast.makeText(this,"Download Completed",Toast.LENGTH_SHORT).show();
    }
}
