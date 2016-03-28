package com.sixgod.dllo.anews.fragment;

import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.base.BaseFragment;

import de.greenrobot.event.EventBus;

/**
 * Created by dllo on 16/3/14.
 */
public class FrameNewsFragment extends BaseFragment {
//    private SingleNewsFragment singleNewsFragment;
    private HostNewsFragment newsFragment;

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_news_frame;
    }

    @Override
    protected void initData() {
        FragmentManager manager = getChildFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        newsFragment = new HostNewsFragment();
        final FindFragment findFragment = new FindFragment();
//        singleNewsFragment = new SingleNewsFragment();
        transaction.add(R.id.frament_news_frame, newsFragment);


        transaction.commit();
        Log.i("stack", getChildFragmentManager().getBackStackEntryCount() + "");
        findFragment.setListener(new FindFragment.BackListener() {
            @Override
            public void goBack() {
                getChildFragmentManager().beginTransaction().replace(R.id.frament_news_frame, newsFragment).show(newsFragment).commit();

            }
        });
        newsFragment.setListener(new HostNewsFragment.FindListener() {
            @Override
            public void startFind() {

                getChildFragmentManager().beginTransaction().add(R.id.frament_news_frame, findFragment).show(findFragment).hide(newsFragment).commit();
            }
        });
    }


}
