package com.aircore.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import cube.com.axislibrary.factory.Axis;

public class ControlFragment extends TBaseFragment {

	private static final String FRAGMENT_INDEX = "fragment_index";
	private int mCurIndex = -1;
	private RelativeLayout view;

	public static ControlFragment newInstance(int index) {
		Bundle bundle = new Bundle();
		bundle.putInt(FRAGMENT_INDEX, index);
		ControlFragment fragment = new ControlFragment();
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if(view == null){
			view = new RelativeLayout(context);
			getNView();
			Bundle bundle = getArguments();
			if (bundle != null) {
				mCurIndex = bundle.getInt(FRAGMENT_INDEX);
			}
			setPrepared();
			DataLoad();
		}

		return view;
	}


	public View getNView(){

		BaseRelativeLayout parent = new BaseRelativeLayout(context);
		RelativeLayout.LayoutParams parent_Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
		view.addView(parent,parent_Params);


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

		return  view;
	}



	@Override
	public void onDestroy() {
		super.onDestroy();

	}

	@Override
	protected void DataLoad() {
		if (!canDataLoad()) {
			return;
		}
		Log.e("=====", mCurIndex+"");



	}


}
