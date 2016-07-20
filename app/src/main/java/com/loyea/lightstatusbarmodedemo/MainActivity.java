package com.loyea.lightstatusbarmodedemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isLightStatusBarNow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView sysInfoTv = (TextView) findViewById(R.id.tv_sys_info);
        TextView hintTv = (TextView) findViewById(R.id.tv_hint);
        Button switchBtn = (Button) findViewById(R.id.btn_switch);

        sysInfoTv.setText(Build.BRAND + " - " + Build.MODEL + " - SDK Version:" + Build.VERSION.SDK_INT);

        switch (RomUtils.getLightStatausBarAvailableRomType()) {
            case RomUtils.AvailableRomType.MIUI:
                hintTv.setText("当前系统为MIUI6或以上 浅色状态栏可用");
                break;

            case RomUtils.AvailableRomType.FLYME:
                hintTv.setText("当前系统为Flyme4或以上 浅色状态栏可用");
                break;

            case RomUtils.AvailableRomType.ANDROID_NATIVE:
                hintTv.setText("当前系统为Android M或以上 浅色状态栏可用");
                break;

            case RomUtils.AvailableRomType.NA:
                hintTv.setText("当前系统浅色状态栏不可用");
                switchBtn.setEnabled(false);
                switchBtn.setText("light status bar mode not available");
                break;
        }

        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLightStatusBarNow) {
                    LightStatusBarUtils.setLightStatusBar(MainActivity.this, false);
                    isLightStatusBarNow = false;
                } else {
                    LightStatusBarUtils.setLightStatusBar(MainActivity.this, true);
                    isLightStatusBarNow = true;
                }

            }
        });


    }

}
