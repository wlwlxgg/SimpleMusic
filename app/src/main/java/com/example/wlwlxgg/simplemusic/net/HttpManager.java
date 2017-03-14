package com.example.wlwlxgg.simplemusic.net;


import com.example.wlwlxgg.simplemusic.domain.MusicInfo;
import com.example.wlwlxgg.simplemusic.domain.SearchResult;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wlwlxgg on 2017/3/7.
 */

public class HttpManager {
    private static HttpService getService(String baseURl) {
        return new Retrofit.Builder()
                .baseUrl(baseURl)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(HttpService.class);
    }

    /**
     * 获取搜索结果的方法
     */
    public static Call<SearchResult> getSearchRequest(HashMap<String, String> map){
        Call<SearchResult> call = getService(URL.BASE_URL_SEARCH).getSearchRequest(map);
        return call;
    }

    /**
     * 获取歌曲信息的方法
     */
    public static Call<MusicInfo> getMusicRequest(String song_id)  {
        Call<MusicInfo> call = getService(URL.BASE_URL_MUSICINFO).getMusicRequest(song_id);
        return call;
    }
}
