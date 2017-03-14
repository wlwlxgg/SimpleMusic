package com.example.wlwlxgg.simplemusic.net;

import com.example.wlwlxgg.simplemusic.domain.MusicInfo;
import com.example.wlwlxgg.simplemusic.domain.SearchResult;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

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
    /**
     * 下载歌曲接口
     */
    @GET
    rx.Observable<ResponseBody> download(@Header("RANGE") String start, @Url String url);

}
