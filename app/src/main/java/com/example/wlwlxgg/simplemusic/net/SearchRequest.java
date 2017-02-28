package com.example.wlwlxgg.simplemusic.net;

import com.example.wlwlxgg.simplemusic.domain.SearchResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by wlwlxgg on 2017/2/27.
 */

public interface SearchRequest {
    @GET("restserver/ting?")
    Call<SearchResult> getSearchRequest(@QueryMap Map<String, String> map);
}
