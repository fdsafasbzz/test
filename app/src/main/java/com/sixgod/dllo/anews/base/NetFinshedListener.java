package com.sixgod.dllo.anews.base;

/**
 * Created by dllo on 16/3/1.
 */
public interface NetFinshedListener {
    void netHasFinshed(String url);
    //此方法在上一层调用来操作下一层
}
