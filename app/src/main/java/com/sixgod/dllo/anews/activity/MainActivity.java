package com.sixgod.dllo.anews.activity;

import android.support.v4.app.FragmentTransaction;
import android.widget.TabHost;

import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.base.BaseActivity;
import com.sixgod.dllo.anews.fragment.FrameDiscussFragment;
import com.sixgod.dllo.anews.fragment.FrameNewsFragment;
import com.sixgod.dllo.anews.fragment.FrameReadFragment;
import com.sixgod.dllo.anews.fragment.HostMySelfFragment;
import com.sixgod.dllo.anews.fragment.RadioFragment;

public class MainActivity extends BaseActivity {
    private TabHost tb;

    @Override
    protected void initView() {
        tb = (TabHost) findViewById(android.R.id.tabhost);

    }

    @Override
    protected void initData() {
        tb.setup();
        TabHost.TabSpec newsTab = tb.newTabSpec("1");
        newsTab.setContent(R.id.view1);
        newsTab.setIndicator("新闻");
        tb.addTab(newsTab);
        TabHost.TabSpec readTab = tb.newTabSpec("2");
        readTab.setContent(R.id.view2);
        readTab.setIndicator("阅读");
        tb.addTab(readTab);
        TabHost.TabSpec radioTab = tb.newTabSpec("3");
        radioTab.setContent(R.id.view3);
        radioTab.setIndicator("视听");
        tb.addTab(radioTab);

//        TabHost.TabSpec radioTab = tb.newTabSpec("3");
//        newsTab.setContent(R.id.view3);
//        newsTab.setIndicator("视听");
//        tb.addTab(radioTab);




        TabHost.TabSpec disscussTab = tb.newTabSpec("4");
        disscussTab.setContent(R.id.view4);
        disscussTab.setIndicator("话题");
        tb.addTab(disscussTab);


//
//        TabHost.TabSpec myselfTab = tb.newTabSpec("5");
//        disscussTab.setContent(R.id.view5);
//        disscussTab.setIndicator("话题");
//        tb.addTab(disscussTab);

//
        TabHost.TabSpec myselfTab = tb.newTabSpec("5");
        myselfTab.setContent(R.id.view5);
        myselfTab.setIndicator("我");
        tb.addTab(myselfTab);

//        newsTab.setContent(R.id.view5);
//        newsTab.setIndicator("我");
        //        tb.addTab(myselfTab);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.view1, new FrameNewsFragment());
        fragmentTransaction.replace(R.id.view2, new FrameReadFragment());
        fragmentTransaction.replace(R.id.view3, new RadioFragment());
        fragmentTransaction.replace(R.id.view4, new FrameDiscussFragment());
        fragmentTransaction.replace(R.id.view5, new HostMySelfFragment());
        fragmentTransaction.commit();

    }


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }
}
