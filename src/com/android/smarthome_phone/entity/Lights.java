package com.android.smarthome_phone.entity;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 * 灯光类数据集合
 * @author fengruyi
 *
 */
@XStreamAlias("lights")  
public class Lights{

	public Lights(){};
	
	@XStreamAlias("lights_list")  
	private List<LightInfo> lights_list;
	
	public List<LightInfo> getLights_list() {
		return lights_list;
	}

	public void setLights_list(List<LightInfo> lights_list) {
		this.lights_list = lights_list;
	}

	
}
