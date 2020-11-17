package com.example.appj;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class TestView extends View {

    private Paint mPaint;

    public TestView(Context context) {
        this(context, null, 0);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(100, 100, 100, mPaint);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("TestView", "dispatchTouchEvent: " + event.toString());
//        return super.dispatchTouchEvent(event);
        return true;
//        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TestView", "onTouchEvent: " + event.toString());
        return super.onTouchEvent(event);
//        return true;
    }
}
