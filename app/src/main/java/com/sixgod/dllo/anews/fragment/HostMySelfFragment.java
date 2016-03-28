package com.sixgod.dllo.anews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.base.BaseFragment;
import com.sixgod.dllo.anews.net.NetHelper;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;

/**
 * Created by dllo on 16/3/2.
 */
public class HostMySelfFragment extends BaseFragment{
    private RelativeLayout loginLayout;
    private ImageView head;
    private TextView name;


    @Override
    protected void initView() {
        loginLayout = getView(R.id.fragment_myself_login_layout);
        head = getView(R.id.fragment_myself_head);
        name = getView(R.id.fragment_myself_name);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_myself;
    }

    @Override
    protected void initData() {
        loginLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareSDK.initSDK(getActivity());
                Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
                if ((platform.isAuthValid())){
                    platform.removeAccount();
                }
                platform.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        name.setText(platform.getDb().getUserName());
                        NetHelper helper = new NetHelper();
                        helper.setImage(head,platform.getDb().getUserIcon());
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
                platform.SSOSetting(false);
                platform.showUser(null);
            }
        });
    }
}
