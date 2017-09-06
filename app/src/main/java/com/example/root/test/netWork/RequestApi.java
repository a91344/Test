package com.example.root.test.netWork;


import com.example.root.test.bean.ExpressInfo;
import com.example.root.test.bean.CityInfo;
import com.example.root.test.bean.LocationInfo;
import com.example.root.test.bean.MusicInfo;
import com.example.root.test.bean.WeatherInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by root on 17-9-3.
 */

public interface RequestApi {
    @GET("search-ajaxsearch-searchall")
    Observable<MusicInfo> requestMusicInfos(@Query("kw") String name, @Query("pi") String pageNo, @Query("pz") String pageSize);

    @GET("query")
    Observable<ExpressInfo> requestExpressInfo(@Query("type") String type, @Query("postid") String postid);

    @GET("json")
    Observable<LocationInfo> requestLocation(@Query("lang") String lang);


    @GET("open/api/weather/json.shtml")
    Observable<WeatherInfo> requestWeather(@Query("city") String city);


}
