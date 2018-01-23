# 欢迎使用 Axis 适配库
![cmd-markdown-logo](https://octodex.github.com/images/yaktocat.png)

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
        




