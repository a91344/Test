package com.example.root.test.netWork;


import com.example.root.test.bean.MusicInfo;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by root on 17-9-3.
 */

public interface RequestApi {
    @GET("search-ajaxsearch-searchall")
    Observable<MusicInfo> requesetMusicInfos(@Query("kw") String name, @Query("pi") String pageNo, @Query("pz") String pageSize);

}
