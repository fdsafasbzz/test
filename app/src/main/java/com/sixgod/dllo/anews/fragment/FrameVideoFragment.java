package com.sixgod.dllo.anews.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/3/19.
 */
public class FrameVideoFragment extends BaseFragment {
    private ViewPager vp;
    private TabLayout tb;
    private List<Fragment> fragments;

    @Override
    protected void initView() {
        fragments = new ArrayList<>();
        vp = getView(R.id.video_vp);
        tb = getView(R.id.video_tb);

    }

    @Override
    protected int setLayoutId() {

        return R.layout.fragment_frame_video;
    }

    @Override
    protected void initData() {
        fragments.add(new HostVideoRecyclerViewFragment());
        fragments.add(new RadioFragment());
        vp.setAdapter(new VideoPagerAdapter(getChildFragmentManager()));
        tb.setupWithViewPager(vp);
    }

    class VideoPagerAdapter extends FragmentPagerAdapter {

        public VideoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            if (position==0){
                return "视听";
            }
            else return "电台";

        }
    }

}
