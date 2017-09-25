package com.example.root.test.utils;

import com.example.root.test.MyApp;
import com.example.root.test.bean.LocationInfo;
import com.example.root.test.network.HttpRequests;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/9/4.
 */

public class LocationUtils {
    public static void requestCity() {
        HttpRequests.SingletonHolder.getInstanceLocation().requestLocation(new Subscriber<LocationInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(LocationInfo locationInfo) {
                if (!MyApp.getCity().equals(locationInfo.getCity())) {
                    MyApp.setCity(locationInfo.getCity());
                } else {
                    MyApp.setIsWeatherCache(true);
                }
            }
        });
    }
}
