package com.example.wlwlxgg.simplemusic.net;

import com.example.wlwlxgg.simplemusic.domain.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wlwlxgg on 2017/2/27.
 */

public interface SearchRequest {
    @GET("restserver/ting?")
    Call<SearchResult> getSearchRequest(@Query("from") String from,
                                        @Query("version") String version,
                                        @Query("method") String method,
                                        @Query("format") String format,
                                        @Query("query") String query,
                                        @Query("page_no") String page_no,
                                        @Query("page_size") String page_size,
                                        @Query("type") String type,
                                        @Query("data_source") String data_source,
                                        @Query("use_cluster") String use_cluster);
}
