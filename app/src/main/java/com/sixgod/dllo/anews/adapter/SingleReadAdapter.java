package com.sixgod.dllo.anews.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sixgod.dllo.anews.bean.MySingleReadData;
import com.sixgod.dllo.anews.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/12.
 */
public class SingleReadAdapter extends RecyclerView.Adapter {
    private ArrayList<MySingleReadData> readDatas;
    private String title;
    private String time;
    private static final int HEAD_MODE=1;
    private static final int CONTET_MODE=2;


    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SingleReadAdapter(ArrayList<MySingleReadData> readDatas) {
        this.readDatas = readDatas;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return HEAD_MODE;
        }
        else {
            return CONTET_MODE;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType ==HEAD_MODE){
            return new HeadHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_head_single_read,parent,false));
        }
       else {
            return new SingleReadHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_single_read,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==HEAD_MODE){
            HeadHolder headHolder = (HeadHolder) holder;
            headHolder.time.setText(time);
            headHolder.title.setText(title);
        }
        else {
            SingleReadHolder singleReadHolder = (SingleReadHolder) holder;
            String content = readDatas.get(position-1).getContent();
            singleReadHolder.content.setText(Html.fromHtml(content));
            singleReadHolder.img.setVisibility(View.VISIBLE);
            if (readDatas.get(position-1).getImgUrl()!=null){
                singleReadHolder.img.setImageURI(Uri.parse(readDatas.get(position-1).getImgUrl()));
            }
            else  {
                singleReadHolder.img.setVisibility(View.GONE);
            }
        }

    }

    @Override
    public int getItemCount() {
        return readDatas.size()+1;
    }

    class SingleReadHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView img;
        TextView content;

        public SingleReadHolder(View itemView) {
            super(itemView);
            img = (SimpleDraweeView) itemView.findViewById(R.id.item_single_read_img);
            content = (TextView) itemView.findViewById(R.id.item_single_read_content);
        }
    }
    class HeadHolder extends RecyclerView.ViewHolder {
        TextView title,time;
        public HeadHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_head_read_title);
            time = (TextView) itemView.findViewById(R.id.item_head_read_time);
        }
    }
}
