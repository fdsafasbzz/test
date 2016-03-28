package com.sixgod.dllo.anews.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sixgod.dllo.anews.bean.CategoryNewsData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.activity.SingleNewsActivity;
import com.sixgod.dllo.anews.activity.ThreePicNewsActivity;
import com.sixgod.dllo.anews.base.BaseRecyclerAdapter;
import com.sixgod.dllo.anews.base.LoadListener;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/2.
 */
public class NewsCategoryAdapter extends BaseRecyclerAdapter<CategoryNewsData> {

    private ArrayList<CategoryNewsData> datas;
    private FragmentManager manager;
    private Context context;
    private ItemOnClickListener listener;

    public void setListener(ItemOnClickListener listener) {
        this.listener = listener;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public NewsCategoryAdapter(RecyclerView recyclerView, LoadListener listener, ArrayList<CategoryNewsData> data) {
        super(recyclerView, listener, data);
        datas = data;
        Log.i("适配器初始化", data.toString());
    }


    @Override
    protected RecyclerView.ViewHolder holders(ViewGroup parent, int viewType) {
        if (viewType == TOP_MODE) {
            return new FirstHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_category_first, parent, false));
        }

        if (viewType == CONTENT_MODE) {
            return new Content(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_category, parent, false));

        }
        if (viewType == THREE_PIC_MODE) {
            return new ThreePicHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_category_three_picture, parent, false));
        } else return null;
    }

    @Override
    protected boolean hasThreePicModeViewType(int position) {

        return datas.get(position).getImgextra() != null && datas.get(position).getImgextra().size() > 0;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (getItemViewType(position) == TOP_MODE) {
            ArrayList<String> urls = new ArrayList<>();
            ArrayList<String> titles = new ArrayList<>();
            ArrayList<String> webUrls = new ArrayList<>();
            if (datas.get(position).getAds() != null) {
                for (int i = 0; i < datas.get(position).getAds().size(); i++) {
                    urls.add(datas.get(position).getAds().get(i).getImgsrc());
                    titles.add(datas.get(position).getAds().get(i).getTitle());
                    webUrls.add(datas.get(position).getAds().get(i).getUrl());
                }
            } else {
                urls.add(datas.get(position).getImgsrc());
                titles.add(datas.get(position).getTitle());
                webUrls.add(datas.get(position).getSkipID());
            }
            FirstItemViewPagerAdapter adapter = new FirstItemViewPagerAdapter(urls, titles,webUrls,context);

            ((FirstHolder) holder).viewPager.setAdapter(adapter);
//            ((FirstHolder) holder).tb.setTabTextColors( Color.WHITE, Color.BLUE);
//            ((FirstHolder) holder).tb.setSelectedTabIndicatorHeight(0);
//            ((FirstHolder) holder).tb.setupWithViewPager(((FirstHolder) holder).viewPager);
        }
        if (getItemViewType(position) == CONTENT_MODE) {

            ((Content) holder).contentPosition = position;
            ((Content) holder).tv.setText(datas.get(position).getTitle());

            ((Content) holder).tv_d.setText(datas.get(position).getDigest());
            if (datas.get(position).getImgsrc() != null) {
                ((Content) holder).draweeView.setImageURI(Uri.parse(datas.get(position).getImgsrc()));
            }
        }
        if (getItemViewType(position) == THREE_PIC_MODE) {
            ThreePicHolder threePicHolder = (ThreePicHolder) holder;
            threePicHolder.threePosion =position;
            threePicHolder.lDraweeView.setImageURI(Uri.parse(datas.get(position).getImgsrc()));
            threePicHolder.mDraweeView.setImageURI(Uri.parse(datas.get(position).getImgextra().get(0).getImgsrc()));
            threePicHolder.rDraweeView.setImageURI(Uri.parse(datas.get(position).getImgextra().get(1).getImgsrc()));
            threePicHolder.title.setText(datas.get(position).getTitle());
        }
    }

    class Content extends RecyclerView.ViewHolder {
        private TextView tv;
        private SimpleDraweeView draweeView;
        private TextView tv_d;
        LinearLayout layout;
        private int contentPosition;

        public Content(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.news_title);
            tv_d = (TextView) itemView.findViewById(R.id.news_digest);
            draweeView = (SimpleDraweeView) itemView.findViewById(R.id.news_image);
            layout = (LinearLayout) itemView.findViewById(R.id.item_type_news_layout);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent1 = new Intent(context, WebActivity.class);
//                   intent1.putExtra("webUrl",datas.get(contentPosition).getUrl());
//                           context.startActivity(intent1);
                    Intent intent = new Intent(context, SingleNewsActivity.class);
                    intent.putExtra("id", datas.get(contentPosition).getPostid());
                    context.startActivity(intent);

//                    listener.itemOnClickListener(datas.get(contentPosition).getPostid());
//                    EventBus.getDefault().post(datas.get(contentPosition).getPostid());

                }
            });

        }
    }

    class FirstHolder extends RecyclerView.ViewHolder {
        ViewPager viewPager;
        TabLayout tb;
        FrameLayout layout;


        public FirstHolder(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.first_news_vp);
            tb = (TabLayout) itemView.findViewById(R.id.first_news_tb);
            layout = (FrameLayout) itemView.findViewById(R.id.item_news_type_first_layout);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(context, WebActivity.class);
//                    intent.putCharSequenceArrayListExtra("webUrl",datas.get(0).get.get)
//                           context.startActivity(intent);
                }
            });
        }
    }

    class ThreePicHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private SimpleDraweeView lDraweeView, mDraweeView, rDraweeView;
        private LinearLayout layout;
        private int threePosion;
        public ThreePicHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_news_type_three_tv);
            lDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.item_news_type_three_l_img);
            mDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.item_news_type_three_m_img);
            rDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.item_news_type_three_r_img);
            layout = (LinearLayout) itemView.findViewById(R.id.item_news_type_three_layout);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    if (datas.get(threePosion).getUrl()!=null){
//                    Intent intent = new Intent(context, SingleNewsActivity.class);
//                    intent.putExtra("id", datas.get(threePosion).getPostid());
//                           context.startActivity(intent);
//                    }
//                    else {
//                        Intent intent = new Intent(context, WebActivity.class);
//                        intent.putExtra("webUrl", datas.get(threePosion).getUrl());
//                        context.startActivity(intent);
//                    }


                    if (datas.get(threePosion).getPhotosetID()!=null) {
                        Intent intent = new Intent(context, ThreePicNewsActivity.class);
                        intent.putExtra("photoId", datas.get(threePosion).getPhotosetID());
                        context.startActivity(intent);
                    }

                }
            });

        }
    }
public interface ItemOnClickListener{
    void itemOnClickListener(String posId);
}
}
