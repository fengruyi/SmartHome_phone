package com.android.smarthome_phone.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.smarthome_phone.BaseActivity;
import com.android.smarthome_phone.MyApplicatioin;
import com.android.smarthome_phone.R;
import com.android.smarthome_phone.entity.LightInfo;
import com.android.smarthome_phone.entity.Lights;
import com.fengruyi.common.log.Logger;
import com.fengruyi.common.util.PrefsUtil;
import com.fengruyi.common.util.TextUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * 应用的第一个页面，闪页
 * @author fengruyi
 *
 */
public class SpalishActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		 	LoadingDialog.showLoadingDialog(this, "正在配置信息");
////		//从assets中解释xml成对象
//			XStream	xstream = new XStream(new DomDriver()); 
//			xstream.alias("lights", Lights.class);//必须加，否则默认是含有包全全路径的名称
//			xstream.alias("lightinfo", LightInfo.class);
//			LightInfo info = new LightInfo();
//			info.setBrightness_control(false);
//			info.setLight_name("灯光1");
//			info.setLight_id(1);
//			
//			LightInfo info2 = new LightInfo();
//			info2.setBrightness_control(false);
//			info2.setLight_name("灯光2");
//			info2.setLight_id(2);
//			List<LightInfo> infos = new ArrayList<LightInfo>();
//			infos.add(info);
//			infos.add(info2);
//			Lights lights = new Lights();
//			lights.setLights_list(infos);
//			String xmlStr = xstream.toXML(lights); 
//			Logger.e("SpalishActivity", "xmlStr-->"+xmlStr);
//			
//			
//			List<LightInfo> list;
//			
//			try {
//				Lights lights_ =  (Lights) xstream.fromXML(getAssets().open("lightinfo.xml"));
//				 Logger.e("SpalishActivity", "list-->"+lights_);
//				for (LightInfo lightInfo : lights_.getLights_list()) {
//					Logger.e("SpalishActivity", "lightInfo"+lightInfo.toString());
//				}
//			} catch (Exception e) {
//				 Logger.e("SpalishActivity", e.toString());
//				e.printStackTrace();
//			}
			String json = PrefsUtil.getInstance().getString("deviceinfo");
			if(TextUtil.isEmpty(json)){
				try {
				 Logger.e("SpalishActivity", "xml 解释");
				 XStream	xstream = new XStream(new DomDriver()); 
				 xstream.alias("lights", Lights.class);//必须加，否则默认是含有包全全路径的名称
			     xstream.alias("lightinfo", LightInfo.class);
				 Lights lights_ =  (Lights) xstream.fromXML(getAssets().open("lightinfo.xml"));
				 MyApplicatioin.getInstance().setmDevice(lights_);
				 PrefsUtil.getInstance().putString("deviceinfo", JSON.toJSONString(lights_)).commit();;
				 Logger.e("SpalishActivity", "list-->"+lights_);
				for (LightInfo lightInfo : lights_.getLights_list()) {
					Logger.e("SpalishActivity", "lightInfo"+lightInfo.toString());
				}
				} catch (Exception e) {
					 Logger.e("SpalishActivity", e.toString());
					e.printStackTrace();
				}
				
			}else{
				 Logger.e("SpalishActivity", "JSOn 解释");
				 Lights lights_ = JSON.parseObject(json, Lights.class);
				MyApplicatioin.getInstance().setmDevice(lights_);
			}
			Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
				
				@Override
				public void run() {
					Intent intent = new Intent(SpalishActivity.this,MainActivity.class);
					startActivity(intent);
					finish();
				}
			},2*1000);
			

	
	}
	
}
