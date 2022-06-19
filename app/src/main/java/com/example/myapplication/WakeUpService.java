package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.EditText;


public class WakeUpService extends Service {
    public WakeUpService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("hello","开始计时");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e("hello","服务进行中");
        Log.e("hello","extras="+intent.getExtras().get("checktime"));
        startAlarmNow((Integer) intent.getExtras().get("checktime"));
        return super.onStartCommand(intent, flags, startId);

    }

    void startAlarmNow(int sec){
        
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("hello","服务已关闭");
//        Intent localIntent = new Intent();
//        localIntent.setClass(this, WakeUpService.class); //销毁时重新启动Service
//        this.startService(localIntent);
    }
}