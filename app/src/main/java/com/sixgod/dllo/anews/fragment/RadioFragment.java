package com.sixgod.dllo.anews.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.activity.ListMusicActivity;
import com.sixgod.dllo.anews.base.BaseFragment;
import com.sixgod.dllo.anews.bean.RadioData;
import com.sixgod.dllo.anews.net.NetHelper;
import com.sixgod.dllo.anews.net.NetListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/3/18.
 */
public class RadioFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private List<RadioData.CListEntity> datas;


    @Override
    protected void initView() {
        recyclerView = getView(R.id.fragment_radio_rv);

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_radio;
    }

    @Override
    protected void initData() {
        NetHelper helper = new NetHelper();
        helper.getInfo("http://c.m.163.com/nc/topicset/ios/radio/index.html", RadioData.class, new NetListener<RadioData>() {
            @Override
            public void getSucceed(RadioData radioData) {
                datas = radioData.getCList();
                recyclerView.setAdapter(new RadioAdapter());
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            }

            @Override
            public void getFailed(String failed) {

            }

            @Override
            public void getSucceed(ArrayList<RadioData> list) {

            }
        });
    }

    class  RadioAdapter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ContentHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_radio_content,parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         ContentHolder contentHolder = (ContentHolder) holder;
            contentHolder.rightImg.setImageURI(Uri.parse(datas.get(position).getTList().get(2).getRadio().getImgsrc()));
            contentHolder.middleImg.setImageURI(Uri.parse(datas.get(position).getTList().get(1).getRadio().getImgsrc()));
            contentHolder.leftImg.setImageURI(Uri.parse(datas.get(position).getTList().get(0).getRadio().getImgsrc()));
            contentHolder.position = position;

        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class ContentHolder extends RecyclerView.ViewHolder{
            SimpleDraweeView leftImg,middleImg,rightImg;
            int position;
            public ContentHolder(View itemView) {
                super(itemView);
                leftImg = (SimpleDraweeView) itemView.findViewById(R.id.item_radio_left_img);
                leftImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(RadioFragment.this.getActivity(),ListMusicActivity.class);
                        intent.putExtra("id",datas.get(position).getTList().get(0).getTid());
                        startActivity(intent);
                    }
                });
                middleImg = (SimpleDraweeView) itemView.findViewById(R.id.item_radio_middle_img);
                middleImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(RadioFragment.this.getActivity(),ListMusicActivity.class);
                        intent.putExtra("id",datas.get(position).getTList().get(1).getTid());
                        startActivity(intent);
                    }
                });
                rightImg = (SimpleDraweeView) itemView.findViewById(R.id.item_radio_right_img);
                rightImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(RadioFragment.this.getActivity(),ListMusicActivity.class);
                        intent.putExtra("id",datas.get(position).getTList().get(2).getTid());
                        startActivity(intent);
                    }
                });

            }
        }
    }
}

