package com.aircore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.aircore.util.BaseUtils;
import com.aircore.view.ControlView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


public class MainActivity extends AppCompatActivity {

    private ControlView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseUtils.setWindowStatusBarColor(this);
        view = new ControlView(this);
        setContentView(view);


        String URL = "https://www.ecarobo.com/api/userservice/mobileaccount/getappversion?version=7&appId=102190655212731";
        StringRequest request = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {//s为请求返回的字符串数据
                        Log.e("1111",s);
                        Toast.makeText(MainActivity.this,s+"",Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("aaaaa",volleyError.toString()+"");
                    }
                });
        //设置请求的Tag标签，可以在全局请求队列中通过Tag标签进行请求的查找
        request.setTag("testGet");
        //将请求加入全局队列中
        LinqiApplication.getHttpQueues().add(request);
    }

}
