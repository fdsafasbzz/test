//package com.sixgod.dllo.anews.fragment;
//
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.facebook.drawee.view.SimpleDraweeView;
//import com.sixgod.dllo.anews.R;
//
///**
// * Created by dllo on 16/3/5.
// */
//public class ItemFirstFragment extends Fragment {
//    private String url;
//    private String title;
//    private TextView textView;
//    private SimpleDraweeView draweeView;
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.vp_item_head, container, false);
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        textView = (TextView) view.findViewById(R.id.vp_item_first_tv);
//        draweeView = (SimpleDraweeView) view.findViewById(R.id.vp_item_first_fresco);
//
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        Uri uri = Uri.parse(url);
//        draweeView.setImageURI(uri);
//        textView.setText(title);
//    }
//}
