package com.sixgod.dllo.anews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixgod.dllo.anews.base.BaseRecyclerViewFragment;
import com.sixgod.dllo.anews.bean.ReadData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.adapter.ReadAdapter;
import com.sixgod.dllo.anews.base.BaseRecyclerAdapter;
import com.sixgod.dllo.anews.net.NetListener;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/2.
 */
public class HostReadRecyclerViewFragment extends BaseRecyclerViewFragment<ReadData> {
    private RecyclerView recyclerView;
    private ReadAdapter adapter;
    private SwipeRefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_read, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.read_fragment_rv);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_read_refresh);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                helper.getInfo("http://c.3g.163.com/recommend/getSubDocNews?from=yuedu&passport=&devId=6PEGSk0qQoE1%2BjVlUNG4NNrJEaVlY1adMqVwjUV%2BaVVZlarSeCideUwwMq0spE4a&size=20&version=5.5.3&spever=false&net=wifi&lat=&lon=&ts=1456743641&sign=54nS%2FHtrdmSgMJg6ShnbeE60NKOplfwlm%2FhrGk2c6Z548ErR02zJ6%2FKXOnxX046I&encryption=1&canal=appstore推荐", ReadData.class, new NetListener() {
                    @Override
                    public void getSucceed(Object o) {
                        ReadData data = (ReadData) o;
                        adapter.upData(data.getRecommend());
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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //设置刷新时动画的颜色，可以设置4个
//        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
    }

    @Override
    public void loadSucceed(ReadData readData) {
        adapter.refreshView(readData.getRecommend());

    }

    @Override
    public String getHeadDefaultUrl() {
        return "http://c.3g.163.com/recommend/getSubDocNews?from=yuedu&passport=&devId=6PEGSk0qQoE1%2BjVlUNG4NNrJEaVlY1adMqVwjUV%2BaVVZlarSeCideUwwMq0spE4a&size=20&version=5.5.3&spever=false&net=wifi&lat=&lon=&ts=1456743641&sign=54nS%2FHtrdmSgMJg6ShnbeE60NKOplfwlm%2FhrGk2c6Z548ErR02zJ6%2FKXOnxX046I&encryption=1&canal=appstore推荐";
    }

    @Override
    public String getBottomDefaultUrl() {
        return "";
    }

    @Override
    public int getMiddleDefaultUrl() {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public Class<ReadData> getDataCls() {
        return ReadData.class;
    }

    @Override
    public void netHasSucceed(Object o) {
        ReadData data = (ReadData) o;
        adapter = new ReadAdapter(recyclerView, this, data.getRecommend());
        adapter.setContext(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void netHasSucceedForList(ArrayList<ReadData> t) {

    }

    @Override
    public void netHasFailed(String failed) {

    }

    @Override
    protected BaseRecyclerAdapter getAdapter() {
        return null;
    }

    @Override
    protected void hasRefresh(ArrayList<ReadData> t) {

    }

    @Override
    protected void hasRefreshForJason(ReadData readData) {

    }

    @Override
    protected void willRefresh() {

    }
}
