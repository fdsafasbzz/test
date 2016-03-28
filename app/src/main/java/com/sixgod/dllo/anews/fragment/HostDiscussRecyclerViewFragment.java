package com.sixgod.dllo.anews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixgod.dllo.anews.bean.DiscussData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.adapter.AttentionAdatper;
import com.sixgod.dllo.anews.adapter.DiscussAdapter;
import com.sixgod.dllo.anews.base.BaseRecyclerViewFragment;
import com.sixgod.dllo.anews.base.BaseRecyclerAdapter;
import com.sixgod.dllo.anews.db.Attention;
import com.sixgod.dllo.anews.net.NetListener;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/2.
 */
public class HostDiscussRecyclerViewFragment extends BaseRecyclerViewFragment<DiscussData> {
    private DiscussAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView attentionRv;
    private DrawerLayout drawerLayout;
    private AttentionAdatper attentionAdatper;
    private SwipeRefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discuss,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.discuss_vp);
        attentionRv = (RecyclerView) view.findViewById(R.id.discuss_left_drawer_rv);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_disscuss_refresh);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        attentionAdatper = new AttentionAdatper(getActivity());
        attentionRv.setAdapter(attentionAdatper);
        attentionRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                helper.getInfo("http://c.m.163.com/newstopic/list/expert/0-10.html", DiscussData.class, new NetListener() {
                    @Override
                    public void getSucceed(Object o) {
                        DiscussData data = (DiscussData) o;
                        adapter.upData(data.getData().getExpertList());
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
    public void loadSucceed(DiscussData discussData) {
        adapter.refreshView(discussData.getData().getExpertList());
    }

    @Override
    public String getHeadDefaultUrl() {
        return "http://c.m.163.com/newstopic/list/expert/";
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
    public Class<DiscussData> getDataCls() {
        return DiscussData.class;
    }

    @Override
    public void netHasSucceed(Object o) {
        DiscussData discussData = (DiscussData) o;
        adapter = new DiscussAdapter(recyclerView,this,discussData.getData().getExpertList());
        adapter.setListener(new DiscussAdapter.AttentionListener() {
            @Override
            public void attention(Attention attention) {
                attentionAdatper = new AttentionAdatper(getActivity());
                attentionRv.setAdapter(attentionAdatper);
                attentionRv.setLayoutManager(new LinearLayoutManager(getActivity()));
            }
        });
        adapter.setContext(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void netHasSucceedForList(ArrayList<DiscussData> t) {

    }

    @Override
    public void netHasFailed(String failed) {

    }

    @Override
    protected BaseRecyclerAdapter getAdapter() {
        return adapter;
    }

    @Override
    protected void hasRefresh(ArrayList<DiscussData> t) {

    }

    @Override
    protected void hasRefreshForJason(DiscussData discussData) {

    }

    @Override
    protected void willRefresh() {

    }
}
