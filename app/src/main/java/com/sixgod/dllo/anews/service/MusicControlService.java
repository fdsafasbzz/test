package com.sixgod.dllo.anews.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.sixgod.dllo.anews.EnventBussDatas.MusicStart;
import com.sixgod.dllo.anews.EnventBussDatas.NextMusic;
import com.sixgod.dllo.anews.EnventBussDatas.PeriousMusic;
import com.sixgod.dllo.anews.EnventBussDatas.StopMusic;
import com.sixgod.dllo.anews.bean.ListMusicData;
import com.sixgod.dllo.anews.bean.SingleMusicData;
import com.sixgod.dllo.anews.net.SingleQueue;
import com.sixgod.dllo.anews.tool.MusicTool;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by dllo on 16/3/19.
 */
public class MusicControlService extends Service {
    private MusicTool tool;
    private int MusicId = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onEvent(ArrayList<ListMusicData> listMusicDatas) {
        tool = new MusicTool(this, listMusicDatas);
        tool.startMusic(listMusicDatas.get(0).getPostid());
    }

    public void onEvent(MusicStart start) {
        tool.startMusic(start.getUrl());
    }
    public void onEvent(NextMusic start) {
        tool.nextMusic();
    }
    public void onEvent(PeriousMusic start) {
        tool.previousMusic();
    }
    public void onEvent(StopMusic start) {
        tool.stopMussic();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
