//package com.sixgod.dllo.anews.fragment;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.google.gson.Gson;
//import com.sixgod.dllo.anews.bean.MySingleReadData;
//import com.sixgod.dllo.anews.bean.SingleReadData;
//import com.sixgod.dllo.anews.R;
//import com.sixgod.dllo.anews.adapter.SingleReadAdapter;
//import com.sixgod.dllo.anews.net.SingleQueue;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
///**
// * Created by dllo on 16/3/14.
// */
//public class SingleReadFragment extends Fragment{
//    private RequestQueue queue ;
//    private String id;
//    private SingleReadData data;
//    private ArrayList<MySingleReadData> datas;
//    private RecyclerView rv;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.activity_single_read,container,false);
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        queue = SingleQueue.newSingleQueue().getRequestQueue();
//        rv = (RecyclerView) view.findViewById(R.id.activity_read_rv);
////        webView = (WebView) findViewById(R.id.activity_read_wb);
//        datas = new ArrayList<>();
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        id = getArguments().getString("id");
//        String url = " http://c.m.163.com/nc/article/"+id+"/full.html";
//        Log.i("666666123415166", url);
//        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONObject o = response.getJSONObject(id);
//                    data = new Gson().fromJson(o.toString(),SingleReadData.class);
//                    String body  = data.getBody();
//                    if (body==null){
//                        Toast.makeText(getActivity(), "正在维护中请浏览其他", Toast.LENGTH_SHORT).show();
////                        SingleReadActivity.this.finish();
//                    }
//                    String[] content = body.split("<\\/p>");
//                    int j  = 0;
//                    for (int i = 0; i <content.length ; i++) {
//                        MySingleReadData readData = new MySingleReadData();
//                        if (content[i].contains("IMG#")){
//                            readData.setImgUrl(data.getImg().get(j).getSrc());
//                            j++;
//                        }
//                        Log.i("img", content[i]);
//                        readData.setContent(content[i]);
//                        datas.add(readData);
//                        SingleReadAdapter adapter = new SingleReadAdapter(datas);
//                        adapter.setTitle(data.getTitle());
//                        adapter.setTime(data.getPtime());
//                        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
//                        rv.setAdapter(adapter);
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        queue.add(request);
//
//    }
//}
