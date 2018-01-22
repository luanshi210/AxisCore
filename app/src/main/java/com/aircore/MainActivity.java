package com.aircore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aircore.view.ControlView;


public class MainActivity extends AppCompatActivity {

    //test
    private ControlView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new ControlView(this);
        setContentView(view);

    }

    /**
     * Application 配置基准屏幕 1920*1080
     * @return
     */
    /*private View getView(){
        view = new RelativeLayout(this);

        RelativeLayout middleLayout = new RelativeLayout(this);
        middleLayout.setBackgroundColor(0xFF20B2AA);
        RelativeLayout.LayoutParams middleLayout_Params = new RelativeLayout.LayoutParams(Axis.scaleX(800), Axis.scaleX(800));
        middleLayout_Params.addRule(RelativeLayout.CENTER_IN_PARENT);
        view.addView(middleLayout,middleLayout_Params);

        middleLayout = new RelativeLayout(this);
        middleLayout.setBackgroundColor(0xFF1874CD);
        middleLayout_Params = new RelativeLayout.LayoutParams(Axis.scaleX(400),Axis.scaleX(400));
        middleLayout_Params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        middleLayout_Params.setMargins(0,Axis.scaleX(250),0,0);
        view.addView(middleLayout,middleLayout_Params);

        return view;

    }*/



}
