package com.sixgod.dllo.anews.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.sixgod.dllo.anews.R;

/**
 * Created by dllo on 16/3/17.
 */
public class RefreshView extends View{
    private int y= 0;
    private Bitmap bitmap;
    private Paint paint= new Paint();
    private int r;
    private boolean refresh= false;
    int i = 0;
    private Handler handler;
    private Thread thread;


    public void setRefresh(boolean refresh) {
        this.refresh = refresh;

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                invalidate();
                return false;
            }
        });
    }

    public RefreshView(Context context) {

        super(context);

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                invalidate();
                return false;
            }
        });
         bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.find);

    }

    public RefreshView(Context context, AttributeSet attrs) {

        super(context, attrs);
        thread =     new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    i += 2;
                    y = y+i;
                    Log.i("draw11111",y+"");
                    handler.sendEmptyMessage(1);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i > 100) {
                        break;
                    }
                }
            }
        });
         bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.find);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
//        canvas.setBitmap(bitmap);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(50);
        Log.i("draw",y+"");
        canvas.drawCircle(100,y, 90, paint);
        if ((!thread.isAlive())&&refresh) {

        thread.start();
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        r = widthMeasureSpec/2;
        Log.i("r",r+"");
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

}
