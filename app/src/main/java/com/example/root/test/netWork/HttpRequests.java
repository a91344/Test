package com.example.root.test.netWork;

import com.example.root.test.bean.MusicInfo;
import com.example.root.test.constant.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by root on 17-9-2.
 */

public class HttpRequests {
    private final RequestApi requestApi;

    public static class SingletonHolder{
        private static final HttpRequests INSTANCE=new HttpRequests();
        public static HttpRequests getInstance(){
            return SingletonHolder.INSTANCE;
        }
    }
    private HttpRequests(){
        OkHttpClient httpClient=new OkHttpClient.Builder().connectTimeout(5000, TimeUnit.SECONDS).build();
        Retrofit build = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .build();
        requestApi = build.create(RequestApi.class);
    }
    public void requestMusicInfo(Subscriber<MusicInfo> musicInfoSubscriber, String name, String pageNo, String pageSize){
        requestApi.requesetMusicInfos(name,pageNo,pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(musicInfoSubscriber);
    }
}
