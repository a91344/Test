package com.example.root.test.contract;

import com.example.root.test.BasePresenter;
import com.example.root.test.BaseView;
import com.example.root.test.bean.WeatherInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */

public interface WeatherContract {
    interface View extends BaseView<Presenter> {
        void showWeather(List<WeatherInfo.DataBean.ForecastBean> datas);

        void showCurrentWeather(WeatherInfo.DataBean dataBean);
    }

    interface Presenter extends BasePresenter {
    }
}
