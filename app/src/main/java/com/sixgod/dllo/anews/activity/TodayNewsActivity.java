package com.sixgod.dllo.anews.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sixgod.dllo.anews.bean.TodayNewsData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.base.BaseActivity;
import com.sixgod.dllo.anews.net.NetHelper;
import com.sixgod.dllo.anews.net.NetListener;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/16.
 */
public class TodayNewsActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private NetHelper helper;
    private TodayNewsData data;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.activity_today_news_rv);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.activity_today_news_collapsing_toolbar);
        collapsingToolbarLayout.setContentScrimColor(Color.TRANSPARENT);
    }

    @Override
    protected void initData() {
        helper = new NetHelper();
        helper.getInfo("http://c.m.163.com/nc/article/list/T1429173683626/0-20.html", TodayNewsData.class, new NetListener() {
            @Override
            public void getSucceed(Object o) {
                data = (TodayNewsData) o;
                recyclerView.setLayoutManager(new LinearLayoutManager(TodayNewsActivity.this));
                recyclerView.setAdapter(new TodayNewsActivityAdapter());
            }

            @Override
            public void getFailed(String failed) {

            }

            @Override
            public void getSucceed(ArrayList list) {

            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_today_news;
    }


    class TodayNewsActivityAdapter extends RecyclerView.Adapter {
        private static final int HEAD_MODE = 1;
        private static final int CONTENT_MODE = 2;

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return HEAD_MODE;
            } else {
                return CONTENT_MODE;
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == HEAD_MODE) {
                return new HeadHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_today_news_head, parent, false));

            } else {
                return new ContentHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_today_news_content, parent, false));

            }

        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (getItemViewType(position) == HEAD_MODE) {
                HeadHolder headHolder = (HeadHolder) holder;
                headHolder.headPosition = position;
                headHolder.img.setImageURI(Uri.parse(data.getT1429173683626().get(0).getImgsrc()));
                headHolder.textView.setText(data.getT1429173683626().get(0).getTitle());
            }
            else {

                ContentHolder contentHolder = (ContentHolder) holder;
                contentHolder.contentPostion = position;
                contentHolder.describe.setText(data.getT1429173683626().get(position).getDigest());
                contentHolder.title.setText(data.getT1429173683626().get(position).getTitle());
                if (data.getT1429173683626().get(position).getImgsrc()!=null){
                    contentHolder.leftImg.setImageURI(Uri.parse(data.getT1429173683626().get(position).getImgsrc()));
                }
                if (data.getT1429173683626().get(position).getSkipType()!=null&&data.getT1429173683626().get(position).getSkipType().equals("special")){
                    contentHolder.rightImg.setImageResource(R.mipmap.ic_launcher);
                }
            }
        }

        @Override
        public int getItemCount() {
            return data.getT1429173683626().size();
        }

        class TodayNewsHolder extends RecyclerView.ViewHolder {

            public TodayNewsHolder(View itemView) {
                super(itemView);
            }
        }
    }

    class HeadHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView img;
        private LinearLayout layout;
        private TextView textView;
        private int headPosition;

        public HeadHolder(View itemView) {
            super(itemView);
            img = (SimpleDraweeView) itemView.findViewById(R.id.item_today_news_head_img);
            layout = (LinearLayout) itemView.findViewById(R.id.item_today_news_head_layout);
            textView = (TextView) itemView.findViewById(R.id.item_today_news_head_tv);

        }
    }

    class ContentHolder extends RecyclerView.ViewHolder {
        private LinearLayout layout;
        private int contentPostion;
        private ImageView rightImg;
        private SimpleDraweeView leftImg;
        private TextView title, describe;
        public ContentHolder(View itemView) {
            super(itemView);
            rightImg = (ImageView) itemView.findViewById(R.id.item_today_news_content_right_img);
            leftImg = (SimpleDraweeView)itemView. findViewById(R.id.item_today_news_content_left_img1);
            title = (TextView) itemView.findViewById(R.id.item_today_news_content_title);
            describe = (TextView) itemView.findViewById(R.id.item_today_news_content_describe);
            layout = (LinearLayout) itemView.findViewById(R.id.item_today_news_content_layout);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (data.getT1429173683626().get(contentPostion).getSkipType()==null||data.getT1429173683626().get(contentPostion).getSkipType().equals("special")) {
                        data.getT1429173683626().get(contentPostion).getSpecialId();
                        Intent intent = new Intent(TodayNewsActivity.this, SingleNewsActivity.class);
                        intent.putExtra("id", data.getT1429173683626().get(contentPostion).getPostid());
                        startActivity(intent);
                    }
                    else Toast.makeText(TodayNewsActivity.this, "此页面维护中", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
