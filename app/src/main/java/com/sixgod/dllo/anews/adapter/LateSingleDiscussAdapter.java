package com.sixgod.dllo.anews.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sixgod.dllo.anews.bean.SingleDiscussData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.activity.ChildDiscussActivity;
import com.sixgod.dllo.anews.base.BaseRecyclerAdapter;
import com.sixgod.dllo.anews.base.LoadListener;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/10.
 */
public class LateSingleDiscussAdapter extends BaseRecyclerAdapter<SingleDiscussData.DataEntity.LatestListEntity>{
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public LateSingleDiscussAdapter(RecyclerView recyclerView, LoadListener listener, ArrayList<SingleDiscussData.DataEntity.LatestListEntity> data) {
        super(recyclerView, listener, data);
    }

    @Override
    protected RecyclerView.ViewHolder holders(ViewGroup parent, int viewType) {
        return new HotSingleDisscussHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hot_single_discuss,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (data.size()>0)
        {
        if (getItemViewType(position)==CONTENT_MODE||getItemViewType(position)==TOP_MODE) {
            HotSingleDisscussHolder mhodler = (HotSingleDisscussHolder) holder;
            mhodler.answerHead.setImageURI(Uri.parse(data.get(position).getAnswer().getSpecialistHeadPicUrl()));
            mhodler.questionHead.setImageURI(Uri.parse(data.get(position).getQuestion().getUserHeadPicUrl()));
            mhodler.questionName.setText(data.get(position).getQuestion().getUserName());
            mhodler.questionContent.setText(data.get(position).getQuestion().getContent());
            mhodler.answerName.setText(data.get(position).getAnswer().getSpecialistName());
            mhodler.answerContent.setText(data.get(position).getAnswer().getContent());
        }

        }
        else {
            Toast.makeText(context, "此页面正在维护中", Toast.LENGTH_SHORT).show();
            ((ChildDiscussActivity)context).finish();
        }
    }

    @Override
    protected boolean hasThreePicModeViewType(int position) {
        return false;
    }

    class HotSingleDisscussHolder extends RecyclerView.ViewHolder {
        TextView questionName, questionContent, answerName, answerContent;
        SimpleDraweeView questionHead, answerHead;

        public HotSingleDisscussHolder(View itemView) {
            super(itemView);
            questionName = (TextView) itemView.findViewById(R.id.item_hot_single_discuss_question_vector);
            questionContent = (TextView) itemView.findViewById(R.id.item_hot_single_discuss_question_content);
            answerName = (TextView) itemView.findViewById(R.id.item_hot_single_discuss_answer_vector);
            answerContent = (TextView) itemView.findViewById(R.id.item_hot_single_discuss_answer_content);
            questionHead = (SimpleDraweeView) itemView.findViewById(R.id.item_hot_single_discuss_img);
            answerHead = (SimpleDraweeView) itemView.findViewById(R.id.item_hot_single_discuss_answer_img);
        }
    }

}
