package com.sixgod.dllo.anews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.sixgod.dllo.anews.base.BaseFragment;
import com.sixgod.dllo.anews.bean.ReadIdata;
import com.sixgod.dllo.anews.R;

import de.greenrobot.event.EventBus;

/**
 * Created by dllo on 16/3/14.
 */
public class FrameReadFragment extends BaseFragment{
    private FragmentTransaction transaction;
    private HostReadRecyclerViewFragment readFragment;
//    private SingleReadFragment singleReadFragment;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_read_frame;
    }

    @Override
    protected void initData() {
        FragmentManager manager = getChildFragmentManager();
        transaction = manager.beginTransaction();
        readFragment = new HostReadRecyclerViewFragment();
//        singleReadFragment = new SingleReadFragment();
        transaction.replace(R.id.fragment_read_framelayout,readFragment);
        transaction.commit();
//        EventBus.getDefault().register(this);
    }

//    public void onEvent(ReadIdata readIdata){
//        Bundle bundle  = new Bundle();
//        bundle.putString("id",readIdata.getId());
////        singleReadFragment.setArguments(bundle);
////        transaction.add(R.id.fragment_read_framelayout,singleReadFragment);
//    }
    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}
