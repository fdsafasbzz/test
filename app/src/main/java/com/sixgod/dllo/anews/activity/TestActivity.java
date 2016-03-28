package com.sixgod.dllo.anews.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.sixgod.dllo.anews.R;
import com.sixgod.dllo.anews.View.RefreshView;

/**
 * Created by dllo on 16/3/17.
 */
public class TestActivity extends AppCompatActivity {
    private RefreshView view;
    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        view = (RefreshView) findViewById(R.id.test_refresh);
        layout= (LinearLayout) findViewById(R.id.test_lll);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    view.setRefresh(true);
                    view.invalidate();
                }

                return true;
            }
        });

    }
}
