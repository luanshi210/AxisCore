package com.aircore.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.aircore.LinqiApplication;


public abstract class TBaseFragment extends Fragment{
	public final String TAG=""+getClass().getSimpleName();
	protected boolean isVisible;
	protected boolean mHasLoadedOnce;
	/** 标志位，标志已经初始化完成 */
	private boolean isPrepared;
	public Context context;
	private Activity activity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getActivity();
	}
	public Context getContext() {
		if (activity == null) {
			return LinqiApplication.getInstance();
		}
		return activity;
	}
	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		activity = getActivity();
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);

		if (getUserVisibleHint()) {
			isVisible = true;
			onVisible();
		} else {
			isVisible = false;
			onInvisible();
		}
	}

	protected void onVisible() {
		if (!mHasLoadedOnce && isPrepared) {
			mHasLoadedOnce = true;
			DataLoad();
		}


	}

	protected void setPrepared() {
		isPrepared = true;
	}

	protected void onInvisible() {

	}
	
	protected boolean canDataLoad(){
		if (isPrepared&&isVisible&&!mHasLoadedOnce) {
			mHasLoadedOnce=true;
		}
		return isPrepared&&isVisible;
	}
	protected abstract void DataLoad();
	


	@Override
	public void onDestroy() {
		super.onDestroy();


	}


}
