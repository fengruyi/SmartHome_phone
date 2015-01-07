package com.android.smarthome_phone;

import com.fengruyi.common.util.AppManager;

import android.app.Activity;
import android.os.Bundle;
/**
 * 应用基类activity，其他的需要继承，方便管理
 * @author fengruyi
 *
 */
public class BaseActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		AppManager.getAppManager().addActivity(this);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppManager.getAppManager().finishActivity(this);
	}
}
