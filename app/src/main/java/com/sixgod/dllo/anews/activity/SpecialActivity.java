package com.sixgod.dllo.anews.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonObject;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.base.BaseActivity;
import com.sixgod.dllo.anews.net.SingleQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dllo on 16/3/17.
 */
public class SpecialActivity extends BaseActivity{
    private String sId;
    private RequestQueue queue;
    @Override
    protected void initView() {
    queue = SingleQueue.newSingleQueue().getRequestQueue();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        sId = intent.getStringExtra("sid");
        Log.i("json","http://c.m.163.com/nc/special/" + sId + ".html");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://c.m.163.com/nc/special/" + sId + ".html", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray(sId);
                    Log.i("json",array.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

queue.add(jsonObjectRequest);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_special;
    }


    class SpecialAdapter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
        class SpecialHeadHolder extends RecyclerView.ViewHolder{

            public SpecialHeadHolder(View itemView) {
                super(itemView);
            }
        }
        class SpecialCotentHolder extends RecyclerView.ViewHolder{

            public SpecialCotentHolder(View itemView) {
                super(itemView);
            }
        }


    }
}
