package com.aircore.view;

import android.view.View;

/**
 * Created by zhoujiaqi on 2017/9/18.
 */

public interface DirectionControlListener {

    void onScroll(View view);

    void leftSlide(View view);

    void rightSlide(View view);

    void upSlide(View view);

    void downSlide(View view);
}
