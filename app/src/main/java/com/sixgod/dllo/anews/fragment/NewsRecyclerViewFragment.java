package com.sixgod.dllo.anews.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sixgod.dllo.anews.base.BaseRecyclerViewFragment;
import com.sixgod.dllo.anews.bean.CategoryNewsData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.adapter.NewsCategoryAdapter;
import com.sixgod.dllo.anews.base.BaseApplication;
import com.sixgod.dllo.anews.base.BaseRecyclerAdapter;
import com.sixgod.dllo.anews.base.NetFinshedListener;
import com.sixgod.dllo.anews.net.NetHelper;
import com.sixgod.dllo.anews.net.NetListener;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/1.
 */
public class NewsRecyclerViewFragment extends BaseRecyclerViewFragment<CategoryNewsData> implements NetFinshedListener {
    private String newsUrl;
    private RecyclerView recyclerView;
    private NewsCategoryAdapter testAdapter;
    private LinearLayoutManager manager;
    private Context context;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textView;
    private NetHelper helper = new NetHelper();

    public static NewsRecyclerViewFragment newFragment(String url) {
        NewsRecyclerViewFragment fragment = new NewsRecyclerViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, null);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.fragment_news_tv);
        recyclerView = (RecyclerView) view.findViewById(R.id.news_rv);
        url = getArguments().getString("url");
//        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.news_refresh_layout);
//        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public String getHeadDefaultUrl() {
        return "http://c.m.163.com/nc/article/list/";
    }

    @Override
    public String getBottomDefaultUrl() {
        return "-20.html";
    }

    @Override
    public int getMiddleDefaultUrl() {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public Class<CategoryNewsData> getDataCls() {
        return CategoryNewsData.class;
    }

    @Override
    public void netHasSucceed(Object o) {

    }

    @Override
    public void netHasSucceedForList(ArrayList<CategoryNewsData> t) {
        manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        testAdapter = new NewsCategoryAdapter(recyclerView, this, t);
        testAdapter.setContext(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(testAdapter);

    }

    @Override
    public void netHasFailed(String failed) {

    }


    @Override
    protected BaseRecyclerAdapter getAdapter() {
        return testAdapter;
    }

    @Override
    protected void hasRefresh(ArrayList<CategoryNewsData> t) {
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(testAdapter);

    }

    @Override
    protected void hasRefreshForJason(CategoryNewsData categoryNewsData) {

    }

    @Override
    protected void willRefresh() {

    }


    @Override
    public void topRefresh() {
        Toast.makeText(BaseApplication.getContext(), "1111111111", Toast.LENGTH_SHORT).show();
        textView.setVisibility(View.VISIBLE);
        helper.getInfo("http://c.m.163.com/nc/article/list/" , url , "/0","-20.html", CategoryNewsData.class, new NetListener() {
            @Override
            public void getSucceed(Object o) {

            }

            @Override
            public void getFailed(String failed) {

            }

            @Override
            public void getSucceed(ArrayList list) {
               textView.setVisibility(View.INVISIBLE);
                testAdapter.upData(list);
            }
        });

    }

    @Override
    public void loadSucceed(CategoryNewsData categoryNewsData) {

    }


    //
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        Log.i("1createfragment","5555555555555");
//        NetHelper  helper = new NetHelper();
////        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
////        recyclerView.setAdapter(testAdapter);
//        Log.i("6666url","http://c.m.163.com/nc/article/list/" + url + "/0-20.html");
////        left.setText("http://c.m.163.com/nc/article/list/" + url + "/0-20.html");
//        helper.getInfo("http://c.m.163.com/nc/article/list/" ,url ,"/0", "-20.html", CategoryNewsData.class, new NetListener<CategoryNewsData>() {
//
//            @Override
//            public void getSucceed(CategoryNewsData typeNewsData) {
//
//            }
//
//            @Override
//            public void getFailed(String failed) {
//
//            }
//
//            @Override
//            public void getSucceed(ArrayList<CategoryNewsData> list) {
//                Log.i("list",list.toString());
//                testAdapter = new TestAdapter(list);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//                recyclerView.setAdapter(testAdapter);
//
////              right.setText(list.get(2).getTitle());
//            }
//
//        });
//
//    }
//
//
//    public  void setUrl(String urls) {
////        left.setText(url);
//        url = urls;
//    }
}
