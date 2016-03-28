//package com.sixgod.dllo.anews.fragment;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.design.widget.CollapsingToolbarLayout;
//import android.support.v4.app.Fragment;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.CompoundButton;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.Switch;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.google.gson.Gson;
//import com.sixgod.dllo.anews.bean.SingleDiscussData;
//import com.sixgod.dllo.anews.R;
//import com.sixgod.dllo.anews.adapter.HotSingleDiscussAdapter;
//import com.sixgod.dllo.anews.adapter.LateSingleDiscussAdapter;
//import com.sixgod.dllo.anews.base.LoadListener;
//import com.sixgod.dllo.anews.db.AttentionHelper;
//import com.sixgod.dllo.anews.net.NetHelper;
//import com.sixgod.dllo.anews.net.NetListener;
//import com.sixgod.dllo.anews.net.SingleQueue;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
///**
// * Created by dllo on 16/3/14.
// */
//public class SingleDisCussFragment extends Fragment{
//    private NetHelper helper;
//    private FrameLayout hot;
//    private FrameLayout late;
//    private Switch sBtn;
//    private RecyclerView recyclerView;
//    private String id;
//    private HotSingleDiscussAdapter hotAdapter;
//    private LateSingleDiscussAdapter lateAdapter;
//    private Toolbar toolbar;
//    private ImageView headView;
//    private TextView countTv, contentTv;
//    private CollapsingToolbarLayout collapsingToolbar;
//    private int lateCount = 0;
//    private int hotCount = 0;
//    private RequestQueue queue;
//    private Button btn;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.actvity_single_discuss,container,false);
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        headView = (ImageView) view.findViewById(R.id.activity_single_discuss_backdrop_img);
//        contentTv = (TextView) view.findViewById(R.id.activity_single_discuss_tb_tv);
//        countTv = (TextView) view.findViewById(R.id.activity_single_discuss_count);
//        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_hot_single_discuss_rv);
//        sBtn = (Switch) view.findViewById(R.id.activity_single_discuss_sbtn);
//        toolbar = (Toolbar)view. findViewById(R.id.activity_single_discuss_toolbar);
//        btn = (Button) view.findViewById(R.id.activity_single_discuss_btn);
//        collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.activity_single_discuss_collapsing_toolbar);
//        collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
//        collapsingToolbar.setContentScrimColor(Color.TRANSPARENT);
//        collapsingToolbar.setExpandedTitleColor(Color.TRANSPARENT);
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        id = getArguments().getString("id");
//        final String title = getArguments().getString("title");
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AttentionHelper.newHelper(getActivity()).insertAttention(id,title);
//                Toast.makeText(getActivity(), "添加成功", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        final NetHelper helper = new NetHelper();
//
//        helper.getInfo("http://c.m.163.com/newstopic/qa/" + id + ".html", SingleDiscussData.class, new NetListener<SingleDiscussData>() {
//            @Override
//            public void getSucceed(SingleDiscussData singleDiscussData) {
//                hotAdapter = new HotSingleDiscussAdapter(recyclerView, new LoadListener() {
//                    @Override
//                    public void refresh() {
//                        hotCount += 10;
//
//                        String b = "http://c.m.163.com/newstopic/list/latestqa/" + id + "/" + lateCount + "-10.html";
//                        Log.i("next1111111111111111111", b);
//                        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(b, null, new Response.Listener<JSONObject>() {
//                            @Override
//                            public void onResponse(JSONObject response) {
//                                ArrayList<SingleDiscussData.DataEntity.HotListEntity> list = new ArrayList<SingleDiscussData.DataEntity.HotListEntity>();
//                                Log.i("hllllllload1", response.toString());
//                                try {
//                                    JSONArray array = response.getJSONArray("data");
//                                    Log.i("llllllload2", array.toString());
//
//                                    for (int i = 0; i < array.length(); i++) {
//                                        JSONObject o = array.getJSONObject(i);
//                                        list.add(new Gson().fromJson(o.toString(), SingleDiscussData.DataEntity.HotListEntity.class));
//                                    }
//                                    hotAdapter.refreshView(list);
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }, new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                Log.i("hllllllload1", error.toString());
//
//                            }
//                        });
//                        queue = SingleQueue.newSingleQueue().getRequestQueue();
//                        queue.add(jsonObjectRequest);
//
//                    }
//
//                    @Override
//                    public void topRefresh() {
//
//                    }
//                }, singleDiscussData.getData().getHotList());
//                hotAdapter.setContext(getActivity());
//                recyclerView.setAdapter(hotAdapter);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//                helper.setImage(headView, singleDiscussData.getData().getExpert().getPicurl());
//                contentTv.setText(singleDiscussData.getData().getExpert().getDescription());
//                countTv.setText("----- " + singleDiscussData.getData().getExpert().getConcernCount() / 10000 + "万 -----");
//                collapsingToolbar.setTitle(singleDiscussData.getData().getExpert().getDescription());
//            }
//
//            @Override
//            public void getFailed(String failed) {
//
//            }
//
//            @Override
//            public void getSucceed(ArrayList<SingleDiscussData> list) {
//
//            }
//        });
//
//        sBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
//                hotCount = 0;
//                lateCount = 0;
//
//                String a = "http://c.m.163.com/newstopic/qa/" + id + ".html";
//                helper.getInfo(a, SingleDiscussData.class, new NetListener<SingleDiscussData>() {
//                    @Override
//                    public void getSucceed(final SingleDiscussData singleDiscussData) {
//                        if (!isChecked) {
//                            hotAdapter.upData(singleDiscussData.getData().getHotList());
//                            recyclerView.setAdapter(hotAdapter);
//                        } else {
//                            lateAdapter = new LateSingleDiscussAdapter(recyclerView, new LoadListener() {
//                                @Override
//                                public void refresh() {
//                                    lateCount += 10;
//
//                                    String b = "http://c.m.163.com/newstopic/list/latestqa/" + id + "/" + lateCount + "-10.html";
//                                    Log.i("next1111111111111111111", b);
//                                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(b, null, new Response.Listener<JSONObject>() {
//                                        @Override
//                                        public void onResponse(JSONObject response) {
//                                            ArrayList<SingleDiscussData.DataEntity.LatestListEntity> list = new ArrayList<SingleDiscussData.DataEntity.LatestListEntity>();
//                                            Log.i("hllllllload1", response.toString());
//                                            try {
//                                                JSONArray array = response.getJSONArray("data");
//                                                Log.i("llllllload2", array.toString());
//
//                                                for (int i = 0; i < array.length(); i++) {
//                                                    JSONObject o = array.getJSONObject(i);
//                                                    list.add(new Gson().fromJson(o.toString(), SingleDiscussData.DataEntity.LatestListEntity.class));
//                                                }
//                                                lateAdapter.refreshView(list);
//                                            } catch (JSONException e) {
//                                                e.printStackTrace();
//                                            }
//                                        }
//                                    }, new Response.ErrorListener() {
//                                        @Override
//                                        public void onErrorResponse(VolleyError error) {
//                                            Log.i("hllllllload1", error.toString());
//
//                                        }
//                                    });
//                                    queue = SingleQueue.newSingleQueue().getRequestQueue();
//                                    queue.add(jsonObjectRequest);
//                                }
//
//                                @Override
//                                public void topRefresh() {
//
//                                }
//                            }, singleDiscussData.getData().getLatestList());
//                            lateAdapter.setContext(getActivity());
//
//                            recyclerView.setAdapter(lateAdapter);
//                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//                        }
//                    }
//
//                    @Override
//                    public void getFailed(String failed) {
//
//                    }
//
//                    @Override
//                    public void getSucceed(ArrayList<SingleDiscussData> list) {
//
//                    }
//                });
//
//            }
//        });
//    }
//}
