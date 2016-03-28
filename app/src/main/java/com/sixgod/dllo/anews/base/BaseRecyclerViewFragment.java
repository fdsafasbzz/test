package com.sixgod.dllo.anews.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.sixgod.dllo.anews.net.NetHelper;
import com.sixgod.dllo.anews.net.NetListener;

import java.util.ArrayList;


/**
 * Created by dllo on 16/3/1.
 */
public abstract class BaseRecyclerViewFragment<T> extends Fragment implements NetFinshedListener, LoadListener {
    private boolean ActivityNetHasFinshed;
    private String defaultHeadUrl, defaultBottomUrl;
    private Class<T> tClass;
    private String allUrl;
    private int middleDefaultUrl;
    protected NetHelper helper;
    protected String url;
    private BaseRecyclerAdapter<T> adapter;
    private int itemCount;
    protected String refreshUrl;
    protected int middleUrl;
    private boolean firstScroll = true;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ActivityNetHasFinshed = false;


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        defaultHeadUrl = getHeadDefaultUrl();
        defaultBottomUrl = getBottomDefaultUrl();
        middleDefaultUrl = getMiddleDefaultUrl();
        middleUrl = middleDefaultUrl;
        tClass = getDataCls();
        itemCount = getItemCount();
        helper = new NetHelper();
        if (url == null) {
            url = "";
        }
        refreshUrl = url;

        String a ="/" +middleDefaultUrl;
        if (itemCount==0){
               a="";
            Log.i("nnnnnnnnn",defaultHeadUrl+url+a+defaultBottomUrl);
        }

        helper.getInfo(defaultHeadUrl, url,  a, defaultBottomUrl, tClass, new NetListener<T>() {
            @Override
            public void getSucceed(T t) {
                netHasSucceed(t);
            }


            @Override
            public void getFailed(String failed) {
                netHasFailed(failed);
            }

            @Override
            public void getSucceed(ArrayList<T> list) {
                netHasSucceedForList(list);
            }
        });


    }

    @Override
    public void netHasFinshed(String url) {
        this.url = url;
    }

    @Override
    public void refresh() {


            middleDefaultUrl += itemCount;
            if (url == null) {
                url = "";
            }
            String a = "/" + middleDefaultUrl;
            if (itemCount == 0) {
                a = "";
            }
            allUrl = defaultHeadUrl + url + "/" + middleDefaultUrl + defaultBottomUrl;

            helper.getInfo(defaultHeadUrl, url, a, defaultBottomUrl, tClass, new NetListener<T>() {
                @Override
                public void getSucceed(T t) {
                    loadSucceed(t);
                }

                @Override
                public void getFailed(String failed) {
                    netHasFailed(failed);
                }

                @Override
                public void getSucceed(ArrayList<T> list) {

                    adapter = getAdapter();
                    adapter.refreshView(list);
                    firstScroll =true;
                }
            });

    }//到底刷新执行

    @Override
    public void topRefresh() {
        willRefresh();
        if (refreshUrl == null) {
            refreshUrl = "";
        }
        helper.getInfo(defaultHeadUrl, refreshUrl, "/" + middleUrl, defaultBottomUrl, tClass, new NetListener<T>() {
            @Override
            public void getSucceed(T t) {
                hasRefreshForJason(t);

            }


            @Override
            public void getFailed(String failed) {

            }

            @Override
            public void getSucceed(ArrayList<T> list) {
                adapter = getAdapter();
                Log.i("ppto", "刷新");
                adapter.refreshView(list);
                hasRefresh(list);
            }
        });
    }

//    @Override
//    public void topRefresh() {
//        Log.i("444^^^^^^^^^^^^^","ttttttttttttttttttt");
//        willRefresh();
//        helper.getInfo(defaultHeadUrl, refreshUrl,"/"+middleDefaultUrl, defaultBottomUrl, tClass, new NetListener<T>() {
//            @Override
//            public void getSucceed(T t) {
//
//
//            }
//
//
//            @Override
//            public void getFailed(String failed) {
//
//            }
//
//            @Override
//            public void getSucceed(ArrayList<T> list) {
//
//                hasRefresh(list);
//            }
//        });
//    }
    public abstract void loadSucceed(T t);
    public abstract String getHeadDefaultUrl();

    public abstract String getBottomDefaultUrl();

    public abstract int getMiddleDefaultUrl();

    public abstract int getItemCount();

    public abstract Class<T> getDataCls();

    public abstract void netHasSucceed(Object o);

    public abstract void netHasSucceedForList(ArrayList<T> t);

    public abstract void netHasFailed(String failed);

    protected abstract BaseRecyclerAdapter getAdapter();

    protected abstract void hasRefresh(ArrayList<T> t);

    protected abstract void hasRefreshForJason(T t);

    protected abstract void willRefresh();
}