package com.sixgod.dllo.anews.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dllo on 16/3/8.
 */
public class ChooseNewsData implements Parcelable{
    private String title;
    private String url;

    public ChooseNewsData(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public ChooseNewsData() {
        super();
    }

    protected ChooseNewsData(Parcel in) {
        title = in.readString();
        url = in.readString();
    }

    public static final Creator<ChooseNewsData> CREATOR = new Creator<ChooseNewsData>() {
        @Override
        public ChooseNewsData createFromParcel(Parcel in) {
            return new ChooseNewsData(in);
        }

        @Override
        public ChooseNewsData[] newArray(int size) {
            return new ChooseNewsData[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(url);
    }
}
