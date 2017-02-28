package com.example.wlwlxgg.simplemusic.net;

import com.example.wlwlxgg.simplemusic.domain.MusicInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wlwlxgg on 2017/2/28.
 */

public interface GetMusicRequest {
    @GET("music/links?")
    Call<MusicInfo> getMusicRequest(@Query("songIds") String songIds);
}
