package com.sixgod.dllo.anews.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.activity.ThreePicNewsActivity;
import com.sixgod.dllo.anews.base.BaseApplication;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/5.
 */
public class FirstItemViewPagerAdapter extends PagerAdapter {
    private ArrayList<String> urls = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> cicles;
   private ArrayList<String > webUrls = new ArrayList<>();
    private Context context;

    public FirstItemViewPagerAdapter(ArrayList<String> urls, ArrayList<String> titles,ArrayList<String> webUrls,Context context) {
        this.urls = urls;
        this.titles = titles;
        this.webUrls = webUrls;
        this.context = context;
        cicles = new ArrayList<>();
        for (int i = 0; i < urls.size(); i++) {
            cicles.add("●");
        }

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
        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.vp_item_head, container, false);
        container.addView(v);
        TextView textView = (TextView) v.findViewById(R.id.vp_item_first_tv);
        SimpleDraweeView draweeView = (SimpleDraweeView) v.findViewById(R.id.vp_item_first_fresco);
        FrameLayout layout = (FrameLayout) v.findViewById(R.id.vp_item_first_layout);
        Uri uri = Uri.parse(urls.get(position));
        draweeView.setImageURI(uri);
        textView.setText(titles.get(position));
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webUrls.get(position)!=null){
                Intent intent1 = new Intent(context, ThreePicNewsActivity.class);
                intent1.putExtra("photoId",webUrls.get(position));
                context.startActivity(intent1);
                }

            }
        });


        return v;
    }

    //
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.vp_item_head, container, false);
        container.removeView(v);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (cicles.size() > 1) {
            Toast.makeText(BaseApplication.getContext(), cicles.toString(), Toast.LENGTH_SHORT).show();
            return cicles.get(position);
        } else return "";
    }
}
