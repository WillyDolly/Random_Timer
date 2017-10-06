package com.popland.pop.random_timer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
CountDownTimer cdt;
    TextView txtv, txtvTimeRun, txtvTimeRemain;
    int G = 0, K = 0;
    int secondsLeft = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
         txtv = (TextView)findViewById(R.id.TV);
        Button btnGo = (Button)findViewById(R.id.BTNgo);
        Button btnTimer = (Button)findViewById(R.id.BTNtimer);
        Button btnStop = (Button)findViewById(R.id.BTNstop);
        txtvTimeRun = (TextView)findViewById(R.id.TVtimerun);
        txtvTimeRemain = (TextView)findViewById(R.id.TVtimeremain);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Random r = new Random();
               int m = 123456789 + r.nextInt(999999999);
               int n = 123456789 + r.nextInt(999999999);
               String tong = String.valueOf(m)+String.valueOf(n);
               txtv.setText(tong);
            }
        });

        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdt = new CountDownTimer(10000, 100) {
                    @Override
                    public void onTick(long ms) {
                        if (Math.round((float)ms/1000.0f)!= secondsLeft){
                           secondsLeft = Math.round((float)ms/1000.0f);
                           txtvTimeRun.setText(secondsLeft+"");
                        }
                      Log.i("test","ms="+ms+" till finished ="+secondsLeft);
                    }

                    @Override
                    public void onFinish() {
                         txtvTimeRun.setText("0");
                    }
                }.start();
            }
        });
          btnStop.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  cdt.cancel();
              }

          });
    }

}
