package com.sixgod.dllo.anews.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sixgod.dllo.anews.R;

import com.sixgod.dllo.anews.base.BaseApplication;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/14.
 */
public class ThreePicNewsVpAdapter extends PagerAdapter {
    private ArrayList<String> urls = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private Context context;


    public ThreePicNewsVpAdapter(ArrayList<String> urls, ArrayList<String> titles, Context context) {
        super();
        this.urls = urls;
        this.titles = titles;
        this.context = context;

    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.item_three_pic_vp, container, false);
        container.addView(v);
        TextView textView = (TextView) v.findViewById(R.id.item_three_pic_vp_tv);
        SimpleDraweeView draweeView = (SimpleDraweeView) v.findViewById(R.id.item_three_pic_vp_fresco);
        Uri uri = Uri.parse(urls.get(position));
        draweeView.setImageURI(uri);
        textView.setText(titles.get(position));
        return v;
    }

    //
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.vp_item_head, container, false);
        container.removeView(v);
    }


}
