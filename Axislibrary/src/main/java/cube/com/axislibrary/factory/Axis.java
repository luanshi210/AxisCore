package cube.com.axislibrary.factory;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class Axis {
	private static int w;
	private static int h;
	private static float scaledDensity;


	public static void init(Context context,int width,int height) {
		AxisConfig.mContext = context;
		Config.width = width;
		Config.height = height;
		DisplayMetrics metrics = new DisplayMetrics();
		WindowManager mWindowManager  = (WindowManager) AxisConfig.mContext .getSystemService(Context.WINDOW_SERVICE);
		mWindowManager.getDefaultDisplay().getMetrics(metrics);
		w = metrics.widthPixels;
		h = metrics.heightPixels;
		scaledDensity = metrics.scaledDensity;
	}

	public static int scaleX(int x) {
		return scaleX(x, 0);
	}

	public static int scaleY(int y) {
		return scaleY(y, 0);
	}

	public static int toDesignX(int x) {
		return (int) (x * Config.width / w);
	}

	public static int toDesignY(int y) {
		return (int) (y * Config.height / h);
	}

	public static int scaleX(int x, float ox) {
		return (int) (x * (w - w * ox) / (Config.width - Config.width * ox));
	}

	public static int scaleY(int y, float oy) {
		return (int) (y * (h - h * oy) / (Config.height - Config.height * oy));
	}

	public static int getWidth() {
		return w;
	}

	public static int getHeight() {
		return h;
	}

	public static int scale(int x) {
		return x * Math.min(w, h) / Config.width;
	}

	public static float scaleTextSize(int textSize) {
		return scale(textSize) / scaledDensity;
	}



}
