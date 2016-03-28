package com.sixgod.dllo.anews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sixgod.dllo.anews.bean.ChooseNewsData;
import com.sixgod.dllo.anews.R;

import java.util.List;

/**
 * Created by dllo on 16/3/8.
 */
public class AllNewsTypeAdapter extends RecyclerView.Adapter<AllNewsTypeAdapter.AllNewsTypeHolder>{
    private List<ChooseNewsData> types;
    private AllTypeItemListener listener;

    @Override
    public AllNewsTypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AllNewsTypeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_news_type,parent,false));
    }

    @Override
    public void onBindViewHolder(AllNewsTypeHolder holder, int position) {
        holder.position = position;
        holder.textView.setText(types.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return types!=null&&types.size()>0?types.size():0;
    }
    public void upData(List<ChooseNewsData> types){
        this.types = types;
        notifyDataSetChanged();
    }

    class AllNewsTypeHolder extends RecyclerView.ViewHolder{
      TextView textView;
        int position;
        public AllNewsTypeHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.all_news_type_tv);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LikeNewsCategoryAdapter.newLikeNewsAdapter().upData(types.get(position));

                }
            });
        }
    }

    public interface AllTypeItemListener{
        void onClick(View v,String tag);
    }



}
