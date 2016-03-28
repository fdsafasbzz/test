package com.sixgod.dllo.anews.net;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/1.
 */
public interface NetListener<T> {
    void getSucceed(T t);
    void getFailed(String failed);
    void getSucceed(ArrayList<T> list);

}
