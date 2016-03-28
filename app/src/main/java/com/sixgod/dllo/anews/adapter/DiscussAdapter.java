package com.sixgod.dllo.anews.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sixgod.dllo.anews.bean.DiscussData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.activity.ChildDiscussActivity;
import com.sixgod.dllo.anews.base.BaseRecyclerAdapter;
import com.sixgod.dllo.anews.base.LoadListener;
import com.sixgod.dllo.anews.db.Attention;
import com.sixgod.dllo.anews.db.AttentionHelper;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/5.
 */
public class DiscussAdapter extends BaseRecyclerAdapter<DiscussData.DataEntity.ExpertListEntity> {
    private Context context;
    private AttentionHelper helper;
    private AttentionListener listener;

    public void setListener(AttentionListener listener) {
        this.listener = listener;
    }

    public void setContext(Context context) {
        this.context = context;
        helper = AttentionHelper.newHelper(context);
    }

    public DiscussAdapter(RecyclerView recyclerView, LoadListener listener, ArrayList<DiscussData.DataEntity.ExpertListEntity> data) {
        super(recyclerView, listener, data);
    }

    @Override
    protected RecyclerView.ViewHolder holders(ViewGroup parent, int viewType) {
        return new DiscussHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discuss, parent, false));
    }

    @Override
    protected boolean hasThreePicModeViewType(int position) {
        return false;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (getItemViewType(position) == CONTENT_MODE || getItemViewType(position) == TOP_MODE) {

            DiscussHolder holder1 = (DiscussHolder) holder;
            holder1.positon = position;
            holder1.name.setText(data.get(position).getName());
            holder1.title.setText(data.get(position).getTitle());
            holder1.draweeView.setImageURI(Uri.parse(data.get(position).getPicurl()));
            holder1.face.setImageURI(Uri.parse(data.get(position).getHeadpicurl()));
            holder1.content.setText(data.get(position).getAlias());
            holder1.followCount.setText("关注  " + String.valueOf(data.get(position).getConcernCount()));
            holder1.questionCount.setText("提问  " + data.get(position).getQuestionCount());
            holder1.type.setText(data.get(position).getClassification());
        }

    }

    class DiscussHolder extends RecyclerView.ViewHolder {
        private TextView name, title, content, questionCount, type, followCount;
        private SimpleDraweeView draweeView, face;
        private int positon;
        private LinearLayout layout;
        private Button addAttention;

        public DiscussHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.discuss_item_name);
            title = (TextView) itemView.findViewById(R.id.discuss_item_title);
            content = (TextView) itemView.findViewById(R.id.discuss_item_content_tv);
            draweeView = (SimpleDraweeView) itemView.findViewById(R.id.discuss_image);
            face = (SimpleDraweeView) itemView.findViewById(R.id.discuss_image_face);
            questionCount = (TextView) itemView.findViewById(R.id.discuss_item_question_tv);
            type = (TextView) itemView.findViewById(R.id.discuss_item_type_tv);
            followCount = (TextView) itemView.findViewById(R.id.discuss_item_follow_tv);
            layout = (LinearLayout) itemView.findViewById(R.id.item_discuss_layout);
            addAttention = (Button) itemView.findViewById(R.id.item_disscuss_attention);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    MySingleDiscussData data1 = new MySingleDiscussData(data.get(positon).getExpertId(), data.get(positon).getTitle() + " :   " + data.get(positon).getName());
//                    EventBus.getDefault().post(data1);
//                    Log.i("dfghsadsfa", "&&&&&&&&&&&&&");

                    Intent intent = new Intent(context, ChildDiscussActivity.class);
                    intent.putExtra("id",data.get(positon).getExpertId());
                    intent.putExtra("title",data.get(positon).getTitle() + " :   " + data.get(positon).getName());
                    context.startActivity(intent);
                }
            });
            addAttention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helper.insertAttention(data.get(positon).getExpertId(), data.get(positon).getTitle() + " :   " + data.get(positon).getName());
                    Attention singleAttention = new Attention();
                    singleAttention.setTitle(data.get(positon).getTitle() + " :   " + data.get(positon).getName());
                    singleAttention.setUrl(data.get(positon).getExpertId());
                    listener.attention(singleAttention);
                    Toast.makeText(context, "关注成功,滑动屏幕左侧查看", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public interface AttentionListener {
        public void attention(Attention attention);
    }

}
