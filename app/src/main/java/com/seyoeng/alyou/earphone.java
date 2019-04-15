package com.seyoeng.alyou;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.util.Log;

public class earphone extends AppCompatActivity {

    private IntentFilter intentFilter;
    private BroadcastReceiver broadcastReceiver;
    private boolean isEarphoneON;

    public void onCreate() {
        intentFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                isEarphoneON = (intent.getIntExtra("state",0)>0)?true:false;
            }
        };

        registerReceiver(broadcastReceiver,intentFilter);

        if(isEarphoneON){
            Log.i("이어폰","있음");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
