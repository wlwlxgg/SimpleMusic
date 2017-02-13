package com.example.wlwlxgg.simplemusic.domain;

import java.io.Serializable;

/**
 * Created by wlwlxgg on 2017/2/6.
 */

public class PlayList implements Serializable {
    private String cover_name;
    private int cover_num;
    //private int cover;

    public String getCover_name() {
        return cover_name;
    }

    public void setCover_name(String cover_name) {
        this.cover_name = cover_name;
    }

    public int getCover_num() {
        return cover_num;
    }

    public void setCover_num(int cover_num) {
        this.cover_num = cover_num;
    }

//    public int getCover() {
//        return cover;
//    }
//
//    public void setCover(int cover) {
//        this.cover = cover;
//    }
}
