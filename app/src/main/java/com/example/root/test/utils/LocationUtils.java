package com.example.root.test.utils;

import android.Manifest;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.example.root.test.MyApp;
import com.example.root.test.bean.LocationInfo;
import com.example.root.test.netWork.HttpRequests;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/9/4.
 */

public class LocationUtils implements LocationListener {
    private LocationManager myLocationManager;
    private String locationProvider;

    public LocationUtils() {
        this.myLocationManager = (LocationManager) MyApp.getMyAppContext().getSystemService(Context.LOCATION_SERVICE);
        getLocation();
    }

    private void getLocation() {
        //查找服务信息
        List<String> providers = myLocationManager.getProviders(true);
        if (providers.contains(LocationManager.GPS_PROVIDER)) {
            //如果是GPS
            locationProvider = LocationManager.GPS_PROVIDER;
        } else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
            //如果是Network
            locationProvider = LocationManager.NETWORK_PROVIDER;
        } else {
            return;
        }
        //获取Location
        if (ActivityCompat.checkSelfPermission(MyApp.getMyAppContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MyApp.getMyAppContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = myLocationManager.getLastKnownLocation(locationProvider);

        if (location != null) {
            //不为空,显示地理位置经纬度
            requesetLocation(location.getLatitude() + "," + location.getLongitude());
            return;
        }
        //监视地理位置变化
        if (ActivityCompat.checkSelfPermission(MyApp.getMyAppContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MyApp.getMyAppContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        myLocationManager.requestLocationUpdates(locationProvider, 3000, 1, this);
    }


    @Override
    public void onLocationChanged(final Location location) {
        if (location != null) {
            requesetLocation(location.getLatitude() + "," + location.getLongitude());
            myLocationManager.removeUpdates(this);
        }
        Log.i("AAA", "onLocationChanged: " + location.getLatitude() + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    private void requesetLocation(String location) {
        HttpRequests.SingletonHolder.getInstanceLocation().requestLocation(new Subscriber<LocationInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(LocationInfo locationInfo) {
                MyApp.setCity(locationInfo.getResult().getAddressComponent().getCity());
            }
        }, location);
    }
}
