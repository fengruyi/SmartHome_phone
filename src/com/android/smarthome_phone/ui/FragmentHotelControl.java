package com.android.smarthome_phone.ui;

import com.android.smarthome_phone.R;


import com.android.smarthome_phone.view.HorizonRollingView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentHotelControl extends Fragment{
	private HorizonRollingView mHorizonRollingView;
	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_hotelcontrol_layout, null);
		mHorizonRollingView = (HorizonRollingView) view.findViewById(R.id.rollingview);
		int[] resid = new int[]{R.drawable.banner_bs};
		mHorizonRollingView.setData(resid, false);
		return view;
	}
}
