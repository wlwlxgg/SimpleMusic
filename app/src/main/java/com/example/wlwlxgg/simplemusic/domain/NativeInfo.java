package com.example.wlwlxgg.simplemusic.domain;

import java.io.Serializable;

/**
 * Created by wlwlxgg on 2017/3/7.
 */

public class NativeInfo implements Serializable {
    private String albumLink;
    private String albumName;
    private String lrcLink;
    private String singerName;
    private String songId;
    private String songLink;
    private String songName;
    private String userName;
    private String isDownload;
    private String songPath;
    private String downloadProgress;

    public String getAlbumLink() {
        return albumLink;
    }

    public void setAlbumLink(String albumLink) {
        this.albumLink = albumLink;
    }

    public String getDownloadProgress() {
        return downloadProgress;
    }

    public void setDownloadProgress(String downloadProgress) {
        this.downloadProgress = downloadProgress;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getLrcLink() {
        return lrcLink;
    }

    public void setLrcLink(String lrcLink) {
        this.lrcLink = lrcLink;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIsDownload() {
        return isDownload;
    }

    public void setIsDownload(String isDownload) {
        this.isDownload = isDownload;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }
}
