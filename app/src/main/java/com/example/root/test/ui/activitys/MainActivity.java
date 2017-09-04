package com.example.root.test.ui.activitys;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.root.test.R;

public class MainActivity extends AppCompatActivity {
    private ImageView mMainIvExp;
    private ImageView mainIvWea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mMainIvExp = (ImageView) findViewById(R.id.main_iv_exp);
        mainIvWea = (ImageView) findViewById(R.id.main_iv_wea);
    }

    private void initData() {
//        Intent locationIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//        startActivity(locationIntent);
    }

    private void initEvent() {
        mMainIvExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExpressActivity.class));
            }
        });
        mainIvWea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WeatherActivity.class));
            }
        });
    }
}
