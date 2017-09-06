package com.example.root.test.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.example.root.test.MyApp;
import com.example.root.test.bean.CityInfo;
import com.example.root.test.bean.LocationInfo;
import com.example.root.test.netWork.HttpRequests;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

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
                MyApp.setCity(locationInfo.getCity());
            }
        });
    }
}
