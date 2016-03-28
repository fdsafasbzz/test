package com.sixgod.dllo.anews.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.sixgod.dllo.anews.bean.ChooseNewsData;
import com.sixgod.dllo.anews.bean.WholeData;
import com.sixgod.dllo.anews.R;

import com.sixgod.dllo.anews.activity.TodayNewsActivity;
import com.sixgod.dllo.anews.adapter.NewsAdapter;
import com.sixgod.dllo.anews.net.NetHelper;
import com.sixgod.dllo.anews.net.NetListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import de.greenrobot.event.EventBus;

/**
 * Created by dllo on 16/3/2.
 */
public class HostNewsFragment extends Fragment {
    private ViewPager vp;
    private TabLayout tb;
    private List<String> urls;
    private WholeData data;
    private ArrayList<ChooseNewsData> likeTypes, AllTypes;
    private FrameLayout layout;
    private ImageView imageView, findImg;
    private ChooseNewsTypeFragment fragment;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private boolean isSet = true;
    NewsAdapter adapter;
    private FindListener listener;

    public void setListener(FindListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_host_news, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vp = (ViewPager) view.findViewById(R.id.news_vp);
        tb = (TabLayout) view.findViewById(R.id.news_tb);
        urls = new ArrayList<>();
        likeTypes = new ArrayList<>();
        AllTypes = new ArrayList<>();
        layout = (FrameLayout) view.findViewById(R.id.choose_news_view);
        imageView = (ImageView) view.findViewById(R.id.host_news_image);
        findImg = (ImageView) view.findViewById(R.id.fragment_host_news_toolbar_find);
        view.findViewById(R.id.fragment_host_news_toolbar_toDay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TodayNewsActivity.class));
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        EventBus.getDefault().register(this);
        findImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.startFind();
            }
        });
        sp = getActivity().getSharedPreferences("urls", Context.MODE_PRIVATE);
        editor = sp.edit();
        Iterator ir = sp.getAll().entrySet().iterator();
        while (ir.hasNext()) {
            Map.Entry en = (Map.Entry) ir.next();
            String url = sp.getString(String.valueOf(en.getKey()), "");
            String tName = en.getKey().toString();
            likeTypes.add(new ChooseNewsData(tName, url));

        }//遍历 shared
        if (likeTypes.size() == 0) {

        }
        final FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        fragment = new ChooseNewsTypeFragment();
        fragment.setLayout(layout);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("types", AllTypes);
                bundle.putParcelableArrayList("likeTypes", likeTypes);
                if (isSet) {
                    fragment.setArguments(bundle);
                    isSet = false;
                    ft.replace(R.id.choose_news_view, fragment);
                    ft.commit();
                }

                layout.setVisibility(View.VISIBLE);
            }
        });
        NetHelper helper = new NetHelper();
        helper.getInfo("http://c.m.163.com/nc/topicset/ios/subscribe/manage/listspecial.html", WholeData.class, new NetListener() {
            @Override
            public void getSucceed(Object o) {
                data = (WholeData) o;

                for (int i = 0; i < data.getTList().size(); i++) {
                    ChooseNewsData chooseNewsData = new ChooseNewsData(data.getTList().get(i).getTname(), data.getTList().get(i).getTid());
                    AllTypes.add(chooseNewsData);
                    if (likeTypes.contains(data.getTList().get(i).getTname())) {
                        urls.add(data.getTList().get(i).getTid());
                    }

                }
                adapter = NewsAdapter.newNewsAdapter(getChildFragmentManager());
                vp.setAdapter(adapter);
                tb.setTabMode(TabLayout.MODE_SCROLLABLE);
                tb.setupWithViewPager(vp);
                adapter.upData(likeTypes);

            }


            @Override
            public void getFailed(String failed) {
                Log.i("55555555", failed);
            }

            @Override
            public void getSucceed(ArrayList list) {

            }
        });
    }
    public void onEventMainThread(ArrayList<ChooseNewsData> types) {

        vp.removeAllViews();
        adapter.upData(types);
        vp.setAdapter(adapter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public interface FindListener {
        void startFind();
    }
}
