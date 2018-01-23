# 欢迎使用 Axis 适配库
![cmd-markdown-logo](https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1991354765,3873757137&fm=27&gp=0.jpg)

在Android日常开发中，我们经常会遇到各种不同屏幕尺寸的手机，适配是一件很让人头疼的事情，特别是刚接触Android开发的童鞋，**Axis** 是我在开发中常用的方案，一套图（1920*1080）来适配所有的机型。主要是运用了等比缩放的方案，但是在实际开发中，只做X轴的等比，Y轴超出部分用滚动条。
这样就能避免，XY轴同时缩放带来的变形问题。

### Axis是什么?
一个用Java代码动态布局的适配方案。

### Axis怎么用？

其实很简单，先来了解一下，一个View在屏幕中的位置以及形状取决于（x,y,w,h）,既左上角坐标和View的实际宽高。接下来直接看下代码中的使用。


* 获取屏幕 w,h以及scaledDensity。

```
            DisplayMetrics metrics = new DisplayMetrics();
            WindowManager mWindowManager  = (WindowManager) AxisConfig.mContext .getSystemService(Context.WINDOW_SERVICE);
            mWindowManager.getDefaultDisplay().getMetrics(metrics);
            w = metrics.widthPixels;
            h = metrics.heightPixels;
            scaledDensity = metrics.scaledDensity;

```

* 再来看一下核心部分，X轴与Y轴的等比缩放方法

```
            //Config.width  Config.height就是我们UI妹子设计的UI图宽高啦，目前一般都是（1920*1080）
            
            public static int scaleX(int x, float ox) {
            		return (int) (x * (w - w * ox) / (Config.width - Config.width * ox));
            	}
            
            public static int scaleY(int y, float oy) {
            		return (int) (y * (h - h * oy) / (Config.height - Config.height * oy));
            	}

```

        
* 用Android 自带API 动态添加View
```
            //这样就添加了一个View
            
            RelativeLayout middleLayout = new RelativeLayout(getActivity());
     		middleLayout.setBackgroundColor(0xFF20B2AA);
     		RelativeLayout.LayoutParams middleLayout_Params = new RelativeLayout.LayoutParams(Axis.scaleX(800), Axis.scaleX(800));
     		middleLayout_Params.addRule(RelativeLayout.CENTER_IN_PARENT);
     		view.addView(middleLayout,middleLayout_Params);
     
     		middleLayout = new RelativeLayout(getActivity());
     		middleLayout.setBackgroundColor(0xFF1874CD);
     		middleLayout_Params = new RelativeLayout.LayoutParams(Axis.scaleX(400),Axis.scaleX(400));
     		middleLayout_Params.addRule(RelativeLayout.CENTER_HORIZONTAL);
     		middleLayout_Params.setMargins(0,Axis.scaleX(250),0,0);
     		view.addView(middleLayout,middleLayout_Params);              
            
```

* 以上是View的适配，因为用了等比缩放，就直接忽略了屏幕密度，下面说说字体的适配，这个就和屏幕密度有关了，看下面

```
            public static float scaleTextSize(int textSize) {
            		return scale(textSize) / scaledDensity;
            	}            
```

* 再说一下，其实能用XML布局的属性，代码基本上都是有这个属性的，所以用Java代码布局，把界面拆分，做成组件，是一件非常简单的事情，而且复用性相当高的。
比如说HeaderView   BottomView  等等复杂的View都可以封装起来。好了就说到这吧。直接看代码吧。  哈哈哈哈。。。。记得在你的
Application中初始化哦。

```
        Axis.init(this,1080,1920);//适配初始化,基准宽高
```










