package com.aircore.view;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;



public class BaseRelativeLayout extends RelativeLayout implements GestureDetector.OnGestureListener{

    private static final String TAG = BaseRelativeLayout.class.getSimpleName();
    private static final int MIN_OFFSET_VALUE = 120;
    private GestureDetector mGestureDetector;
    private DirectionControlListener mDirectionControlListener;
    private View v;
    public BaseRelativeLayout(Context context) {
        super(context);
        init(context);
    }
    
    private void init(Context context) {
        mGestureDetector = new GestureDetector(context,this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mGestureDetector.onTouchEvent(ev);
        super.dispatchTouchEvent(ev);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Log.i(TAG, "onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        Log.i(TAG, "onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Log.i(TAG, "onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v0, float v1) {
        Log.i(TAG, "onScroll:"+motionEvent.getY());
        float offsetY = motionEvent.getY() - motionEvent1.getY();//Y方向偏移量
       // LogUtils.e("onScroll-----",offsetY+"");
        if (mDirectionControlListener != null) {
            mDirectionControlListener.onScroll(v);
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Log.i(TAG, "onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i(TAG, "onFling");

        float offsetX = e1.getX() - e2.getX();//X方向偏移量
        float offsetY = e1.getY() - e2.getY();//Y方向偏移量


        if (Math.abs(offsetX) > Math.abs(offsetY)) {//左滑或者右滑
            if (e1.getX() - e2.getX() > MIN_OFFSET_VALUE) {
                if (mDirectionControlListener != null) {//左滑
                    mDirectionControlListener.leftSlide(v);
                }
            } else {
                if (mDirectionControlListener != null) {//右滑
                    mDirectionControlListener.rightSlide(v);
                }
            }
        } else {//上滑或者下滑
            if (e1.getY() - e2.getY() > MIN_OFFSET_VALUE) {
                if (mDirectionControlListener != null) {//上滑
                    mDirectionControlListener.upSlide(v);
                }
            } else {
                if (mDirectionControlListener != null) {//下滑
                    mDirectionControlListener.downSlide(v);
                }
            }
        }
        return true;
    }

    public void setControlStateListener(DirectionControlListener listener, View v) {
        mDirectionControlListener = listener;
        this.v = v;
    }

}
