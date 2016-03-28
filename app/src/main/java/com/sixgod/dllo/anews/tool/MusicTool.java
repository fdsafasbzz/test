package com.sixgod.dllo.anews.tool;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.sixgod.dllo.anews.bean.ListMusicData;
import com.sixgod.dllo.anews.bean.SingleMusicData;
import com.sixgod.dllo.anews.net.SingleQueue;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dllo on 16/3/19.
 */
public class MusicTool {
    private MediaPlayer mediaPlayer;
    private Context context;
    private RequestQueue requestQueue;
    private int musicId = 0;
    private ArrayList<String> postIds;

    public MusicTool(Context context, ArrayList<ListMusicData> listMusicDatas) {
        mediaPlayer = new MediaPlayer();
        this.context = context;
        postIds = new ArrayList<>();
        for (int i = 0; i < listMusicDatas.size(); i++) {
            postIds.add(listMusicDatas.get(i).getPostid());
        }
        requestQueue = SingleQueue.newSingleQueue().getRequestQueue();
    }

    public void startMusic(final String postID) {
        mediaPlayer.stop();
        mediaPlayer.reset();
        musicId = postIds.indexOf(postID);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://c.m.163.com/nc/article/" + postID + "/full.html ", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject o = response.getJSONObject(postID);
                    SingleMusicData data = new Gson().fromJson(o.toString(), SingleMusicData.class);
                    mediaPlayer.setDataSource(context, Uri.parse(data.getVideo().get(0).getUrl_mp4()));
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public void nextMusic() {
        if (musicId == postIds.size() - 1) {
            startMusic(postIds.get(0));
        } else {
            startMusic(postIds.get(musicId + 1));

        }
    }

    public void previousMusic() {
        if (musicId == 0) {

        } else {
            startMusic(postIds.get(musicId));

        }
    }
    public void stopMussic(){
        mediaPlayer.stop();
    }
    public void LoopMusic() {

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }

    }

}
