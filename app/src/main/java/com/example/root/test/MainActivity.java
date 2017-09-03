package com.example.root.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.root.test.bean.MusicInfo;
import com.example.root.test.netWork.HttpRequests;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpRequests.SingletonHolder.getInstance().requestMusicInfo(new Subscriber<MusicInfo>() {
            @Override
            public void onCompleted() {
                
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MusicInfo musicInfo) {
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        },"爱",1+"",10+"");
        
    }
}
