package com.sixgod.dllo.anews.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sixgod.dllo.anews.EnventBussDatas.MusicStart;
import com.sixgod.dllo.anews.EnventBussDatas.NextMusic;
import com.sixgod.dllo.anews.EnventBussDatas.PeriousMusic;
import com.sixgod.dllo.anews.EnventBussDatas.StopMusic;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.base.BaseActivity;
import com.sixgod.dllo.anews.base.BaseRecyclerAdapter;
import com.sixgod.dllo.anews.base.LoadListener;
import com.sixgod.dllo.anews.bean.ListMusicData;
import com.sixgod.dllo.anews.net.NetHelper;
import com.sixgod.dllo.anews.net.NetListener;
import com.sixgod.dllo.anews.service.MusicControlService;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by dllo on 16/3/18.
 */
public class ListMusicActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private ArrayList<ListMusicData> datas;
    private ListMusicAdapter adapter;
    private ServiceConnection connection;
    private Button next,preious;

    @Override
    protected void initView() {
        next = (Button) findViewById(R.id.activity_list_music_next);
        preious = (Button) findViewById(R.id.activity_list_music_previous);
        recyclerView = (RecyclerView) findViewById(R.id.activity_list_music_title_rv);
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        Intent intent = new Intent(this, MusicControlService.class);
        startService(intent);
        bindService(intent,connection,BIND_AUTO_CREATE);
    }

    @Override
    protected void initData() {
        preious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new PeriousMusic());
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new NextMusic());
            }
        });


        String id = getIntent().getStringExtra("id");
        NetHelper<ListMusicData> helper = new NetHelper<>();
        helper.getInfo("http://c.m.163.com/nc/article/list/", id, "/0", "-20.html", ListMusicData.class, new NetListener<ListMusicData>() {
            @Override
            public void getSucceed(ListMusicData listMusicData) {

            }

            @Override
            public void getFailed(String failed) {

            }

            @Override
            public void getSucceed(ArrayList<ListMusicData> list) {
                datas = list;
                recyclerView.setLayoutManager(new LinearLayoutManager(ListMusicActivity.this));
                EventBus.getDefault().post(list);
                adapter = new ListMusicAdapter(recyclerView, new LoadListener() {
                    @Override
                    public void refresh() {

                    }

                    @Override
                    public void topRefresh() {

                    }
                }, datas);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_list_music;
    }

    class ListMusicAdapter extends BaseRecyclerAdapter<ListMusicData> {


        public ListMusicAdapter(RecyclerView recyclerView, LoadListener listener, ArrayList<ListMusicData> data) {
            super(recyclerView, listener, data);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            super.onBindViewHolder(holder, position);
            if (getItemViewType(position)==CONTENT_MODE||getItemViewType(position)==TOP_MODE){
                ((ListMusicHolder)holder).textView.setText(data.get(position).getTitle());
                ((ListMusicHolder)holder).ID=position;
            }
        }

        @Override
        protected RecyclerView.ViewHolder holders(ViewGroup parent, int viewType) {
            return  new ListMusicHolder(LayoutInflater.from(ListMusicActivity.this).inflate(R.layout.item_list_music,parent,false));
        }

        @Override
        protected boolean hasThreePicModeViewType(int position) {
            return false;
        }

        class ListMusicHolder extends RecyclerView.ViewHolder {
            private TextView textView;
            private int ID;


            public ListMusicHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.item_list_music_name);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicStart start = new MusicStart(data.get(ID).getPostid(),ID);
                        EventBus.getDefault().post(start);

                    }
                });
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().post(new StopMusic());
        unbindService(connection);
    }
}
