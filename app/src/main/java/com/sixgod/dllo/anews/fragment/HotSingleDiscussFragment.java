//package com.sixgod.dllo.anews.fragment;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.Toolbar;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.sixgod.dllo.anews.bean.SingleDiscussData;
//import com.sixgod.dllo.anews.R;
//import com.sixgod.dllo.anews.adapter.HotSingleDiscussAdapter;
//import com.sixgod.dllo.anews.base.LoadListener;
//import com.sixgod.dllo.anews.net.NetHelper;
//import com.sixgod.dllo.anews.net.NetListener;
//
//import java.util.ArrayList;
//
///**
// * Created by dllo on 16/3/10.
// */
//public class HotSingleDiscussFragment extends Fragment {
//    private RecyclerView recyclerView;
//    private ArrayList<SingleDiscussData.DataEntity.HotListEntity> datas = new ArrayList<>();
//    private String id;
//    Toolbar toolbar;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragmet_hot_sigle_disscuss,container,false);
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//          toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_hot_single_discuss_rv);
////        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
////        collapsingToolbar.setTitle("cheeseName");
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        id = getArguments().getString("id");
////        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
////        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        NetHelper helper = new NetHelper();
//
//        helper.getInfo("http://c.m.163.com/newstopic/qa/" + id + ".html", SingleDiscussData.class, new NetListener<SingleDiscussData>() {
//
//            @Override
//            public void getSucceed(SingleDiscussData singleDiscussData) {
//                HotSingleDiscussAdapter adapter = new HotSingleDiscussAdapter(recyclerView, new LoadListener() {
//                    @Override
//                    public void refresh() {
//
//
//
//
//                    }
//
//                    @Override
//                    public void topRefresh() {
//
//                    }
//                }, singleDiscussData.getData().getHotList());
//
//                recyclerView.setAdapter(adapter);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//
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
//
//    }
//
//
//}
