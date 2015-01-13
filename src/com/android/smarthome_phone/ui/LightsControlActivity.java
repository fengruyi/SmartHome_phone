package com.android.smarthome_phone.ui;

import android.os.Bundle;
import android.widget.ListView;

import com.android.smarthome_phone.BaseActivity;
import com.android.smarthome_phone.MyApplicatioin;
import com.android.smarthome_phone.R;
import com.android.smarthome_phone.adapter.LightListAdapter;
/**
 *灯光控制页面
 * @author fengruyi
 *
 */
public class LightsControlActivity extends BaseActivity{
	private ListView mListView;
	private LightListAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_light_control_layout);
		init();
	}
	
	private void init(){
		mListView = (ListView) findViewById(R.id.light_list);
		mAdapter = new LightListAdapter(this, MyApplicatioin.getInstance().getmDevice().getLights_list());
		mListView.setAdapter(mAdapter);
	}
}
