package com.sixgod.dllo.anews.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.test.ActivityTestCase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.activity.ChildDiscussActivity;
import com.sixgod.dllo.anews.db.Attention;
import com.sixgod.dllo.anews.db.AttentionHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/3/14.
 */
public class AttentionAdatper extends RecyclerView.Adapter<AttentionAdatper.AttentionHoler> {
    private List<Attention> attentions;
    private Context context;

    public AttentionAdatper(Context context) {
        this.context = context;

        attentions = AttentionHelper.newHelper(context).allData();
        if (attentions==null){
            attentions=new ArrayList<>();
        }
    }

    @Override
    public AttentionHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AttentionHoler(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_attention, parent, false));
    }

    @Override
    public void onBindViewHolder(AttentionHoler holder, int position) {
        Log.i("index", String.valueOf(position));
        holder.position = position;
        holder.textView.setText(attentions.get(position).getTitle());
        holder.url = attentions.get(position).getUrl();

    }

    @Override
    public int getItemCount() {
        return attentions != null && attentions.size() > 0 ? attentions.size() : 0;
    }

    class AttentionHoler extends RecyclerView.ViewHolder {
        private TextView textView;
        private RelativeLayout layout;
        private int position;
        private String url;
        private Button btn;

        public AttentionHoler(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_attention_tv);
            layout = (RelativeLayout) itemView.findViewById(R.id.item_attention_layout);
            btn = (Button) itemView.findViewById(R.id.item_atteion_btn);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChildDiscussActivity.class);
                    intent.putExtra("id", attentions.get(position).getUrl());
                    context.startActivity(intent);
                }
            });

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("index", attentions.toString());
                    AttentionHelper.newHelper(context).cancelAttention(attentions.get(position).getUrl());
                    if (attentions==null){
                        attentions=new ArrayList<>();
                    }
                    attentions = AttentionHelper.newHelper(context).allData();

                    if (attentions.size() > 0) {
                        notifyDataSetChanged();
                    } else notifyDataSetChanged();
                }
            });
        }
    }
    public void addData(){
        if (attentions==null){
            attentions=new ArrayList<>();
        }
        notifyDataSetChanged();
    }
}
