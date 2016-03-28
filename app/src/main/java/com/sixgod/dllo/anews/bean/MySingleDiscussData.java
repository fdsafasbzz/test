package com.sixgod.dllo.anews.bean;

/**
 * Created by dllo on 16/3/14.
 */
public class MySingleDiscussData {
    private String id;
    private String title;

    public MySingleDiscussData(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public MySingleDiscussData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
