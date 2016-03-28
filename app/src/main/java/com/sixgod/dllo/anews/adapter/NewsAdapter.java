package com.sixgod.dllo.anews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentStatePagerAdapter;

import com.sixgod.dllo.anews.bean.ChooseNewsData;

import com.sixgod.dllo.anews.fragment.NewsRecyclerViewFragment;

import java.util.List;

/**
 * Created by dllo on 16/3/2.
 */
public class NewsAdapter extends FragmentStatePagerAdapter {
     private List<ChooseNewsData> data;
     private static NewsAdapter adapter;


    private NewsAdapter(FragmentManager fm) {
        super(fm);
    }
    public static NewsAdapter newNewsAdapter(FragmentManager fm){
        if (adapter==null){
            adapter = new NewsAdapter(fm);
        }
        return adapter;
    }
    public void upData(List<ChooseNewsData> datas){
        this.data = datas;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
//        NewsRecyclerViewFragment fragment = (NewsRecyclerViewFragment) fragments.get(position);
//        NetFinshedListener listener = fragment;
//        String url = data.getTList().get(position).getTid();
//        listener.netHasFinshed(url);
//        NewsRecyclerViewFragment fragment = new NewsRecyclerViewFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("url" ,data.get(position).getTid());
//        fragment.setArguments(bundle);
        return NewsRecyclerViewFragment.newFragment(data.get(position).getUrl());
    }

    @Override
    public int getCount() {
        return data!=null&&data.size()>0?data.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getTitle();
    }
}
