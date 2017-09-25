package com.example.root.test.presenter;

import android.os.Handler;
import android.util.Log;

import com.example.root.test.MyApp;
import com.example.root.test.bean.WeatherInfo;
import com.example.root.test.contract.WeatherContract;
import com.example.root.test.db.WeatherCache;
import com.example.root.test.network.HttpRequests;
import com.google.gson.Gson;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/9/4.
 */

public class WeatherPresenter implements WeatherContract.Presenter {
    private WeatherContract.View weatherContractView;

    public WeatherPresenter(WeatherContract.View weatherContractView) {
        this.weatherContractView = weatherContractView;
        weatherContractView.setPresenter(this);
    }

    @Override
    public void start() {
        if (MyApp.isIsWeatherCache()) {
            WeatherInfo weatherInfo = new Gson().fromJson(DataSupport.findFirst(WeatherCache.class).getJson(), WeatherInfo.class);
            List<WeatherInfo.DataBean.ForecastBean> forecast = new ArrayList<>();
            forecast.add(weatherInfo.getData().getYesterday());
            forecast.addAll(weatherInfo.getData().getForecast());
            weatherContractView.showWeather(forecast);
            weatherContractView.showCurrentWeather(weatherInfo.getData());
        } else {
            HttpRequests.SingletonHolder.getInstanceWeather().requesetWeather(new Subscriber<WeatherInfo>() {
                @Override
                public void onStart() {
                    super.onStart();
                    weatherContractView.showProgressDialog();
                }

                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            weatherContractView.hideProgressDialog();
                        }
                    }, 1000);
                }

                @Override
                public void onNext(final WeatherInfo weatherInfo) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            weatherContractView.hideProgressDialog();
                            Log.i("AAA", "onNext: " + weatherInfo.toString());
                            List<WeatherInfo.DataBean.ForecastBean> forecast = new ArrayList<>();
                            forecast.add(weatherInfo.getData().getYesterday());
                            forecast.addAll(weatherInfo.getData().getForecast());
                            weatherContractView.showWeather(forecast);
                            weatherContractView.showCurrentWeather(weatherInfo.getData());
                            DataSupport.deleteAll(WeatherCache.class);
                            new WeatherCache(weatherInfo.getCity(), new Gson().toJson(weatherInfo)).save();
                        }
                    }, 1000);
                }
            }, MyApp.getCity());
        }
    }
}
