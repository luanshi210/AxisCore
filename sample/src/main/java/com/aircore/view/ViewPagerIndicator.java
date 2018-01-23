package com.aircore.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aircore.R;

import java.util.List;

import cube.com.axislibrary.factory.Axis;


/**
 * Created by zhoujiaqi on 2017/9/21.
 */
public class ViewPagerIndicator extends LinearLayout {

    /**
     * 指示器文字位置
     */

    private int IndicatePosition = 1;

    /**
     * 绘制矩形的画笔
     */
    private Paint mPaint;
    /**
     * path构成一个矩形
     */
    private Path mPath;
    /**
     * 矩形的宽度
     */
    private int mTriangleWidth;

    /**
     * 画笔颜色
     */
    private int IndicatorColor = 0xFF006cff;

    /**
     * 矩形的高度
     */
    private int mTriangleHeight = 25; //指示条的高度
    private int mTriangleH;

    private static final float MAGNIFICATION_DEFAULT_TAB = (float) 3.0;
    /**
     * 矩形的宽度为单个Tab的1/3
     */
    private static final double RADIO_TRIANGEL = 1.0f / 3;
    /**
     * 矩形的最大宽度
     */
    private int dimension_triangel_width = (int) (getScreenWidth() / 3 * RADIO_TRIANGEL);

    /**
     * 初始时，矩形指示器的偏移量
     */
    private int mInitTranslationX;
    /**
     * 手指滑动时的偏移量
     */
    private float mTranslationX;

    /**
     * 默认的Tab数量
     */
    private  final int COUNT_DEFAULT_TAB = 3;
    /**
     * tab数量
     */
    private int mTabVisibleCount = COUNT_DEFAULT_TAB;

    /**
     * tab上的内容
     */
    private List<String> mTabTitles;
    /**
     * 与之绑定的ViewPager
     */
    public ViewPager mViewPager;


    /**
     * 标题正常时的颜色
     */
    private   int COLOR_TEXT_NORMAL = 0xFF999999;

    /**
     * 标题选中时的颜色
     */
    private   int COLOR_TEXT_HIGHLIGHTCOLOR = 0xFFFFFFFF;

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 获得自定义属性，tab的数量
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ViewPagerIndicator);
        mTabVisibleCount = 6;
        //设置指示条宽度的放大系数
        float magnification = 1.0f / 4;
        dimension_triangel_width = (int) (getScreenWidth() / 3 * magnification);

        if (mTabVisibleCount < 0)
            mTabVisibleCount = COUNT_DEFAULT_TAB;
        a.recycle();

        // 初始化画笔
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(IndicatorColor);
        mPaint.setStyle(Style.FILL);
        //mPaint.setPathEffect(new CornerPathEffect(4));
    }



    /**
     * 绘制指示器
     */
    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawColor(0x00FFFFFF);
        canvas.save();
        // 画笔平移到正确的位置
        canvas.translate(mInitTranslationX + mTranslationX,  IndicatePosition);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        super.dispatchDraw(canvas);
    }

    /**
     * 初始化矩形的宽度
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mTriangleH = (int) (w / mTabVisibleCount * RADIO_TRIANGEL);
        // width
        mTriangleWidth = Math.min(dimension_triangel_width, dimension_triangel_width);

        //初始化矩形指示器
        iniTrectangle();

        // 初始时的偏移量
        mInitTranslationX = getWidth() / mTabVisibleCount / 2 - mTriangleWidth
                / 2;
    }

    /**
     * 设置可见的tab的数量
     *
     * @param count
     */
    public void setVisibleTabCount(int count) {
        this.mTabVisibleCount = count;
    }

    public void setIndicatePosition(int IndicatePosition){
        this.IndicatePosition = getHeight();
        invalidate();
    }

    /**
     * 设置tab的标题内容 可选，可以自己在布局文件中写死
     *
     * @param datas
     */
    public void setTabItemTitles(List<String> datas) {
        // 如果传入的list有值，则移除布局文件中设置的view
        if (datas != null && datas.size() > 0) {
            this.removeAllViews();
            this.mTabTitles = datas;

            for (String title : mTabTitles) {
                // 添加view
                addView(generateTextView(title));
            }
            // 设置item的click事件
            setItemClickEvent();
        }

    }

    /**
     * 对外的ViewPager的回调接口
     */
    public interface PageChangeListener {
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels);

        public void onPageSelected(int position);

        public void onPageScrollStateChanged(int state);
    }

    // 对外的ViewPager的回调接口
    private PageChangeListener onPageChangeListener;

    // 对外的ViewPager的回调接口的设置
    public void setOnPageChangeListener(PageChangeListener pageChangeListener) {
        this.onPageChangeListener = pageChangeListener;
    }

    // 设置关联的ViewPager
    public void setViewPager(ViewPager mViewPager, int pos) {
        this.mViewPager = mViewPager;

        mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // 设置字体颜色高亮
                resetTextViewColor();
                highLightTextView(position);

                // 回调
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(position);
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                // 滚动
                scroll(position, positionOffset);

                // 回调
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(position,
                            positionOffset, positionOffsetPixels);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // 回调
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(state);
                }

            }
        });
        // 设置当前页
        mViewPager.setCurrentItem(pos);
        // 高亮
        highLightTextView(pos);
    }

    /**
     * 设置指示器颜色
     */
    public  void setIndicatorColor(int IndicatorColor){
        this.IndicatorColor = IndicatorColor;
        mPaint.setColor(IndicatorColor);
        invalidate();

    }

    /**
     * 设置正常标题颜色
     * @param COLOR_TEXT_NORMAL
     */
    public void setCOLOR_TEXT_NORMAL(int COLOR_TEXT_NORMAL) {
        this.COLOR_TEXT_NORMAL = COLOR_TEXT_NORMAL;
    }
    /**
     * 设置选中标题颜色
     * @param COLOR_TEXT_HIGHLIGHTCOLOR
     */
    public void setCOLOR_TEXT_HIGHLIGHTCOLOR(int COLOR_TEXT_HIGHLIGHTCOLOR) {
        this.COLOR_TEXT_HIGHLIGHTCOLOR = COLOR_TEXT_HIGHLIGHTCOLOR;
    }

    /**
     * 高亮文本
     *
     * @param position
     */
    protected void highLightTextView(int position) {
        View view = getChildAt(position);
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(COLOR_TEXT_HIGHLIGHTCOLOR);
            ((TextView) view).setTextSize(Axis.scaleTextSize(36));
        }
    }

    /**
     * 重置文本颜色
     */
    private void resetTextViewColor() {
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(COLOR_TEXT_NORMAL);
                ((TextView) view).setTextSize(Axis.scaleTextSize(28));
            }
        }
    }

    /**
     * 设置点击事件
     */
    public void setItemClickEvent() {
        int cCount = getChildCount();
        for (int i = 0; i < cCount; i++) {
            final int j = i;
            View view = getChildAt(i);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.setCurrentItem(j);
                }
            });
        }
    }

	/**
	 * 根据标题生成我们的TextView
	 * 
	 * @param text
	 * @return
	 */
	private TextView generateTextView(String text)
	{
		TextView tv = new TextView(getContext());
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		lp.width = getScreenWidth() / mTabVisibleCount;
		tv.setGravity(Gravity.CENTER);
		tv.setTextColor(COLOR_TEXT_NORMAL);
        tv.setText(text);
        tv.setTextSize(Axis.scaleTextSize(28));
		tv.setLayoutParams(lp);
		return tv;
	}

    /**
     * 初始化矩形指示器
     */
    private void iniTrectangle() {
        mPath = new Path();
        mPath.rewind();
        mTriangleHeight = 50;//指示条的高度

        mPath.moveTo(mTriangleWidth, mTriangleHeight / 5);
        mPath.lineTo(-mTriangleWidth / 100, mTriangleHeight / 5);
        mPath.lineTo(-mTriangleWidth / 100, -mTriangleHeight / 5);
        mPath.lineTo(mTriangleWidth, -mTriangleHeight / 5);
        mPath.close();
    }

    /**
     * 指示器跟随手指滚动，以及容器滚动
     *
     * @param position
     * @param offset
     */
    public void scroll(int position, float offset) {
        /**
         * <pre>
         *  0-1:position=0 ;1-0:postion=0;
         * </pre>
         */
        // 不断改变偏移量，invalidate
        mTranslationX = getWidth() / mTabVisibleCount * (position + offset);

        int tabWidth = getScreenWidth() / mTabVisibleCount;

        // 容器滚动，当移动到倒数最后一个的时候，开始滚动
        if (offset > 0 && position >= (mTabVisibleCount - 2)
                && getChildCount() > mTabVisibleCount) {
            if (mTabVisibleCount != 1) {
                this.scrollTo((position - (mTabVisibleCount - 2)) * tabWidth
                        + (int) (tabWidth * offset), 0);
            } else
            // 为count为1时 的特殊处理
            {
                this.scrollTo(
                        position * tabWidth + (int) (tabWidth * offset), 0);
            }
        }

        invalidate();
    }

    /**
     * 设置布局中view的一些必要属性；如果设置了setTabTitles，布局中view则无效
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        int cCount = getChildCount();

        if (cCount == 0)
            return;

        for (int i = 0; i < cCount; i++) {
            View view = getChildAt(i);
            LayoutParams lp = (LayoutParams) view
                    .getLayoutParams();
            lp.weight = 0;
            lp.width = getScreenWidth() / mTabVisibleCount;
            view.setLayoutParams(lp);
        }
        // 设置点击事件
        setItemClickEvent();

    }

    /**
     * 获得屏幕的宽度
     *
     * @return
     */
    public int getScreenWidth() {
        WindowManager wm = (WindowManager) getContext().getSystemService(
                Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

}
