package com.sixgod.dllo.anews.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sixgod.dllo.anews.bean.ChooseNewsData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.tool.MoveListener;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dllo on 16/3/8.
 */
public class LikeNewsCategoryAdapter extends RecyclerView.Adapter<LikeNewsCategoryAdapter.AllNewsTypeHolder> implements MoveListener {
    private ArrayList<ChooseNewsData> types;
    private AllTypeItemListener listener;
    private static LikeNewsCategoryAdapter adapter;


    public ArrayList<ChooseNewsData> getTypes() {
        return types;
    }

    private LikeNewsCategoryAdapter() {
        super();
        types = new ArrayList<>();
    }

    public static LikeNewsCategoryAdapter newLikeNewsAdapter() {
        if (adapter == null) {
            adapter = new LikeNewsCategoryAdapter();

        }
        return adapter;
    }

    @Override
    public AllNewsTypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AllNewsTypeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_like_news_type, parent, false));
    }

    @Override
    public void onBindViewHolder(AllNewsTypeHolder holder, int position) {
        holder.position = position;
        holder.textView.setText(types.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return types != null && types.size() > 0 ? types.size() : 0;
    }

    public void upData(ChooseNewsData chooseNewsData) {
        if (!types.contains(chooseNewsData)) {
            types.add(chooseNewsData);
            notifyItemInserted(getItemCount() - 1);
        }
    }

    public void setTypes(ArrayList<ChooseNewsData> types) {
        this.types = types;
        notifyDataSetChanged();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(types, fromPosition, toPosition);
        //刷新适配器
        //实时刷新刷新移动后的状态
        notifyItemMoved(fromPosition, toPosition);
        String a ="";
        for (int i = 0; i < types.size(); i++) {
             a +=types.get(i).getTitle();
        }
        Log.i("typeccontent",a);
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        types.remove(position);
        //刷新移除数据后的状态.
        notifyItemRemoved(position);
    }

    class AllNewsTypeHolder extends RecyclerView.ViewHolder {
        TextView textView;
        int position;

        public AllNewsTypeHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.like_news_type_tv);
//            textView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (types.size()>position&&types.contains(types.get(position))) {
//                        types.remove(position);
//                        notifyItemRemoved(position);
//                    }
//                    else notifyDataSetChanged();
//
//                }
//            });
        }
    }

    public interface AllTypeItemListener {
        void onClick(View v, String tag);
    }


}
