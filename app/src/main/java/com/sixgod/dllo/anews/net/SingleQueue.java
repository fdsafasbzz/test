package com.sixgod.dllo.anews.net;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.sixgod.dllo.anews.base.BaseApplication;

/**
 * Created by dllo on 16/3/1.
 */
public class SingleQueue {
    private static SingleQueue singleQueue;
    private RequestQueue requestQueue;


    private SingleQueue() {
        super();
        requestQueue = Volley.newRequestQueue(BaseApplication.getContext());
    }

    public static SingleQueue newSingleQueue(){
        if (singleQueue==null) {
            synchronized (SingleQueue.class) {
                if (singleQueue == null) {
                    singleQueue = new SingleQueue();

                }
            }
        }
        return singleQueue;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
