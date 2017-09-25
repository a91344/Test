package com.example.root.test.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/9/25.
 */

public class WeatherCache extends DataSupport {
    private String city;
    private String json;

    public WeatherCache(String city, String json) {
        this.city = city;
        this.json = json;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Override
    public String toString() {
        return "WeatherCache{" +
                "city='" + city + '\'' +
                ", json='" + json + '\'' +
                '}';
    }
}
