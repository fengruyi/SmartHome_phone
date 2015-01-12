package com.android.smarthome_phone.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.android.smarthome_phone.BaseFragmentActivity;
import com.android.smarthome_phone.R;
import com.fengruyi.common.util.AppManager;
import com.fengruyi.common.util.DoubleClickCloseUtils;
import com.fengruyi.common.util.ViewUtil;


/**
 * 主页activty
 * @author fengruyi
 *
 */
public class MainActivity extends BaseFragmentActivity implements OnClickListener{
	private DoubleClickCloseUtils mDoubleClickCloseUtils;
	private FragmentTransaction mTransaction;
	private Fragment mFragmentHoltelControl,mFragmentHotelIntroduce,mFragmentMessage,mFragmentSetting;
	private TextView mTab_1,mTab_2,mTab_3,mTab_4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		init();
		switchFragment(1);
	}
	
	private void init(){
		mDoubleClickCloseUtils = new DoubleClickCloseUtils();
		mTab_1 = (TextView) findViewById(R.id.tab_1);
		mTab_2 = (TextView) findViewById(R.id.tab_2);
		mTab_3 = (TextView) findViewById(R.id.tab_3);
		mTab_4 = (TextView) findViewById(R.id.tab_4);
		ViewUtil.setOnClickListener(this, mTab_1,mTab_2,mTab_3,mTab_4);
		
	}
	@SuppressLint("CommitTransaction")
	private void switchFragment(int position){
		mTransaction = getSupportFragmentManager().beginTransaction();
		switch (position) {
		case 1:
			if(mFragmentHoltelControl==null){
				mFragmentHoltelControl = new FragmentHotelControl();
				mTransaction.add(R.id.fragment_container, mFragmentHoltelControl);
			}else{
				if(mFragmentHoltelControl.isAdded()){
					mTransaction.show(mFragmentHoltelControl);
				}else{
					mTransaction.add(R.id.fragment_container, mFragmentHoltelControl);
				}
			}
			if(mFragmentHotelIntroduce!=null&&mFragmentHotelIntroduce.isAdded()){
				mTransaction.hide(mFragmentHotelIntroduce);
			}
			if(mFragmentMessage!=null&&mFragmentMessage.isAdded()){
				mTransaction.hide(mFragmentMessage);
			}
			if(mFragmentSetting!=null&&mFragmentSetting.isAdded()){
				mTransaction.hide(mFragmentSetting);
			}
			break;
		case 2:
			if(mFragmentHotelIntroduce==null){
				mFragmentHotelIntroduce = new FragmentHotelIntroduce();
				mTransaction.add(R.id.fragment_container, mFragmentHotelIntroduce);
			}else{
				if(mFragmentHotelIntroduce.isAdded()){
					mTransaction.show(mFragmentHotelIntroduce);
				}else{
					mTransaction.add(R.id.fragment_container, mFragmentHotelIntroduce);
				}
			}
			if(mFragmentHoltelControl!=null&&mFragmentHoltelControl.isAdded()){
				mTransaction.hide(mFragmentHoltelControl);
			}
			if(mFragmentMessage!=null&&mFragmentMessage.isAdded()){
				mTransaction.hide(mFragmentMessage);
			}
			if(mFragmentSetting!=null&&mFragmentSetting.isAdded()){
				mTransaction.hide(mFragmentSetting);
			}
			break;
		case 3:
			if(mFragmentMessage==null){
				mFragmentMessage = new FragmentMessage();
				mTransaction.add(R.id.fragment_container, mFragmentMessage);
			}else{
				if(mFragmentMessage.isAdded()){
					mTransaction.show(mFragmentMessage);
				}else{
					mTransaction.add(R.id.fragment_container, mFragmentMessage);
				}
			}
			if(mFragmentHotelIntroduce!=null&&mFragmentHotelIntroduce.isAdded()){
				mTransaction.hide(mFragmentHotelIntroduce);
			}
			if(mFragmentHoltelControl!=null&&mFragmentHoltelControl.isAdded()){
				mTransaction.hide(mFragmentHoltelControl);
			}
			if(mFragmentSetting!=null&&mFragmentSetting.isAdded()){
				mTransaction.hide(mFragmentSetting);
			}
			break;
		case 4:
			if(mFragmentSetting==null){
				mFragmentSetting = new FragmentSetting();
				mTransaction.add(R.id.fragment_container, mFragmentSetting);
			}else{
				if(mFragmentSetting.isAdded()){
					mTransaction.show(mFragmentSetting);
				}else{
					mTransaction.add(R.id.fragment_container, mFragmentSetting);
				}
			}
			if(mFragmentHotelIntroduce!=null&&mFragmentHotelIntroduce.isAdded()){
				mTransaction.hide(mFragmentHotelIntroduce);
			}
			if(mFragmentMessage!=null&&mFragmentMessage.isAdded()){
				mTransaction.hide(mFragmentMessage);
			}
			if(mFragmentHoltelControl!=null&&mFragmentHoltelControl.isAdded()){
				mTransaction.hide(mFragmentHoltelControl);
			}
			break;
		default:
			break;
		}
		mTransaction.commit();
	}
	@Override
	public void onBackPressed() {
		if(mDoubleClickCloseUtils.isNeedToClose()){
			AppManager.getAppManager().AppExit(this);
		}else{
			Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();;
		}
		return;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tab_1:
			switchFragment(1);
			break;
		case R.id.tab_2:
			switchFragment(2);
			break;
		case R.id.tab_3:
			switchFragment(3);
			break;
		case R.id.tab_4:
			switchFragment(4);
			break;
		default:
			break;
		}
		
	}
}
