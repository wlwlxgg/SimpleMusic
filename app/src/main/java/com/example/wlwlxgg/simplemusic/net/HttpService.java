package com.example.wlwlxgg.simplemusic.net;

import com.example.wlwlxgg.simplemusic.domain.MusicInfo;
import com.example.wlwlxgg.simplemusic.domain.SearchResult;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by wlwlxgg on 2017/3/7.
 * 所有api接口方法
 */

public interface HttpService {
    /**
     * 搜索接口
     */
    @GET(URL.SEARCH)
    Call<SearchResult> getSearchRequest(@QueryMap HashMap<String, String> map);
    /**
     * 根据song_ID获取歌曲信息接口
     */
    @GET(URL.MUSICINFO)
    Call<MusicInfo> getMusicRequest(@Query("songIds") String songIds);

}
