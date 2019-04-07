package com.seyoeng.alyou;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

public class alarm extends AppCompatActivity {

    private SeekBar seekBar;
    private EditText time;
    private Switch sw;
    private Button btn_apply;
    private Vibrator vib;
    private int strength, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        time = (EditText)findViewById(R.id.time);
        sw = (Switch)findViewById(R.id.sw);
        btn_apply = (Button)findViewById(R.id.btn_apply);
        vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        seekBar.setProgress(5);

        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strength = seekBar.getProgress();
                second = Integer.parseInt(time.getText().toString());
                Vibstrength(vib,strength);
                Vibtime(vib,second);
                Toast.makeText(alarm.this,"설정 완료",Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

    public void Vibstrength(Vibrator vib, int strength){
        Toast.makeText(alarm.this,strength,Toast.LENGTH_LONG).show();

        //진동세기 설정
    }

    public void Vibtime(Vibrator vib, int second){
        Toast.makeText(alarm.this,second,Toast.LENGTH_LONG).show();
        long[] pattern = {(second * 1000),1000};
        vib.vibrate(pattern,5);
        //진동 지속시간 설정
    }



}
