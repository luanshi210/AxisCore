package com.aircore.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.aircore.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import cube.com.axislibrary.factory.Axis;
/**
 * Created by zhoujiaqi on 2017/9/21.
 */

public class ControlView extends RelativeLayout {

    private NViewPager mViewPager;//设置关联的Viewpager
    private ViewPagerIndicator mIndicator;//设置关联的Viewpager指示器
    private BaseRelativeLayout dropDownView;
    private Context context;
    public ControlView(Context context) {
        super(context);
        this.context = context;
        init(context);
    }
    public void init(final Context context){
        dropDownView = new BaseRelativeLayout(context);
        dropDownView.setBackgroundColor(0xFF000000);
        dropDownView.setTag("dropDownView");
        RelativeLayout.LayoutParams dropDownView_Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        super.addView(dropDownView,dropDownView_Params);

        LinearLayout bodyLayout = new LinearLayout(context);
        bodyLayout.setOrientation(LinearLayout.VERTICAL);
        RelativeLayout.LayoutParams bodyLayout_Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        dropDownView.addView(bodyLayout,bodyLayout_Params);
        mIndicator = new ViewPagerIndicator(context);


        mIndicator.setBackgroundColor(0x00000000);
        LinearLayout.LayoutParams mIndicator_Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, Axis.scaleX(120));
        bodyLayout.addView(mIndicator,mIndicator_Params);

        mViewPager = new NViewPager(context);
        mViewPager.setId(R.id.control_viewpager);
        bodyLayout.addView(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int arg0) {
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageSelected(int i) {

            }
        });

        initData();
    }

    private void initData() {
        List<String> mTitles;
        mTitles = Arrays.asList("常用", "空调", "电量","车灯", "天窗", "车窗","方向盘", "反光镜", "座椅","雨刮");
        ArrayList<Fragment> fragmentList =  new ArrayList<>();
        ControlFragment mControlFragment0 = ControlFragment.newInstance(0);//常用控制
        fragmentList.add(mControlFragment0);
        mControlFragment0 = ControlFragment.newInstance(1);//常用控制
        fragmentList.add(mControlFragment0);
        mControlFragment0 = ControlFragment.newInstance(2);//常用控制
        fragmentList.add(mControlFragment0);
        mControlFragment0 = ControlFragment.newInstance(3);//常用控制
        fragmentList.add(mControlFragment0);
        mControlFragment0 = ControlFragment.newInstance(4);//常用控制
        fragmentList.add(mControlFragment0);
        mControlFragment0 = ControlFragment.newInstance(5);//常用控制
        fragmentList.add(mControlFragment0);
        mControlFragment0 = ControlFragment.newInstance(6);//常用控制
        fragmentList.add(mControlFragment0);
        mControlFragment0 = ControlFragment.newInstance(7);//常用控制
        fragmentList.add(mControlFragment0);
        mControlFragment0 = ControlFragment.newInstance(8);//常用控制
        fragmentList.add(mControlFragment0);
        mControlFragment0 = ControlFragment.newInstance(9);//常用控制
        fragmentList.add(mControlFragment0);




       NFragmentPagerAdapter pagerAdapter = new NFragmentPagerAdapter(((AppCompatActivity)context).getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setNoScroll(false);
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setCurrentItem(0, true);
        //给tab加上标题
        mIndicator.setTabItemTitles(mTitles);
        //设置关联的ViewPager，默认显示第一个
        mIndicator.setViewPager(mViewPager,0);
    }


}
