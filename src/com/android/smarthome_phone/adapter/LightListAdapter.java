package com.android.smarthome_phone.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.android.smarthome_phone.R;
import com.android.smarthome_phone.entity.LightInfo;
import com.fengruyi.common.adapter.MyBaseAdapter;
public class LightListAdapter extends MyBaseAdapter{
	private List<LightInfo> mlist;
	public LightListAdapter(Context context,List<LightInfo> list){
		super(context);
		mlist = list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mlist==null?0:mlist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public int itemLayoutRes() {
		// TODO Auto-generated method stub
		return R.layout.light_list_item_layout1;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent,ViewHolder holder) {
		LightInfo info = mlist.get(position);
		TextView tv_light_name;
		SeekBar sb_light;
		ToggleButton tbtn_light;
		tv_light_name = holder.obtainView(convertView, R.id.tv_light_name);
		sb_light = holder.obtainView(convertView, R.id.sb_light);
		tbtn_light = holder.obtainView(convertView, R.id.tbtn_light);
		tv_light_name.setText(info.getLight_name());
		if(info.isBrightness_control()){
			sb_light.setVisibility(View.VISIBLE);
		}else{
			sb_light.setVisibility(View.INVISIBLE);
		}
		return convertView;
	}

}
