package com.android.smarthome_phone.ui;

import com.android.smarthome_phone.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * 酒店介绍
 * @author fengruyi
 *
 */
public class FragmentSetting extends Fragment{
	
	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_setting_layout, null);
		return view;
	}
}
