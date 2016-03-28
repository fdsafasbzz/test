package com.sixgod.dllo.anews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sixgod.dllo.anews.bean.CategoryNewsData;
import com.sixgod.dllo.anews.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/2.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.Holder> {
    ArrayList<CategoryNewsData> datas;

    public TestAdapter() {
        super();
    }

    public TestAdapter(ArrayList<CategoryNewsData> datas) {
        this.datas = datas;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Log.i("holder", datas.get(2).getTitle());
        return new TestAdapter.Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_category, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
//        Log.i("OnBind111", position + "  " + datas.get(position).getTitle());
        holder.textView.setText(datas.get(position).getTitle());
    }

    @Override
    public int getItemCount() {

        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }

    public void addData(ArrayList<CategoryNewsData> data) {
        datas = data;
        notifyDataSetChanged();
    }


    class Holder extends RecyclerView.ViewHolder {
        private TextView textView;

        public Holder(View itemView) {
            super(itemView);
//            textView = (TextView) itemView.findViewById(R.id.refresh_tv);
        }
    }
    class Load extends RecyclerView.ViewHolder{

        public Load(View itemView) {
            super(itemView);
        }
    }
}
