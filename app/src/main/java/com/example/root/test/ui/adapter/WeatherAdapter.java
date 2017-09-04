package com.example.root.test.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.test.R;
import com.example.root.test.bean.WeatherInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */

public class WeatherAdapter extends BaseAdapter {
    private Context mContext;
    private List<WeatherInfo.DataBean.ForecastBean> datas;
    private LayoutInflater inflater;

    public WeatherAdapter(Context mContext, List<WeatherInfo.DataBean.ForecastBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ViewHolder holder;
        if (v == null) {
            v = inflater.inflate(R.layout.item_weather, viewGroup, false);
            holder = new ViewHolder(v);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        WeatherInfo.DataBean.ForecastBean forecastBean = datas.get(i);
        boolean isCurrent = i == 2;
        switch (forecastBean.getType()) {
            case "晴":
                holder.itemWeaIv.setBackgroundResource(isCurrent ? R.mipmap.current_fine : R.mipmap.fine);
                break;
            case "阵雨":
                holder.itemWeaIv.setBackgroundResource(isCurrent ? R.mipmap.current_rainy : R.mipmap.rainy);
                break;
            case "雷阵雨":
                holder.itemWeaIv.setBackgroundResource(isCurrent ? R.mipmap.current_thunder : R.mipmap.thunder);
                break;
            case "多云":
                holder.itemWeaIv.setBackgroundResource(isCurrent ? R.mipmap.current_overcast : R.mipmap.overcast);
                break;
            case "阴":
                holder.itemWeaIv.setBackgroundResource(isCurrent ? R.mipmap.current_cloudy : R.mipmap.cloudy);
                break;
        }
        holder.itemWeaTvType.setText(forecastBean.getType());
        holder.itemWeaTvDate.setText(forecastBean.getDate());
        holder.itemWeaTvAqi.setText("空气质量指数:" + forecastBean.getAqi());
        holder.itemWeaTvTemperature.setText(forecastBean.getLow() + " " + forecastBean.getHigh());
        holder.itemWeaTvWarn.setText("注意\n" + forecastBean.getNotice());
        holder.itemWeaTvWindDirection.setText(String.format("风向:%s 风级:%s", forecastBean.getFx(), forecastBean.getFl()));
        return v;
    }

    class ViewHolder {
        private ImageView itemWeaIv;
        private TextView itemWeaTvType;
        private TextView itemWeaTvDate;
        private TextView itemWeaTvWindDirection;
        private TextView itemWeaTvAqi;
        private TextView itemWeaTvTemperature;
        private TextView itemWeaTvWarn;

        public ViewHolder(View v) {
            itemWeaIv = (ImageView) v.findViewById(R.id.item_wea_iv);
            itemWeaTvType = (TextView) v.findViewById(R.id.item_wea_tv_type);
            itemWeaTvDate = (TextView) v.findViewById(R.id.item_wea_tv_date);
            itemWeaTvWindDirection = (TextView) v.findViewById(R.id.item_wea_tv_wind_direction);
            itemWeaTvAqi = (TextView) v.findViewById(R.id.item_wea_tv_aqi);
            itemWeaTvTemperature = (TextView) v.findViewById(R.id.item_wea_tv_temperature);
            itemWeaTvWarn = (TextView) v.findViewById(R.id.item_wea_tv_warn);
        }
    }
}
