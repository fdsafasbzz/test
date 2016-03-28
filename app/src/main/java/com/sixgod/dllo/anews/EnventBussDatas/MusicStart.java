package com.sixgod.dllo.anews.EnventBussDatas;

/**
 * Created by dllo on 16/3/19.
 */
public class MusicStart {
    private String url;
    private int musicId;

    public MusicStart(String url, int musicId) {
        this.url = url;
        this.musicId = musicId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }
}
