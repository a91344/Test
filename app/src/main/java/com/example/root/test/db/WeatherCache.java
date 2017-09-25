package com.example.root.test.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/9/25.
 */

public class WeatherCache extends DataSupport {
    private String json;

    public WeatherCache(String json) {
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
