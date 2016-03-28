package com.sixgod.dllo.anews.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.adapter.ThreePicNewsVpAdapter;
import com.sixgod.dllo.anews.base.BaseActivity;
import com.sixgod.dllo.anews.net.SingleQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by dllo on 16/3/14.
 */
public class ThreePicNewsActivity extends BaseActivity{
    private ViewPager viewPager;
    private ThreePicNewsVpAdapter adapter;
    private ImageButton imageButton;
    private ArrayList<String> imgUrl;
    private ArrayList<String> titles;
    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.activity_three_pic_vp);
        imageButton = (ImageButton) findViewById(R.id.activity_three_ibtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
//        http://c.3g.163.com/photo/api/set/0026/95208.json
       String photoId=intent.getStringExtra("photoId");
        String a = photoId.replace("|", "/");
        String urlId = a.substring(4, photoId.length());
        imgUrl = new ArrayList<String>();
        titles = new ArrayList<String>();
        Log.i("33333three", "http://c.3g.163.com/photo/api/set/" + urlId + ".json");


        RequestQueue queue = SingleQueue.newSingleQueue().getRequestQueue();
        final JsonObjectRequest requset = new JsonObjectRequest("http://c.3g.163.com/photo/api/set/" + urlId + ".json", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray  array = response.getJSONArray("photos");
                    for (int i = 0; i <array.length() ; i++) {
                        JSONObject o = array.getJSONObject(i);
                        imgUrl.add(o.getString("imgurl"));
                        titles.add(o.getString("note"));
                    }
                    adapter = new ThreePicNewsVpAdapter(imgUrl, titles, ThreePicNewsActivity.this);
                    viewPager.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(requset);
//adapter = new FirstItemViewPagerAdapter()
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
        oks.setText(titles.get(0));
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        oks.setImageUrl(imgUrl.get(0));
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
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
        return R.layout.acitivyt_three_pic;
    }
}
