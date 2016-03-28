package com.sixgod.dllo.anews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixgod.dllo.anews.base.BaseFragment;
import com.sixgod.dllo.anews.bean.MySingleDiscussData;
import com.sixgod.dllo.anews.R;

import de.greenrobot.event.EventBus;

/**
 * Created by dllo on 16/3/14.
 */
public class FrameDiscussFragment extends BaseFragment {
    private HostDiscussRecyclerViewFragment hostDiscussFragment;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void initView() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_discuss_frame;
    }

    @Override
    protected void initData() {
        hostDiscussFragment = new HostDiscussRecyclerViewFragment();
        fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_discuss_framelayout, hostDiscussFragment);
        fragmentTransaction.commit();
    }




}
