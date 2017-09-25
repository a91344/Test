package com.example.root.test.network;

import com.example.root.test.bean.ExpressInfo;
import com.example.root.test.bean.LocationInfo;
import com.example.root.test.bean.MusicInfo;
import com.example.root.test.bean.WeatherInfo;
import com.example.root.test.constant.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by root on 17-9-2.
 */

public class HttpRequests {
    private final RequestApi requestApi;

    public static class SingletonHolder {
        private static final HttpRequests INSTANCE_MUSIC = new HttpRequests(Constants.BASE_MUSIC_URL);
        private static final HttpRequests INSTANCE_EXPRESS = new HttpRequests(Constants.BASE_EXPRESS_URL);
        private static final HttpRequests INSTANCE_LOCATION = new HttpRequests(Constants.BASE_LOCATION_URL);
        private static final HttpRequests INSTANCE_WEATHER = new HttpRequests(Constants.BASE_WEATHER_URL);

        public static HttpRequests getInstanceMusic() {
            return SingletonHolder.INSTANCE_MUSIC;
        }

        public static HttpRequests getInstanceExpress() {
            return SingletonHolder.INSTANCE_EXPRESS;
        }

        public static HttpRequests getInstanceLocation() {
            return SingletonHolder.INSTANCE_LOCATION;
        }


        public static HttpRequests getInstanceWeather() {
            return SingletonHolder.INSTANCE_WEATHER;
        }
    }

    private HttpRequests(String url) {
        OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(Constants.CONNECT_TIME_OUT, TimeUnit.SECONDS).build();
        Retrofit build = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .build();
        requestApi = build.create(RequestApi.class);
    }

    public void requestMusicInfo(Subscriber<MusicInfo> musicInfoSubscriber, String name, String pageNo, String pageSize) {
        requestApi.requestMusicInfos(name, pageNo, pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(musicInfoSubscriber);
    }

    public void requestExpressInfo(Subscriber<ExpressInfo> expressInfoSubscriber, String type, String postid) {
        requestApi.requestExpressInfo(type, postid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(expressInfoSubscriber);
    }

    public void requestLocation(Subscriber<LocationInfo> locationInfoSubscriber) {
        requestApi.requestLocation("zh-CN")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(locationInfoSubscriber);
    }

    public void requesetWeather(Subscriber<WeatherInfo> weatherInfoSubscriber, String city) {
        requestApi.requestWeather(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherInfoSubscriber);
    }
}
