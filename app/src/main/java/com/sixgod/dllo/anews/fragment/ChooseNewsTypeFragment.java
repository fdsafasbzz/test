package com.sixgod.dllo.anews.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.sixgod.dllo.anews.base.BaseFragment;
import com.sixgod.dllo.anews.bean.ChooseNewsData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.adapter.AllNewsTypeAdapter;
import com.sixgod.dllo.anews.adapter.LikeNewsCategoryAdapter;
import com.sixgod.dllo.anews.tool.ItemTouchHelperCallBack;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by dllo on 16/3/8.
 */
public class ChooseNewsTypeFragment extends BaseFragment{
    private RecyclerView likeRecyclerView,allRecyclerView;
    private AllNewsTypeAdapter allAdapter;
    private LikeNewsCategoryAdapter likeAdapter;
    private ArrayList<ChooseNewsData> allType;
    private Button btn;
    private FrameLayout layout;

    @Override
    protected void initView() {
        likeRecyclerView = getView(R.id.like_news_type_rv);
        allRecyclerView  = getView(R.id.all_news_type_rv);
        allAdapter = new AllNewsTypeAdapter();
        btn = getView(R.id.activity_choose_news_btn);
        likeAdapter = LikeNewsCategoryAdapter.newLikeNewsAdapter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_choose_news;
    }

    @Override
    protected void initData() {
        allType = getArguments().getParcelableArrayList("types");
        allRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 8));
        allAdapter.upData(allType);
        likeRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 8));
        likeRecyclerView.setAdapter(likeAdapter);
        allRecyclerView.setAdapter(allAdapter);
        ItemTouchHelper.Callback mCallback =new ItemTouchHelperCallBack(likeAdapter);
        ItemTouchHelper touchHelper =new ItemTouchHelper(mCallback);
        touchHelper.attachToRecyclerView(likeRecyclerView);
        ArrayList<ChooseNewsData> likeList = getArguments().getParcelableArrayList("likeTypes");
        likeAdapter.setTypes(likeList);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp   = getActivity().getSharedPreferences("urls", Context.MODE_PRIVATE);
                SharedPreferences.Editor  editor = sp.edit();
                ArrayList<ChooseNewsData> likeTypes = likeAdapter.getTypes();
                editor.clear();
                for (int i = 0; i <likeTypes.size() ; i++) {
                    editor.putString(likeTypes.get(i).getTitle(), likeTypes.get(i).getUrl());
                }
                editor.commit();
                layout.setVisibility(View.GONE);
                EventBus.getDefault().post(likeTypes);



            }
        });
    }

    public void setLayout(FrameLayout layout) {
        this.layout = layout;
    }
}
