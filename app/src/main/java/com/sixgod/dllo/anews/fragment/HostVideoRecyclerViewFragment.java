package com.sixgod.dllo.anews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.VideoView;

import com.sixgod.dllo.anews.base.BaseRecyclerViewFragment;
import com.sixgod.dllo.anews.bean.VideoData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.adapter.VideoAdapter;
import com.sixgod.dllo.anews.base.BaseRecyclerAdapter;
import com.sixgod.dllo.anews.net.NetListener;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/2.
 */
public class HostVideoRecyclerViewFragment extends BaseRecyclerViewFragment<VideoData> {
    private RecyclerView rv;
    private VideoAdapter adapter;
    private SwipeRefreshLayout refreshLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = (RecyclerView) view.findViewById(R.id.fragment_video_rv);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_video_refresh);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                helper.getInfo("http://c.m.163.com/nc/video/home/0-10.html", VideoData.class, new NetListener() {
                    @Override
                    public void getSucceed(Object o) {
                        VideoData data = (VideoData) o;
                        adapter.upData(data.getVideoList());
                        refreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void getFailed(String failed) {

                    }

                    @Override
                    public void getSucceed(ArrayList list) {

                    }
                });
            }
        });
    }

    @Override
    public void loadSucceed(VideoData videoData) {
        VideoData data =  videoData;
        adapter.refreshView(data.getVideoList());
    }

    @Override
    public String getHeadDefaultUrl() {
        return "http://c.m.163.com/nc/video/home";
    }

    @Override
    public String getBottomDefaultUrl() {
        return "-10.html";
    }

    @Override
    public int getMiddleDefaultUrl() {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public Class<VideoData> getDataCls() {
        return VideoData.class;
    }

    @Override
    public void netHasSucceed(Object o) {
        VideoData data = (VideoData) o;
        adapter = new VideoAdapter(rv, this, data.getVideoList());
        adapter.setContext(getActivity());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void netHasSucceedForList(ArrayList<VideoData> t) {

    }

    @Override
    public void netHasFailed(String failed) {

    }

    @Override
    protected BaseRecyclerAdapter getAdapter() {
        return null;
    }

    @Override
    protected void hasRefresh(ArrayList<VideoData> t) {

    }

    @Override
    protected void hasRefreshForJason(VideoData videoData) {

    }

    @Override
    protected void willRefresh() {
        Toast.makeText(getActivity(), "5555555555555", Toast.LENGTH_SHORT).show();
    }
}
