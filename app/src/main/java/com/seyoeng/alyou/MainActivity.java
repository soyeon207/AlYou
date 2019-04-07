package com.seyoeng.alyou;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button town;
    private Button alarm;

    private static final int REQUEST_ENABLE_BT = 10;    //블루투스 활성화상태
    private BluetoothAdapter bluetoothAdapter;             //블루투스 어댑터

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        town = (Button)findViewById(R.id.btn_town);
        alarm = (Button)findViewById(R.id.btn_alarm);

        town.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,town.class);
                startActivity(intent);
            }
        });

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,alarm.class);
                startActivity(intent);
            }
        });

        checkBlueTooth();

    }

    public void checkBlueTooth() {
        //어댑터 가져오기
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter == null) {
            // 장치가 블루투스를 지원하지 않음.
            Toast.makeText(this,"어댑터",Toast.LENGTH_LONG).show();
        }

        else {
            // 장치가 블루투스를 지원
            if(!bluetoothAdapter.isEnabled()) {
                //블루투스 비활성상태 -> 활성상태
                Intent btIntent = new Intent(bluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(btIntent, REQUEST_ENABLE_BT);
            }

            else {
                //활성상태
                Toast.makeText(this,"연결 성공",Toast.LENGTH_LONG).show();

            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case REQUEST_ENABLE_BT:
                if(resultCode == RESULT_OK) {
                    //활성상태 -> 연결
                    Toast.makeText(this,"연결 성공",Toast.LENGTH_LONG).show();
                }
                else if(resultCode == RESULT_CANCELED) {
                    // 블루투스가 비활성상태
                    Toast.makeText(this,"블루투스 비활성",Toast.LENGTH_LONG).show();

                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }



}
