package com.android.smarthome_phone.ui;

import com.android.smarthome_phone.R;


import com.android.smarthome_phone.view.HorizonRollingView;
import com.fengruyi.common.adapter.MyBaseAdapter.ViewHolder;
import com.fengruyi.common.util.ViewUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FragmentHotelControl extends Fragment implements OnClickListener{
	private HorizonRollingView mHorizonRollingView;
	private Button mBtn1,mBtn2,mBtn3,mBtn4,mBtn5,mBtn6,mBtn7;
	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_hotelcontrol_layout, null);
		mHorizonRollingView = (HorizonRollingView) view.findViewById(R.id.rollingview);
		int[] resid = new int[]{R.drawable.banner_bs};
		mHorizonRollingView.setData(resid, false);
		
		mBtn1  = (Button) view.findViewById(R.id.menu_lights);
		mBtn2  = (Button) view.findViewById(R.id.menu_air);
		mBtn3  = (Button) view.findViewById(R.id.menu_music);
		mBtn4  = (Button) view.findViewById(R.id.menu_curtain);
		mBtn5  = (Button) view.findViewById(R.id.menu_scene);
		mBtn6  = (Button) view.findViewById(R.id.menu_service);
		mBtn7  = (Button) view.findViewById(R.id.menu_tv);
		ViewUtil.setOnClickListener(this, mBtn1,mBtn2,mBtn3,mBtn4,mBtn5,mBtn6,mBtn7);
		return view;
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.menu_lights:
			((MainActivity)getActivity()).startActivity(LightsControlActivity.class);
			break;
		case R.id.menu_air:
			
			break;	
		case R.id.menu_music:
			
			break;
		case R.id.menu_curtain:
			
			break;
		case R.id.menu_scene:
					
			break;
		case R.id.menu_service:
			
			break;
		case R.id.menu_tv:
			
			break;
		default:
			break;
		}
	}
}
