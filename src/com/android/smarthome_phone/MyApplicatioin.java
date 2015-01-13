package com.android.smarthome_phone;
import com.android.smarthome_phone.entity.Lights;
import com.fengruyi.common.app.BaseApplication;
public class MyApplicatioin extends BaseApplication{
	public Lights mDevice;
	private static MyApplicatioin mSingleInstance;
	
	public Lights getmDevice() {
		return mDevice;
	}

	public void setmDevice(Lights mDevice) {
		this.mDevice = mDevice;
	}
	
	public static MyApplicatioin getInstance(){
		return mSingleInstance;
	}
	/**
	 *应用初始工作
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		mSingleInstance = this;
	}
}
