package com.sixgod.dllo.anews.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.sixgod.dllo.anews.bean.MySingleReadData;
import com.sixgod.dllo.anews.bean.SingleReadData;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.adapter.SingleReadAdapter;
import com.sixgod.dllo.anews.base.BaseActivity;
import com.sixgod.dllo.anews.net.SingleQueue;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by dllo on 16/3/14.
 */
public class SingleNewsActivity extends BaseActivity {
    private RequestQueue queue;
    private String id;
    private SingleReadData data;
    private ArrayList<MySingleReadData> datas;
    private RecyclerView rv;
    private ImageButton ibtn;

    @Override
    protected void initView() {
        queue = SingleQueue.newSingleQueue().getRequestQueue();
        rv = (RecyclerView) findViewById(R.id.activity_read_rv);
//        webView = (WebView) findViewById(R.id.activity_read_wb);
        ibtn = (ImageButton) findViewById(R.id.activity_single_read_ibtn);
        datas = new ArrayList<>();
        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });
    }

    @Override
    protected void initData() {
        id = getIntent().getStringExtra("id");
        String url = " http://c.3g.163.com/nc/article/" + id + "/full.html";
        Log.i("3333321251235", url);
        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject o = response.getJSONObject(id);
                    data = new Gson().fromJson(o.toString(), SingleReadData.class);
                    String body = data.getBody();
                    if (body == null) {
                        Toast.makeText(SingleNewsActivity.this, "正在维护中请浏览其他", Toast.LENGTH_SHORT).show();
                        SingleNewsActivity.this.finish();
                    }
                    String[] content = body.split("<\\/p>");
                    int j = 0;
                    for (int i = 0; i < content.length; i++) {
                        MySingleReadData readData = new MySingleReadData();
                        if (content[i].contains("IMG#")) {
                            readData.setImgUrl(data.getImg().get(j).getSrc());
                            j++;
                        }
                        readData.setContent(content[i]);
                        datas.add(readData);
                    }
                    SingleReadAdapter adapter = new SingleReadAdapter(datas);
                    adapter.setTitle(data.getTitle());
                    adapter.setTime(data.getPtime());
                    rv.setLayoutManager(new LinearLayoutManager(SingleNewsActivity.this));
                    rv.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);


    }

    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("今日最热新闻");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("");
        // text是分享文本，所有平台都需要这个字段
        oks.setText(data.getTitle());
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        oks.setImageUrl(datas.get(0).getImgUrl());
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("");

// 启动分享GUI
        oks.show(this);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_single_read;
    }
}
