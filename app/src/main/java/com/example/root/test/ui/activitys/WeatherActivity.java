package com.example.root.test.ui.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.root.test.MyApp;
import com.example.root.test.R;
import com.example.root.test.bean.WeatherInfo;
import com.example.root.test.contract.WeatherContract;
import com.example.root.test.presenter.WeatherPresenter;
import com.example.root.test.ui.adapter.WeatherAdapter;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */

public class WeatherActivity extends AppCompatActivity implements WeatherContract.View {
    private LinearLayout weaLl;
    private TextView weaTvCity;
    private TextView weaTvTemperatureOrQuality;
    private TextView weaTvPm;
    private TextView weaTvHumidity;
    private TextView weaTvNotice;
    private ListView weaLvDatas;
    private WeatherContract.Presenter presenter;
    private List<WeatherInfo.DataBean.ForecastBean> datas;
    private WeatherAdapter weatherAdapter;
    private QMUITipDialog qmuiTipDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_weather);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        weaLl = (LinearLayout) findViewById(R.id.wea_ll);
        weaTvCity = (TextView) findViewById(R.id.wea_tv_city);
        weaTvTemperatureOrQuality = (TextView) findViewById(R.id.wea_tv_temperature_or_quality);
        weaTvPm = (TextView) findViewById(R.id.wea_tv_pm);
        weaTvHumidity = (TextView) findViewById(R.id.wea_tv_humidity);
        weaTvNotice = (TextView) findViewById(R.id.wea_tv_notice);
        weaLvDatas = (ListView) findViewById(R.id.wea_lv_datas);
    }

    private void initData() {
        new WeatherPresenter(this);

        datas = new ArrayList<>();
        weatherAdapter = new WeatherAdapter(this, datas);
        weaLvDatas.setAdapter(weatherAdapter);

        QMUITipDialog.Builder builder = new QMUITipDialog.Builder(this);
        builder.setTipWord("正在加载");
        builder.setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING);
        qmuiTipDialog = builder.create();

        presenter.start();
    }

    private void initEvent() {

    }

    @Override
    public void setPresenter(WeatherContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showWeather(List<WeatherInfo.DataBean.ForecastBean> datas) {
        this.datas.clear();
        this.datas.removeAll(this.datas);
        this.datas.addAll(datas);
        weatherAdapter.notifyDataSetChanged();
        weaLl.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCurrentWeather(WeatherInfo.DataBean dataBean) {
        weaTvCity.setText(MyApp.getCity());
        weaTvTemperatureOrQuality.setText(String.format("温度:%s\n质量:%s", dataBean.getWendu(), dataBean.getQuality()));
        weaTvPm.setText(String.format("PM2.5:%s\nPM1.0:%s", dataBean.getPm25(), dataBean.getPm10()));
        weaTvHumidity.setText(String.format("湿度:%s", dataBean.getShidu()));
        weaTvNotice.setText(String.format("提示:%s", dataBean.getGanmao()));
    }

    @Override
    public void hideProgressDialog() {
        qmuiTipDialog.dismiss();
        qmuiTipDialog.hide();
    }

    @Override
    public void showProgressDialog() {
        qmuiTipDialog.show();
    }
}
