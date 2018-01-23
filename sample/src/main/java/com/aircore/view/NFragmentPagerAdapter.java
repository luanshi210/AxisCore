package com.aircore.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class NFragmentPagerAdapter extends FragmentPagerAdapter {
	ArrayList<Fragment> list;

	public NFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
		super(fm);
		this.list = list;

	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Fragment getItem(int arg0) {
		return list.get(arg0);
	}

}
