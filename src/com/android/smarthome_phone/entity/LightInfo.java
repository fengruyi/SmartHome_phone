package com.android.smarthome_phone.entity;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 灯光类结构
 * @author fengruyi
 *
 */
@XStreamAlias("lightinfo")
public class LightInfo {
	
	/**
	 * 灯光名称
	 */
	private String light_name;
	/**
	 * 是否为可调亮度灯光，true则是
	 */
	private boolean isBrightness_control;
	/**
	 * 灯光的id
	 */
	private int light_id;
	
	public LightInfo() {
		
	}
	public String getLight_name() {
		return light_name;
	}
	public void setLight_name(String light_name) {
		this.light_name = light_name;
	}
	public boolean isBrightness_control() {
		return isBrightness_control;
	}
	public void setBrightness_control(boolean isBrightness_control) {
		this.isBrightness_control = isBrightness_control;
	}
	public int getLight_id() {
		return light_id;
	}
	public void setLight_id(int light_id) {
		this.light_id = light_id;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
