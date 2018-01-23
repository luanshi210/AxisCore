package com.aircore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aircore.util.BaseUtils;
import com.aircore.view.ControlView;


public class MainActivity extends AppCompatActivity {

    private ControlView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseUtils.setWindowStatusBarColor(this);
        view = new ControlView(this);
        setContentView(view);
    }

}
