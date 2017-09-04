package com.example.root.test.presenter;

import com.example.root.test.MyApp;
import com.example.root.test.bean.WeatherInfo;
import com.example.root.test.contract.WeatherContract;
import com.example.root.test.netWork.HttpRequests;

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
        HttpRequests.SingletonHolder.getInstanceWeather().requesetWeather(new Subscriber<WeatherInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(WeatherInfo weatherInfo) {
                List<WeatherInfo.DataBean.ForecastBean> forecast = new ArrayList<>();
                forecast.add(weatherInfo.getData().getYesterday());
                forecast.addAll(weatherInfo.getData().getForecast());
                weatherContractView.showWeather(forecast);
                weatherContractView.showCurrentWeather(weatherInfo.getData());
            }
        }, MyApp.getCity());
    }
}
