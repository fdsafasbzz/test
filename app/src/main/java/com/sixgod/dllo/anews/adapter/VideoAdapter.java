package com.sixgod.dllo.anews.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sixgod.dllo.anews.bean.VideoData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.base.BaseRecyclerAdapter;
import com.sixgod.dllo.anews.base.LoadListener;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/9.
 */
public class VideoAdapter extends BaseRecyclerAdapter<VideoData.VideoListEntity> {
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public VideoAdapter(RecyclerView recyclerView, LoadListener listener, ArrayList<VideoData.VideoListEntity> data) {
        super(recyclerView, listener, data);
    }

    @Override
    protected RecyclerView.ViewHolder holders(ViewGroup parent, int viewType) {
        return new VideoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_video, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
//        Log.i("video",data.get(position).getMp4_url());
        if (getItemViewType(position) == CONTENT_MODE || getItemViewType(position) == TOP_MODE) {
            Log.i("video", data.get(position).getMp4_url());
            ((VideoHolder) holder).title.setText(data.get(position).getTitle());
            ((VideoHolder) holder).describe.setText(data.get(position).getDescription());
            ((VideoHolder) holder).time.setText("时间 :"+data.get(position).getLength()/60+" 分 "+data.get(position).getLength()%60+" 秒");
            ((VideoHolder) holder).count.setText("播放次数 :"+data.get(position).getPlayCount());
            ((VideoHolder) holder).draweeView.setImageURI(Uri.parse(data.get(position).getCover()));
            ((VideoHolder) holder).draweeView.setVisibility(View.VISIBLE);
            ((VideoHolder) holder).vv.setVideoURI(Uri.parse(data.get(position).getMp4_url()));
            MediaController controller = new MediaController(context);
            ((VideoHolder) holder).vv.setMediaController(controller);
            controller.setMediaPlayer(((VideoHolder) holder).vv);
            ((VideoHolder) holder).vv.requestFocus();

        }
    }


    @Override
    protected boolean hasThreePicModeViewType(int position) {
        return false;
    }

    class VideoHolder extends RecyclerView.ViewHolder {
        VideoView vv;
        TextView title, describe, time, count;
        FrameLayout frameLayout;
        SimpleDraweeView draweeView;

        public VideoHolder(View itemView) {
            super(itemView);
            vv = (VideoView) itemView.findViewById(R.id.item_video_fragment_vv);
            title = (TextView) itemView.findViewById(R.id.item_video_fragment_title);
            frameLayout = (FrameLayout) itemView.findViewById(R.id.item_video_fragment_framelayout);
            draweeView = (SimpleDraweeView) itemView.findViewById(R.id.item_video_fragment_draweeview);
            describe = (TextView) itemView.findViewById(R.id.item_video_fragment_describe);
            time = (TextView) itemView.findViewById(R.id.item_video_fragment_time);
            count = (TextView) itemView.findViewById(R.id.item_video_fragment_count);

            vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    draweeView.setVisibility(View.VISIBLE);
                }
            });
            draweeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    draweeView.setVisibility(View.INVISIBLE);
                    vv.start();
                }
            });
        }
    }
}
