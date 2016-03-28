package com.sixgod.dllo.anews.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sixgod.dllo.anews.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/2.
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter {
    protected static final int TOP_MODE = 2;
    protected static final int CONTENT_MODE = 0;
    protected static final int BOTTOM_MODE = 1;
    protected static final int THREE_PIC_MODE = 4;
    protected RecyclerView recyclerView;
    private boolean isTop;
    private boolean isBottom;
    protected ArrayList<T> data;
    protected LoadListener listener;
    private boolean refresh = false;
    private boolean hasBottom = true;

    public BaseRecyclerAdapter(RecyclerView recyclerView, final LoadListener listener, ArrayList<T> data) {

        this.recyclerView = recyclerView;
        this.listener = listener;
        this.data = data;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                super.onScrolled(recyclerView, dx, dy);
                if (isBottomed()&&hasBottom) {
                    listener.refresh();
                    hasBottom=false;
                }
                if (isToped()) {
                    if (recyclerView.getChildAt(0).getY() == 0) {
                        if (refresh) {
                            listener.topRefresh();
//                            Toast.makeText(BaseApplication.getContext(), "刷新", Toast.LENGTH_SHORT).show();
                            refresh = false;
                        }
                        refresh = true;
                    }

                }
                if (!isBottomed()){
                    hasBottom = true;
                }

                else {
                    refresh = false;

                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size() + 1;

    }

    @Override
    public int getItemViewType(int position) {
        loadAndRefresh();
        if (position == 0) {
            return TOP_MODE;
        }
        if (position + 1 == getItemCount()) {
            return BOTTOM_MODE;
        }

        else {
            if (position!=0&& hasThreePicModeViewType(position)) {
                return THREE_PIC_MODE;
            }
//            hasThreePicModeViewType(position);
             else return CONTENT_MODE;

        }
    }

    private boolean isBottomed() {
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
        isBottom = (manager.findLastVisibleItemPosition() == getItemCount() - 1);
        return isBottom;
    }

    private boolean isToped() {
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
        isTop = (manager.findFirstVisibleItemPosition() == 0);
        return isTop;
    }

    private void loadAndRefresh() {

    }

    public void refreshView(ArrayList<T> o) {
        this.data.addAll(o);
        notifyItemInserted(getItemCount() - 1);
    }

    public void upData(ArrayList<T> o) {
        this.data = o;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BOTTOM_MODE) {
            ((DownLoad) holder).tv.setText("正  在  加  载");
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BOTTOM_MODE) {
            return new DownLoad(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_load, parent, false));
        } else {
            return holders(parent, viewType);
        }
    }

    class DownLoad extends RecyclerView.ViewHolder {
        private TextView tv;

        public DownLoad(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.load_tv);
        }
    }

    protected abstract RecyclerView.ViewHolder holders(ViewGroup parent, int viewType);

    protected abstract boolean hasThreePicModeViewType(int position);
//    protected abstract RecyclerView.ViewHolder createHolders(ViewGroup parent, int viewType);
}
