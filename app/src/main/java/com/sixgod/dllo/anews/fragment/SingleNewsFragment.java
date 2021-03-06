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
//import android.widget.ImageButton;
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
//import cn.sharesdk.framework.ShareSDK;
//import cn.sharesdk.onekeyshare.OnekeyShare;
//
///**
// * Created by dllo on 16/3/15.
// */
//public class SingleNewsFragment extends Fragment {
//    private RequestQueue queue;
//    private String id;
//    private SingleReadData data;
//    private ArrayList<MySingleReadData> datas;
//    private RecyclerView rv;
//    private ImageButton ibtn;
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
//        rv = (RecyclerView)view. findViewById(R.id.activity_read_rv);
////        webView = (WebView) findViewById(R.id.activity_read_wb);
//        ibtn = (ImageButton) view.findViewById(R.id.activity_single_read_ibtn);
//        datas = new ArrayList<>();
//        ibtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showShare();
//            }
//        });
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        id = getArguments().getString("id");
//        String url = " http://c.3g.163.com/nc/article/" + id + "/full.html";
//        Log.i("3333321251235", url);
//        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONObject o = response.getJSONObject(id);
//                    data = new Gson().fromJson(o.toString(), SingleReadData.class);
//                    String body = data.getBody();
//                    if (body == null) {
//                        Toast.makeText(getActivity(), "正在维护中请浏览其他", Toast.LENGTH_SHORT).show();
////                        SingleNewsActivity.this.finish();
//                    }
//                    String[] content = body.split("<\\/p>");
//                    int j = 0;
//                    for (int i = 0; i < content.length; i++) {
//                        MySingleReadData readData = new MySingleReadData();
//                        if (content[i].contains("IMG#")) {
//                            readData.setImgUrl(data.getImg().get(j).getSrc());
//                            j++;
//                        }
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
//
//    }
//    private void showShare() {
//        ShareSDK.initSDK(getActivity());
//        OnekeyShare oks = new OnekeyShare();
//        //关闭sso授权
//        oks.disableSSOWhenAuthorize();
//
//// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
//        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
//        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
//        oks.setTitle("33333");
//        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
//        oks.setTitleUrl("http://sharesdk.cn");
//        // text是分享文本，所有平台都需要这个字段
//        oks.setText("我是分享文本");
//        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
//        // url仅在微信（包括好友和朋友圈）中使用
//        oks.setUrl("http://sharesdk.cn");
//        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("我是测试评论文本");
//        // site是分享此内容的网站名称，仅在QQ空间使用
//        oks.setSite(getString(R.string.app_name));
//        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://sharesdk.cn");
//
//// 启动分享GUI
//        oks.show(getActivity());
//    }
//}
