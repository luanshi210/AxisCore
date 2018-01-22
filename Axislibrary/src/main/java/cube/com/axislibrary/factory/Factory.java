package cube.com.axislibrary.factory;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;



public class Factory {
	public static final int LEFT = 1;
	public static final int TOP = 1 << 1;
	public static final int RIGHT = 1 << 2;
	public static final int BOTTOM = 1 << 3;
	public static final int LEFT_OF = 1 << 4;
	public static final int ABOVE = 1 << 5;
	public static final int RIGHT_OF = 1 << 6;
	public static final int BELOW = 1 << 7;
	
	public static RelativeLayout.LayoutParams createRelativeLayoutParams(int x, int y, int w, int h) {
		return createRelativeLayoutParams(x, y, w, h, 0, 0);
	}
	
	public static RelativeLayout.LayoutParams createRelativeLayoutParams(int x, int y, int w, int h, float ox, float oy) {
		int ix = Axis.scaleX(x, ox);
		int iy = Axis.scaleY(y, oy);
		int iw = w == LayoutParams.WRAP_CONTENT ? LayoutParams.WRAP_CONTENT : w == LayoutParams.MATCH_PARENT ? LayoutParams.MATCH_PARENT : Axis.scaleX(w, ox);
		int ih = h == LayoutParams.WRAP_CONTENT ? LayoutParams.WRAP_CONTENT : h == LayoutParams.MATCH_PARENT ? LayoutParams.MATCH_PARENT : Axis.scaleY(h, oy);
		RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(iw, ih);
		param.setMargins(ix, iy, 0, 0);
		return param;
	}
	

	public static void addToRelativeLayout(final RelativeLayout rl, final View v, final RelativeLayout.LayoutParams params) {
		((Activity)AxisConfig.mContext).runOnUiThread(new Runnable() {
			public void run() {
				if (rl != null && v != null && params != null) {
					rl.addView(v, params);
				}
			}
		});
	}
	
	public static RelativeLayout.LayoutParams createAnchorParams(int id, int x, int y, int anchor) {
		RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		if ((anchor & LEFT) == LEFT) {
			param.addRule(RelativeLayout.ALIGN_LEFT, id);
		}
		if ((anchor & TOP) == TOP) {
			param.addRule(RelativeLayout.ALIGN_TOP, id);
		}
		if ((anchor & RIGHT) == RIGHT) {
			param.addRule(RelativeLayout.ALIGN_RIGHT, id);
		}
		if ((anchor & BOTTOM) == BOTTOM) {
			param.addRule(RelativeLayout.ALIGN_BOTTOM, id);
		}
		if ((anchor & LEFT_OF) == LEFT_OF) {
			param.addRule(RelativeLayout.LEFT_OF, id);
		}
		if ((anchor & ABOVE) == ABOVE) {
			param.addRule(RelativeLayout.ABOVE, id);
		}
		if ((anchor & RIGHT_OF) == RIGHT_OF) {
			param.addRule(RelativeLayout.RIGHT_OF, id);
		}
		if ((anchor & BELOW) == BELOW) {
			param.addRule(RelativeLayout.BELOW, id);
		}
		int ix = Axis.scaleX(x);
		int iy = Axis.scaleY(y);
		param.setMargins(ix, iy, 0, 0);
		return param;
	}
	
	public static LinearLayout.LayoutParams createLinearLayoutParams(int x, int y, int w, int h) {
		return createLinearLayoutParams(x, y, w, h, 0, 0);
	}
	
	public static LinearLayout.LayoutParams createLinearLayoutParams(int x, int y, int w, int h, float ox, float oy) {
		int ix = Axis.scaleX(x, ox);
		int iy = Axis.scaleY(y, oy);
		int iw = w == LayoutParams.WRAP_CONTENT ? LayoutParams.WRAP_CONTENT : w == LayoutParams.MATCH_PARENT ? LayoutParams.MATCH_PARENT : Axis.scaleX(w, ox);
		int ih = h == LayoutParams.WRAP_CONTENT ? LayoutParams.WRAP_CONTENT : h == LayoutParams.MATCH_PARENT ? LayoutParams.MATCH_PARENT : Axis.scaleY(h, oy);
		LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(iw, ih);
		param.setMargins(ix, iy, 0, 0);
		return param;
	}

	/**
	 * 创建一个相对布局
	 * @param w
	 * @param h
     * @return
     */
	public static RelativeLayout.LayoutParams createRLParams(int w, int h) {
		int wi,hi;
		if(w==-1){
			wi= RelativeLayout.LayoutParams.MATCH_PARENT;
		}else if(w==-2){
			wi= RelativeLayout.LayoutParams.WRAP_CONTENT;
		}else{
			wi= Axis.scaleX(w);
		}
		if(h==-1){
			hi= RelativeLayout.LayoutParams.MATCH_PARENT;
		}else if(h==-2){
			hi= RelativeLayout.LayoutParams.WRAP_CONTENT;
		}else{
			hi= Axis.scaleX(h);
		}
		RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(wi, hi);
		return param;
	}

	/**
	 * 创建一个线性布局
	 * @param w
	 * @param h
	 * @return
	 */
	public static LinearLayout.LayoutParams createLLParams(int w, int h) {
		int wi,hi;
		if(w==-1){
			wi= LinearLayout.LayoutParams.MATCH_PARENT;
		}else if(w==-2){
			wi= LinearLayout.LayoutParams.WRAP_CONTENT;
		}else{
			wi= Axis.scaleX(w);
		}
		if(h==-1){
			hi= LinearLayout.LayoutParams.MATCH_PARENT;
		}else if(h==-2){
			hi= LinearLayout.LayoutParams.WRAP_CONTENT;
		}else{
			hi= Axis.scaleX(h);
		}
		LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(wi, hi);
		return param;
	}

	public static void addToLinearLayout(final LinearLayout rl, final View v, final LinearLayout.LayoutParams params) {
		((Activity)AxisConfig.mContext).runOnUiThread(new Runnable() {
			public void run() {
				if (rl != null && v != null && params != null) {
					rl.addView(v, params);
				}
			}
		});
	}
	
}
