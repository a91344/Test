package com.example.root.test;

import android.app.Application;
import android.content.Context;

import com.example.root.test.utils.LocationUtils;

/**
 * Created by Administrator on 2017/9/4.
 */

public class MyApp extends Application {
    private static Context mContext;
    private static String city = "北京";

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        LocationUtils locationUtil = new LocationUtils();
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
}
