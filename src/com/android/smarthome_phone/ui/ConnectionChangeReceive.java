package com.android.smarthome_phone.ui;

import com.fengruyi.common.log.Logger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 网络状态监听
 * @author fengruyi
 *
 */
public class ConnectionChangeReceive extends BroadcastReceiver{
	private final String TAG = "ConnectionChangeReceive";
	public static enum NetState{NET_MOBILE,NET_WIFI,NET_NO}
	private NetworkChangeListener networkChangeListener;
	@Override
	public void onReceive(Context context, Intent intent) {
		/*在WLAN设置界面

		1，显示连接已保存，但标题栏没有，即没有实质连接上，输出为：not connect， available

		2，显示连接已保存，标题栏也有已连接上的图标，            输出为：connect， available

		3，选择不保存后                                                                        输出为：not connect， available

		4，选择连接，在正在获取IP地址时                                        输出为：not connect， not available

		5，连接上后                                                                                输出为：connect， available
		*/
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netinfo = cm.getActiveNetworkInfo();//当前使用的网络
		if(netinfo!=null&&netinfo.isConnected()){
			if(netinfo.getType()==ConnectivityManager.TYPE_WIFI){
				Logger.e(TAG, "当前wifi网络：typename-->"+netinfo.getTypeName()+",是否可用：-->"+netinfo.isAvailable()+",status--->"+netinfo.getState());
				if(networkChangeListener!=null){
					networkChangeListener.onNetworkChange(NetState.NET_WIFI);
				}
			}else{
				if(networkChangeListener!=null){
					networkChangeListener.onNetworkChange(NetState.NET_MOBILE);
				}
				Logger.e(TAG, "当前移动网络：typename-->"+netinfo.getTypeName()+",是否可用：-->"+netinfo.isAvailable()+",status--->"+netinfo.getState());
			}
		}else{
			if(networkChangeListener!=null){
				networkChangeListener.onNetworkChange(NetState.NET_NO);
			}
			Logger.e(TAG, "当前没有可用网络");
		}
		
	}
	
	public NetworkChangeListener getNetworkChangeListener() {
		return networkChangeListener;
	}

	public void setNetworkChangeListener(NetworkChangeListener networkChangeListener) {
		this.networkChangeListener = networkChangeListener;
	}

	interface NetworkChangeListener{
		public void onNetworkChange(NetState state);
	}
}
