package com.sixgod.dllo.anews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.sixgod.dllo.anews.activity.SingleNewsActivity;
import com.sixgod.dllo.anews.bean.FindResultData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.net.SingleQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dllo on 16/3/14.
 */
public class FindFragment extends Fragment {
    private ArrayList<String> hotWords;
    private RecyclerView recyclerView;
    private EditText et;
    private RequestQueue queue;
    private Button btn,backBtn;
    private FindResultData result;
    private BackListener listener;

    public void setListener(BackListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_find, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_news_find_content_rv);
        et = (EditText) view.findViewById(R.id.fragment_news_find_content_et);
        btn = (Button) view.findViewById(R.id.fragment_news_find_search_btn);
        backBtn = (Button) view.findViewById(R.id.fragment_news_find_back_btn);
        hotWords = new ArrayList<>();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.goBack();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest("http://c.m.163.com/search/comp/MA%3D%3D/20/" + et.getText().toString() + ".html?deviceId=NjIxRUNGMzItQUUzMi00M0I5LTg3NkYtQkMxOTNDOUQ0REIy&version=NS41LjM%3D&channel=5aS05p2h", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        result = new Gson().fromJson(response, FindResultData.class);
                        recyclerView.setAdapter(new FindResultAdapter());
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(stringRequest);
            }
        });
        queue = SingleQueue.newSingleQueue().getRequestQueue();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://c.m.163.com/nc/search/hotWord.html", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("hot", response.toString());
                try {
                    JSONArray array = response.getJSONArray("hotWordList");
                    Log.i("hot", array.toString());
                    for (int i = 0; i < array.length(); i++) {
                        hotWords.add(array.getJSONObject(i).getString("hotWord"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                recyclerView.setAdapter(new FindAdapter());
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }

    public class FindAdapter extends RecyclerView.Adapter {
      private List<Integer> heights;
        public FindAdapter() {
            heights = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                heights.add(random.nextInt(100)+50);

            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new FindHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_find, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            FindHolder findHolder = (FindHolder) holder;
            findHolder.position =position;
            ViewGroup.LayoutParams params = ((FindHolder) holder).findTv.getLayoutParams();//可以通过params来设置textView的宽高
            params.height = heights.get(position);
            findHolder.findTv.setText(hotWords.get(position));
        }

        @Override
        public int getItemCount() {
            return hotWords.size();
        }


        class FindHolder extends RecyclerView.ViewHolder {
            int position;
            TextView findTv;

            public FindHolder(View itemView) {
                super(itemView);
                findTv = (TextView) itemView.findViewById(R.id.item_find_content);
                findTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            StringRequest stringRequest = new StringRequest("http://c.m.163.com/search/comp/MA%3D%3D/20/" + hotWords.get(position) + ".html?deviceId=NjIxRUNGMzItQUUzMi00M0I5LTg3NkYtQkMxOTNDOUQ0REIy&version=NS41LjM%3D&channel=5aS05p2h", new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    result = new Gson().fromJson(response, FindResultData.class);
                                    recyclerView.setAdapter(new FindResultAdapter());
                                    recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));


                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            });
                            queue.add(stringRequest);
                        }

                });
            }
        }
    }

    public class FindResultAdapter extends RecyclerView.Adapter {


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new FindHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_find_result_head, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            FindHolder findHolder = (FindHolder) holder;
             findHolder.position = position;
            findHolder.findTv.setText(Html.fromHtml(result.getDoc().getResult().get(position).getTitle()));
        }

        @Override
        public int getItemCount() {
            return result.getDoc().getResult().size();
        }

        class FindHolder extends RecyclerView.ViewHolder {
            int position;
            TextView findTv;

            public FindHolder(View itemView) {
                super(itemView);
                findTv = (TextView) itemView.findViewById(R.id.item_find_result_content);
                findTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (result.getDoc().getResult().get(position).getSkipType().equals("doc")) {
                            Intent intent = new Intent(getActivity(), SingleNewsActivity.class);
                            intent.putExtra("id", result.getDoc().getResult().get(position).getDocid());
                            getActivity().startActivity(intent);
                        }
                    }
                });
            }
        }
    }
    public interface BackListener{
        void goBack();
    }

}
