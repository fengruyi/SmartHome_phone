package com.android.smarthome_phone;

import com.fengruyi.common.util.AppManager;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
/**
 * 应用基类activity，其他的需要继承，方便管理
 * @author fengruyi
 *
 */
public class BaseFragmentActivity extends FragmentActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.slide_in_right, R.anim.retain_);//以从右往左的动画进入这个页面
		AppManager.getAppManager().addActivity(this);
	}
	
	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(0, R.anim.slide_out_left);//退出页面时从右往左动画退出
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppManager.getAppManager().finishActivity(this);
	}
	
	public void startActivity(Class<? extends Activity> className){
		Intent intent = new Intent(this,className);
		startActivity(intent);
	}
	/**
	 * 通用设备标题的方法
	 * @param str
	 */
	public void setBarTitle(String str){
		((TextView)findViewById(R.id.bar_title)).setText(str);
	}
	
	/**
	 * 通用设备标题的方法
	 * @param resId
	 */
	public void setBarTitle(int resId){
		((TextView)findViewById(R.id.bar_title)).setText(resId);
	}
}
