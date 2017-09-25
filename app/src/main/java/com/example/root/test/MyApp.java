package com.example.root.test;

import android.app.Application;
import android.content.Context;

import com.example.root.test.db.WeatherCache;
import com.example.root.test.utils.LocationUtils;

import org.litepal.LitePalApplication;
import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/9/4.
 */

public class MyApp extends LitePalApplication {
    private static Context mContext;
    private static String city = "北京";
    private static boolean isWeatherCache = false;

    @Override
    public void onCreate() {
        super.onCreate();
        WeatherCache first = DataSupport.findFirst(WeatherCache.class);
        if (first != null) {
            city = first.getCity();
        }
        mContext = getApplicationContext();
        LocationUtils.requestCity();
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        MyApp.city = city;
    }

    public static Context getMyAppContext() {
        return mContext;
    }

    public static boolean isIsWeatherCache() {
        return isWeatherCache;
    }

    public static void setIsWeatherCache(boolean isWeatherCache) {
        MyApp.isWeatherCache = isWeatherCache;
    }
}
