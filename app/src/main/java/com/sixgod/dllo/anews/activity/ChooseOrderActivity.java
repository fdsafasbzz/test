package com.sixgod.dllo.anews.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.sixgod.dllo.anews.bean.ChooseOrderTitleData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.base.BaseActivity;
import com.sixgod.dllo.anews.bean.ChooseTitleData;
import com.sixgod.dllo.anews.net.NetHelper;
import com.sixgod.dllo.anews.net.NetListener;
import com.sixgod.dllo.anews.net.SingleQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/3/18.
 */
public class ChooseOrderActivity extends BaseActivity{
    private RecyclerView titleRv,contentRv;
    private ArrayList<ChooseOrderTitleData> titles;
    private RequestQueue queue;
    private ArrayList<ChooseOrderTitleData.TListEntity> contents;
    private ContentAdapter adapter;
    @Override
    protected void initView() {
        titleRv = (RecyclerView) findViewById(R.id.activity_choose_order_title_rv);
        contentRv = (RecyclerView) findViewById(R.id.activity_choose_order_content_rv);
        queue = SingleQueue.newSingleQueue().getRequestQueue();
        titles = new ArrayList<>();
        adapter = new ContentAdapter();

    }

    @Override
    protected void initData() {
        NetHelper helper = new NetHelper();
        helper.getInfoArray("http://c.m.163.com/nc/topicset/ios/v4/subscribe/read/all.html",ChooseOrderTitleData.class, new NetListener<ChooseOrderTitleData>() {
            @Override
            public void getSucceed(ChooseOrderTitleData chooseOrderTitleData) {

            }

            @Override
            public void getFailed(String failed) {

            }

            @Override
            public void getSucceed(ArrayList<ChooseOrderTitleData> list) {
               titles = list;
                Log.i("titles666666",titles.get(2).getCName());
                contents = (ArrayList<ChooseOrderTitleData.TListEntity>) titles.get(0).getTList();
                titleRv.setAdapter(new TitleAdapter());
                contentRv.setAdapter(adapter);
                contentRv.setLayoutManager(new LinearLayoutManager(ChooseOrderActivity.this));
                titleRv.setLayoutManager(new LinearLayoutManager(ChooseOrderActivity.this));
            }
        });

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_choose_order;
    }














    class ContentAdapter extends RecyclerView.Adapter{

      @Override
      public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          return new ContentHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_choose_order_content,parent,false));
      }

      @Override
      public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
          ContentHolder1 contentHolder  = (ContentHolder1) holder;
          contentHolder.title.setText(contents.get(position).getTname());
          contentHolder.count.setText(contents.get(position).getNum()+"");

      }

      @Override
      public int getItemCount() {
          return contents.size();
      }
      class ContentHolder1 extends RecyclerView.ViewHolder {

          TextView title,count;
          SimpleDraweeView leftImg,rightImg;

          public ContentHolder1(View itemView) {
              super(itemView);
              title = (TextView) itemView.findViewById(R.id.item_choose_order_content_title_tv);
              count = (TextView) itemView.findViewById(R.id.item_choose_order_content_count_tv);
              leftImg = (SimpleDraweeView) itemView.findViewById(R.id.item_choose_order_content_left_img);
              rightImg = (SimpleDraweeView) itemView.findViewById(R.id.item_choose_order_content_right_img);
          }

      }
  }
class TitleAdapter extends RecyclerView.Adapter{

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TitleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_choose_order_title,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TitleHolder titleHolder = (TitleHolder) holder;
        titleHolder.textView.setText(titles.get(position).getCName());
        titleHolder.titlePosition =position;
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
    class TitleHolder extends RecyclerView.ViewHolder {
        private  TextView textView;
        private int titlePosition;

        public TitleHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_choose_order_title_tv);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
               contents= (ArrayList<ChooseOrderTitleData.TListEntity>) titles.get(titlePosition).getTList();
                    adapter.notifyDataSetChanged();
                }
            });
        }
    }
}
}
