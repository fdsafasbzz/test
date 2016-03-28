package com.sixgod.dllo.anews.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sixgod.dllo.anews.bean.ReadData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.activity.SingleReadActivity;
import com.sixgod.dllo.anews.base.BaseRecyclerAdapter;
import com.sixgod.dllo.anews.base.LoadListener;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/8.
 */
public class ReadAdapter extends BaseRecyclerAdapter<ReadData.RecommendEntity>{
    private Context context;
    private OnItemClickListener listener;
    public ReadAdapter(RecyclerView recyclerView, LoadListener listener, ArrayList<ReadData.RecommendEntity> data) {
        super(recyclerView, listener, data);
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected RecyclerView.ViewHolder holders(ViewGroup parent, int viewType) {
        if (viewType==THREE_PIC_MODE){
            return new ThreePicHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_read_three_pic,parent,false));
        }
       else {
            return new ReadHoler(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_read,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (getItemViewType(position)==CONTENT_MODE||getItemViewType(position)==TOP_MODE) {
            ReadHoler readHoler = (ReadHoler) holder;
            readHoler.content.setText(data.get(position).getTitle());
            readHoler.author.setText(data.get(position).getSource());
            readHoler.readPosition = position;
            if (data.get(position).getImgsrc()!=null){
            readHoler.draweeView.setImageURI(Uri.parse(data.get(position).getImgsrc()));}
        }
        if (getItemViewType(position)==THREE_PIC_MODE){
            ThreePicHolder threePicHolder = (ThreePicHolder) holder;
            threePicHolder.rightBottom.setImageURI(Uri.parse(data.get(position).getImgnewextra().get(1).getImgsrc()));
            threePicHolder.rightTop.setImageURI(Uri.parse(data.get(position).getImgnewextra().get(0).getImgsrc()));
            threePicHolder.left.setImageURI(Uri.parse(data.get(position).getImgsrc()));
            threePicHolder.content.setText(data.get(position).getTitle());
            threePicHolder.readPosition = position;
        }
    }

    @Override
    protected boolean hasThreePicModeViewType(int position) {
        return data.get(position).getImgnewextra()!=null&&data.get(position).getImgnewextra().size()>0;
    }
    class ReadHoler extends RecyclerView.ViewHolder {
        private TextView author,content;
        private int readPosition;
        private SimpleDraweeView draweeView;
        private LinearLayout layout;
        public ReadHoler(View itemView) {
            super(itemView);
            author = (TextView) itemView.findViewById(R.id.item_read_author);
            content = (TextView) itemView.findViewById(R.id.item_read_content);
            draweeView = (SimpleDraweeView) itemView.findViewById(R.id.read_image);
            layout = (LinearLayout) itemView.findViewById(R.id.item_read_layout);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SingleReadActivity.class);
                    intent.putExtra("id",data.get(readPosition).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
    class ThreePicHolder extends RecyclerView.ViewHolder {
        private TextView content;
        private int readPosition;
        private SimpleDraweeView left;
        private LinearLayout layout;
        private SimpleDraweeView rightTop;
        private SimpleDraweeView rightBottom;
        public ThreePicHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.item_read_three_pic_content_tv);
            left = (SimpleDraweeView) itemView.findViewById(R.id.item_read_three_pic_left_img);
            rightTop = (SimpleDraweeView) itemView.findViewById(R.id.item_read_three_pic_right_top_img);
            rightBottom = (SimpleDraweeView) itemView.findViewById(R.id.item_read_three_pic_right_bottom_img);
            layout = (LinearLayout) itemView.findViewById(R.id.item_read_three_pic_layout);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SingleReadActivity.class);
                    intent.putExtra("id",data.get(readPosition).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
    public interface OnItemClickListener{
        void clickListener(String id);
    }
}
