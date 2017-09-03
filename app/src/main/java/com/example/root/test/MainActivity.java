package com.example.root.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.root.test.R;
import com.example.root.test.bean.ExpressInfo;
import com.example.root.test.bean.MusicInfo;
import com.example.root.test.netWork.HttpRequests;
import com.example.root.test.ui.activitys.ExpressActivity;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity {
    private ImageView mMainIvExp;

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
    }

    private void initData() {

    }

    private void initEvent() {
        mMainIvExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExpressActivity.class));
            }
        });
    }
}
